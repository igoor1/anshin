package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.DonationDTO;
import fatec.anshinpet.api.dto.input.DonationInput;
import fatec.anshinpet.domain.service.DonationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/donations")
public class DonationController {

    private final DonationService donationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DonationDTO> findAll() {
        return donationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DonationDTO getById(@PathVariable Long id) {
        return donationService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DonationDTO createDonation(@RequestBody @Valid DonationInput donationInput) {
        return donationService.create(donationInput);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DonationDTO updateDonation(@PathVariable Long id, @RequestBody @Valid DonationInput donationInput) {
        return donationService.update(id, donationInput);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        donationService.deleteById(id);
    }
}
