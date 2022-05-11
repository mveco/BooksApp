package finki.ukim.mk.wpproekt.web;

import finki.ukim.mk.wpproekt.model.Author;
import finki.ukim.mk.wpproekt.model.Publisher;
import finki.ukim.mk.wpproekt.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String findAll(@RequestParam(required = false) String namePart, Model model) {

        List<Author> authors;
        if(namePart == null || namePart.equals(""))
            authors =  this.authorService.getAll();
        else
            authors = this.authorService.getAllByName(namePart);

        model.addAttribute("authors", authors);
        return "authors";
    }

    @PostMapping("/add")
    public String save(@RequestParam String name) {

        this.authorService.create(name);
        return "redirect:/authors";

    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {

        Author author = this.authorService.getById(id).get();
        model.addAttribute("author", author);
        return "authors-update";

    }

    @PostMapping("/edited")
    public String edit(Model model, @RequestParam Integer id, @RequestParam String name) {

        this.authorService.update(id, name);
        return "redirect:/authors";

    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){

        this.authorService.deleteById(id);
        return "redirect:/authors";
    }
}
