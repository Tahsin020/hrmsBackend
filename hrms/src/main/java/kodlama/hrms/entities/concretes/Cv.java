package kodlama.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cv")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @ManyToOne()
	    @JoinColumn(name = "candidate_id")
	    private Candidate candidate;

	    @Column(name = "github")
	    private String github;

	    @Column(name = "linkedin")
	    private String linkedin;

	    @Column(name = "biography")
	    private String biography;

	    @OneToMany(mappedBy = "cv")
	    private List<Image> images;

	    @OneToMany(mappedBy = "cv")
	    private List<Experiance> experiances;

	    @OneToMany(mappedBy = "cv")
	    private List<Language> languages;

	    @OneToMany(mappedBy = "cv")
	    private List<School> schools;

	    @OneToMany(mappedBy = "cv")
	    private List<Technology> technologies;
}
