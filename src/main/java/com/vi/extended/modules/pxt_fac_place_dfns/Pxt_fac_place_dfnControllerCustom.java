/*
 - Version Number 0.0.1
*/

package com.vi.extended.modules.pxt_fac_place_dfns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vi.base.modules.pxt_fac_place_dfns.Pxt_fac_place_dfnService;
import com.vi.corelib.api.MicroService;
import com.vi.corelib.api.RequestPatterns;
import com.vi.model.dto.Pxt_fac_hdrDTO;
import com.vi.model.dto.Pxt_fac_place_dfnDTO;
import com.vi.model.dto.Pxt_fac_place_dfnDTOCustom;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;
import java.util.Base64;


@RestController
@RequestMapping("/Placement")
@Slf4j
public class Pxt_fac_place_dfnControllerCustom {
    @Autowired
    public Environment env;
	
	@Autowired
	Pxt_fac_place_dfnServiceCustom pxt_fac_place_dfnServiceCustom;

	@Autowired
	Pxt_fac_place_dfnService pxt_fac_place_dfnService;

	@PersistenceContext
	EntityManager em;

	
	@GetMapping("/process")
    @Transactional 
    public ResponseEntity<?> createPlacement(@RequestParam Long policyId) throws JsonProcessingException {
        try {
            em.createNativeQuery("CALL create_placements(:policyId)")
              .setParameter("policyId", policyId)
              .executeUpdate();

            return ResponseEntity.ok().body(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }




}
