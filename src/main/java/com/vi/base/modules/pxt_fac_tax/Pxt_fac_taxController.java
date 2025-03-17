package com.vi.base.modules.pxt_fac_tax;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vi.model.dto.Pxt_fac_taxDTO;
import com.vi.model.dto.Pxt_fac_taxDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Pxtfactax")
@Slf4j
public class Pxt_fac_taxController {
	@Autowired
    Pxt_fac_taxService pxt_fac_taxService;
    
    @GetMapping("/all")
	public ResponseEntity<List<Pxt_fac_taxDTO>> getAll(@Nullable @RequestParam HashMap<String, String> json) {
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(pxt_fac_taxService.filterData(jsonRequest));
	}
	@SuppressWarnings("rawtypes")
	@GetMapping("{id}")
	public ResponseEntity get(@PathVariable int id) {
		var Pxt_fac_taxDTO = pxt_fac_taxService.get(id);
		return ResponseEntity.ok().body(Pxt_fac_taxDTO);
	}
	@PostMapping("/create")
	public ResponseEntity<Pxt_fac_taxDTO> create( @RequestBody Pxt_fac_taxDTO pxt_fac_taxDTO) {
		var pxt_fac_taxPxt_fac_taxDTO = pxt_fac_taxService.create(pxt_fac_taxDTO);
		return ResponseEntity.ok().body(pxt_fac_taxPxt_fac_taxDTO);
	}
	@PutMapping("/update")
	public ResponseEntity<Pxt_fac_taxDTO> update( @RequestBody Pxt_fac_taxDTO pxt_fac_taxDTO) {
		
		var pxt_fac_taxPxt_fac_taxDTO = pxt_fac_taxService.update(pxt_fac_taxDTO);
		return ResponseEntity.ok().body(pxt_fac_taxPxt_fac_taxDTO);
	}
	@GetMapping("/filter")
	public ResponseEntity<List<Pxt_fac_taxDTO>> filterData(@RequestParam(value = "search") String search) {
		
		return ResponseEntity.ok().body(pxt_fac_taxService.filterData(search));
	}

	@GetMapping("/filter2")
	public ResponseEntity<List<Pxt_fac_taxDTO>> filterData(@RequestParam HashMap<String, Object> json) {
	
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(pxt_fac_taxService.filterData(jsonRequest));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteOne(@PathVariable int id) {
		//var Pxt_fac_taxDTO = pxt_fac_taxService.get(id);
		return ResponseEntity.ok().body(pxt_fac_taxService.delete(id));

	}
}
