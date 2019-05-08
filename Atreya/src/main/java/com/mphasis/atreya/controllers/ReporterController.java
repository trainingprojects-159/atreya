package com.mphasis.atreya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.atreya.service.ReporterService;

@RestController
public class ReporterController {
    @Autowired
	ReporterService reporterService;

	public void setReporterService(ReporterService reporterService) {
		this.reporterService = reporterService;
	}
    
}
