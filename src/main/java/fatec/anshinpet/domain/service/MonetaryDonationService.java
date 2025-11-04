package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.MonetaryDonationDTO;
import fatec.anshinpet.api.dto.input.MonetaryDonationInput;
import fatec.anshinpet.domain.exception.DonationNotFoundException;
import fatec.anshinpet.domain.model.Donation;
import fatec.anshinpet.domain.model.MonetaryDonation;
import fatec.anshinpet.domain.repository.MonetaryDonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class MonetaryDonationService {

    private final MonetaryDonationRepository monetaryDonationRepository;
    private final DonationService donationService;

    public List<MonetaryDonationDTO> findAll() {
        List<MonetaryDonation>  monetaryDonations = monetaryDonationRepository.findAll();
        return parseListObjects(monetaryDonations, MonetaryDonationDTO.class);
    }

    public MonetaryDonation findByIdOrException(Long id) {
        return monetaryDonationRepository.findById(id).orElseThrow(
                () -> new DonationNotFoundException("Donation not found.")
        );
    }

    public MonetaryDonationDTO getById(Long id) {
        MonetaryDonation donation = findByIdOrException(id);
        return parseObject(donation, MonetaryDonationDTO.class);
    }

    @Transactional
    public MonetaryDonationDTO create(MonetaryDonationInput donationInput) {
        Donation donation = donationService.findByIdOrException(donationInput.getDonationId());
        MonetaryDonation monetaryDonation = parseObject(donationInput, MonetaryDonation.class);
        monetaryDonation.setDonation(donation);
        monetaryDonationRepository.save(monetaryDonation);
        return parseObject(monetaryDonation, MonetaryDonationDTO.class);
    }

    @Transactional
    public MonetaryDonationDTO update(Long id, MonetaryDonationInput donationInput) {
        MonetaryDonation currentMonetaryDonation = findByIdOrException(id);
        Donation donation = donationService.findByIdOrException(donationInput.getDonationId());
        MonetaryDonation monetaryDonation = parseObject(donationInput, MonetaryDonation.class);
        monetaryDonation.setDonation(donation);
        BeanUtils.copyProperties(monetaryDonation, currentMonetaryDonation, "id");
        return parseObject(currentMonetaryDonation, MonetaryDonationDTO.class);
    }

    @Transactional
    public void  delete(Long id) {
        MonetaryDonation donation = findByIdOrException(id);
        monetaryDonationRepository.deleteById(id);
    }
}
