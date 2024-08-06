package cl.bennu.note.domain;

import cl.bennu.note.domain.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Profile extends BaseDomain {
    private Long usuarioId;
    private String mail;
    private String name;
    private String alias;
    private Long countryId;
    private String address;
    private Long phonePrefixId;
    private Long phone;
    private String photo;
    private Boolean statusProfile;    
}
