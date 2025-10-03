package fatec.anshinpet.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class Image implements Serializable {

    @Serial
    private static final long  serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String description;
    private String contentType;
    private Long size;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image image)) return false;
        return Objects.equals(getId(), image.getId()) && Objects.equals(getFileName(), image.getFileName()) && Objects.equals(getDescription(), image.getDescription()) && Objects.equals(getContentType(), image.getContentType()) && Objects.equals(getSize(), image.getSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFileName(), getDescription(), getContentType(), getSize());
    }
}
