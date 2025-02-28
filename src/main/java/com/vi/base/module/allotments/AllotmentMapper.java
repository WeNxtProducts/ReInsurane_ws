/*
 - Version Number 0.0.1
*/

package com.sm.cars.base.modules.allotments;

import com.vi.model.dao.AllotmentDAO;
import com.vi.model.dto.AllotmentDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AllotmentMapper {

	AllotmentMapper INSTANCE = Mappers.getMapper(AllotmentMapper.class);

	AllotmentDTO allotmentDAOToAllotmentDTO(AllotmentDAO allotmentDAO);

	AllotmentDAO allotmentDTOToAllotmentDAO(AllotmentDTO allotmentDTO);

	List<AllotmentDTO> allotmentDAOListToAllotmentDTOList(List<AllotmentDAO> allotmentDAOList);

	List<AllotmentDAO> allotmentDTOListToAllotmentDAOList(List<AllotmentDTO> allotmentDTOList);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void assignValues(AllotmentDTO dto, @MappingTarget AllotmentDAO entity);
}