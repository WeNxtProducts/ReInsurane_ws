/*
 Version Number 0.0.1
*/

package com.vi.model.dao;

import com.vi.model.BaseDao;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import jakarta.persistence.*;
import java.util.Date;

@Entity(name = "Allotment")
@Table(name = "allotments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AllotmentDAO extends BaseDao {
	
	@Column(name="doc_num")
	private String docNum;
	
	@Column(name="booking_id")
	private Long bookingId;
	
	@Column(name="allotment_date")
	private Date allotmentDate;
	
	@Column(name="vehicle_id")
	private Long vehicleId;
	
	@Column(name="branch_id")
	private Long branchId;
	
	@Column(name="division_id")
	private Long divisionId;
	
	@Column(name="allotted_vin_no")
	private String allottedVinNo;
	
	@Column(name="quote_id")
	private Long quoteId;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name="booking_id", referencedColumnName = "id", insertable=false, updatable=false)
	// private BookingDAO bookingIdData;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name="vehicle_id", referencedColumnName = "id", insertable=false, updatable=false)
	// private VehicleDetailDAO vehicleIdData;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name="branch_id", referencedColumnName = "id", insertable=false, updatable=false)
	// private BranchDAO branchIdData;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name="division_id", referencedColumnName = "id", insertable=false, updatable=false)
	// private DivisionDAO divisionIdData;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name="quote_id", referencedColumnName = "id", insertable=false, updatable=false)
	// private QuoteDAO quoteIdData;
}