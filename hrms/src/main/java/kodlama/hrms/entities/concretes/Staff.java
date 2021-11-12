package kodlama.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "staff")
@PrimaryKeyJoinColumn(name = "id")
public class Staff  extends User{

	@Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
}
