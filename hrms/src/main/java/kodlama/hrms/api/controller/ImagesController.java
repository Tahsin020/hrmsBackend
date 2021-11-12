package kodlama.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.hrms.business.abstracts.ImageService;
import kodlama.hrms.core.services.CloudinaryService;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.dataAccess.abstracts.CvDao;

@CrossOrigin
@RestController
@RequestMapping("/api/images")
public class ImagesController {

    private CloudinaryService cloudinaryService;
    private ImageService imageService;
    private CvDao cvDao;

    @Autowired
    public ImagesController(CloudinaryService cloudinaryService, ImageService imageService,CvDao cvDao) {
        this.cloudinaryService = cloudinaryService;
        this.imageService = imageService;
        this.cvDao=cvDao;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.imageService.getAll());
    }

    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile ,@RequestParam int cvId){
        Result result=this.imageService.update(multipartFile,cvId);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        Result result=this.imageService.delete(id);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
