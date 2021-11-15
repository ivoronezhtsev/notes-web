package ru.voronezhtsev.notes;

import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Controller
@SpringBootApplication
public class NotesController {

    private final NoteDao noteDao;

    public NotesController(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @GetMapping("/")
    public String index(Model model) {
        val notes = new ArrayList<Note>();
        noteDao.findAll().forEach(notes::add);
        model.addAttribute("notes", notes);
        return "index";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        val note = new Note();
        model.addAttribute("note", note);
        return "info";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute("note") Note note) {
        noteDao.save(note);
        return "redirect:/";
    }

    @RequestMapping(value = "/save/{id}")
    public String save(@PathVariable("id") Integer id, @ModelAttribute("note") Note note) {
        note.setId(id);
        noteDao.save(note);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("note", noteDao.findById(id).orElseThrow(NoSuchElementException::new));
        return "info";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        noteDao.deleteById(id);
        return "redirect:/";
    }

    public static void main(String[] args) {
        SpringApplication.run(NotesController.class, args);
    }
}
