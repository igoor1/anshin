package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.AnimalMedicationDTO;
import fatec.anshinpet.api.dto.input.AnimalMedicationInput;
import fatec.anshinpet.domain.exception.AnimalMedicationNotFoundException;
import fatec.anshinpet.domain.model.Animal;
import fatec.anshinpet.domain.model.AnimalMedication;
import fatec.anshinpet.domain.model.Medication;
import fatec.anshinpet.domain.repository.AnimalMedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class AnimalMedicationService {

    private final AnimalMedicationRepository animalMedicationRepository;
    private final MedicationService medicationService;
    private final AnimalService animalService;

    public List<AnimalMedicationDTO> findAll() {
        List<AnimalMedication> medications = animalMedicationRepository.findAll();
        return parseListObjects(medications, AnimalMedicationDTO.class);
    }

    public AnimalMedication findByIdOrException(Long id) {
        return animalMedicationRepository.findById(id).orElseThrow(
                () -> new AnimalMedicationNotFoundException("Animal medication not found.")
        );
    }

    public AnimalMedicationDTO getById(Long id) {
        AnimalMedication animalMedication = findByIdOrException(id);
        return parseObject(animalMedication, AnimalMedicationDTO.class);
    }

    public List<AnimalMedicationDTO> findByAnimal(Long id) {
        List<AnimalMedication> animalMedication = animalMedicationRepository.findByAnimalId(id);
        return parseListObjects(animalMedication, AnimalMedicationDTO.class);
    }
    @Transactional
    public AnimalMedicationDTO create(AnimalMedicationInput medicationInput) {
        Animal animal = animalService.findByIdOrException(medicationInput.getAnimalId());
        Medication medication = medicationService.findByIdOrException(medicationInput.getMedicationId());
        AnimalMedication animalMedication = parseObject(medicationInput, AnimalMedication.class);
        animalMedication.setAnimal(animal);
        animalMedication.setMedication(medication);
        animalMedicationRepository.save(animalMedication);
        return parseObject(animalMedication, AnimalMedicationDTO.class);
    }

    @Transactional
    public AnimalMedicationDTO update(Long id, AnimalMedicationInput medicationInput) {
        AnimalMedication currentAnimalMedication = findByIdOrException(id);
        Animal animal = animalService.findByIdOrException(medicationInput.getAnimalId());
        Medication medication = medicationService.findByIdOrException(medicationInput.getMedicationId());
        AnimalMedication animalMedication = parseObject(medicationInput, AnimalMedication.class);
        animalMedication.setAnimal(animal);
        animalMedication.setMedication(medication);
        BeanUtils.copyProperties(animalMedication, currentAnimalMedication, "id");
        return parseObject(currentAnimalMedication, AnimalMedicationDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        AnimalMedication animalMedication = findByIdOrException(id);
        animalMedicationRepository.deleteById(id);
    }
}