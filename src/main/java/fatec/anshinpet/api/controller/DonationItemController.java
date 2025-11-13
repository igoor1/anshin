package fatec.anshinpet.api.controller;

import fatec.anshinpet.api.dto.DonationItemDTO;
import fatec.anshinpet.api.dto.input.DonationItemInput;
import fatec.anshinpet.domain.service.DonationItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/donation-items")
public class DonationItemController {

    private final DonationItemService donationItemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DonationItemDTO> findAll() {
        return donationItemService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DonationItemDTO findById(@PathVariable Long id) {
        return donationItemService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DonationItemDTO create(@RequestBody @Valid DonationItemInput itemInput) {
        return  donationItemService.create(itemInput);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DonationItemDTO update(@PathVariable Long id, @RequestBody @Valid DonationItemInput itemInput) {
        return donationItemService.update(id, itemInput);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        donationItemService.delete(id);
    }
}
