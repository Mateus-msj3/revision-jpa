package io.github.msj.revisionjpa.controller;

import io.github.msj.revisionjpa.dao.AuthorDAO;
import io.github.msj.revisionjpa.entity.Author;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDAO authorDAO;

    @PostMapping
    public Author save(@RequestBody Author author) {
        authorDAO.save(author);
        return author;
    }

    @PutMapping
    public Author update(@RequestBody Author author) {
        authorDAO.update(author);
        return author;
    }

}
