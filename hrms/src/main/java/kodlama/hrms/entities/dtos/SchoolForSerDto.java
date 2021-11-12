package kodlama.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolForSerDto {
	
	    private int CvId;
	    private String name;
	    private String department;
	    private LocalDate startDate;
	    private LocalDate endDate;
}
