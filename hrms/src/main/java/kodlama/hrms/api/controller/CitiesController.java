package kodlama.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.CityService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.City;

@RestController
@RequestMapping("/cities")
@CrossOrigin
public class CitiesController {
	
	   private CityService cityService;

	    @Autowired
	    public CitiesController(CityService cityService) {
	        this.cityService = cityService;
	    }

	    @GetMapping("/getAll")
	    public DataResult<List<City>> getAll(){
	        return this.cityService.getAll();
	    }
}
