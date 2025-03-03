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

@Entity(name = "companies")
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AllotmentDAO extends BaseDao {
	
	
	
	@Column(name="company_code")
	private Long companyCode;
	
	@Column(name="name")
	private Date name;
	
	@Column(name="description")
	private Long description;
	
	@Column(name="address1")
	private Long address1;
	
	@Column(name="address2")
	private Long address2;
	
	@Column(name="address3")
	private String address3;
	
	@Column(name="city")
	private Long city;

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