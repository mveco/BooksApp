package finki.ukim.mk.wpproekt.web;

import finki.ukim.mk.wpproekt.model.Author;
import finki.ukim.mk.wpproekt.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/authors", allowedHeaders="*")//add
@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return this.authorService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Integer id) {
        return this.authorService.getById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestParam String name) {
        return this.authorService.create(name)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        this.authorService.delete(id);
    }
}
