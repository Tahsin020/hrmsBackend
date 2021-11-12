package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.School;
import kodlama.hrms.entities.dtos.SchoolForSerDto;

public interface SchoolService {

	 	public Result addSchool(SchoolForSerDto schoolForSerDto);
	    public Result deleteSchool(int schoolId);
	    public DataResult<List<School>> getByCvId(int cvId);
}
