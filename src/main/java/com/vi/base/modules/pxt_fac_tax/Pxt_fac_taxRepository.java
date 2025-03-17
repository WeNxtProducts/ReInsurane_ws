package com.vi.base.modules.pxt_fac_tax;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vi.model.dao.Pxt_fac_taxDAO;

@Repository
public interface Pxt_fac_taxRepository extends JpaRepository<Pxt_fac_taxDAO,Integer>,JpaSpecificationExecutor<Pxt_fac_taxDAO> {
    
}
