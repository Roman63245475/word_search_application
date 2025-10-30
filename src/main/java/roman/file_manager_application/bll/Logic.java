package roman.file_manager_application.bll;

import roman.file_manager_application.dal.WordsData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Logic {

    WordsData dal;
    public Logic() throws IOException {
        dal =  new WordsData();
        this.file = new File(path);
        this.fw = new FileWriter(this.file);
        this.bw = new BufferedWriter(this.fw);
    }

    private String path = "C:\\Users\\yummi\\Documents\\Software_design\\file_manager_application\\src\\main\\java\\roman\\file_manager_application\\dal\\history.txt";

    private File file;

    private FileWriter fw;

    private BufferedWriter bw;

    public ArrayList<String> getWords(){
        return dal.getWords();
    }

    public int searchWord(String word){
        ArrayList<String> words = dal.getWords();
        return words.indexOf(word);
    }

    public String createSentence(String word){
        int status = searchWord(word);
        if (status != -1){
            String sentence = "search for " + "'" + word + "' and found result";
            return sentence;
        }
        else {
            String sentence = "search for " + "'" + word + "' and found no result";
            return sentence;
        }
    }

    public String writeDownTheSentence(String word){
        String sentence = createSentence(word);
        try{
            bw.write(sentence + System.lineSeparator());
            return sentence;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getSearchHistory(){
        return dal.getSearchHistory();
    }
}
