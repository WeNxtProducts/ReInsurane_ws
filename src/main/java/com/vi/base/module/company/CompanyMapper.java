/*
 - Version Number 0.0.1
*/

package com.vi.globals.base.modules.companies;

import com.vi.model.dao.CompanyDAO;
import com.vi.model.dto.CompanyDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

	CompanyDTO companyDAOToCompanyDTO(CompanyDAO companyDAO);

	CompanyDAO companyDTOToCompanyDAO(CompanyDTO companyDTO);

	List<CompanyDTO> companyDAOListToCompanyDTOList(List<CompanyDAO> companyDAOList);

	List<CompanyDAO> companyDTOListToCompanyDAOList(List<CompanyDTO> companyDTOList);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void assignValues(CompanyDTO dto, @MappingTarget CompanyDAO entity);
}