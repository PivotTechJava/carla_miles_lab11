package com.pivottech.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/hello")
    public String helloWorld (@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello world";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize (@PathVariable(name="text") String text, Model model) {
        model.addAttribute("text", text.toUpperCase());
        // text capitalize
        return "capitalize";
    }

    @GetMapping("/")
    public String splash () {
        return "splash";
    }

    @GetMapping("/albums")
    public String albums (Model model) {
        ArrayList<Album> albumList= new ArrayList<>();

        Album album1 = new Album("Damn.", "Kendrick Lamar", 14, 3240, "https://images-na.ssl-images-amazon.com/images/I/A1AMeOSldQL._SL1500_.jpg");
        Album album2 = new Album("Chasing Summer", "Sir", 14, 2700, "https://m.media-amazon.com/images/I/814+RZcGxZL._SS500_.jpg");
        Album album3 = new Album("Off the Wall", "Michael Jackson", 10, 2520, "https://images-na.ssl-images-amazon.com/images/I/71rBUj%2Bt-8L._SL1500_.jpg");

        albumList.add(album1);
        albumList.add(album2);
        albumList.add(album3);

        model.addAttribute("albumList", albumList);
        return "albums";
    }

}