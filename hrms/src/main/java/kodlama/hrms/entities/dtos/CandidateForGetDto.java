package kodlama.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForGetDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
}
