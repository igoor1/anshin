package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.AnimalVaccineDTO;
import fatec.anshinpet.api.dto.input.AnimalVaccineInput;
import fatec.anshinpet.domain.service.AnimalVaccineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/animal-vaccines")
public class AnimalVaccineController {

    private final AnimalVaccineService animalVaccineService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalVaccineDTO> findAll() {
        return animalVaccineService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalVaccineDTO findById(@PathVariable Long id) {
        return animalVaccineService.getById(id);
    }

    @GetMapping("/animal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalVaccineDTO> findByName(@PathVariable Long id) {
        return animalVaccineService.findByAnimal(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalVaccineDTO createAnimalVaccine(@RequestBody @Valid AnimalVaccineInput input) {
        return animalVaccineService.create(input);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalVaccineDTO updateAnimalVaccine(@PathVariable Long id, @RequestBody @Valid AnimalVaccineInput input) {
        return animalVaccineService.update(id, input);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimalVaccine(@PathVariable Long id) {
        animalVaccineService.delete(id);
    }
}
