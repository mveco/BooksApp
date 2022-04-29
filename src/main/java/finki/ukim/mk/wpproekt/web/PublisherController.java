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

        List<Publisher> publishers = null;
        if(namePart == null || namePart.equals(""))
            publishers =  this.publisherService.getAll();
        else
            publishers = this.publisherService.getAllByName(namePart);

        model.addAttribute("publishers", publishers);
        return "publishers";
    }

//    @PostMapping()
//    public String findAllByName(Model model, @RequestParam(required = false) String namePart) {
//
//        List<Publisher> publishers = null;
//        if(namePart == null || namePart.equals(""))
//            publishers =  this.publisherService.getAll();
//        else
//            publishers = this.publisherService.getAllByName(namePart);
//
//        model.addAttribute("publishers", publishers);
//        return "publishers";
//    }

    @GetMapping("/publishers/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable Integer id) {
        return this.publisherService.getById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/publishers/add")
    public String save(@RequestParam String name) {

        this.publisherService.create(name);
        return "redirect:/publishers";

    }

    @DeleteMapping("/publishers/delete/{id}")
    public String delete(@PathVariable Integer id){

        this.publisherService.deleteById(id);
        return "redirect:/publishers";
    }
}
