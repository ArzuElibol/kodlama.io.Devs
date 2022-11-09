package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.PrograminLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;

@Repository
public class InMemoryProgramingLanguage implements PrograminLanguageRepository {

    List<ProgramingLanguage> programingLanguages;

    public InMemoryProgramingLanguage() {
        programingLanguages = new ArrayList<ProgramingLanguage>();
        programingLanguages.add(new ProgramingLanguage(1, "C#"));
        programingLanguages.add(new ProgramingLanguage(2, "Java"));
        programingLanguages.add(new ProgramingLanguage(3, "Python"));
    }

    @Override
    public List<ProgramingLanguage> getAll() {
        return programingLanguages;
    }

    @Override
    public void add(ProgramingLanguage programingLanguage) {
        programingLanguages.add(programingLanguage);

    }

    @Override
    public void update(ProgramingLanguage programingLanguage, int id) {
        ProgramingLanguage pLanguage = getLanguageId(id);
        pLanguage.setName(programingLanguage.getName());

    }

    

    @Override
    public void delete(int id) {
    ProgramingLanguage pLanguage=getLanguageId(id);
    this.programingLanguages.remove(pLanguage);

    }

    @Override
    public ProgramingLanguage getLanguageId(int id) {
        for (ProgramingLanguage programingLanguage : getAll()) {
            if (programingLanguage.getId() == id) {
                return programingLanguage;
            }

        }
        return null;
    }

}
