package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.AnimalDTO;
import fatec.anshinpet.api.dto.input.AnimalInput;
import fatec.anshinpet.domain.exception.AnimalNotFoundException;
import fatec.anshinpet.domain.model.Animal;
import fatec.anshinpet.domain.model.AnimalStatus;
import fatec.anshinpet.domain.model.AnimalType;
import fatec.anshinpet.domain.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalTypeService animalTypeService;
    private final AnimalStatusService animalStatusService;

    public Page<AnimalDTO> findAll(Pageable pageable) {
        Page<Animal> animalPage = animalRepository.findAll(pageable);
        List<Animal> animalList = animalPage.getContent();
        List<AnimalDTO> animalDTO = parseListObjects(animalList, AnimalDTO.class);
        return new PageImpl<>(animalDTO, pageable, animalPage.getTotalElements());
    }

    public Animal findByIdOrException(Long animalId) {
        return animalRepository.findById(animalId).orElseThrow(
                () -> new AnimalNotFoundException("Animal not found!")
        );
    }

    public AnimalDTO getById(Long animalId) {
        Animal animal = findByIdOrException(animalId);
        return parseObject(animal, AnimalDTO.class);
    }

    @Transactional
    public AnimalDTO create(AnimalInput animalInput) {
        Animal animal = parseObject(animalInput, Animal.class);
        AnimalType type = animalTypeService.findByIdOrException(animalInput.getType());
        AnimalStatus status = animalStatusService.findByIdOrException(animalInput.getStatus());
        animal.setAnimalType(type);
        animal.setAnimalStatus(status);
        animalRepository.save(animal);
        return parseObject(animal, AnimalDTO.class);
    }

    @Transactional
    public AnimalDTO update (Long id, AnimalInput animal) {
        Animal currentAnimal = findByIdOrException(id);
        AnimalType type = animalTypeService.findByIdOrException(animal.getType());
        AnimalStatus status = animalStatusService.findByIdOrException(animal.getStatus());
        currentAnimal.setAnimalType(type);
        currentAnimal.setAnimalStatus(status);
        BeanUtils.copyProperties(animal, currentAnimal, "id");
        animalRepository.save(currentAnimal);
        return parseObject(currentAnimal, AnimalDTO.class);
    }

    @Transactional
    public void detele(Long animalId) {
        Animal animal = findByIdOrException(animalId);
        animalRepository.deleteById(animalId);
    }

}
