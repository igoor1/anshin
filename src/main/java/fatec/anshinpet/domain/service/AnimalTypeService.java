package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.AnimalStatusDTO;
import fatec.anshinpet.api.dto.AnimalTypeDTO;
import fatec.anshinpet.api.dto.input.TypeInput;
import fatec.anshinpet.domain.exception.AnimalTypeNotFoundException;
import fatec.anshinpet.domain.model.AnimalType;
import fatec.anshinpet.domain.repository.AnimalTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class AnimalTypeService {

    private final AnimalTypeRepository animalTypeRepository;

    public AnimalType findByIdOrException(Long id) {
        return animalTypeRepository.findById(id)
                .orElseThrow(() -> new AnimalTypeNotFoundException("")
        );
    }

    public AnimalTypeDTO getById(Long typeId){
        AnimalType type = findByIdOrException(typeId);
        return parseObject(type, AnimalTypeDTO.class);
    }

    public List<AnimalTypeDTO> findAll() {
        List<AnimalType> types = animalTypeRepository.findAll();
        return parseListObjects(types, AnimalTypeDTO.class);
    }

    @Transactional
    public AnimalTypeDTO create(TypeInput typeInput) {
        AnimalType type = parseObject(typeInput, AnimalType.class);
        animalTypeRepository.save(type);
        return parseObject(type, AnimalTypeDTO.class);
    }

    @Transactional
    public AnimalTypeDTO update(Long typeId, TypeInput type) {
        AnimalType currentType = findByIdOrException(typeId);
        BeanUtils.copyProperties(type, currentType, "id");
        return parseObject(currentType, AnimalTypeDTO.class);
    }

    @Transactional
    public void delete(Long typeId) {
        AnimalType type = findByIdOrException(typeId);
        animalTypeRepository.deleteById(typeId);
    }
}
