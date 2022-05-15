package finki.ukim.mk.wpproekt.web;

import finki.ukim.mk.wpproekt.model.Book;
import finki.ukim.mk.wpproekt.model.User;
import finki.ukim.mk.wpproekt.model.UserBookInteraction;
import finki.ukim.mk.wpproekt.model.exceptions.UBINotFound;
import finki.ukim.mk.wpproekt.service.BookService;
import finki.ukim.mk.wpproekt.service.UserBookInteractionService;
import finki.ukim.mk.wpproekt.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {

    private final UserBookInteractionService service;
    private final UserService userService;

    public ReadingListController(UserBookInteractionService service, BookService bookService, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    public String usersReadingList(HttpServletRequest req, Authentication authentication, Model model){

        User user = (User) authentication.getPrincipal();
        List<UserBookInteraction> books = this.service.findAllByUser(user);
        model.addAttribute("books", books);
        model.addAttribute("bodyContent", "home");

        return "master-template";
    }

    @GetMapping("/add/{id}")
    public String addToReadingList(@PathVariable Integer id, HttpServletRequest req, Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        UserBookInteraction ubi = this.service.create(user.getUsername(), id)
                .orElseThrow(() -> new UBINotFound());
        return "redirect:/home";
    }


    @PostMapping("/rate")
    public String rate(@RequestParam Integer id, @RequestParam Integer rating){

        service.rate(id, rating);
        return "redirect:/home";
    }
}
