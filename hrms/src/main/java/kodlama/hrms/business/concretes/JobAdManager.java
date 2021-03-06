package kodlama.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.JobAdService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorDataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.CityDao;
import kodlama.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.hrms.dataAccess.abstracts.JobAdActivationDao;
import kodlama.hrms.dataAccess.abstracts.JobAdDao;
import kodlama.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.hrms.dataAccess.abstracts.StaffDao;
import kodlama.hrms.dataAccess.abstracts.WorkPlaceDao;
import kodlama.hrms.dataAccess.abstracts.WorkTimeDao;
import kodlama.hrms.entities.concretes.JobAd;
import kodlama.hrms.entities.concretes.JobAdActivation;
import kodlama.hrms.entities.dtos.JobAdDto;
import kodlama.hrms.entities.dtos.JobAdFilter;

@Service
public class JobAdManager implements JobAdService {

    private JobAdDao jobAdDao;
    private JobPositionDao jobPositionDao;
    private EmployerDao employerDao;
    private CityDao cityDao;
    private WorkPlaceDao workPlaceDao;
    private WorkTimeDao workTimeDao;
    private JobAdActivationDao jobAdActivationDao;
    private StaffDao staffDao;

    @Autowired
    public JobAdManager(JobAdDao jobAdDao,JobPositionDao jobPositionDao,EmployerDao employerDao,CityDao cityDao,WorkPlaceDao workPlaceDao,WorkTimeDao workTimeDao,JobAdActivationDao jobAdActivationDao,StaffDao staffDao) {
        this.jobAdDao = jobAdDao;
        this.jobPositionDao=jobPositionDao;
        this.employerDao=employerDao;
        this.cityDao=cityDao;
        this.workPlaceDao=workPlaceDao;
        this.workTimeDao=workTimeDao;
        this.jobAdActivationDao=jobAdActivationDao;
        this.staffDao=staffDao;
    }

    @Override
    public Result create(JobAdDto jobAdDto) {

        if(!cityDao.existsById(jobAdDto.getCityId())){
            return new ErrorResult("??ehir bulunamad??");
        }
        else if(!this.employerDao.existsById(jobAdDto.getEmployerId())){
            return new ErrorResult("???? veren bulunamad??");
        }
        else if(jobAdDto.getDescription().isEmpty()){
            return new ErrorResult("A????klama bo?? birak??lamaz");
        }
        else if(jobAdDto.getMinSalary()==0){
            return new ErrorResult("Minumum maa?? 0 verilemez");
        }
        else if(jobAdDto.getMaxSalary()==0){
            return new ErrorResult("Maximum maa?? s??f??r verilemez");
        }
        else if(jobAdDto.getMinSalary() >= jobAdDto.getMaxSalary()){
            return new ErrorResult("Minumum maa?? maksimum maala e??it yada b??y??k olamaz");
        }
        else if(jobAdDto.getOpenPositions()<1){
            return new ErrorResult("A????k pozisyon adeti 1 den k??????k olamaz");
        }
        else if(jobAdDto.getLastDate() == null){
            return new ErrorResult("Son ba??vuru tarihi bo?? b??rak??lamaz");
        }else if(!this.workPlaceDao.existsById(jobAdDto.getWorkPlaceId())){
            return new ErrorResult("Ge??ersiz ??al????ma yeri");
        }else if(!this.workTimeDao.existsById(jobAdDto.getWorkTimeId())){
            return new ErrorResult("Ge??ersiz ??al????ma zaman??");
        }

        JobAd jobAd=new JobAd();
        jobAd.setId(0);
        jobAd.setJobPosition(this.jobPositionDao.getById(jobAdDto.getJobPositionId()));
        jobAd.setEmployer(this.employerDao.getById(jobAdDto.getEmployerId()));
        jobAd.setDescription(jobAdDto.getDescription());
        jobAd.setCity(this.cityDao.getById(jobAdDto.getCityId()));
        jobAd.setMinSalary(jobAdDto.getMinSalary());
        jobAd.setMaxSalary(jobAdDto.getMaxSalary());
        jobAd.setOpenPositions(jobAdDto.getOpenPositions());
        jobAd.setLastDate(jobAdDto.getLastDate());
        jobAd.setActive(false);
        jobAd.setCreateDate(LocalDate.now());
        jobAd.setWorkPlace(this.workPlaceDao.getById(jobAdDto.getWorkPlaceId()));
        jobAd.setWorkTime(this.workTimeDao.getById(jobAdDto.getWorkTimeId()));
        jobAd.setConfirmed(false);
        this.jobAdDao.save(jobAd);

        JobAdActivation jobAdActivation=new JobAdActivation();
        jobAdActivation.setJobAdId(jobAd.getId());
        jobAdActivation.setConfirm(false);
        this.jobAdActivationDao.save(jobAdActivation);


        return new SuccessResult("??lan ba??ar??l?? bir ??ekilde eklendi");
    }

    @Override
    public Result setPasssive(int jobAdId) {
        try {
            JobAd jobAd=this.jobAdDao.getById(jobAdId);
            jobAd.setActive(false);
            jobAdDao.save(jobAd);
            return new SuccessResult("???? ilan?? pasifle??tirildi");
        }catch (EntityNotFoundException exception){
            return new ErrorResult("???? ilan?? bulunamad??");
        }

    }
    @Override
    public DataResult<List<JobAd>> getWaitingJobAdvertisements() {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getWaitingJobAdvertisements(),"Ba??ar??l?? ??ekilde Onaylanm???? ???? ??lanlari Listelendi");
    }

    @Override
    public Result setActiveAndConfirm(int jobAdId,int staffId) {
        try{
            if(!this.staffDao.existsById(staffId)){
                return new ErrorResult("B??yle bir personel yok");
            }
            JobAdActivation jobAdActivation=this.jobAdActivationDao.getById(jobAdId);
            jobAdActivation.setConfirmDate(LocalDate.now());
            jobAdActivation.setConfirm(true);
            jobAdActivation.setStaffId(staffId);
            this.jobAdActivationDao.save(jobAdActivation);

            JobAd jobAd=this.jobAdDao.getById(jobAdId);
            jobAd.setActive(true);
            jobAd.setConfirmed(true);
            this.jobAdDao.save(jobAd);
            return new SuccessResult("???? ilan?? aktifle??tirildi");
        }catch (EntityNotFoundException exception){
            return new ErrorResult("???? ilan?? bulunamad??");
        }

    }

    @Override
    public DataResult<List<JobAd>> getAll() {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findAll(),"Data listelendi");
    }

    @Override
    public DataResult<JobAd> getByJobAdId(int id) {
        if(!this.jobAdDao.existsById(id)){
            return new ErrorDataResult<JobAd>("B??yle bir ilan yok");
        }
        return new SuccessDataResult<JobAd>(this.jobAdDao.getById(id),"Data listelendi");
    }


    @Override
    public DataResult<List<JobAd>> getActiveAds() {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findByActive(true),"Aktif i?? ilanlar?? listelendi");
    }

    @Override
    public DataResult<List<JobAd>> getActiveAndOrderLastDate() {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findByActiveOrderByLastDate(true),"Aktif i?? ilanlar?? tarihe g??re listelendi");
    }

    @Override
    public DataResult<List<JobAd>> getActiveAndCompanyId(int id) {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findByActiveTrueAndEmployer_Id(id),"??irkere g??re aktif i?? i??anlar?? listelendi");
    }

    @Override
    public DataResult<List<JobAd>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize, JobAdFilter jobAdFilter) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getByFilter(jobAdFilter, pageable).getContent(), this.jobAdDao.getByFilter(jobAdFilter,pageable).getTotalElements()+"");
    }


}