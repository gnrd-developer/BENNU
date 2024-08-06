package cl.bennu.note.api;


import cl.bennu.note.domain.NoteType;
import cl.bennu.note.service.NoteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/note-type")
@Produces(MediaType.APPLICATION_JSON)
public class NoteTypeResource {

    private @Inject NoteService noteService;

    @GET
    public Response getAll() {
        List<NoteType> noteTypes = noteService.getAllNoteType();
        return Response.ok(noteTypes).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        NoteType noteType = noteService.getNoteTypeById(id);
        return Response.ok(noteType).build();
    }

    @POST
    public Response insert(NoteType noteType) {
        noteService.saveNoteType(noteType);
        return Response.ok(noteType).build();
    }

    @PUT
    public Response update(NoteType noteType) {
        noteService.saveNoteType(noteType);
        return Response.ok(noteType).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(Long id) {
        noteService.deleteNoteTypeById(id);
        return Response.ok().build();
    }

}
