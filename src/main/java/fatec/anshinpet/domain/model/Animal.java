package fatec.anshinpet.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String color;

    private String gender;

    private LocalDate birth_date;

    private String breed;

    private String description;

    private LocalDate rescue_date;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image image;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private AnimalStatus animalStatus;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private AnimalType animalType;

}
