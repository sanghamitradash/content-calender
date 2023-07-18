package com.example.contentcalender.Repository;

import com.example.contentcalender.model.Content;
import com.example.contentcalender.model.Status;
import com.example.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();//initialize the arraylist here

    public ContentCollectionRepository(){
    }

    public List<Content> findAll(){

        return content;
    }

    public Optional<Content> findById(Integer id){
        return content.stream().filter(c -> c.id().equals(id)).findFirst();

    }

    @PostConstruct
    private void init(){
        Content c = new Content(id:1,
                  title: "My First Blog Post",
                   desc:"My first blog post",
                   Status.IDEA,
                    Type.ARTICLE,
                    LocalDateTime.now(),
                    dateUpdated: null,
                    url:"");

    }
}
