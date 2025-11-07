package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.AnimalDiseaseDTO;
import fatec.anshinpet.api.dto.input.AnimalDiseaseInput;
import fatec.anshinpet.domain.service.AnimalDiseaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/animal-diseases")
public class AnimalDiseaseController {

    private final AnimalDiseaseService animalDiseaseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDiseaseDTO> findAll() {
        return animalDiseaseService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDiseaseDTO findById(@PathVariable Long id) {
        return animalDiseaseService.getById(id);
    }

    @GetMapping("/animal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDiseaseDTO> findByName(@PathVariable Long id) {
        return animalDiseaseService.findByAnimal(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDiseaseDTO createAnimalDisease(@RequestBody @Valid AnimalDiseaseInput input) {
        return animalDiseaseService.create(input);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDiseaseDTO updateAnimalDisease(@PathVariable Long id, @RequestBody @Valid AnimalDiseaseInput input) {
        return animalDiseaseService.update(id, input);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimalDisease(@PathVariable Long id) {
        animalDiseaseService.delete(id);
    }
}
