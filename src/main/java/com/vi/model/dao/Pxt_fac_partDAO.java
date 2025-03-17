package com.vi.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Data
@Entity(name="pxt_fac_part")
@Table(name = "pxt_fac_part")
@AllArgsConstructor
@NoArgsConstructor
public class Pxt_fac_partDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FP_SYS_ID")
    private int fpSysId;

    @Column(name = "FP_UW_SYS_ID")
    private Integer fpUwSysId;

    @Column(name = "FP_POL_IDX")
    private Integer fpPolIdx;

    @Column(name = "FP_FAC_IDX")
    private Integer fpFacIdx;

    @Column(name = "FP_FPD_SYS_ID")
    private Integer fpFpdSysId;

    @Column(name = "FP_PLACE_NO")
    private String fpPlaceNo;

    @Column(name = "FP_PART_CODE")
    private String fpPartCode;

    @Column(name = "FP_PART_PERC")
    private BigDecimal fpPartPerc;

    @Column(name = "FP_BRK_CODE")
    private String fpBrkCode;

    @Column(name = "FP_SI")
    private BigDecimal fpSi;

    @Column(name = "FP_SI_LC")
    private BigDecimal fpSiLc;

    @Column(name = "FP_PML_SI")
    private BigDecimal fpPmlSi;

    @Column(name = "FP_PREM_LC")
    private BigDecimal fpPremLc;

    @Column(name = "FP_PML_SI_LC")
    private BigDecimal fpPmlSiLc;

    @Column(name = "FP_PREM")
    private BigDecimal fpPrem;

    @Column(name = "FP_OVR_PREM_LC")
    private BigDecimal fpOvrPremLc;

    @Column(name = "FP_OVR_PREM")
    private BigDecimal fpOvrPrem;

    @Column(name = "FP_SI_ORG")
    private BigDecimal fpSiOrg;

    @Column(name = "FP_SI_LC_ORG")
    private BigDecimal fpSiLcOrg;

    @Column(name = "FP_PML_SI_ORG")
    private BigDecimal fpPmlSiOrg;

    @Column(name = "FP_PML_SI_LC_ORG")
    private BigDecimal fpPmlSiLcOrg;

    @Column(name = "FP_PREM_ORG")
    private BigDecimal fpPremOrg;

    @Column(name = "FP_PREM_LC_ORG")
    private BigDecimal fpPremLcOrg;

    @Column(name = "FP_OVR_PREM_ORG")
    private BigDecimal fpOvrPremOrg;

    @Column(name = "FP_OVR_PREM_LC_ORG")
    private BigDecimal fpOvrPremLcOrg;
}
