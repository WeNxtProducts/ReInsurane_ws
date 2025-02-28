/*
 - Version Number 0.0.1
*/

package com.sm.cars.base.modules.allotments;

import com.fasterxml.jackson.databind.JsonNode;
import com.vi.model.dao.AllotmentDAO;
import com.vi.model.dto.AllotmentDTO;
//import com.vi.corelib.events.EventPublisher;
import com.vi.corelib.filter.FilterSpecificationsBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;
import java.io.IOException;
import org.json.simple.parser.ParseException;


public class AllotmentJPAAdapter implements AllotmentPersistent {
	@Autowired
	AllotmentRepository allotmentRepository;

	@Override
	public List<AllotmentDTO> fetchAll() {
		var allotmentDAOList = allotmentRepository.findAll();
		return AllotmentMapper.INSTANCE.allotmentDAOListToAllotmentDTOList(allotmentDAOList);
	}

	@Override
	public AllotmentDTO get(Long id) {
		var allotmentDAO = allotmentRepository.findById(id);
		if(allotmentDAO.isPresent()) {
			return AllotmentMapper.INSTANCE.allotmentDAOToAllotmentDTO(allotmentDAO.get());
		}
		return null;
	}

  @SneakyThrows
	@Override
	public AllotmentDTO create(AllotmentDTO allotmentDTO) {
		var allotmentDAO = AllotmentMapper.INSTANCE.allotmentDTOToAllotmentDAO(allotmentDTO);
		var newAllotment = allotmentRepository.save(allotmentDAO);
		var newData = AllotmentMapper.INSTANCE.allotmentDAOToAllotmentDTO(newAllotment);
		// try {
		// 	EventPublisher.publish("Allotment-Created", null, newData);
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// } catch (ParseException e) {
		// 	e.printStackTrace();
		// }
		
		return newData;
	}

	@Override
 		public AllotmentDTO update(AllotmentDTO allotmentDTO) {
		var allotmentDAO = allotmentRepository.getById(allotmentDTO.getId());
		var oldData = AllotmentMapper.INSTANCE.allotmentDAOToAllotmentDTO(allotmentDAO);
		AllotmentMapper.INSTANCE.assignValues(allotmentDTO, allotmentDAO);
		var newAllotment = allotmentRepository.save(allotmentDAO);
		var newData = AllotmentMapper.INSTANCE.allotmentDAOToAllotmentDTO(newAllotment); 
		// try {
		// 	EventPublisher.publish("Allotment-Updated", oldData, newData);
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// } catch (ParseException e) {
		// 	e.printStackTrace();
		// }
		return newData;   
	}

	@SneakyThrows
	@Override
	public Boolean delete(Long id) {
		var allotmentDAO = allotmentRepository.getById(id);
		var oldData = AllotmentMapper.INSTANCE.allotmentDAOToAllotmentDTO(allotmentDAO);
		allotmentDAO.setDeleted(true);
		var newData = allotmentRepository.save(allotmentDAO);
		// try {
		// 	EventPublisher.publish("Allotment-Deleted", oldData, newData);
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// } catch (ParseException e) {
		// 	e.printStackTrace();
		// }
		return true;
	}

	@Override
	public List<AllotmentDTO> filterData(String search) {
		Specification<AllotmentDAO> result = new FilterSpecificationsBuilder<AllotmentDAO>().with(search).build();
		return AllotmentMapper.INSTANCE.allotmentDAOListToAllotmentDTOList(allotmentRepository.findAll(result));
	}

	@Override
	public List<AllotmentDTO> filterData(JsonNode search) {
    Specification<AllotmentDAO> result = new FilterSpecificationsBuilder<AllotmentDAO>().with(search).build();
		return AllotmentMapper.INSTANCE.allotmentDAOListToAllotmentDTOList(allotmentRepository.findAll(result));
	}
}
