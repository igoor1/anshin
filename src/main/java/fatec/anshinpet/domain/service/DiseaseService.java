package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.DiseaseDTO;
import fatec.anshinpet.api.dto.input.DiseaseInput;
import fatec.anshinpet.domain.exception.DiseaseNotFoundException;
import fatec.anshinpet.domain.model.Disease;
import fatec.anshinpet.domain.repository.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public List<DiseaseDTO> findAll() {
        List<Disease> diseases = diseaseRepository.findAll();
        return parseListObjects(diseases, DiseaseDTO.class);
    }

    public Disease findByIdOrException(Long id) {
        return diseaseRepository.findById(id).orElseThrow(
                () -> new DiseaseNotFoundException("Disease not found.")
        );
    }

    public DiseaseDTO getById(Long id) {
        Disease disease = findByIdOrException(id);
        return parseObject(disease, DiseaseDTO.class);
    }

    @Transactional
    public DiseaseDTO create(DiseaseInput diseaseInput) {
        Disease disease = parseObject(diseaseInput, Disease.class);
        diseaseRepository.save(disease);
        return parseObject(disease, DiseaseDTO.class);
    }

    @Transactional
    public DiseaseDTO update(Long id, DiseaseInput diseaseInput) {
        Disease currentDisease = findByIdOrException(id);
        BeanUtils.copyProperties(diseaseInput, currentDisease, "id");
        return parseObject(currentDisease, DiseaseDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        Disease disease = findByIdOrException(id);
        diseaseRepository.deleteById(id);
    }
}
