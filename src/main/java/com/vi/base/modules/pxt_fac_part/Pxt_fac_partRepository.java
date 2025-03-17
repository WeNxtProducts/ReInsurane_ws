package com.vi.base.modules.pxt_fac_part;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vi.model.dao.Pxt_fac_partDAO;

public interface Pxt_fac_partRepository extends JpaRepository <Pxt_fac_partDAO,Integer>, JpaSpecificationExecutor<Pxt_fac_partDAO> {
    
}
