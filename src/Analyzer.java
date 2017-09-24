import java.io.*;
import java.util.*;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

    /*
     * Implement this method in Part 1
     */
    public static List<Sentence> readFile(String filename) {
        System.out.println(filename);
        LinkedList<Sentence> listOfSentences = new LinkedList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {
                if (line.length() > 1) {
                    System.out.println(line);
                    String[] arrString = line.split(" ", 2);
                    if (arrString.length == 2) {
                        String score = arrString[0];
                        System.out.println("Score: " + score);
                        String sentence = arrString[1];
                        System.out.println("Sentence: " + sentence);
                        if (validateScore(score) || sentence.contains("\\d+")) continue;
                        listOfSentences.add(new Sentence(Integer.parseInt(score), sentence));
                    }
                }
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Something bad happens");
            return listOfSentences;
        }


        return listOfSentences; // this line is here only so this code will compile if you don't modify it

    }

    private static boolean validateScore(String s) {
        return s.contains(" ") || s.contains(".") || !s.replace("-", "").matches("\\d") || Integer.parseInt(s) < -2 || Integer.parseInt(s) > 2;
    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {
        Set<String> words = new HashSet<>();
        Set<Word> setOfWord = new HashSet<>();
        if (!(sentences == null) && !sentences.isEmpty()) {
            for (Sentence item : sentences) {
                try {
                    System.out.println(item.getText());
                    String arrWord[] = item.getText().split(" ");
                    for (String s : arrWord) {

                        if (ignoreWordWithSpecialScharacter(s)) continue;
                        if (!words.contains(s.toLowerCase())) {
                            System.out.println("word: " + s);
                            System.out.println("hashcode: " + s.toLowerCase().hashCode());
                            words.add(s.toLowerCase());
                            setOfWord.add(new Word(s.toLowerCase()));
                            System.out.println(words);
                        }
                    }
                } catch (NullPointerException e) {

                }
            }
        }


        return setOfWord; // this line is here only so this code will compile if you don't modify it
    }

    private static boolean ignoreWordWithSpecialScharacter(String s) {
        if (s.toLowerCase().contains("?") || s.toLowerCase().contains("$")) {
            System.out.println("skip because contains " + s);
            return true;
        }
        return false;
    }

    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {

        HashMap<String, Double> hashOfScores = new HashMap<>();
        if (!(words == null) && !words.isEmpty()) {
            for (Word item : words) {
                if (item == null) {
                    continue;
                }
                hashOfScores.put(item.getText(), item.calculateScore());
            }
        }
        return hashOfScores; // this line is here only so this code will compile if you don't modify it

    }

    /*
     * Implement this method in Part 4
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

        String arrayOfSentence[];
        double sentenceScore = 0.0;
        double aux = 0.0;
        if (!(wordScores == null) && !(sentence == null) && !wordScores.isEmpty() && !sentence.isEmpty() && sentence.length() > 1) {

            System.out.println(sentence);
            arrayOfSentence = sentence.split(" ");
            for (String word : arrayOfSentence) {
                if (ignoreWordWithSpecialScharacter(word)) {
                    System.out.println("skip");
                    continue;
                }

                if (!wordScores.containsKey(word.toLowerCase())) {
                    wordScores.put(word.toLowerCase(), 0.0);
                }
            }
            for (Map.Entry<String, Double> entry : wordScores.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                aux = aux + entry.getValue();
            }
            sentenceScore = aux / wordScores.size();
        }
        System.out.println(wordScores);
        System.out.println(sentenceScore);
        return sentenceScore;


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
        for (Word s : words) {
            System.out.println(s);
        }
    }
}
