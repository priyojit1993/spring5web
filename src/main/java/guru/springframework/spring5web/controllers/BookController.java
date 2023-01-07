package guru.springframework.spring5web.controllers;

import guru.springframework.spring5web.DTO.BookResponseDTO;
import guru.springframework.spring5web.model.Book;
import guru.springframework.spring5web.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getAllView")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";// tells spring to look for list.html inside books folder of thymeleaf template folder.
    }


    @GetMapping("/getAll")
    public ResponseEntity<Set<BookResponseDTO>> getAllBooks() {
        HashSet<BookResponseDTO> bookResponseDTOS = new HashSet<>();
        for (Book book : bookRepository.findAll()) {
            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setId(book.getId());
            bookResponseDTO.setIsbn(book.getIsbn());
            bookResponseDTO.setTitle(book.getTitle());
            bookResponseDTOS.add(bookResponseDTO);
        }
        return ResponseEntity.ok(bookResponseDTOS);
    }

}
