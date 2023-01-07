package guru.springframework.spring5web.controllers;

import guru.springframework.spring5web.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/getAllView")
    public String getAllAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";

    }


}
