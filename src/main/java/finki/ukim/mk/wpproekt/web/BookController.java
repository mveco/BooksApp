package finki.ukim.mk.wpproekt.web;

import finki.ukim.mk.wpproekt.model.Author;
import finki.ukim.mk.wpproekt.model.Book;
import finki.ukim.mk.wpproekt.model.Publisher;
import finki.ukim.mk.wpproekt.service.AuthorService;
import finki.ukim.mk.wpproekt.service.BookService;
import finki.ukim.mk.wpproekt.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;


    public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @GetMapping
    public String findAll(@RequestParam(required = false) String namePart, Model model){
        List<Book> books;
        if(namePart == null || namePart.equals(""))
            books =  this.bookService.getAll();
        else
            books = this.bookService.getAllByTitle(namePart);

        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id) {
        Book book = this.bookService.getById(id).get();
        
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestParam String title,
                                     @RequestParam(value = "0.0", required=false) Float avg_rating,
                                     @RequestParam(value = "", required=false) String isbn,
                                     @RequestParam(value = "", required=false) String isbn13,
                                     @RequestParam String lang_code,
                                     @RequestParam Integer num_pages,
                                     @RequestParam(value = "0", required=false) Integer ratings_count,
                                     @RequestParam(value = "", required=false) Date publication_date,
                                     @RequestParam Integer publisherID,
                                     @RequestParam List<Integer> authorsID) {
        return this.bookService.create(title, avg_rating, isbn, isbn13, lang_code, num_pages, ratings_count,
                        publication_date, publisherID, authorsID)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        this.bookService.delete(id);
    }



}
