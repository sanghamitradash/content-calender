package com.example.contentcalender.controller;

import com.example.contentcalender.Repository.ContentCollectionRepository;
import com.example.contentcalender.model.Content;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {

        this.repository = repository;
    }

    //make a request and find all the pieces of content in the system
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException (HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)

    //CREATE a data
    @PostMapping("")
    public Content create(@RequestBody Content content) {
        // Save the content object to the repository
        repository.save(content);

        // You can perform additional operations if needed

        // Return the saved content object in the response
        return content;
    }

    //UPDATE in data
    @PutMapping("/{id}")
    public Content update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
        return content;
    }

}