package kodlama.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.StaffService;
import kodlama.hrms.business.abstracts.UserService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.abstracts.StaffDao;
import kodlama.hrms.entities.concretes.Staff;
import kodlama.hrms.entities.dtos.StaffUpdateDto;

@Service
public class StaffManager implements StaffService {

    private StaffDao staffDao;
    private UserService userService;

    @Autowired
    public StaffManager(StaffDao staffDao,UserService userService) {
        this.staffDao = staffDao;
        this.userService=userService;
    }

    @Override
    public Result create(Staff staff) {
        if(staff.getPassword().length() <=6){
            return new ErrorResult("Şifre 6 karakterden uzun olmalıdır");
        }else if(!isEmailValid(staff.getEmail())){
            return new ErrorResult("Email geçerli formatta değil");
        }else if(userService.getByEmail(staff.getEmail()).getData() != null){
            return new ErrorResult("Bu email zaten kayıtlı");
        }
        staff.setMailVerify(true);
        staffDao.save(staff);
        return new SuccessResult("Kayıt yapıldı");
    }

    @Override
    public DataResult<List<Staff>> getAll() {
        return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(),"Data listelendi");
    }

    @Override
    public DataResult<Staff> findById(int id){
        return  new SuccessDataResult<Staff>(this.staffDao.findById(id),"Bilgiler Getirildi");
    }

    @Override
    public Result update(StaffUpdateDto staffUpdateDto) {

        if(!this.staffDao.existsById(staffUpdateDto.getStaffId())){
            return new ErrorResult("Böyle bir personel yok");
        }else if(staffUpdateDto.getFirstName().length()<2){
            return new ErrorResult("İsim 2 karakterden kısa olamaz");
        }else if(staffUpdateDto.getLastName().length()<2){
            return new ErrorResult("Soy isim 2 karakterden kısa olamaz");
        }else if(!isEmailValid(staffUpdateDto.getEmail())){
            return new ErrorResult("Geçerli bir email değil");
        }

        Staff staff=this.staffDao.getById(staffUpdateDto.getStaffId());
        staff.setFirstName(staffUpdateDto.getFirstName());
        staff.setLastName(staffUpdateDto.getLastName());
        staff.setEmail(staffUpdateDto.getEmail());
        this.staffDao.save(staff);
        return new SuccessResult("Bilgiler kaydedildi");
    }

    private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public boolean isEmailValid(String emailInput) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }
}
