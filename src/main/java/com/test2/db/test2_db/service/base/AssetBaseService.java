package com.test2.db.test2_db.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.test2.db.test2_db.entity.Asset;
import com.test2.db.test2_db.service.AssetService;

//IMPORT RELATIONS
import com.test2.db.test2_db.entity.User;

@Service
public class AssetBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Asset insert(Asset obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `asset`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `asset` (`_id`, `nane`,`fk_asset_user`) VALUES (:id,:nane, :fk_asset_user )";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("nane", obj.getNane())
			.addValue("fk_asset_user", obj.getFk_asset_user());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `asset` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - GET ONE
    	
	public Asset get(Long id) {
	    
		String sql = "select * from `asset` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Asset) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Asset.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Asset> getList() {
	    
		String sql = "select * from `asset`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Asset.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Asset update(Asset obj, Long id) {

		String sql = "UPDATE `asset` SET `nane` = :nane , `fk_asset_user` = :fk_asset_user  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("nane", obj.getNane())
			.addValue("fk_asset_user", obj.getFk_asset_user());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in assetService.java
     */
    

}
