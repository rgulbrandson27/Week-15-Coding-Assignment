package com.promineotech.jeep.controller;

import java.util.List;

import javax.swing.Spring;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

@RestController
public class BasicJeepSalesController implements JeepSalesController {
	

public List<Jeep> fetchJeeps(String mdoel, String trim) {
	return null;
}


}


