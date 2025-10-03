package fatec.anshinpet.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String manufacturer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaccine vaccine)) return false;
        return Objects.equals(getId(), vaccine.getId()) && Objects.equals(getName(), vaccine.getName()) && Objects.equals(getManufacturer(), vaccine.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getManufacturer());
    }
}
