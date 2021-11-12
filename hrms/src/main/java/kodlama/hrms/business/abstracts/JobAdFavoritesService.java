package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobAdFavorites;

public interface JobAdFavoritesService {
		public DataResult<List<JobAdFavorites>> getByCandidateId(int candidateId);
	    public Result addFavorite(int candidateId, int jobAdId);
	    public Result removeFavorite(int favoriteId);
}
