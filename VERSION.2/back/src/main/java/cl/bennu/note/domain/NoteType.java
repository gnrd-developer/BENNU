package cl.bennu.note.domain;

import cl.bennu.note.domain.base.BaseDomain;
import lombok.Data;

@Data
public class NoteType extends BaseDomain {

    private String name;
    private Boolean active;

}
