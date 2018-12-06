package com.test2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;

import com.test2.controller.base.AssetBaseController;

@RestController
@PropertySource("classpath:${configfile.path}/test2.properties")
@RequestMapping(value="${endpoint.api}", headers = "Accept=application/json")
public class AssetController extends AssetBaseController {

	//OVERRIDE HERE YOUR CUSTOM CONTROLLER

}
