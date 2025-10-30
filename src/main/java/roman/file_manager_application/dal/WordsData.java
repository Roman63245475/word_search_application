package roman.file_manager_application.dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordsData {

    private ArrayList<String> words;
    private String WordsPath = "C:\\Users\\yummi\\OneDrive\\Documents\\brit-a-z.txt";
    private String path = "C:\\Users\\yummi\\Documents\\Software_design\\file_manager_application\\src\\main\\java\\roman\\file_manager_application\\dal\\history.txt";

    public WordsData(){
        words = new ArrayList<>();
    }

    public ArrayList<String> getWords(){
        if (words.isEmpty()){
            try (BufferedReader br = new BufferedReader(new FileReader(WordsPath))){
                String line;
                while ((line = br.readLine()) != null){
                    words.add(line);
                }
                return words;
            }
            catch (Exception e){
                return null;
            }
        }
        else {
            return words;
        }
    }

    public ArrayList<String> getSearchHistory(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            ArrayList<String> history = new ArrayList<>();
            String line;
            while((line = br.readLine()) != null){
                history.add(line);
            }
            return history;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
