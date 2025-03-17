package com.vi.base.modules.pxt_fac_tax;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.vi.model.dto.Pxt_fac_hdrDTO;
import com.vi.model.dto.Pxt_fac_taxDTO;
import com.vi.model.dto.Pxt_fac_rsk_cvrDTO;
import com.vi.model.dto.Pxt_fac_taxDTO;

import lombok.SneakyThrows;

import com.vi.base.modules.pxt_fac_hdrs.Pxt_fac_hdrMapper;
import com.vi.base.modules.pxt_fac_tax.Pxt_fac_taxMapper;
import com.vi.base.modules.pxt_fac_rsk_cvrs.Pxt_fac_rsk_cvrMapper;
import com.vi.corelib.filter.FilterSpecificationsBuilder;
import com.vi.model.dao.Pxt_fac_hdrDAO;
import com.vi.model.dao.Pxt_fac_taxDAO;
import com.vi.model.dao.Pxt_fac_taxDAO;


import com.fasterxml.jackson.databind.JsonNode;

public class Pxt_fac_taxJPAAdapter implements Pxt_fac_taxPersistent {
    @Autowired
    Pxt_fac_taxRepository pxt_fac_taxRepository;
	@Override
	/*public List<Pxt_fac_taxDTO> fetchAll() {
		// Implementation here
		List<Pxt_fac_taxDAO> pxt_fac_taxDAOList = pxt_fac_taxRepository.findAll();
		return Pxt_fac_taxMapper.INSTANCE.pxt_fac_taxDAOListToPxt_fac_taxDTOList(pxt_fac_taxDAOList);
	}*/
    public List<Pxt_fac_taxDTO> fetchAll() {
		var pxt_fac_taxDAOList = pxt_fac_taxRepository.findAll();
		return Pxt_fac_taxMapper.INSTANCE.Pxt_fac_taxDAOListToPxt_fac_taxDTOList(pxt_fac_taxDAOList);
	}
    @Override
	public Pxt_fac_taxDTO get(int id) {
		var pxt_fac_taxDAO = pxt_fac_taxRepository.findById(id);
		if(pxt_fac_taxDAO.isPresent()) {
			return Pxt_fac_taxMapper.INSTANCE.Pxt_fac_taxDAOToPxt_fac_taxDTO(pxt_fac_taxDAO.get());
		}
		return null;
	}

	@SneakyThrows
	@Override
	public Pxt_fac_taxDTO create(Pxt_fac_taxDTO pxt_fac_taxDTO) {
		var pxt_fac_taxDAO = Pxt_fac_taxMapper.INSTANCE.Pxt_fac_taxDTOToPxt_fac_taxDAO(pxt_fac_taxDTO);
		var newPxt_fac_tax = pxt_fac_taxRepository.save(pxt_fac_taxDAO);
		var newData = Pxt_fac_taxMapper.INSTANCE.Pxt_fac_taxDAOToPxt_fac_taxDTO(newPxt_fac_tax);
		
		
		return newData;
	}

	@Override
	public Pxt_fac_taxDTO update(Pxt_fac_taxDTO pxt_fac_taxDTO) {
		var pxt_fac_taxDAO = pxt_fac_taxRepository.getById(pxt_fac_taxDTO.getFT_SYS_ID());
		var oldData = Pxt_fac_taxMapper.INSTANCE.Pxt_fac_taxDAOToPxt_fac_taxDTO(pxt_fac_taxDAO);
		Pxt_fac_taxMapper.INSTANCE.assignValues(pxt_fac_taxDTO, pxt_fac_taxDAO);
		var newPxt_fac_tax = pxt_fac_taxRepository.save(pxt_fac_taxDAO);
		var newData = Pxt_fac_taxMapper.INSTANCE.Pxt_fac_taxDAOToPxt_fac_taxDTO(newPxt_fac_tax); 
		
		return newData; 
	}

	@SneakyThrows
	@Override
	public Boolean delete(int id) {
		var pxt_fac_taxDAO = pxt_fac_taxRepository.getById(id);
		var oldData = Pxt_fac_taxMapper.INSTANCE.Pxt_fac_taxDAOToPxt_fac_taxDTO(pxt_fac_taxDAO);
		//Pxt_fac_hdrDAO.setDeleted(true);
		//var newData = pxt_fac_taxRepository.save(pxt_fac_taxDAO);
		pxt_fac_taxRepository.delete(pxt_fac_taxDAO);
		return true;
	}
	@Override
	public List<Pxt_fac_taxDTO> filterData(String search) {
		Specification<Pxt_fac_taxDAO> result = new FilterSpecificationsBuilder<Pxt_fac_taxDAO>().with(search).build();
		return Pxt_fac_taxMapper.INSTANCE.Pxt_fac_taxDAOListToPxt_fac_taxDTOList(pxt_fac_taxRepository.findAll(result));
	}

	@Override
    public List<Pxt_fac_taxDTO> filterData(JsonNode search) {
    Specification<Pxt_fac_taxDAO> result = new FilterSpecificationsBuilder<Pxt_fac_taxDAO>().with(search).build();
		return Pxt_fac_taxMapper.INSTANCE.Pxt_fac_taxDAOListToPxt_fac_taxDTOList(pxt_fac_taxRepository.findAll(result));
	}
	@Override
	public Boolean delete(Long id) {
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
	@Override
	public Pxt_fac_taxDTO get(Long id) {
		throw new UnsupportedOperationException("Unimplemented method 'get'");
	}
}   

