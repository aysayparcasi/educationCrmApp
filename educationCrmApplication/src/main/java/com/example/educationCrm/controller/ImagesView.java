package com.example.educationCrm.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Scope(value = "view")
@Controller
public class ImagesView {

    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("nature" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}