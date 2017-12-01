package Homeworks.SD2x.collections;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class AnalyzerTest {

    @Test
    public void readFile() {
        String filename = " ";
        List<Sentence> actual = Analyzer.readFile(filename);
        assertTrue(actual.isEmpty());

        filename = "submissions/Homeworks/SD2x/collections/testSentences.txt";
        actual = Analyzer.readFile(filename);
        List<Sentence> expected = new ArrayList<>();
        expected.add(new Sentence(-2, "This quiet , introspective and"));
        expected.add(new Sentence(-1, "Even fans of Ismail Merchant 's work , I"));
        expected.add(new Sentence(0, "A positively thrilling combination of ethnography"));
        expected.add(new Sentence(1, "Aggressive self-glorification and a manipulative whitewash ."));
        expected.add(new Sentence(2, "A comedy-drama of nearly epic proportions rooted in a sincere"));
        expected.add(new Sentence(-1, "There 's little to recommend Snow Dogs , unless one"));
        assertEquals(expected, actual);

        //filename = "submissions/Homeworks/SD2x/collections/reviews.txt";
        //actual = Analyzer.readFile(filename);
        //System.out.println(actual.size());
    }

    @Test
    public void allWords() {
        String filename = "";
        List<Sentence> sentences = Analyzer.readFile(filename);
        Set<Word> actual = Analyzer.allWords(sentences);
        assertTrue(actual.isEmpty());

        filename = "submissions/Homeworks/SD2x/collections/testWords.txt";
        sentences = Analyzer.readFile(filename);
        actual = Analyzer.allWords(sentences);

        HashMap<String, int[]> expected = new HashMap<>();
        expected.put("this", new int[]{1, -2});
        expected.put("quiet", new int[]{1, -2});
        expected.put("introspective", new int[]{1, -2});
        expected.put("and", new int[]{2, -1});
        expected.put("fans", new int[]{1, -1});
        expected.put("of", new int[]{3, 1});
        expected.put("work", new int[]{1, -1});
        expected.put("i", new int[]{1, -1});
        expected.put("a", new int[]{3, 3});
        expected.put("ethnography", new int[]{1, 0});
        expected.put("self-glorification", new int[]{1, 1});
        expected.put("to", new int[]{1, -1});
        expected.put("sincere", new int[]{1, 2});

        for (Word word : actual) {
            int actualCount = word.getCount();
            int actualTotal = word.getTotal();
            int expectedCount = expected.get(word.getText())[0];
            int expectedTotal = expected.get(word.getText())[1];
            System.out.println(word.getText());
            assertEquals(expectedCount, actualCount);
            assertEquals(expectedTotal, actualTotal);
        }
    }

    @Test
    public void calculateScores() {
        Set<Word> words = new HashSet<>();
        Map<String, Double> actual = Analyzer.calculateScores(words);
        assertTrue(actual.isEmpty());

        String filename = "submissions/Homeworks/SD2x/collections/testWords.txt";
        List<Sentence>sentences = Analyzer.readFile(filename);
        words = Analyzer.allWords(sentences);
        actual = Analyzer.calculateScores(words);


        HashMap<String, Double> expected = new HashMap<>();
        // the word text, score / count
        expected.put("this", -2.0 / 1);
        expected.put("quiet", -2.0 / 1);
        expected.put("introspective", -2.0 / 1);
        expected.put("and", -1.0 / 2);
        expected.put("fans", -1.0 / 1);
        expected.put("of", 1.0 / 3);
        expected.put("work", -1.0 / 1);
        expected.put("i", -1.0 / 1);
        expected.put("a", 3.0 / 3);
        expected.put("ethnography", 0 / 1.0);
        expected.put("self-glorification", 1.0 / 1);
        expected.put("to", -1.0 / 1);
        expected.put("sincere", 2.0 / 1);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateSentenceScore() {
        HashMap<String, Double> expected = new HashMap<>();
        // the word text, score / count
        expected.put("this", -2.0 / 1);
        expected.put("quiet", -2.0 / 1);
        expected.put("introspective", -2.0 / 1);
        expected.put("and", -1.0 / 2);
        expected.put("fans", -1.0 / 1);
        expected.put("of", 1.0 / 3);
        expected.put("work", -1.0 / 1);
        expected.put("i", -1.0 / 1);
        expected.put("a", 3.0 / 3);
        expected.put("ethnography", 0 / 1.0);
        expected.put("self-glorification", 1.0 / 1);
        expected.put("to", -1.0 / 1);
        expected.put("sincere", 2.0 / 1);

        double expectedAverage = expected.values().stream().mapToDouble(Double::doubleValue).sum() / 18;

        String sentence = "This quiet , introspective and fans of 's work , I " +
                "A of ethnography self-glorification and a . A of sincere to";

        double actualAverage = Analyzer.calculateSentenceScore(expected, sentence);
        // assertEquals(expectedAverage, actualAverage, 0.0); // FIXME
        sentence = "ddddddddd 'dd _ aaaaaaaaaaa gggggggggg ' + dddddddd sssssssssss dddddddddd rrrrrrrr";
        actualAverage = Analyzer.calculateSentenceScore(expected, sentence);
        assertEquals(0.0, actualAverage, 0.0);

        HashMap var1 = new HashMap();
        var1.put("dog", 2.0D);
        double var2 = Analyzer.calculateSentenceScore(var1, "$");
        assertEquals(0.0, var2, 0.0);
    }
}