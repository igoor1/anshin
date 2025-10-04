package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.AnimalDiseaseDTO;
import fatec.anshinpet.api.dto.input.AnimalDiseaseInput;
import fatec.anshinpet.domain.exception.AnimalDiseaseNotFoundException;
import fatec.anshinpet.domain.model.Animal;
import fatec.anshinpet.domain.model.AnimalDisease;
import fatec.anshinpet.domain.model.Disease;
import fatec.anshinpet.domain.repository.AnimalDiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class AnimalDiseaseService {

    private final AnimalDiseaseRepository animalDiseaseRepository;
    private final DiseaseService diseaseService;
    private final AnimalService animalService;

    public List<AnimalDiseaseDTO> findAll() {
        List<AnimalDisease> diseases = animalDiseaseRepository.findAll();
        return parseListObjects(diseases, AnimalDiseaseDTO.class);
    }

    public AnimalDisease findByIdOrException(Long id) {
        return animalDiseaseRepository.findById(id).orElseThrow(
                () -> new AnimalDiseaseNotFoundException("Animal-disease not Found.")
        );
    }

    public AnimalDiseaseDTO getById(Long id) {
        AnimalDisease animalDisease = findByIdOrException(id);
        return parseObject(animalDisease, AnimalDiseaseDTO.class);
    }

    public List<AnimalDiseaseDTO> findByAnimal(Long id) {
        List<AnimalDisease> animalDisease = animalDiseaseRepository.findByAnimalId(id);
        return parseListObjects(animalDisease, AnimalDiseaseDTO.class);
    }

    @Transactional
    public AnimalDiseaseDTO create(AnimalDiseaseInput diseaseInput) {
        Animal animal = animalService.findByIdOrException(diseaseInput.getAnimalId());
        Disease disease = diseaseService.findByIdOrException(diseaseInput.getDiseaseId());
        AnimalDisease animalDisease = parseObject(diseaseInput, AnimalDisease.class);
        animalDisease.setAnimal(animal);
        animalDisease.setDisease(disease);
        animalDiseaseRepository.save(animalDisease);
        return parseObject(animalDisease, AnimalDiseaseDTO.class);
    }

    @Transactional
    public AnimalDiseaseDTO update(Long id, AnimalDiseaseInput diseaseInput) {
        AnimalDisease currentAnimalDisease = findByIdOrException(id);
        Animal animal = animalService.findByIdOrException(diseaseInput.getAnimalId());
        Disease disease = diseaseService.findByIdOrException(diseaseInput.getDiseaseId());
        AnimalDisease animalDisease = parseObject(diseaseInput, AnimalDisease.class);
        animalDisease.setAnimal(animal);
        animalDisease.setDisease(disease);
        BeanUtils.copyProperties(animalDisease, currentAnimalDisease, "id");
        return parseObject(currentAnimalDisease, AnimalDiseaseDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        AnimalDisease animalDisease = findByIdOrException(id);
        animalDiseaseRepository.deleteById(id);
    }
}
