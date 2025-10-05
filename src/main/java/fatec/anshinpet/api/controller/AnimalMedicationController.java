package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.AnimalMedicationDTO;
import fatec.anshinpet.api.dto.input.AnimalMedicationInput;
import fatec.anshinpet.domain.model.AnimalMedication;
import fatec.anshinpet.domain.service.AnimalMedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/animal-medications")
public class AnimalMedicationController {

    private final AnimalMedicationService animalMedicationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalMedicationDTO> findAll() {
        return animalMedicationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalMedicationDTO findById(@PathVariable Long id) {
        return animalMedicationService.getById(id);
    }

    @GetMapping("animal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalMedicationDTO> findByName(@PathVariable Long id) {
        return animalMedicationService.findByAnimal(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalMedicationDTO createAnimalMedication(@RequestBody AnimalMedicationInput input) {
        return animalMedicationService.create(input);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalMedicationDTO updateAnimalMedication(@PathVariable Long id, @RequestBody AnimalMedicationInput input) {
        return animalMedicationService.update(id, input);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimalMedication(@PathVariable Long id) {
        animalMedicationService.delete(id);
    }
}
