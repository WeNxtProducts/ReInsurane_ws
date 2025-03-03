/*
 - Version Number 0.0.1
*/

package com.vi.base.modules.Pxt_fac_hdrs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.vi.model.dto.Pxt_fac_hdrDTO;
import com.vi.corelib.filter.Filter;
import com.vi.corelib.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Pxtfachdr")
@Slf4j
public class Pxt_fac_hdrController {

	@Autowired
	Pxt_fac_hdrService pxt_fac_hdrService;

	@GetMapping("/all")
	public ResponseEntity<List<Pxt_fac_hdrDTO>> getAll(@Nullable @RequestParam HashMap<String, String> json) {
		//json.put("branchId",userInfo.getDefaultBranchId().toString());
		//json.put("deleted","false");
		 System.out.print("comming Inside");
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(pxt_fac_hdrService.filterData(jsonRequest));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pxt_fac_hdrDTO> getOne(@PathVariable Long id) {
		var pxt_fac_hdrDTO = pxt_fac_hdrService.get(id);
		return ResponseEntity.ok().body(pxt_fac_hdrDTO);
	}

	@PostMapping("/create")
	public ResponseEntity<Pxt_fac_hdrDTO> create(@RequestAttribute("userInfo") UserInfo userInfo, @RequestBody Pxt_fac_hdrDTO pxt_fac_hdrDTO) {
		
	
		var pxt_fac_hdrPxt_fac_hdrDTO = pxt_fac_hdrService.create(pxt_fac_hdrDTO);
		return ResponseEntity.ok().body(pxt_fac_hdrPxt_fac_hdrDTO);
	}

	@PutMapping("/update")
	public ResponseEntity<Pxt_fac_hdrDTO> update(@RequestAttribute("userInfo") UserInfo userInfo, @RequestBody Pxt_fac_hdrDTO pxt_fac_hdrDTO) {
		
		var pxt_fac_hdrPxt_fac_hdrDTO = pxt_fac_hdrService.update(pxt_fac_hdrDTO);
		return ResponseEntity.ok().body(pxt_fac_hdrPxt_fac_hdrDTO);
	}

	@GetMapping("/filter")
	public ResponseEntity<List<Pxt_fac_hdrDTO>> filterData(@Nullable @RequestAttribute("userInfo") UserInfo userInfo,@RequestParam(value = "search") String search) {
		
		return ResponseEntity.ok().body(pxt_fac_hdrService.filterData(search));
	}

	@GetMapping("/filter2")
	public ResponseEntity<List<Pxt_fac_hdrDTO>> filterData2(@Nullable @RequestAttribute("userInfo") UserInfo userInfo,@RequestParam HashMap<String, Object> json) {
	
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(pxt_fac_hdrService.filterData(jsonRequest));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
		return ResponseEntity.ok().body(pxt_fac_hdrService.delete(id));
	}
}
