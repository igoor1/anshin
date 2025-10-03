package fatec.anshinpet.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class AnimalVaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate application_date;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnimalVaccine that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getApplication_date(), that.getApplication_date()) && Objects.equals(getAnimal(), that.getAnimal()) && Objects.equals(getVaccine(), that.getVaccine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getApplication_date(), getAnimal(), getVaccine());
    }
}
