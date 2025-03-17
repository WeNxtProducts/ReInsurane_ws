package com.vi.base.modules.pxt_fac_part;

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
import com.vi.model.dto.Pxt_fac_partDTO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Pxtfacpart")
@Slf4j
public class Pxt_fac_partController {
    @Autowired
    Pxt_fac_partService pxt_fac_partService;
    @GetMapping("/all")
	public ResponseEntity<List<Pxt_fac_partDTO>> getAll(@Nullable @RequestParam HashMap<String, String> json) {
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(pxt_fac_partService.filterData(jsonRequest));
	}
    
    @SuppressWarnings("rawtypes")
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable int id) {
		//var Pxt_fac_partDTO = pxt_fac_partService.get(id);
		return ResponseEntity.ok().body(pxt_fac_partService.get(id));
	}
    @PostMapping("/create")
	public ResponseEntity<Pxt_fac_partDTO> create( @RequestBody Pxt_fac_partDTO pxt_fac_partDTO) {
		var pxt_fac_partPxt_fac_partDTO = pxt_fac_partService.create(pxt_fac_partDTO);
		return ResponseEntity.ok().body(pxt_fac_partPxt_fac_partDTO);
	}
    @PutMapping("/update")
	public ResponseEntity<Pxt_fac_partDTO> update( @RequestBody Pxt_fac_partDTO pxt_fac_partDTO) {
		
		var pxt_fac_partPxt_fac_partDTO = pxt_fac_partService.update(pxt_fac_partDTO);
		return ResponseEntity.ok().body(pxt_fac_partPxt_fac_partDTO);
	}
    @GetMapping("/filter")
	public ResponseEntity<List<Pxt_fac_partDTO>> filterData(@RequestParam(value = "search") String search) {
		
		return ResponseEntity.ok().body(pxt_fac_partService.filterData(search));
	}
    @DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteOne(@PathVariable int id) {
		//var Pxt_fac_partDTO = pxt_fac_partService.get(id);
		return ResponseEntity.ok().body(pxt_fac_partService.delete(id));
    }
    @GetMapping("/filter2")
	public ResponseEntity<List<Pxt_fac_partDTO>> filterData(@RequestParam HashMap<String, Object> json) {
	
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(pxt_fac_partService.filterData(jsonRequest));
	}

}
