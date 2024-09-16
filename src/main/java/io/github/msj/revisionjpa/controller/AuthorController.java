package io.github.msj.revisionjpa.controller;

import io.github.msj.revisionjpa.dao.AuthorDAO;
import io.github.msj.revisionjpa.entity.Author;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @DeleteMapping("{id}")
    public void update(@PathVariable UUID id) {
        authorDAO.delete(id);
    }

    @GetMapping("{id}")
    public Author get(@PathVariable UUID id) {
        return authorDAO.findById(id);
    }

    @GetMapping
    public List<Author> getAll() {
        return authorDAO.findAll();
    }

}
