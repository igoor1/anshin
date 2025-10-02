package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.AnimalStatusDTO;
import fatec.anshinpet.api.dto.input.StatusInput;
import fatec.anshinpet.domain.model.AnimalStatus;
import fatec.anshinpet.domain.service.AnimalStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/status")
public class AnimalStatusController {

    private final AnimalStatusService animalStatusService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalStatusDTO> getAllStatus () {
        return animalStatusService.findAll();
    }

    @GetMapping("/{statusId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalStatusDTO findById(@PathVariable Long statusId) {
        return animalStatusService.getById(statusId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalStatusDTO createStatus(@RequestBody StatusInput statusInput) {
        return animalStatusService.create(statusInput);
    }

    @PutMapping("/{statusId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalStatusDTO updateStatus(@PathVariable Long statusId, @RequestBody StatusInput status){
        return animalStatusService.update(statusId, status);
    }

    @DeleteMapping("/{statusId}")
    public void deleteStatus(@PathVariable  Long statusId) {
        animalStatusService.delete(statusId);
    }
}
