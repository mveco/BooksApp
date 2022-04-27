package finki.ukim.mk.wpproekt.web;

import finki.ukim.mk.wpproekt.model.Publisher;
import finki.ukim.mk.wpproekt.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/publishers", allowedHeaders="*")//add
@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<Publisher> findAll() {
        return this.publisherService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable Integer id) {
        return this.publisherService.getById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Publisher> save(@RequestParam String name) {
        return this.publisherService.create(name)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        this.publisherService.delete(id);
    }
}
