package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.AnimalDTO;
import fatec.anshinpet.api.dto.PageDTO;
import fatec.anshinpet.domain.service.AnimalService;
import fatec.anshinpet.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/available")
public class AdoptionController {

    private final AnimalService animalService;
    private final ImageService imageService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageDTO<AnimalDTO> list(@PageableDefault(size = 12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<AnimalDTO> animalList = animalService.findAvailable(pageable);
        return new PageDTO<>(animalList);
    }

    @GetMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDTO findById(@PathVariable Long animalId) {
        return animalService.getById(animalId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{animalId}/image")
    public ResponseEntity<InputStreamResource> getAnimalImage(
            @PathVariable Long animalId, @RequestHeader(name = "accept", defaultValue = "image/*") String acceptHeader) {
        var animal = animalService.findByIdOrException(animalId);
        return imageService.getImage(animal.getImage());
    }

}
