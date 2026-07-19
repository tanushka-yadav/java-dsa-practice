package HashTables;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static void main(String[] args){

        String sentence = "java dsa java hash table dsa java coding has";

        //Create Hash Table
        HashMap<String, Integer> wordCount=new HashMap<>();

        //Split sentence into words
        String[] words=sentence.split("  ");

        //Count frequency
        for(String word : words){

            if(wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word)+1);
            }else{
                wordCount.put(word,1);
            }
        }

        //Display all words and frequencies
        System.out.println("Word Frequencies: ");
        for(Map.Entry<String, Integer> entry : wordCount.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }

        //Search a word
        String searchWord="java";

        if(wordCount.containsKey(searchWord)){
            System.out.println("\n"+ searchWord+" appears"+ wordCount.get(searchWord)+" times.");
        }else{
            System.out.println("\nWord not found.");
        }

        //Total unique words
        System.out.println("\nUnique Words = "+ wordCount.size());

        //Remove a word
        wordCount.remove("coding");

        System.out.println("\nAfter Removing 'coding': ");
        System.out.println(wordCount);

        //Display only keys
        System.out.println("\nWords: ");
        for(String key : wordCount.keySet()){
            System.out.println(key);
        }

        //Display only values
        System.out.println("\nFrequencies: ");
        for(Integer value : wordCount.values()){
            System.out.println(value);
        }

        //Clear Hash Table
        wordCount.clear();

        System.out.println("\nAfter Clearing: ");
        System.out.println(wordCount);
    }
}
