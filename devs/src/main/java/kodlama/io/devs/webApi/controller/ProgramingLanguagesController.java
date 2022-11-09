package kodlama.io.devs.webApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgramingLanguageServie;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgramingLanguagesController {
    private ProgramingLanguageServie programingLanguageServie;

    // @Autowired spring in yeni versiyonlarında yazmasanda çalışır
    public ProgramingLanguagesController(ProgramingLanguageServie programingLanguageServie) {
        this.programingLanguageServie = programingLanguageServie;
    }

    @GetMapping("/getAll")
    public List<ProgramingLanguage> getAll() {
        return programingLanguageServie.getAll();

    }

    @PutMapping("update/{id}")
    public void update(@RequestBody() ProgramingLanguage programingLanguage, @PathVariable int id) {
        this.programingLanguageServie.update(programingLanguage, id);
    }

    @PostMapping("/add")
    public void add(@RequestBody() ProgramingLanguage programingLanguage) throws Exception {
        this.programingLanguageServie.add(programingLanguage);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id)throws Exception{
        this.programingLanguageServie.delete(id);
    }

    
    @GetMapping("/getById/{id}")
    public void getLanguageId(@PathVariable int id){
        this.programingLanguageServie.getLanguageId(id);
    }

}
