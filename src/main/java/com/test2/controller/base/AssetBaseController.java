package com.test2.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.test2.db.test2_db.service.AssetService;
import com.test2.db.test2_db.entity.Asset;

//IMPORT RELATIONS
import com.test2.db.test2_db.entity.User;

public class AssetBaseController {
    
    @Autowired
	AssetService assetService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "asset", method = RequestMethod.POST, headers = "Accept=application/json")
	public Asset insert(@RequestBody Asset obj) {
		Asset result = assetService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "asset/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		assetService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "asset/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Asset get(@PathVariable Long id) {
		Asset obj = assetService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "asset", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Asset> getList() {
		return assetService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "asset/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Asset update(@RequestBody Asset obj, @PathVariable("id") Long id) {
		Asset result = assetService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
