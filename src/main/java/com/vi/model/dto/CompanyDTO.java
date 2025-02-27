/*
 Version Number 0.0.1
*/

package com.vi.model.dto;

import com.vi.model.BaseDto;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO extends BaseDto {
  private String code;

  private String name;

  private String legalName;

  private String tradeName;

  private String legalInfo;

  private Long logoProfileId;

  private String notes;

  private String financeCode;

  private String website;

  private DocumentDTO logoProfileIdData;

}