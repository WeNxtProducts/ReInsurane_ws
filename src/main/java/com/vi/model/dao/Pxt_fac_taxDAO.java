package com.vi.model.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name="pxt_fac_tax")
@Table(name="pxt_fac_tax")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pxt_fac_taxDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremented primary key
    @Column(name = "FT_SYS_ID")
    private int FT_SYS_ID;

    @Column(name = "FT_UW_SYS_ID")
    private int FT_UW_SYS_ID;

    @Column(name = "FT_POL_IDX")
    private int FT_POL_IDX;

    @Column(name = "FT_FAC_IDX")
    private int FT_FAC_IDX;

    @Column(name = "FT_FP_SYS_ID")
    private int FT_FP_SYS_ID;

    @Column(name = "FT_FPS_SYS_ID")
    private int FT_FPS_SYS_ID;

    @Column(name = "FT_TAX_CODE")
    private String FT_TAX_CODE;

    @Column(name = "FT_TAX_DESC")
    private String FT_TAX_DESC;

    @Column(name = "FT_TAX_TYP")
    private String FT_TAX_TYP;

    @Column(name = "FT_TAX_ON")
    private String FT_TAX_ON;

    @Column(name = "FT_TAX_PERC")
    private BigDecimal FT_TAX_PERC;

    @Column(name = "FT_TAX")
    private BigDecimal FT_TAX;

    @Column(name = "FT_TAX_LC")
    private BigDecimal FT_TAX_LC;

    @Column(name = "FT_SRC_AMT")
    private BigDecimal FT_SRC_AMT;

    @Column(name = "FT_SRC_AMT_LC")
    private BigDecimal FT_SRC_AMT_LC;

    @Column(name = "FT_TAX_ORG")
    private BigDecimal FT_TAX_ORG;

    @Column(name = "FT_TAX_LC_ORG")
    private BigDecimal FT_TAX_LC_ORG;
}
