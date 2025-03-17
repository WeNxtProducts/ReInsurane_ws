package com.vi.base.modules.pxt_fac_part;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.vi.base.modules.pxt_fac_part.Pxt_fac_partMapper;
import com.vi.model.dao.Pxt_fac_partDAO;
import com.vi.model.dto.Pxt_fac_partDTO;

@Mapper(componentModel = "spring")
public interface Pxt_fac_partMapper {

   Pxt_fac_partMapper INSTANCE = Mappers.getMapper(Pxt_fac_partMapper.class);

    Pxt_fac_partDTO Pxt_fac_partDAOToPxt_fac_partDTO(Pxt_fac_partDAO Pxt_fac_partDAO);

    Pxt_fac_partDAO Pxt_fac_partDTOToPxt_fac_partDAO(Pxt_fac_partDTO Pxt_fac_partDTO);

    List<Pxt_fac_partDTO> Pxt_fac_partDAOListToPxt_fac_partDTOList(List<Pxt_fac_partDAO> Pxt_fac_partDAOList);

    List<Pxt_fac_partDAO> Pxt_fac_partDTOListToPxt_fac_partDAOList(List<Pxt_fac_partDTO> Pxt_fac_partDTOList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void assignValues(Pxt_fac_partDTO dto, @MappingTarget Pxt_fac_partDAO entity);
}