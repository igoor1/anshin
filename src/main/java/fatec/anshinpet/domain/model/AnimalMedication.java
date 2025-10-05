package fatec.anshinpet.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
public class AnimalMedication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dosage;
    private LocalDate start_date;
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private Medication medication;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnimalMedication that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDosage(), that.getDosage()) && Objects.equals(getStart_date(), that.getStart_date()) && Objects.equals(getEnd_date(), that.getEnd_date()) && Objects.equals(getAnimal(), that.getAnimal()) && Objects.equals(getMedication(), that.getMedication());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDosage(), getStart_date(), getEnd_date(), getAnimal(), getMedication());
    }
}
