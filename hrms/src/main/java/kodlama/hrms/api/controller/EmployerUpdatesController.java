package kodlama.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.EmployerUpdateService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/employerUpdate")
@CrossOrigin
public class EmployerUpdatesController {


    private EmployerUpdateService employerUpdateService;

    @Autowired
    public EmployerUpdatesController(EmployerUpdateService employerUpdateService) {
        this.employerUpdateService = employerUpdateService;
    }

    @GetMapping("/getverifyed")
    public DataResult<List<EmployerUpdate>> getWaitingUpdate(){
        return this.employerUpdateService.getVerifyed();
    }

    @GetMapping("/getAll")
    public DataResult<List<EmployerUpdate>> getAll(){
        return this.employerUpdateService.getAll();
    }

}