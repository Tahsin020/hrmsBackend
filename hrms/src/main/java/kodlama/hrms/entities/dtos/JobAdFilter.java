package kodlama.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdFilter {

	private List<Integer> cityId;
    private List<Integer> jobPositionId;
    private List<Integer> workPlaceId;
    private List<Integer> workTimeId;
}
