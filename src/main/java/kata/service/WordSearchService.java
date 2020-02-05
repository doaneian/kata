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
                            continue;
                        }

                        possibleCoordinates = checkHorizontalBackward(row, j, i, word);
                        if (possibleCoordinates.size() == word.length()) {
                            solution.put(word, possibleCoordinates);
                            continue;
                        }

                        possibleCoordinates = checkVertical(puzzle, i, j, word);
                        if (possibleCoordinates.size() == word.length()) {
                            solution.put(word, possibleCoordinates);
                            continue;
                        }

                        possibleCoordinates = checkVerticalBackwards(puzzle, i, j, word);
                        if (possibleCoordinates.size() == word.length()) {
                            solution.put(word, possibleCoordinates);
                            continue;
                        }

                        possibleCoordinates = checkDiagonal(puzzle, i, j, word);
                        if (possibleCoordinates.size() == word.length()) {
                            solution.put(word, possibleCoordinates);
                            continue;
                        }

                        possibleCoordinates = checkDiagonal2(puzzle, i, j, word);
                        if (possibleCoordinates.size() == word.length()) {
                            solution.put(word, possibleCoordinates);
                            continue;
                        }

                        possibleCoordinates = checkDiagonal3(puzzle, i, j, word);
                        if (possibleCoordinates.size() == word.length()) {
                            solution.put(word, possibleCoordinates);
                            continue;
                        }

                        possibleCoordinates = checkDiagonal4(puzzle, i, j, word);
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

    private List<Coordinate> checkHorizontalBackward(String[] row, int startIndex, int rowIndex, String word) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = startIndex; i >= 0 && i < word.length() &&
                row[i].compareTo(word.substring(startIndex - i, startIndex - i + 1)) == 0; i--) {
            Coordinate coordinate = new Coordinate();
            coordinate.setX(i);
            coordinate.setY(rowIndex);
            coordinates.add(coordinate);
        }
        return coordinates;
    }

    private List<Coordinate> checkVertical(String[][] puzzle, int startIndex, int columnIndex, String word) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = startIndex; i < puzzle.length && i < word.length() &&
                puzzle[i][columnIndex].compareTo(word.substring(i - startIndex, i - startIndex + 1)) == 0; i++) {
            Coordinate coordinate = new Coordinate();
            coordinate.setX(columnIndex);
            coordinate.setY(i);
            coordinates.add(coordinate);
        }
        return coordinates;
    }

    private List<Coordinate> checkVerticalBackwards(String[][] puzzle, int startIndex, int columnIndex, String word) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = startIndex; i >= 0 && i < word.length() &&
                puzzle[i][columnIndex].compareTo(word.substring(startIndex - i, startIndex - i + 1)) == 0; i--) {
            Coordinate coordinate = new Coordinate();
            coordinate.setX(columnIndex);
            coordinate.setY(i);
            coordinates.add(coordinate);
        }
        return coordinates;
    }

    private List<Coordinate> checkDiagonal(String[][] puzzle, int startIndex, int columnIndex, String word) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i + startIndex < puzzle.length && i + columnIndex < puzzle[0].length && i < word.length() &&
                puzzle[startIndex + i][columnIndex + i].compareTo(word.substring(i, i + 1)) == 0; i++) {
            Coordinate coordinate = new Coordinate();
            coordinate.setX(columnIndex + i);
            coordinate.setY(startIndex + i);
            coordinates.add(coordinate);
        }
        return coordinates;
    }

    private List<Coordinate> checkDiagonal2(String[][] puzzle, int startIndex, int columnIndex, String word) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i + startIndex < puzzle.length && columnIndex - i >= 0 && i < word.length() &&
                puzzle[startIndex + i][columnIndex - i].compareTo(word.substring(i, i + 1)) == 0; i++) {
            Coordinate coordinate = new Coordinate();
            coordinate.setX(columnIndex - i);
            coordinate.setY(startIndex + i);
            coordinates.add(coordinate);
        }
        return coordinates;
    }

    private List<Coordinate> checkDiagonal3(String[][] puzzle, int startIndex, int columnIndex, String word) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; startIndex - i >= 0 && columnIndex + i < puzzle[0].length && i < word.length() &&
                puzzle[startIndex - i][columnIndex + i].compareTo(word.substring(i, i + 1)) == 0; i++) {
            Coordinate coordinate = new Coordinate();
            coordinate.setX(columnIndex + i);
            coordinate.setY(startIndex - i);
            coordinates.add(coordinate);
        }
        return coordinates;
    }

    private List<Coordinate> checkDiagonal4(String[][] puzzle, int startIndex, int columnIndex, String word) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; startIndex - i >= 0 && columnIndex - i >= 0 && i < word.length() &&
                puzzle[startIndex - i][columnIndex - i].compareTo(word.substring(i, i + 1)) == 0; i++) {
            Coordinate coordinate = new Coordinate();
            coordinate.setX(columnIndex - i);
            coordinate.setY(startIndex - i);
            coordinates.add(coordinate);
        }
        return coordinates;
    }
}
