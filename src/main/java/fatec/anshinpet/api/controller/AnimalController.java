package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.AnimalDTO;
import fatec.anshinpet.api.dto.ImageDTO;
import fatec.anshinpet.api.dto.PageDTO;
import fatec.anshinpet.api.dto.input.AnimalInput;
import fatec.anshinpet.api.dto.input.ImageInput;
import fatec.anshinpet.domain.model.Image;
import fatec.anshinpet.domain.service.AnimalService;
import fatec.anshinpet.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/animals")
public class AnimalController {

    private final AnimalService animalService;
    private final ImageService imageService;

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{animalId}/image")
    public ResponseEntity<InputStreamResource> getUserImage(
            @PathVariable Long animalId, @RequestHeader(name = "accept", defaultValue = "image/*") String acceptHeader) {
        var animal = animalService.findByIdOrException(animalId);
        return imageService.getImage(animal.getImage());
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{animalId}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ImageDTO saveUserImage(@PathVariable Long animalId, ImageInput imageInput) throws IOException {
        MultipartFile file = imageInput.getFile();
        var image = parseObject(imageInput, Image.class);
        image.setFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        var animal = animalService.findByIdOrException(animalId);
        image = animalService.saveAnimalImage(animal, image, imageInput.getFile().getInputStream());
         return parseObject(image, ImageDTO.class);
    }

    @DeleteMapping("/{animalId}/image")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimalImage(@PathVariable Long animalId) {
        var animal = animalService.findByIdOrException(animalId);
        animalService.deleteAnimalImage(animal);
    }
}
