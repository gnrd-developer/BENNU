package cl.bennu.note.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private Long id;
    private Long categoryId;
    private Long noteTypeid;
    private Long labelId;
    private Long statusId;
    private String code;
    private String shortName;
    private String name;
    private boolean deleted;
    private boolean active;
}
