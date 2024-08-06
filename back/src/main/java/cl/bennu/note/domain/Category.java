package cl.bennu.note.domain;

import lombok.Data;

@Data
public class Category {

    private Long id;
    private Long userId;
    private Long labelId;
    private String name;
    private Boolean active;

}
