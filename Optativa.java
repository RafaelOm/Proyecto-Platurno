package TodosPosetPosibles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Optativa {
	@Column (nullable = false)
	private String plazas;
	private String mencion;
	@Embedded
	private Asignatura asig_opt;
}
