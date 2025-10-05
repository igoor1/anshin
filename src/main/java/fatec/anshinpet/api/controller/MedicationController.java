package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.MedicationDTO;
import fatec.anshinpet.api.dto.input.MedicationInput;
import fatec.anshinpet.domain.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/medications")
public class MedicationController {

    private final MedicationService medicationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MedicationDTO> findAll() {
        return medicationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicationDTO findById(@PathVariable Long id) {
        return medicationService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicationDTO createMedication(@RequestBody MedicationInput medicationInput) {
        return medicationService.create(medicationInput);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicationDTO updateMedication(@PathVariable Long id, @RequestBody MedicationInput medicationInput) {
        return medicationService.update(id, medicationInput);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        medicationService.delete(id);
    }
}
