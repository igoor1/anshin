package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.AnimalDTO;
import fatec.anshinpet.api.dto.PageDTO;
import fatec.anshinpet.api.dto.input.AnimalInput;
import fatec.anshinpet.domain.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/animals")
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageDTO<AnimalDTO> findAll(@PageableDefault(size = 12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<AnimalDTO> animalPage = animalService.findAll(pageable);
        return new PageDTO<>(animalPage);
    }

    @GetMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDTO findById(@PathVariable Long animalId) {
        return animalService.getById(animalId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDTO createAnimal(@RequestBody AnimalInput animalInput) {
        return animalService.create(animalInput);
    }

    @PutMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDTO updateAnimal (@PathVariable Long animalId, @RequestBody AnimalInput animal) {
        return animalService.update(animalId, animal);
    }

    @DeleteMapping("/{animalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimal(@PathVariable Long animalId){
        animalService.detele(animalId);
    }

}
