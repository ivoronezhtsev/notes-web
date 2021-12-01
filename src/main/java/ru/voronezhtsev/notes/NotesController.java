package ru.voronezhtsev.notes;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NotesController {
    private final NoteDao noteDao;

    @GetMapping("/notes")
    public String index(Model model) {
        val notes = new ArrayList<Note>();
        noteDao.findByUsername(getUsername()).forEach(notes::add);
        model.addAttribute("username", getUsername());
        model.addAttribute("notes", notes);
        return "notes";
    }

    @RequestMapping("/note/create")
    public String create(Model model) {
        val note = new Note();
        model.addAttribute("note", note);
        return "info";
    }

    @RequestMapping("/note/save")
    public String save(@ModelAttribute("note") Note note) {
        note.setUsername(getUsername());
        noteDao.save(note);
        return "redirect:/notes";
    }

    @RequestMapping(value = "/note/save/{id}")
    public String save(@PathVariable("id") Integer id, @ModelAttribute("note") Note note) {
        note.setId(id);
        note.setUsername(getUsername());
        noteDao.save(note);
        return "redirect:/notes";
    }

    @RequestMapping("/note/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("note", noteDao.findById(id).orElseThrow(NoSuchElementException::new));
        return "info";
    }

    @RequestMapping("/note/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        noteDao.deleteById(id);
        return "redirect:/notes";
    }

    private String getUsername() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return user.getUsername();
        }
        return null;
    }
}
