package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.City;

public interface CityService {

	public DataResult<List<City>> getAll();
}
