package kata.controller;

import kata.bo.Coordinate;
import kata.service.WordSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wordSearch")
public class WordSearchController {
    WordSearchService wordSearchService;

    @Autowired
    public WordSearchController(WordSearchService wordSearchService) {
        this.wordSearchService = wordSearchService;
    }

    @PostMapping
    public Map<String, List<Coordinate>> getWords(@RequestBody String request) {
        String[] parsed = request.split("\n");
        String[][] puzzle = new String[parsed.length - 1][parsed.length - 1];
        for (int i = 1; i < parsed.length; i++) {
            puzzle[i - 1] = parsed[i].split(",");
        }

        return wordSearchService.searchWords(parsed[0].split(","), puzzle);
    }
}
