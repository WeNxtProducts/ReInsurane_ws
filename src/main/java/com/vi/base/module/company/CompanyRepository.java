/*
 - Version Number 0.0.1
*/

package com.vi.globals.base.modules.companies;

import com.vi.model.dao.CompanyDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDAO,Long>, JpaSpecificationExecutor<CompanyDAO> {

}
