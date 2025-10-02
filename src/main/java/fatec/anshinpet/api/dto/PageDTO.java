package fatec.anshinpet.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PageDTO<T> {

    private List<T> content;
    private long totalItems;
    private int totalPages;
    private int currentPage;
    private Integer next;
    private Integer previous;

    public PageDTO(Page<T> page) {
        this.setContent(page.getContent());
        this.setTotalItems(page.getTotalElements());
        this.setTotalPages(page.getTotalPages());
        this.setCurrentPage(page.getNumber());
        this.setNext(page.hasNext() ? page.getNumber() + 1 : null);
        this.setPrevious(page.hasPrevious() ? page.getNumber() - 1 : null);
    }

}

