package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.MonetaryDonationDTO;
import fatec.anshinpet.api.dto.input.MonetaryDonationInput;
import fatec.anshinpet.domain.service.MonetaryDonationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/monetary-donations")
public class MonetaryDonationController {

    private final MonetaryDonationService monetaryDonationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MonetaryDonationDTO> findAll() {
        return  monetaryDonationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MonetaryDonationDTO findById(@PathVariable Long id) {
        return monetaryDonationService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MonetaryDonationDTO create(@RequestBody @Valid MonetaryDonationInput donationInput) {
        return monetaryDonationService.create(donationInput);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MonetaryDonationDTO update(@PathVariable Long id, @RequestBody @Valid MonetaryDonationInput donationInput) {
        return monetaryDonationService.update(id, donationInput);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        monetaryDonationService.delete(id);
    }
}
