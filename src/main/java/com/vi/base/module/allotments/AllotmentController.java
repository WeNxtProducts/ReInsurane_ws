/*
 - Version Number 0.0.1
*/

package com.sm.cars.base.modules.allotments;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.vi.model.dto.AllotmentDTO;
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
@RequestMapping("/allotments")
@Slf4j
public class AllotmentController {

	@Autowired
	AllotmentService allotmentService;

	@GetMapping("/all")
	public ResponseEntity<List<AllotmentDTO>> getAll(@Nullable @RequestAttribute("userInfo") UserInfo userInfo, @Nullable @RequestParam HashMap<String, String> json) {
		json.put("branchId",userInfo.getDefaultBranchId().toString());
		json.put("deleted","false");
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(allotmentService.filterData(jsonRequest));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AllotmentDTO> getOne(@PathVariable Long id) {
		var allotmentDTO = allotmentService.get(id);
		return ResponseEntity.ok().body(allotmentDTO);
	}

	@PostMapping("/create")
	public ResponseEntity<AllotmentDTO> create(@RequestAttribute("userInfo") UserInfo userInfo, @RequestBody AllotmentDTO allotmentDTO) {
		allotmentDTO.setCreated(new Date());
		allotmentDTO.setCreatedBy(userInfo.getUserId());
		allotmentDTO.setModifiedBy(userInfo.getUserId());
		// if(allotmentDTO.getBranchId()==null) { 
        //  		allotmentDTO.setBranchId(userInfo.getDefaultBranchId());
      	// }
		var allotmentAllotmentDTO = allotmentService.create(allotmentDTO);
		return ResponseEntity.ok().body(allotmentAllotmentDTO);
	}

	@PutMapping("/update")
	public ResponseEntity<AllotmentDTO> update(@RequestAttribute("userInfo") UserInfo userInfo, @RequestBody AllotmentDTO allotmentDTO) {
		allotmentDTO.setModifiedBy(userInfo.getUserId());
		allotmentDTO.setModified(new Date());
		var allotmentAllotmentDTO = allotmentService.update(allotmentDTO);
		return ResponseEntity.ok().body(allotmentAllotmentDTO);
	}

	@GetMapping("/filter")
	public ResponseEntity<List<AllotmentDTO>> filterData(@Nullable @RequestAttribute("userInfo") UserInfo userInfo,@RequestParam(value = "search") String search) {
		search=search.concat(",branchId:"+userInfo.getDefaultBranchId());
		search=search.concat(",deleted:"+false);
		return ResponseEntity.ok().body(allotmentService.filterData(search));
	}

	@GetMapping("/filter2")
	public ResponseEntity<List<AllotmentDTO>> filterData2(@Nullable @RequestAttribute("userInfo") UserInfo userInfo,@RequestParam HashMap<String, Object> json) {
		json.put("branchId",userInfo.getDefaultBranchId().toString());
		json.put("deleted","false");
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(allotmentService.filterData(jsonRequest));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
		return ResponseEntity.ok().body(allotmentService.delete(id));
	}
}
