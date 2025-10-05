package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.MedicationDTO;
import fatec.anshinpet.api.dto.input.MedicationInput;
import fatec.anshinpet.domain.exception.MedicationNotFoundException;
import fatec.anshinpet.domain.model.Medication;
import fatec.anshinpet.domain.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public List<MedicationDTO> findAll() {
        List<Medication> medications = medicationRepository.findAll();
        return parseListObjects(medications, MedicationDTO.class);
    }

    public Medication findByIdOrException(Long id) {
        return medicationRepository.findById(id).orElseThrow(
                () -> new MedicationNotFoundException("Medication not found.")
        );
    }

    public MedicationDTO getById(Long id) {
        Medication medication = findByIdOrException(id);
        return parseObject(medication, MedicationDTO.class);
    }

    @Transactional
    public MedicationDTO create(MedicationInput medicationInput) {
        Medication medication = parseObject(medicationInput, Medication.class);
        medicationRepository.save(medication);
        return parseObject(medication, MedicationDTO.class);
    }

    @Transactional
    public MedicationDTO update(Long id, MedicationInput medicationInput) {
        Medication currentMedication = findByIdOrException(id);
        BeanUtils.copyProperties(medicationInput, currentMedication, "id");
        return parseObject(currentMedication, MedicationDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        Medication medication = findByIdOrException(id);
        medicationRepository.deleteById(id);
    }

}
