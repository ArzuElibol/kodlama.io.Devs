package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.ProgramingLanguage;

public interface PrograminLanguageRepository {
    
List<ProgramingLanguage> getAll();
void add(ProgramingLanguage programingLanguage);
void update(ProgramingLanguage programingLanguage, int id);
void delete(int id);
ProgramingLanguage getLanguageId (int id);
}
