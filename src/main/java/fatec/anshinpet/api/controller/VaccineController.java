package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.VaccineDTO;
import fatec.anshinpet.api.dto.input.VaccineInput;
import fatec.anshinpet.domain.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineDTO> findAll() {
        return vaccineService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineDTO findById(@PathVariable Long id) {
        return vaccineService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public VaccineDTO createVaccine(@RequestBody VaccineInput vaccineInput) {
        return vaccineService.create(vaccineInput);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineDTO updateVaccine(@PathVariable Long id, @RequestBody VaccineInput vaccineInput) {
        return vaccineService.update(id, vaccineInput);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        vaccineService.delete(id);
    }
}
