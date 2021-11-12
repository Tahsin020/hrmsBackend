package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Technology;
import kodlama.hrms.entities.dtos.TechnologyForSerDto;

public interface TechnologyService {
	
		public Result addTechnology(TechnologyForSerDto technologyForSerDto);
	    public Result deleteTechnology(int technologyId);
	    public DataResult<List<Technology>> getByCvId(int cvId);
}
