/*
 - Version Number 0.0.1
*/

package com.sm.cars.base.modules.allotments;

import com.fasterxml.jackson.databind.JsonNode;
import com.vi.model.dto.AllotmentDTO;
import java.util.List;

public class AllotmentServiceImpl implements AllotmentService {

	private AllotmentPersistent allotmentPersistent;

	public AllotmentServiceImpl(AllotmentPersistent allotmentPersistent) {
		this.allotmentPersistent = allotmentPersistent;
	}

	@Override
	public List<AllotmentDTO> fetchAll() {
		return allotmentPersistent.fetchAll();
	}

	@Override
	public AllotmentDTO get(Long id) {
		return allotmentPersistent.get(id);
	}

	@Override
	public AllotmentDTO create(AllotmentDTO allotmentDTO) {
		return allotmentPersistent.create(allotmentDTO);
	}

	@Override
	public AllotmentDTO update(AllotmentDTO allotmentDTO) {
		return allotmentPersistent.update(allotmentDTO);
	}

	@Override
	public Boolean delete(Long id) {
		return allotmentPersistent.delete(id);
	}

	@Override
	public List<AllotmentDTO> filterData(String search) {
		return allotmentPersistent.filterData(search);
	}

	@Override
	public List<AllotmentDTO> filterData(JsonNode search) {
		return allotmentPersistent.filterData(search);
	}
}