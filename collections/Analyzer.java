package Homeworks.SD2x.collections;

import java.util.regex.Pattern;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename){
	    List<Sentence> list = new ArrayList<>();
	    if (filename == null) return list;
	    Sentence sentence;
	    String line;
	    int score;
	    String text;
	    Pattern pattern = Pattern.compile("^([-]*\\d\\s.+)");
	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	        while ((line = br.readLine()) != null) {
	            try {
	                if (!pattern.matcher(line).matches()) continue;
	                score = Integer.parseInt(line.substring(0, 2).trim());
	                if (score < -2 || score > 2) continue;
	                text = line.substring(2).trim();
                } catch (NumberFormatException n) {
	                n.printStackTrace();
	                continue;
                }
	            sentence = new Sentence(score, text);
	            list.add(sentence);
            }
        } catch (IOException e) {
	        e.printStackTrace();
        }
        return list;
	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
        HashMap<String, Word> wordHashMap = new HashMap<>();
        if (sentences == null || sentences.isEmpty()) return new HashSet<>();
        for (Sentence sentence : sentences) {
            if (sentence == null || sentence.getText() == null) continue;
            for (String text : sentence.getText().split("\\s")) {
                text = text.toLowerCase();
                if (!text.matches("^[a-z].*")) continue;
                Word word = new Word(text);
                if (wordHashMap.containsKey(text)) {
                    word = wordHashMap.get(text);
                    word.increaseTotal(sentence.getScore());
                } else {
                    word.increaseTotal(sentence.getScore());
                    wordHashMap.put(text, word);
                }
            }
        }
        return new HashSet<>(wordHashMap.values());
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
	    HashMap<String, Double> scoresHashMap = new HashMap<>();
	    if (words == null || words.isEmpty()) return scoresHashMap;
	    for (Word word : words) {
	        if (word == null) continue;
	        scoresHashMap.put(word.getText(), word.calculateScore());
        }
        return scoresHashMap;
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
	    int count = 0;
	    double total = 0.0;
	    if (wordScores == null || wordScores.isEmpty() || sentence == null || sentence.isEmpty()) return 0.0;
	    for (String text : sentence.split("\\s")) {
	        text = text.toLowerCase();
            count++;
            if (!text.matches("^[a-z].*")) continue;
            if (wordScores.containsKey(text)) {
                total += wordScores.get(text);
            }
        }
        return count > 0 ? total / count : 0.0;
	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
