package kodlama.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id")
public class Candidate extends User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name")
	private String lastName;
	
	@Column(name="national_Number")
	private String nationalNumber;
	
	@Column(name="birthdate")
	private LocalDate birthDate;

	public Candidate(int id, String email, String password, boolean mailVerify, int id2, String firstName,
			String lastName, String nationalNumber, LocalDate birthDate) {
		super(id, email, password, mailVerify);
		id = id2;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalNumber = nationalNumber;
		this.birthDate = birthDate;
	}
	

	
}
