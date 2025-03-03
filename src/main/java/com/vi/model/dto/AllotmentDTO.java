/*
 Version Number 0.0.1
*/

package com.vi.model.dto;

import com.vi.model.BaseDto;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AllotmentDTO extends BaseDto {
 

  private Long companyCode;

  private Date allotmentDate;

  private Long name;

  private Long description;

  private Long address1;

  private String address2;

  private Long quoteId;

  // private BookingDTO bookingIdData;

  // private VehicleDetailDTO vehicleIdData;

  // private BranchDTO branchIdData;

  // private DivisionDTO divisionIdData;

  // private QuoteDTO quoteIdData;

}