package fatec.anshinpet.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
public class AnimalDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate diagnosis_date;
    private LocalDate recovery_date;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnimalDisease that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDiagnosis_date(), that.getDiagnosis_date()) && Objects.equals(getRecovery_date(), that.getRecovery_date()) && Objects.equals(getAnimal(), that.getAnimal()) && Objects.equals(getDisease(), that.getDisease());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDiagnosis_date(), getRecovery_date(), getAnimal(), getDisease());
    }
}
