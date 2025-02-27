/*
 Version Number 0.0.1
*/

package com.vi.model.dao;

import com.vi.model.BaseDao;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import javax.persistence.*;

@Entity(name = "Company")
@Table(name = "companies")
@TypeDef(
	name = "json",
	typeClass = JsonType.class
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDAO extends BaseDao {
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="legal_name")
	private String legalName;
	
	@Column(name="trade_name")
	private String tradeName;
	@Type(type = "json")
	@Column(name="legal_info")
	private String legalInfo;
	
	@Column(name="logo_profile_id")
	private Long logoProfileId;
	
	@Column(name="notes")
	private String notes;
	
	@Column(name="finance_code")
	private String financeCode;
	
	@Column(name="website")
	private String website;

	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="logo_profile_id", referencedColumnName = "id", insertable=false, updatable=false)
	private DocumentDAO logoProfileIdData;
}