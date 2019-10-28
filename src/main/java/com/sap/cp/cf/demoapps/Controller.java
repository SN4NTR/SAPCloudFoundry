package com.sap.cp.cf.demoapps;

import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private ProductRepo productRepo;

	@GetMapping("/productsByParam")
	public Collection<Product> getProductByName(@RequestParam(value = "name") final String name) {
		logger.info("***First - Retrieving details for '{}'.", name);
		logger.info("***Second - Retrieving details for '{}'.", name);
		return productRepo.findByName(name);
	}

	@GetMapping("/scaleup")
	public String scaleUp() {
		String str = "";
		HashMap<String, Double> h = null;

		for (int i = 0; i < 10000000; i++) {
			h = new HashMap<>();
			String key = new String("key");
			Double value = 100.98;
			h.put(key, value);
			str = str + h.toString();
		}

		return "success";
	}
}
