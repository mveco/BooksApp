package finki.ukim.mk.wpproekt.web;

import finki.ukim.mk.wpproekt.model.Author;
import finki.ukim.mk.wpproekt.model.Book;
import finki.ukim.mk.wpproekt.model.Publisher;
import finki.ukim.mk.wpproekt.model.exceptions.BookNotFoundException;
import finki.ukim.mk.wpproekt.model.exceptions.PublisherNotFoundException;
import finki.ukim.mk.wpproekt.service.AuthorService;
import finki.ukim.mk.wpproekt.service.BookService;
import finki.ukim.mk.wpproekt.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = {"/books"})
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
    public String findAll(@RequestParam(required = false) String titlePart, Model model) {
        List<Book> books;
        if (titlePart == null || titlePart.equals(""))
            books = this.bookService.getAll();
        else
            books = this.bookService.getAllByTitle(titlePart);

        model.addAttribute("books", books);
        model.addAttribute("bodyContent", "books");
        return "master-template";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Integer id) {
        Book book = this.bookService.getById(id).get();
        model.addAttribute("book", book);
        model.addAttribute("bodyContent", "book-info");
        return "master-template";
    }

    @GetMapping("/admin/addForm")
    public String addForm(Model model) {

        List<Author> authors = this.authorService.getAll();
        List<Publisher> publishers = this.publisherService.getAll();
        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);

        model.addAttribute("bodyContent", "book-add");
        return "master-template";
    }

    @GetMapping("/admin/editForm/{id}")
    public String addForm(Model model, @PathVariable Integer id) {

        Book book = this.bookService.getById(id).orElseThrow(() -> new BookNotFoundException());
        List<Author> authors = this.authorService.getAll();
        List<Publisher> publishers = this.publisherService.getAll();

        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);

        model.addAttribute("bodyContent", "book-add");
        return "master-template";
    }

    @PostMapping("/admin/add-edit")
    public String addOrEdit(@RequestParam(required = false) Integer id,
                       @RequestParam String title,
                       @RequestParam Float avg_rating,
                       @RequestParam(value = "", required = false) String isbn,
                       @RequestParam(value = "", required = false) String isbn13,
                       @RequestParam String lang_code,
                       @RequestParam Integer num_pages,
                       @RequestParam Integer ratings_count,
                       @RequestParam(value = "", required = false) String publication_date,
                       @RequestParam Integer publisherID,
                       @RequestParam List<Integer> authorsID) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

        if (id == null) {
            this.bookService.create(title, avg_rating, isbn, isbn13, lang_code, num_pages, ratings_count,
                    date.parse(publication_date), publisherID, authorsID);
        } else {
            this.bookService.update(id, title, avg_rating, isbn, isbn13, lang_code, num_pages,
                    ratings_count, date.parse(publication_date), publisherID, authorsID);
        }
        return "redirect:/books";
    }

    @PostMapping("/admin/delete/{id}")
    public String delete(@PathVariable Integer id) {
        this.bookService.delete(id);
        return "redirect:/books";
    }


}
