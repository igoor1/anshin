package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.VaccineDTO;
import fatec.anshinpet.api.dto.input.VaccineInput;
import fatec.anshinpet.api.dto_mapper.ObjectMapper;
import fatec.anshinpet.domain.exception.VaccineNotFoundException;
import fatec.anshinpet.domain.model.Vaccine;
import fatec.anshinpet.domain.repository.VaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class VaccineService {

    private final VaccineRepository vaccineRepository;

    public List<VaccineDTO> findAll() {
        List<Vaccine> vaccines = vaccineRepository.findAll();
        return parseListObjects(vaccines, VaccineDTO.class);
    }

    public Vaccine findByIdOrException(Long id) {
        return vaccineRepository.findById(id).orElseThrow(
                () -> new VaccineNotFoundException("Vaccine not found.")
        );
    }

    public VaccineDTO getById(Long id) {
        Vaccine vaccine = findByIdOrException(id);
        return parseObject(vaccine, VaccineDTO.class);
    }

    @Transactional
    public VaccineDTO create(VaccineInput vaccineInput) {
        Vaccine vaccine = parseObject(vaccineInput, Vaccine.class);
        vaccineRepository.save(vaccine);
        return parseObject(vaccine, VaccineDTO.class);
    }

    @Transactional
    public VaccineDTO update(Long id, VaccineInput vaccineInput) {
        Vaccine currentVaccine = findByIdOrException(id);
        BeanUtils.copyProperties(vaccineInput, currentVaccine, "id");
        return parseObject(currentVaccine, VaccineDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        Vaccine vaccine = findByIdOrException(id);
        vaccineRepository.deleteById(id);
    }
}
