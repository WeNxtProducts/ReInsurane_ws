package com.vi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Pxt_fac_partDTO {

    private int fpSysId;
    private Integer fpUwSysId;
    private Integer fpPolIdx;
    private Integer fpFacIdx;
    private Integer fpFpdSysId;
    private String fpPlaceNo;
    private String fpPartCode;
    private BigDecimal fpPartPerc;
    private String fpBrkCode;
    private BigDecimal fpSi;
    private BigDecimal fpSiLc;
    private BigDecimal fpPmlSi;
    private BigDecimal fpPremLc;
    private BigDecimal fpPmlSiLc;
    private BigDecimal fpPrem;
    private BigDecimal fpOvrPremLc;
    private BigDecimal fpOvrPrem;
    private BigDecimal fpSiOrg;
    private BigDecimal fpSiLcOrg;
    private BigDecimal fpPmlSiOrg;
    private BigDecimal fpPmlSiLcOrg;
    private BigDecimal fpPremOrg;
    private BigDecimal fpPremLcOrg;
    private BigDecimal fpOvrPremOrg;
    private BigDecimal fpOvrPremLcOrg;
}
