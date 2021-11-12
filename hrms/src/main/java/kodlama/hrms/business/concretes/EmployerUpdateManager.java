package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.EmployerUpdateService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.dataAccess.abstracts.EmployerUpdateDao;
import kodlama.hrms.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService {

    private EmployerUpdateDao employerUpdateDao;

    @Autowired
    public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
        this.employerUpdateDao = employerUpdateDao;
    }


    @Override
    public DataResult<List<EmployerUpdate>> getVerifyed(){
        return new SuccessDataResult<List<EmployerUpdate>>(this.employerUpdateDao.getVerifyed(),"Başarılı");
    }


    @Override
    public DataResult<List<EmployerUpdate>> getAll(){
        return new SuccessDataResult<List<EmployerUpdate>>(this.employerUpdateDao.findAll(),"Başarılı");
    }

}