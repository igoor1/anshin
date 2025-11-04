package fatec.anshinpet.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class MonetaryDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "donation_id")
    private Donation donation;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MonetaryDonation that = (MonetaryDonation) o;
        return Double.compare(getAmount(), that.getAmount()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getDonation(), that.getDonation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount(), getDonation());
    }
}
