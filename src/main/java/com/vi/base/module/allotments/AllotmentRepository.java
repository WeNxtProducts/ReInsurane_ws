/*
 - Version Number 0.0.1
*/

package com.sm.cars.base.modules.allotments;

import com.vi.model.dao.AllotmentDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AllotmentRepository extends JpaRepository<AllotmentDAO,Long>, JpaSpecificationExecutor<AllotmentDAO> {

}
