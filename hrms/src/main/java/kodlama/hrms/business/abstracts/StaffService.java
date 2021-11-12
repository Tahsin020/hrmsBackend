package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Staff;
import kodlama.hrms.entities.dtos.StaffUpdateDto;

public interface StaffService {

	 	public Result create(Staff staff);
	    public DataResult<List<Staff>> getAll();
	    public Result update(StaffUpdateDto staffUpdateDto);
	    DataResult<Staff> findById(int id);
}
