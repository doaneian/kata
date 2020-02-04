package kata.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wordSearch")
public class WordSearchController {

    @PostMapping
    public String getWords(@RequestBody String request) {
        return "test";
    }
}
