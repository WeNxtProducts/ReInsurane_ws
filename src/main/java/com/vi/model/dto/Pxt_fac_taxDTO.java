package com.vi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Pxt_fac_taxDTO {

    private int FT_SYS_ID;
    private int FT_UW_SYS_ID;
    private int FT_POL_IDX;
    private int FT_FAC_IDX;
    private int FT_FP_SYS_ID;
    private int FT_FPS_SYS_ID;
    private String FT_TAX_CODE;
    private String FT_TAX_DESC;
    private String FT_TAX_TYP;
    private String FT_TAX_ON;
    private BigDecimal FT_TAX_PERC;
    private BigDecimal FT_TAX;
    private BigDecimal FT_TAX_LC;
    private BigDecimal FT_SRC_AMT;
    private BigDecimal FT_SRC_AMT_LC;
    private BigDecimal FT_TAX_ORG;
    private BigDecimal FT_TAX_LC_ORG;

}
