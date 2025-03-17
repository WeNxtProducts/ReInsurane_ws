package com.vi.base.modules.pxt_fac_tax;

import java.util.List;

import com.vi.model.dto.Pxt_fac_taxDTO;

import com.fasterxml.jackson.databind.JsonNode;

public class Pxt_fac_taxServiceImpl implements Pxt_fac_taxService {
        private Pxt_fac_taxPersistent pxt_fac_taxPersistent;

        public Pxt_fac_taxServiceImpl(Pxt_fac_taxPersistent pxt_fac_taxPersistent) {
            this.pxt_fac_taxPersistent = pxt_fac_taxPersistent;
        }
    @Override
    public List<Pxt_fac_taxDTO> fetchAll() {
		return pxt_fac_taxPersistent.fetchAll();
	}
	@Override
	public Pxt_fac_taxDTO get(int id) {
		return pxt_fac_taxPersistent.get(id);
	}
    
	@Override
	public Pxt_fac_taxDTO create(Pxt_fac_taxDTO dto) {
		return pxt_fac_taxPersistent.create(dto);
	}

	@Override
	public Pxt_fac_taxDTO update(Pxt_fac_taxDTO dto) {
		return pxt_fac_taxPersistent.update(dto);
	}

	@Override
	public Boolean delete(int id) {
		return pxt_fac_taxPersistent.delete(id);
	}

	@Override
	public List<Pxt_fac_taxDTO> filterData(String search) {
		return pxt_fac_taxPersistent.filterData(search);
	}

	@Override
	public List<Pxt_fac_taxDTO> filterData(JsonNode search) {
		return pxt_fac_taxPersistent.filterData(search);
    
	
}
	@Override
	public Boolean delete(Long id) {
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
	@Override
	public Pxt_fac_taxDTO get(Long id) {
		throw new UnsupportedOperationException("Unimplemented method 'get'");
	}
}