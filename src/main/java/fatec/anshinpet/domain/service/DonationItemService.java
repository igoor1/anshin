package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.DonationItemDTO;
import fatec.anshinpet.api.dto.input.DonationItemInput;
import fatec.anshinpet.domain.exception.DonationNotFoundException;
import fatec.anshinpet.domain.model.Donation;
import fatec.anshinpet.domain.model.DonationItem;
import fatec.anshinpet.domain.repository.DonationItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class DonationItemService {

    private final DonationItemRepository donationItemRepository;
    private final DonationService donationService;

    public List<DonationItemDTO> findAll() {
        List<DonationItem> donationsList =  donationItemRepository.findAll();
        return parseListObjects(donationsList, DonationItemDTO.class);
    }

    public DonationItem findByIdOrException(Long id) {
        return donationItemRepository.findById(id).orElseThrow(
                () -> new DonationNotFoundException("Donate not found.")
        );
    }

    public DonationItemDTO getById(Long id) {
        DonationItem donation = findByIdOrException(id);
        return parseObject(donation, DonationItemDTO.class);
    }

    @Transactional
    public DonationItemDTO create(DonationItemInput item) {
        Donation donation = donationService.findByIdOrException(item.getDonationId());
        DonationItem donationItem = parseObject(item, DonationItem.class);
        donationItem.setDonation(donation);
        donationItemRepository.save(donationItem);
        return parseObject(donationItem, DonationItemDTO.class);
    }

    @Transactional
    public DonationItemDTO update(Long id, DonationItemInput item) {
        DonationItem currentDonationItem = findByIdOrException(id);
        Donation donation = donationService.findByIdOrException(item.getDonationId());
        DonationItem donationItem = parseObject(item, DonationItem.class);
        donationItem.setDonation(donation);
        BeanUtils.copyProperties(donationItem, currentDonationItem, "id");
        return parseObject(donationItem, DonationItemDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        DonationItem donationItem = findByIdOrException(id);
        donationItemRepository.deleteById(id);
    }
}
