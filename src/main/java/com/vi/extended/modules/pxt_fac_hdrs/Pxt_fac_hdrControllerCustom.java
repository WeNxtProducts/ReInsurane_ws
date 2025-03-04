/*
 - Version Number 0.0.1
*/

package com.vi.extended.modules.pxt_fac_hdrs;

import com.vi.base.modules.pxt_fac_hdrs.Pxt_fac_hdrService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/Pxtfachdr")
@Slf4j
public class Pxt_fac_hdrControllerCustom {

	@Autowired
	Pxt_fac_hdrServiceCustom pxt_fac_hdrServiceCustom;

	@Autowired
	Pxt_fac_hdrService pxt_fac_hdrService;

}
