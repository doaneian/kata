package kata.service;

import kata.bo.Coordinate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WordSearchService {
    public Map<String, List<Coordinate>> searchWords(String[] words, String[][] puzzle) {
        Map<String, List<Coordinate>> solution = new HashMap<>();
        for (int i = 0; i < puzzle.length; i++) {
            String[] row = puzzle[i];
            for (int j = 0; j < row.length; j++) {
                for (String word: words) {
                    if (row[j].compareTo(word.substring(0, 1)) == 0) {
                        List<Coordinate> possibleCoordinates = checkHorizontalForward(row, j, i, word);
                        if (possibleCoordinates.size() == word.length()) {
                            solution.put(word, possibleCoordinates);
                        }
                    }
                }
            }
        }

        return solution;
    }

    private List<Coordinate> checkHorizontalForward(String[] row, int startIndex, int rowIndex, String word) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = startIndex; i < row.length && i < word.length() &&
                row[i].compareTo(word.substring(i - startIndex, i - startIndex + 1)) == 0; i++) {
            Coordinate coordinate = new Coordinate();
            coordinate.setX(i);
            coordinate.setY(rowIndex);
            coordinates.add(coordinate);
        }
        return coordinates;
    }
}
