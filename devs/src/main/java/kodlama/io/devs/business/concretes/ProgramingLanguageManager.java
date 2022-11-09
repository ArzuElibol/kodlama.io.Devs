package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgramingLanguageServie;
import kodlama.io.devs.dataAccess.abstracts.PrograminLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;

@Service
public class ProgramingLanguageManager implements ProgramingLanguageServie {

    private PrograminLanguageRepository programinLanguageRepository;

    public ProgramingLanguageManager(PrograminLanguageRepository programinLanguageRepository) {
        this.programinLanguageRepository = programinLanguageRepository;
    }

    @Override
    public List<ProgramingLanguage> getAll() {

        return programinLanguageRepository.getAll();
    }

    @Override
    public void add(ProgramingLanguage programingLanguage) throws Exception {
        if (isNameExist(programingLanguage)) {
            throw new Exception("İsim tekrar edemez.");
        }
        if (isIdExist(programingLanguage.getId())) {
            throw new Exception("id tekrar edemez");
        }
        programinLanguageRepository.add(programingLanguage);
    }

    @Override
    public void update(ProgramingLanguage programingLanguage, int id) {
       programinLanguageRepository.update(programingLanguage, id);

    }

    @Override
    public void delete(int id) throws Exception{
if (!isIdExist(id)){
    throw new Exception("Id bulunamadı");
}

programinLanguageRepository.delete(id);
    }

    @Override
    public ProgramingLanguage getLanguageId(int id) {
        return programinLanguageRepository.getLanguageId(id);
    }

    public boolean isIdExist(int id) {
        for (ProgramingLanguage pLanguage : getAll()) {
            if (pLanguage.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isNameExist(ProgramingLanguage programingLanguage) {
        for (ProgramingLanguage pLanguage : getAll()) {
            if (pLanguage.getName().equals(programingLanguage.getName())) {
                return true;
            }

        }
        return false;
    }

}
