package kodlama.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.TechnologyService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Technology;
import kodlama.hrms.entities.dtos.TechnologyForSerDto;

@RestController
@RequestMapping("/api/technology")
@CrossOrigin
public class TechnologiesController {

    private TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping("/addTechnology")
    public Result addTechnology(@RequestBody TechnologyForSerDto technologyForSerDto){
        return this.technologyService.addTechnology(technologyForSerDto);
    }

    @DeleteMapping("/deleteTechnology")
    public Result deleteTechnology(@RequestParam int technologyId){
        return this.technologyService.deleteTechnology(technologyId);
    }

    @GetMapping("/getByCvId")
    public DataResult<List<Technology>> getByCvId(@RequestParam int cvId){
        return this.technologyService.getByCvId(cvId);
    }
}
