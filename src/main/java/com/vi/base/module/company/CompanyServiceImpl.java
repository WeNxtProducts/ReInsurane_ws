/*
 - Version Number 0.0.1
*/

package com.vi.globals.base.modules.companies;

import com.fasterxml.jackson.databind.JsonNode;
import com.vi.model.dto.CompanyDTO;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {

	private CompanyPersistent companyPersistent;

	public CompanyServiceImpl(CompanyPersistent companyPersistent) {
		this.companyPersistent = companyPersistent;
	}

	@Override
	public List<CompanyDTO> fetchAll() {
		return companyPersistent.fetchAll();
	}

	@Override
	public CompanyDTO get(Long id) {
		return companyPersistent.get(id);
	}

	@Override
	public CompanyDTO create(CompanyDTO companyDTO) {
		return companyPersistent.create(companyDTO);
	}

	@Override
	public CompanyDTO update(CompanyDTO companyDTO) {
		return companyPersistent.update(companyDTO);
	}

	@Override
	public Boolean delete(Long id) {
		return companyPersistent.delete(id);
	}

	@Override
	public List<CompanyDTO> filterData(String search) {
		return companyPersistent.filterData(search);
	}

	@Override
	public List<CompanyDTO> filterData(JsonNode search) {
		return companyPersistent.filterData(search);
	}
}