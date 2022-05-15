package finki.ukim.mk.wpproekt.web;

import finki.ukim.mk.wpproekt.model.Publisher;
import finki.ukim.mk.wpproekt.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public String findAll(@RequestParam(required = false) String namePart, Model model) {

        List<Publisher> publishers;
        if (namePart == null || namePart.equals(""))
            publishers = this.publisherService.getAll();
        else
            publishers = this.publisherService.getAllByName(namePart);

        model.addAttribute("publishers", publishers);
        model.addAttribute("bodyContent", "publishers");
        return "master-template";
    }


    @PostMapping("/admin/add")
    public String save(@RequestParam String name) {

        this.publisherService.create(name);
        return "redirect:/publishers";

    }

    @GetMapping("/admin/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {

        Publisher publisher = this.publisherService.getById(id).get();
        model.addAttribute("publisher", publisher);
        model.addAttribute("bodyContent", "publishers-update");
        return "master-template";

    }

    @PostMapping("/admin/edited")
    public String edit(Model model, @RequestParam Integer id, @RequestParam String name) {

        this.publisherService.update(id, name);
        return "redirect:/publishers";

    }

    @PostMapping("/admin/delete/{id}")
    public String delete(@PathVariable Integer id) {

        this.publisherService.deleteById(id);
        return "redirect:/publishers";
    }
}
