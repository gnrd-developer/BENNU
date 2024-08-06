package cl.bennu.note.service;

import cl.bennu.note.domain.NoteType;
import cl.bennu.note.mapper.iface.NoteTypeMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class NoteService {

    private @Inject NoteTypeMapper noteTypeMapper;

    public List<NoteType> getAllNoteType() {
        List<NoteType> noteTypes = noteTypeMapper.getAll();
        return noteTypes;
    }

    public NoteType getNoteTypeById(Long id) {
        NoteType noteType = noteTypeMapper.getById(id);
        return noteType;
    }

    public void saveNoteType(NoteType noteType) {
        if (noteType.getId() == null) {
            noteTypeMapper.insert(noteType);

        } else {
            noteTypeMapper.update(noteType);

        }
    }

    public void deleteNoteTypeById(Long id) {
        noteTypeMapper.deleteById(id);
    }

}
