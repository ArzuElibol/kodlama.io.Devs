package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageServie {

    List<ProgramingLanguage> getAll();

    void add(ProgramingLanguage programingLanguage) throws Exception;

    void update(ProgramingLanguage programingLanguage, int id);

    void delete(int id)throws Exception;

    ProgramingLanguage getLanguageId(int id);

}
