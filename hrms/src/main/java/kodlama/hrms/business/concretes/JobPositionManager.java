package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.JobPositionService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data listelendi");
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if(getByName(jobPosition.getName()).getData() != null){
            return new ErrorResult("Bu isimde bir pozisyon zaten kayıtlı");
        }else if(jobPosition.getName().length() <=2){
            return new ErrorResult("İş ismi 2 karakterden kısa olamaz");
        }else{
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult("İş eklendi");
        }


    }

    @Override
    public DataResult<JobPosition> getByName(String name) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByName(name),"Listelendi");
    }
}
