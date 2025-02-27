/*
 - Version Number 0.0.1
*/

package com.vi.globals.base.modules.companies;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.vi.model.dto.CompanyDTO;
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
@RequestMapping("/companies")
@Slf4j
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping("/all")
	public ResponseEntity<List<CompanyDTO>> getAll(@Nullable @RequestAttribute("userInfo") UserInfo userInfo, @Nullable @RequestParam HashMap<String, String> json) {
		json.put("deleted","false");
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(companyService.filterData(jsonRequest));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompanyDTO> getOne(@PathVariable Long id) {
		var companyDTO = companyService.get(id);
		return ResponseEntity.ok().body(companyDTO);
	}

	@PostMapping("/create")
	public ResponseEntity<CompanyDTO> create(@Nullable @RequestAttribute("userInfo") UserInfo userInfo, @RequestBody CompanyDTO companyDTO) {
		companyDTO.setCreated(new Date());
		if(userInfo!=null){
			companyDTO.setCreatedBy(userInfo.getUserId());
			companyDTO.setModifiedBy(userInfo.getUserId());
		}else{
			companyDTO.setCreatedBy(0L);
			companyDTO.setModifiedBy(0L);
		}
		
		
		var companyCompanyDTO = companyService.create(companyDTO);
		return ResponseEntity.ok().body(companyCompanyDTO);
	}

	@PutMapping("/update")
	public ResponseEntity<CompanyDTO> update(@Nullable @RequestAttribute("userInfo") UserInfo userInfo, @RequestBody CompanyDTO companyDTO) {
		if(userInfo!=null){
			companyDTO.setModifiedBy(userInfo.getUserId());
		}
		companyDTO.setModified(new Date());
		
		var companyCompanyDTO = companyService.update(companyDTO);
		return ResponseEntity.ok().body(companyCompanyDTO);
	}

	@GetMapping("/filter")
	public ResponseEntity<List<CompanyDTO>> filterData(@Nullable @RequestAttribute("userInfo") UserInfo userInfo,@RequestParam(value = "search") String search) {
		search=search.concat(",deleted:"+false);
		return ResponseEntity.ok().body(companyService.filterData(search));
	}

	@GetMapping("/filter2")
	public ResponseEntity<List<CompanyDTO>> filterData2(@Nullable @RequestAttribute("userInfo") UserInfo userInfo,@RequestParam HashMap<String, String> json) {
		json.put("deleted","false");
		JsonNode jsonRequest = new ObjectMapper().convertValue(json, JsonNode.class);
		return ResponseEntity.ok().body(companyService.filterData(jsonRequest));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
		return ResponseEntity.ok().body(companyService.delete(id));
	}
}
