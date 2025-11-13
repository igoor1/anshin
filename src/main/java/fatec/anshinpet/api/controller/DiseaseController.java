package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.DiseaseDTO;
import fatec.anshinpet.api.dto.input.DiseaseInput;
import fatec.anshinpet.domain.service.DiseaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diseases")
public class DiseaseController {

    private final DiseaseService diseaseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DiseaseDTO> findAll() {
        return diseaseService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DiseaseDTO findById(@PathVariable Long id) {
        return diseaseService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DiseaseDTO createDisease(@RequestBody @Valid DiseaseInput diseaseInput) {
        return diseaseService.create(diseaseInput);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DiseaseDTO updateDisease(@PathVariable Long id, @RequestBody @Valid DiseaseInput diseaseInput) {
        return diseaseService.update(id, diseaseInput);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        diseaseService.delete(id);
    }
}
