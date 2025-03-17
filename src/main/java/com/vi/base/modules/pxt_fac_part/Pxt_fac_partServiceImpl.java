package com.vi.base.modules.pxt_fac_part;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
//import com.vi.model.dto.Pxt_fac_partDTO;
import com.vi.model.dto.Pxt_fac_partDTO;

public class Pxt_fac_partServiceImpl implements Pxt_fac_partService {
    private Pxt_fac_partPersistent pxt_fac_partPersistent;

	public Pxt_fac_partServiceImpl(Pxt_fac_partPersistent pxt_fac_partPersistent) {
		this.pxt_fac_partPersistent = pxt_fac_partPersistent;
	}

    @Override
    public List<Pxt_fac_partDTO> filterData(String search) {
		return pxt_fac_partPersistent.filterData(search);
	}
    @Override
    public List<Pxt_fac_partDTO> filterData(JsonNode search) {
        return pxt_fac_partPersistent.filterData(search);
    
    }

    @Override
    public List<Pxt_fac_partDTO> fetchAll() {
        return pxt_fac_partPersistent.fetchAll();
    }

    @Override
    public Pxt_fac_partDTO get(int id) {
        return pxt_fac_partPersistent.get(id);
    }
    

    @Override
    public Pxt_fac_partDTO get(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
	public Pxt_fac_partDTO create(Pxt_fac_partDTO dto) {
		return pxt_fac_partPersistent.create(dto);
	}
    @Override
    public Pxt_fac_partDTO update(Pxt_fac_partDTO t) {
        return pxt_fac_partPersistent.update(t);
    }

    @Override
    public Boolean delete(int id) {
        return pxt_fac_partPersistent.delete(id);
    }

    @Override
    public Boolean delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
