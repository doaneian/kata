package kata.service;

import kata.bo.Coordinate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class WordSearchServiceTest {
    WordSearchService wordSearchService;

    @Before
    public void init() {
        this.wordSearchService = new WordSearchService();
    }

    @Test
    public void testFindOneWordHorizontally() {
        Map<String, List<Coordinate>> solution = wordSearchService.searchWords(new String[]{"test"},
                new String[][]{{"t", "e", "s", "t"}, {"a", "b", "c", "d"}, {"e", "f", "g", "h"}, {"i", "j", "k", "l"}});
        Assert.assertEquals(solution.get("test").size(), 4);

        Assert.assertEquals(solution.get("test").get(0).getX(), 0);
        Assert.assertEquals(solution.get("test").get(0).getY(), 0);

        Assert.assertEquals(solution.get("test").get(1).getX(), 1);
        Assert.assertEquals(solution.get("test").get(1).getY(), 0);

        Assert.assertEquals(solution.get("test").get(2).getX(), 2);
        Assert.assertEquals(solution.get("test").get(2).getY(), 0);

        Assert.assertEquals(solution.get("test").get(3).getX(), 3);
        Assert.assertEquals(solution.get("test").get(3).getY(), 0);
    }

    @Test
    public void testFindOneWordHorizontally_backwards() {
        Map<String, List<Coordinate>> solution = wordSearchService.searchWords(new String[]{"test"},
                new String[][]{{"t", "s", "e", "t"}, {"a", "b", "c", "d"}, {"e", "f", "g", "h"}, {"i", "j", "k", "l"}});
        Assert.assertEquals(solution.get("test").size(), 4);

        Assert.assertEquals(solution.get("test").get(0).getX(), 3);
        Assert.assertEquals(solution.get("test").get(0).getY(), 0);

        Assert.assertEquals(solution.get("test").get(1).getX(), 2);
        Assert.assertEquals(solution.get("test").get(1).getY(), 0);

        Assert.assertEquals(solution.get("test").get(2).getX(), 1);
        Assert.assertEquals(solution.get("test").get(2).getY(), 0);

        Assert.assertEquals(solution.get("test").get(3).getX(), 0);
        Assert.assertEquals(solution.get("test").get(3).getY(), 0);
    }

    @Test
    public void testFindOneWordVertically() {
        Map<String, List<Coordinate>> solution = wordSearchService.searchWords(new String[]{"test"},
                new String[][]{{"t", "a", "b", "c"}, {"e", "b", "c", "d"}, {"s", "f", "g", "h"}, {"t", "j", "k", "l"}});
        Assert.assertEquals(solution.get("test").size(), 4);

        Assert.assertEquals(solution.get("test").get(0).getX(), 0);
        Assert.assertEquals(solution.get("test").get(0).getY(), 0);

        Assert.assertEquals(solution.get("test").get(1).getX(), 0);
        Assert.assertEquals(solution.get("test").get(1).getY(), 1);

        Assert.assertEquals(solution.get("test").get(2).getX(), 0);
        Assert.assertEquals(solution.get("test").get(2).getY(), 2);

        Assert.assertEquals(solution.get("test").get(3).getX(), 0);
        Assert.assertEquals(solution.get("test").get(3).getY(), 3);
    }
}
