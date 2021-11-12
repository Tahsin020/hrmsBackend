package kodlama.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Image;

public interface ImageService {

		DataResult<List<Image>> getAll();
	    Result update(MultipartFile multipartFile,int cvId);
	    Result delete(int id);
	    DataResult<Image> getById(int id);
	    Boolean isExist(int id);
}
