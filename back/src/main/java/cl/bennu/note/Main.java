package cl.bennu.note;
// import cl.bennu.note.domain.Category;
// import cl.bennu.note.domain.Country;
// import cl.bennu.note.domain.Note;
// import cl.bennu.note.mapper.iface.CategoryMapper;
// import cl.bennu.note.mapper.iface.CountryMapper;
// import cl.bennu.note.mapper.iface.NoteMapper;
// import cl.bennu.note.mapper.iface.UserMapper;
// import cl.bennu.note.domain.User;
// import java.util.List;
import cl.bennu.note.domain.Profile;
import cl.bennu.note.factory.MapperFactory;
import cl.bennu.note.mapper.iface.ProfileMapper;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);        
        Long idUsuarioProfile;
        ProfileMapper profileMapper = MapperFactory.getProfileMapper();           
        System.out.print("\n---------------------------------INSERT--------------------------------------------\n");
        // PROFILE
        Profile profileA = new Profile();
        System.out.println("que ID USUARIO quieres agregar al profile: ");
        idUsuarioProfile = sc.nextLong();                       
        profileA.setUsuarioId(idUsuarioProfile);//UNICO
        profileA.setMail("gnrd@profile.com");
        profileA.setName("otra cosa");
        profileA.setAlias("otra cosa");
        System.out.println("que ID COUNTRY QUIERES AGREGAR AL PERFIL?: ");
        Long idCountry = sc.nextLong();                                           
        profileA.setCountryId(idCountry);
        profileA.setAddress("gnrd gnrd 123");
        profileA.setPhonePrefixId(idCountry);
        profileA.setPhone(961288942L);
        profileA.setPhoto("http://gnrd.com");
        profileA.setStatusProfile(null);
        profileMapper.insert(profileA);
        System.out.print("\n");
        sc.close();
        //------------------------------CIERRE INSERT------------------------------------------                                           
    }

}
/*    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcionMenuUno;
        Long idBuscado;
        Long idProfileActualizado;
        Long idUsuarioActualizado;
        Long idEliminado;
        Long idUsuarioProfile;
        Long x;
        String c;
        String y;

        Category category1 = new Category();   
             
        do {
            System.out.print("\n\tHOLA OTRA VEZ MENU\n" +
            "---------------\n" +
            "0 . SALIR'\n" +
            "1 . MYBATIS'\n" +
            "2 . JDBC\n");        
            opcionMenuUno = sc.nextInt();
            switch (opcionMenuUno) {
                case 1:
                    //------------------------------MAPPERS--------------------------------------------------
                    // CategoryMapper categoryMapper = MapperFactory.getCategoryMapper();
                    // NoteMapper noteMapper = MapperFactory.getNoteMapper();
                    // CountryMapper countryMapper = MapperFactory.getCountryMapper();
                    // UserMapper userMapper = MapperFactory.getUserMapper();
                    ProfileMapper profileMapper = MapperFactory.getProfileMapper();                 
                    //------------------------------GET ALL---------------------------------------------------
                    System.out.print("\n---------------------------------GET ALL-------------------------------------------\n");
                    // GET ALL PROFILE
                    List<Profile> profileAll = profileMapper.getAll();
                    System.out.println("\n\tTODOS LOS PROFILES\n");
                    profileAll.forEach(profile -> System.out.println(profile + "\n"));
                    System.out.print("\n\n");
                    //------------------------------CIERRE DE GET ALL------------------------------------------    
                    

                    //------------------------------GET BY ID---------------------------------------------------
                    System.out.print("\n---------------------------------GET BY ID-----------------------------------------\n");
                    // GET BY ID
                    System.out.print("QUE ID BUSCAS: ");
                    idBuscado = sc.nextLong();
                    Profile profilePorId = profileMapper.getById(idBuscado);
                    if (profilePorId != null) {
                        System.out.println("\n\tBUSCAR PERFILES POR ID\n" +
                        "\n\t" + profilePorId.toString() 
                        + "\n");
                    }
                    System.out.print("\n\n");
                    //------------------------------CIERRE DE GET BY ID------------------------------------------


                    //------------------------------UPDATE BY ID---------------------------------------------------
                    System.out.print("\n---------------------------------UPDATE BY ID--------------------------------------\n");
                    // UPDATE PROFILE
                    Profile profileUpdate = new Profile();
                    System.out.println("que ID actualizar: ");
                    idProfileActualizado = sc.nextLong();
                    profileUpdate.setId(idProfileActualizado);
                    System.out.println("que ID USUARIO actualizar: ");
                    idUsuarioActualizado = sc.nextLong();                    
                    profileUpdate.setUsuarioId(idUsuarioActualizado);
                    profileUpdate.setMail("xxx");
                    profileUpdate.setName("actualizado");
                    profileUpdate.setAlias("actualizadoAlias");
                    profileUpdate.setCountryId(1L);
                    profileUpdate.setAddress("actualizado direction 123");
                    profileUpdate.setPhonePrefixId(1L);
                    profileUpdate.setPhone(961288942L);
                    profileUpdate.setPhoto("http://tuuuuufoto.actualizado");
                    profileMapper.update(profileUpdate);

                    Profile profilePorId2 = profileMapper.getById(idProfileActualizado);
                    System.out.println("\n\t" +
                    "\n\t" + profilePorId2.toString() 
                    + "\n");
                    System.out.print("\n");
                    //------------------------------CIERRE DE UPDATE BY ID------------------------------------------   
                    
                    
                    //------------------------------DELETES---------------------------------------------------
                    System.out.print("\n---------------------------------DELETES-------------------------------------------\n");
                    //PROFILE
                    System.out.println("que ID quieres eliminar: ");
                    idEliminado = sc.nextLong();                         
                    profileMapper.deleteById(idEliminado);
                    System.out.print("\n\n");
                    //------------------------------CIERRE DELETES------------------------------------------


                    //------------------------------INSERT---------------------------------------------------
                    System.out.print("\n---------------------------------INSERT--------------------------------------------\n");
                    // PROFILE
                    Profile profileA = new Profile();
                    System.out.println("que ID USUARIO quieres agregar al profile: ");
                    idUsuarioProfile = sc.nextLong();                       
                    profileA.setUsuarioId(idUsuarioProfile);//UNICO
                    profileA.setMail("gnrd@profile.com");
                    profileA.setName("otra cosa");
                    profileA.setAlias("otra cosa");
                    System.out.println("que ID COUNTRY QUIERES AGREGAR AL PERFIL?: ");
                    Long idCountry = sc.nextLong();                                           
                    profileA.setCountryId(idCountry);
                    profileA.setAddress("gnrd gnrd 123");
                    profileA.setPhonePrefixId(idCountry);
                    profileA.setPhone(961288942L);
                    profileA.setPhoto("http://gnrd.com");
                    profileMapper.insert(profileA);

                    System.out.println("\n\tTODOS LOS PROFILES\n");
                    profileAll.forEach(profile -> System.out.println(profile + "\n"));
                    System.out.print("\n");
                    //------------------------------CIERRE INSERT------------------------------------------                                           
                    break;
                case 2:
                    //------------------------------MAPPERS--------------------------------------------------
                    CategoryMapper categoryMapperJdbc = MapperFactory.getCategoryMapper();
                    NoteMapper noteMapperJdbc = MapperFactory.getNoteMapper();
                    CountryMapper countryMapperJdbc = MapperFactory.getCountryMapper();
                    UserMapper userMapperJdbc = MapperFactory.getUserMapper();
                    ProfileMapper profileMapperJdbc = MapperFactory.getProfileMapper();                
                    //------------------------------GET ALL---------------------------------------------------
                    System.out.print("\n---------------------------------GET ALL-------------------------------------------\n");

                    // user
                    List<User> users = userMapperJdbc.getAll();
                    System.out.println("\n\tTODOS LOS USUARIOS\n\t----------------------");
                    users.forEach(System.out::println);

                    // categoria
                    System.err.print("\n\t--------------------");
                    List<Category> categories = categoryMapperJdbc.getAll();
                    System.out.println("\n\tTODAS LAS CATEGORIAS\n\t----------------------");
                    categories.forEach(System.out::println);

                    //COUNTRY 
                    System.err.print("\n\t----------------------------\n");
                    long id1 = 0;
                    long id2 = 0;
                    long id3 = 0;
                    System.out.println("\n\tTODOS LOS PAISES\n\t----------------------");

                    List<Country> countries = countryMapperJdbc.getAll();
                    countries.forEach(System.out::println);         
                    for (int i = 0; i < countries.size(); i++) {

                    
                        if (i == 0) {
                        id1 = countries.get(i).getId();
                        
                        }
                        if (i == 1) {
                        id2 = countries.get(i).getId();
                        
                        }
                        if (i == 2) {
                        id3 = countries.get(i).getId();
                        
                        }
                    }

                    // NOTES
                    System.out.println("\n----------------------");
                    List<Note> notes = noteMapperJdbc.getAll();
                    System.out.println("\n\tTODAS LAS NOTAS\n\t");
                    notes.forEach(System.out::println);

                    // PROFILE
                    List<Profile> profileAllJdbc = profileMapperJdbc.getAll();
                    System.out.println("\n\n--------------------\n\tTODOS LOS PROFILES\n");
                    profileAllJdbc.forEach(System.out::println);

                    //------------------------------CIERRE DE GET ALL------------------------------------------


                    //------------------------------GET BY ID-------------------------------------------------
                    System.out.print("\n---------------------------------GET BY ID-------------------------------------------\n");


                    // users
                    if (!users.isEmpty()) {
                    Long userIdToFind = users.get(0).getId(); // Suponiendo que buscamos el primer usuario
                    User foundUser = userMapperJdbc.getById(userIdToFind);
                    System.out.println("\tUsuario encontrado: \n\t" +
                    foundUser + "\n\t------------------------------");
                    }

                    // categoria
                    System.out.print("\n\n");
                    System.out.println("INGRESE ID CATEGORIA BUSCADA: ");
                    x = sc.nextLong();
                    categoryMapperJdbc.getById(x);
                    System.out.print("\n\n");

                    // country
                    System.out.print("\n\n----------------------------\n\tPISES POR ID(los primeros id de la lista\n");                  
                    Country countryx = countryMapperJdbc.getById(id1);
                    System.out.println(countryx.toString());
                    Country country = countryMapperJdbc.getById(id2);
                    System.out.println(country.toString());

                    // NOTES
                    System.out.println("\n\tNOTES Select by id ");
                    System.out.println("INGRESE ID DE NOTA BUSCADA: ");
                    x = sc.nextLong();                    
                    System.out.println(noteMapperJdbc.getById(x));
                    System.out.println("\n\tSelect by code ");
                    System.out.println("INGRESE CODE CATEGORIA BUSCADA: ");
                    c = sc.next();                  
                    System.out.println(noteMapperJdbc.getByCode(c));

                    // PROFILES
                    System.out.println("\n\tINGRESE ID DE PROFILE BUSCADO: ");
                    x = sc.nextLong();                     
                    Profile profilePorIdJdbc = profileMapperJdbc.getById(x);
                    System.out.println("\n\t------------------\n\tBUSCAR PERFILES POR ID\n\t" +
                    "\n\t" + profilePorIdJdbc.toString() 
                    + "\n");


                    //------------------------------CIERRE GET BY ID------------------------------------------


                    //------------------------------UPDATES----------------------------------------------------
                    System.out.print("\n---------------------------------UPDATE-------------------------------------------\n");

                    // users
                    if (!users.isEmpty()) {
                    User userToUpdate = users.get(0);
                    System.out.println("INGRESE NUEVO NOMBRE USUARIO, DEBE SER UNICO(SE ACTUALIZARA EL PRIMER USUARIO EN LA LISTA): ");
                    c = sc.next();                    
                    userToUpdate.setUsername(c);//SE DEBE ACTUALIZAR EN CADA EJECUCION
                    userToUpdate.setPassword("updatedpassword");
                    userToUpdate.setActive(false);
                    userMapperJdbc.update(userToUpdate);
                    System.out.println("\n\tUsuario actualizado.\t");
                    }
                    //USERS
                    // renderizo para ver si se borraron
                    users = userMapperJdbc.getAll();
                    System.out.println("\nUsuarios después de la actualización:\n\t");
                    users.forEach(System.out::println);
                    System.err.print("\n--------------------------------------\n");
                    
                    // categoria
                    System.err.print("\n\n");
                    System.out.println("\n\tTODAS LAS CATEGORIAS\n\t");
                    categories.forEach(System.out::println);
                    System.err.print("\n\n\tUPDATE CATEGORY\n");
                    category1.setName("Hola");
                    category1.setActive(true);
                    System.out.println("INGRESE ID DE LA CATEGORIA QUE QUIERES ACTUALIZAR: ");
                    x = sc.nextLong();                     
                    category1.setId(x);
                    categoryMapperJdbc.update(category1);
                    
                    // country
                    System.err.print("\n-----------------------------------------------\n");
                    Country country4 = new Country();
                    System.out.println("INGRESE NUEVO NAME DE COUNTRY, DEBE SER UNICO(SE ACTUALIZARA EL PRIMERO DE LA LISTA)");  
                    System.out.println("INGRESE NUEVO NOMBRE DE PAIS: ");
                    y = sc.next();
                    country4.setName(y);//UNICO
                    country4.setFlag("12312");
                    country4.setPrefix(3424L);
                    country4.setId(id1);
                    countryMapperJdbc.update(country4);

                    // UPDATE NOTE
                    System.err.print("\n-----------------------------------------------\n");                    
                    users.forEach(System.out::println);
                    System.err.print("\n-----------------------------------------------\n"); 
                    Note newNoteUpdate = new Note();
                    System.out.println("INGRESE ID DE NOTA PARA ACTUALIZAR");
                    x = sc.nextLong();                     
                    newNoteUpdate.setId(x);
                    System.out.println("INGRESE ID DE CATEGORY PARA ACTUALIZAR");
                    x = sc.nextLong();                     
                    newNoteUpdate.setCategoryId(x);
                    newNoteUpdate.setNoteTypeid(1L);
                    newNoteUpdate.setLabelId(1L);
                    newNoteUpdate.setStatusId(1L);
                    newNoteUpdate.setCode("#234");
                    newNoteUpdate.setShortName("Notas estudio modificado");
                    newNoteUpdate.setName("Estudio");
                    newNoteUpdate.setDeleted(false);
                    newNoteUpdate.setActive(true);
                    //noteMapper.insert(newNote);
                    noteMapperJdbc.update(newNoteUpdate);

                    // UPDATE PROFILE
                    Profile profileUpdateJdbc = new Profile();
                    System.out.println("INGRESE ID DE PROFILE PARA ACTUALIZAR: ");
                    x = sc.nextLong();                     
                    profileUpdateJdbc.setId(x);
                    System.out.println("INGRESE ID DE USUARIO PARA ACTUALIZAR: ");
                    x = sc.nextLong();                      
                    profileUpdateJdbc.setUsuarioId(x);
                    profileUpdateJdbc.setMail("actualizado@profile.com");
                    profileUpdateJdbc.setName("actualizado");
                    profileUpdateJdbc.setAlias("actualizadoAlias");
                    profileUpdateJdbc.setCountryId(1L);
                    profileUpdateJdbc.setAddress("actualizado direction 123");
                    profileUpdateJdbc.setPhonePrefixId(1L);
                    profileUpdateJdbc.setPhone(123456789L);
                    profileUpdateJdbc.setPhoto("http://tuuuuufoto.actualizado");
                    profileMapperJdbc.update(profileUpdateJdbc);

                    //------------------------------CIERRE UPDATES---------------------------------------------
                    
                   
                    //------------------------------DELETES----------------------------------------------------
                    System.out.print("\n---------------------------------DELETES-------------------------------------------\n");

                    // users
                    if (!users.isEmpty()) {
                    Long userIdToDelete = users.get(0).getId(); // miramos al usuario 0 ya que ese estamos creando
                    userMapperJdbc.deleteById(userIdToDelete);
                    System.out.println("\n\tEL PRIMER USUARIO DE LA LISTA ID " + userIdToDelete +
                    " FUE ELIMINADO POR TERMINATOR.\n\t");        
                    users = userMapperJdbc.getAll();
                    System.out.println("\tUsuarios restantes:\n\t"
                    );
                    users.forEach(System.out::println);
                    }

                    // DELETE categoria
                    System.err.print("\n\t");
                    System.out.println("INGRESE ID DE CATEGORIA PARA ACTUALIZAR: ");
                    x = sc.nextLong();                      
                    categoryMapperJdbc.deleteById(x);
                    
                    // country
                    System.err.print("\n\t");
                    countryMapperJdbc.deleteById(id3);
                    
                    // NOTE
                    System.err.print("\n----------------------------------------------\n\n");                    
                    System.out.println("INGRESE ID DE NOTA PARA ELIMINAR: ");
                    x = sc.nextLong();                      
                    noteMapperJdbc.deleteById(x);

                    //PROFILE
                    System.out.println("INGRESE ID DEL PERFIL PARA ACTUALIZAR: ");
                    x = sc.nextLong();                      
                    profileMapperJdbc.deleteById(x);

                    //------------------------------CIERRE DELETES--------------------------------------------
                    
                    
                    //------------------------------INSERTAR ENTIDADES----------------------------------------
                    System.out.print("\n---------------------------------INSERTAR ENTIDADES-------------------------------------------\n");

                    // user
                    User newUser = new User();
                    System.out.println("INGRESE NOMBRE DE USUARIO PARA INGRESAR(DEBE SER UNICO): ");
                    c = sc.next();                      
                    newUser.setUsername(c);//UNICO
                    newUser.setPassword("newpassword");
                    newUser.setLastLogin(null);
                    newUser.setLastPassword(null);
                    newUser.setActive(true);
                    userMapperJdbc.insert(newUser);

                    // country
                    Country country1 = new Country();
                    System.out.println("INGRESE NOMBRE DE PAIS PARA INGRESAR: ");
                    y = sc.next();                      
                    country1.setName(y);//UNICO 
                    country1.setFlag("12312");
                    country1.setPrefix(3424L);
                    countryMapperJdbc.insert(country1);
                    
                    Country country2 = new Country();
                    System.out.println("\n\nINGRESE NOMBRE DE OTRO PAIS PARA INGRESAR: ");
                    c = sc.next();                      
                    country2.setName(c);//UNICO 
                    country2.setFlag("1332");
                    country2.setPrefix(4413L);
                    countryMapperJdbc.insert(country2);
                    
                    Country country3 = new Country();
                    System.out.println("\n\nINGRESE OTRO NOMBRE DE PAIS PARA INGRESAR: ");
                    c = sc.next();                      
                    country3.setName(c);//UNICO 
                    country3.setFlag("1432");
                    country3.setPrefix(35455L);
                    countryMapperJdbc.insert(country3);

                    // PROFILE
                    Profile profileJdbc = new Profile();
                    System.out.println("\n\nINGRESE NOMBRE DE PERFIL PARA INGRESAR: ");
                    c = sc.next();                      
                    profileJdbc.setUsuarioId(3L);//UNICO
                    profileJdbc.setMail("profile@profile.com");
                    profileJdbc.setName(c);
                    profileJdbc.setAlias("profileAlias");
                    profileJdbc.setCountryId(1L);
                    profileJdbc.setAddress("profile direction 123");
                    profileJdbc.setPhonePrefixId(1L);
                    profileJdbc.setPhone(961288942L);
                    profileJdbc.setPhoto("http://tuuuuufoto.com");
                    profileMapperJdbc.insert(profileJdbc);

                    // categoria
                    System.out.println("INGRESE NOMBRE DE CATEGORIA PARA INGRESAR(debe ser unico: ");
                    y = sc.next();
                    System.out.println("INGRESE ID DE USUARIO PARA LA CATEGORIA(debe ser unico: ");
                    x = sc.nextLong();
                    category1.setUserId(x);
                    category1.setLabelId(1L);
                    category1.setName(y);
                    category1.setActive(true);
                    categoryMapperJdbc.insert(category1);

                    // NOTAS
                    Note newNote = new Note();
                    System.out.println("INGRESE ID CATEGORIA PARA LA NOTA: ");
                    x = sc.nextLong();                      
                    newNote.setCategoryId(x);
                    newNote.setNoteTypeid(1L);
                    newNote.setLabelId(1L);
                    newNote.setStatusId(1L);
                    newNote.setCode("#1");
                    newNote.setShortName("Notas estudio");
                    newNote.setName("Estudio");
                    newNote.setDeleted(false);
                    newNote.setActive(true);
                    noteMapperJdbc.insert(newNote);
                    
                    
                    //------------------------------CIERRE DE INSERTAR----------------------------------------                
                    break;            
                default:
                    break;
            }            
        } while (opcionMenuUno != 0);
        sc.close();
    }
*/
