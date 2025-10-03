package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.AnimalStatusDTO;
import fatec.anshinpet.api.dto.input.StatusInput;
import fatec.anshinpet.domain.exception.AnimalStatusNotFoundException;
import fatec.anshinpet.domain.model.AnimalStatus;
import fatec.anshinpet.domain.repository.AnimalStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class AnimalStatusService {

    private final AnimalStatusRepository animalStatusRepository;

    public AnimalStatus findByIdOrException(Long statusId) {
        return animalStatusRepository.findById(statusId).orElseThrow(
                () -> new AnimalStatusNotFoundException("")
        );
    }

    public List<AnimalStatusDTO> findAll() {
        List<AnimalStatus> status = animalStatusRepository.findAll();
        return parseListObjects(status, AnimalStatusDTO.class);
    }

    public AnimalStatusDTO getById(Long statusId) {
        AnimalStatus status = findByIdOrException(statusId);
        return parseObject(status, AnimalStatusDTO.class);
    }

    @Transactional
    public AnimalStatusDTO create(StatusInput statusInput) {
        AnimalStatus status = parseObject(statusInput, AnimalStatus.class);
        animalStatusRepository.save(status);
        return parseObject(status, AnimalStatusDTO.class);
    }

    @Transactional
    public AnimalStatusDTO update(Long statusId, StatusInput status) {
        AnimalStatus currentStatus = findByIdOrException(statusId);
        BeanUtils.copyProperties(status, currentStatus, "id");
        return parseObject(currentStatus, AnimalStatusDTO.class);
    }

    @Transactional
    public void delete(Long statusId) {
        AnimalStatus status = findByIdOrException(statusId);
        animalStatusRepository.deleteById(statusId);
    }
}
