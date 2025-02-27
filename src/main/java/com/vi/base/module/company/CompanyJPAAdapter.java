/*
 - Version Number 0.0.1
*/

package com.vi.globals.base.modules.companies;

import com.fasterxml.jackson.databind.JsonNode;
import com.vi.model.dao.CompanyDAO;
import com.vi.model.dto.CompanyDTO;
import com.vi.corelib.events.EventPublisher;
import com.vi.corelib.filter.FilterSpecificationsBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;
import java.io.IOException;
import org.json.simple.parser.ParseException;


public class CompanyJPAAdapter implements CompanyPersistent {
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public List<CompanyDTO> fetchAll() {
		var companyDAOList = companyRepository.findAll();
		return CompanyMapper.INSTANCE.companyDAOListToCompanyDTOList(companyDAOList);
	}

	@Override
	public CompanyDTO get(Long id) {
		var companyDAO = companyRepository.findById(id);
		if(companyDAO.isPresent()) {
			return CompanyMapper.INSTANCE.companyDAOToCompanyDTO(companyDAO.get());
		}
		return null;
	}

  @SneakyThrows
	@Override
	public CompanyDTO create(CompanyDTO companyDTO) {
		var companyDAO = CompanyMapper.INSTANCE.companyDTOToCompanyDAO(companyDTO);
		var newCompany = companyRepository.save(companyDAO);
		var newData = CompanyMapper.INSTANCE.companyDAOToCompanyDTO(newCompany);
		try {
			EventPublisher.publish("Company-Created", null, newData);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return newData;
	}

	@Override
 		public CompanyDTO update(CompanyDTO companyDTO) {
		var companyDAO = companyRepository.getById(companyDTO.getId());
		var oldData = CompanyMapper.INSTANCE.companyDAOToCompanyDTO(companyDAO);
		CompanyMapper.INSTANCE.assignValues(companyDTO, companyDAO);
		var newCompany = companyRepository.save(companyDAO);
		var newData = CompanyMapper.INSTANCE.companyDAOToCompanyDTO(newCompany); 
		try {
			EventPublisher.publish("Company-Updated", oldData, newData);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newData;   
	}

	@SneakyThrows
	@Override
	public Boolean delete(Long id) {
		var companyDAO = companyRepository.getById(id);
		var oldData = CompanyMapper.INSTANCE.companyDAOToCompanyDTO(companyDAO);
		companyDAO.setDeleted(true);
		var newData = companyRepository.save(companyDAO);
		try {
			EventPublisher.publish("Company-Deleted", oldData, newData);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<CompanyDTO> filterData(String search) {
		Specification<CompanyDAO> result = new FilterSpecificationsBuilder<CompanyDAO>().with(search).build();
		return CompanyMapper.INSTANCE.companyDAOListToCompanyDTOList(companyRepository.findAll(result));
	}

	@Override
	public List<CompanyDTO> filterData(JsonNode search) {
    Specification<CompanyDAO> result = new FilterSpecificationsBuilder<CompanyDAO>().with(search).build();
		return CompanyMapper.INSTANCE.companyDAOListToCompanyDTOList(companyRepository.findAll(result));
	}
}
