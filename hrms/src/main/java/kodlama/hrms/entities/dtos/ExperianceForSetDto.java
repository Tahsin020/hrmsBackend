package kodlama.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperianceForSetDto {

	private int cvId;

    private String companyName;

    private String position;

    private LocalDate startDate;

    private LocalDate endDate;
}
