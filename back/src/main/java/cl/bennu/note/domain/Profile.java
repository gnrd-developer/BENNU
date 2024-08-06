package cl.bennu.note.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile {

    private Long id;
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
