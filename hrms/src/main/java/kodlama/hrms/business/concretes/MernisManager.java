package kodlama.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.NationalValidationService;
import kodlama.hrms.entities.concretes.Candidate;

@Service
public class MernisManager implements NationalValidationService {


    @Override
    public boolean validate(Candidate candidate) {
        if(candidate.getNationalNumber().length()!=11){
            return false;
        }
        return true;
    }
}
