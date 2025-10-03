package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.AnimalVaccineDTO;
import fatec.anshinpet.api.dto.input.AnimalVaccineInput;
import fatec.anshinpet.domain.exception.AnimalVaccineNotFoundException;
import fatec.anshinpet.domain.model.Animal;
import fatec.anshinpet.domain.model.AnimalVaccine;
import fatec.anshinpet.domain.model.Vaccine;
import fatec.anshinpet.domain.repository.AnimalVaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class AnimalVaccineService {

    private final AnimalVaccineRepository animalVaccineRepository;
    private final AnimalService animalService;
    private final VaccineService vaccineService;

    public List<AnimalVaccineDTO> findAll() {
        List<AnimalVaccine> vaccines = animalVaccineRepository.findAll();
        return parseListObjects(vaccines, AnimalVaccineDTO.class);
    }

    public AnimalVaccine findByIdOrException(Long id) {
        return animalVaccineRepository.findById(id).orElseThrow(
                () -> new AnimalVaccineNotFoundException("")
        );
    }

    public AnimalVaccineDTO getById(Long id) {
        AnimalVaccine animalVaccine = findByIdOrException(id);
        return parseObject(animalVaccine, AnimalVaccineDTO.class);
    }

    public List<AnimalVaccineDTO> findByAnimal(Long id){
        List<AnimalVaccine> animalVaccine = animalVaccineRepository.findByAnimalId(id);
        return parseListObjects(animalVaccine, AnimalVaccineDTO.class);
    }

    @Transactional
    public AnimalVaccineDTO create(AnimalVaccineInput vaccineInput){
        Animal animal = animalService.findByIdOrException(vaccineInput.getAnimalId());
        Vaccine vaccine = vaccineService.findByIdOrException(vaccineInput.getVaccineId());
        AnimalVaccine animalVaccine = parseObject(vaccineInput, AnimalVaccine.class);
        animalVaccine.setAnimal(animal);
        animalVaccine.setVaccine(vaccine);
        animalVaccineRepository.save(animalVaccine);
        return parseObject(animalVaccine, AnimalVaccineDTO.class);
    }

    @Transactional
    public AnimalVaccineDTO update(Long id, AnimalVaccineInput animalVaccine) {
        AnimalVaccine currentAnimalVaccine = findByIdOrException(id);
        Animal animal = animalService.findByIdOrException(animalVaccine.getAnimalId());
        Vaccine vaccine = vaccineService.findByIdOrException(animalVaccine.getVaccineId());
        currentAnimalVaccine.setAnimal(animal);
        currentAnimalVaccine.setVaccine(vaccine);
        BeanUtils.copyProperties(animalVaccine, currentAnimalVaccine, "id");
        return parseObject(currentAnimalVaccine, AnimalVaccineDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        AnimalVaccine animalVaccine = findByIdOrException(id);
        animalVaccineRepository.deleteById(id);
    }
}
