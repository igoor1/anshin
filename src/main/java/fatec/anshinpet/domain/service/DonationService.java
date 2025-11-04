package fatec.anshinpet.domain.service;

import fatec.anshinpet.api.dto.DonationDTO;
import fatec.anshinpet.api.dto.input.DonationInput;
import fatec.anshinpet.domain.exception.DonationNotFoundException;
import fatec.anshinpet.domain.model.Donation;
import fatec.anshinpet.domain.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static fatec.anshinpet.api.dto_mapper.ObjectMapper.*;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public List<DonationDTO> findAll() {
        List<Donation> donations = donationRepository.findAll();
        return parseListObjects(donations, DonationDTO.class);
    }

    public Donation findByIdOrException(Long id) {
        return donationRepository.findById(id).orElseThrow(
                () -> new DonationNotFoundException("Donation not found.")
        );
    }

    public DonationDTO getById(Long id) {
        Donation donation = findByIdOrException(id);
        return parseObject(donation, DonationDTO.class);
    }

    @Transactional
    public DonationDTO create(DonationInput donationInput) {
        Donation donation = parseObject(donationInput, Donation.class);
        donationRepository.save(donation);
        return parseObject(donation, DonationDTO.class);
    }

    @Transactional
    public DonationDTO update(Long id, DonationInput donationInput) {
        Donation currentDonation = findByIdOrException(id);
        BeanUtils.copyProperties(donationInput, currentDonation, "id");
        return parseObject(currentDonation, DonationDTO.class);
    }

    @Transactional
    public void deleteById(Long id) {
        Donation donation = findByIdOrException(id);
        donationRepository.deleteById(id);
    }
}
