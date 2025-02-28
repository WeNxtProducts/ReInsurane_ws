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
  private String docNum;

  private Long bookingId;

  private Date allotmentDate;

  private Long vehicleId;

  private Long branchId;

  private Long divisionId;

  private String allottedVinNo;

  private Long quoteId;

  // private BookingDTO bookingIdData;

  // private VehicleDetailDTO vehicleIdData;

  // private BranchDTO branchIdData;

  // private DivisionDTO divisionIdData;

  // private QuoteDTO quoteIdData;

}