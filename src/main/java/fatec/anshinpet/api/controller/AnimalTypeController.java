package fatec.anshinpet.api.controller;


import fatec.anshinpet.api.dto.AnimalTypeDTO;
import fatec.anshinpet.api.dto.input.TypeInput;
import fatec.anshinpet.domain.service.AnimalTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/types")
public class AnimalTypeController {

    private final AnimalTypeService animalTypeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalTypeDTO> getAllTypes() {
        return animalTypeService.findAll();
    }

    @GetMapping("/{typeId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalTypeDTO findById(@PathVariable Long typeId) {
        return animalTypeService.getById(typeId);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public AnimalTypeDTO createType(@RequestBody @Valid TypeInput typeInput) {
        return animalTypeService.create(typeInput);
    }

    @PutMapping("/{typeId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalTypeDTO updateType(@PathVariable Long typeId, @RequestBody @Valid TypeInput type) {
        return animalTypeService.update(typeId, type);
    }

    @DeleteMapping("/{typeId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteType(@PathVariable  Long typeId) {
        animalTypeService.delete(typeId);
    }
}
