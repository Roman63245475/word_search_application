package roman.file_manager_application.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import roman.file_manager_application.bll.Logic;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FileManagerController implements Initializable {
    @FXML
    private ListView<String> lstWords;

    private Logic logic;

    @FXML
    private ListView<String> searchHistory;

    @FXML
    private ListView<String> lstA;

    @FXML
    private TextField prompt;

    @FXML
    private ListView<String> lstN;

    public FileManagerController() throws IOException {
        logic = new Logic();
    }

    public void initialize(URL location, ResourceBundle resources){
        ArrayList<String> words = logic.getWords();
        for(String word : words){
            lstWords.getItems().add(word);
        }
        setAList();
        setNList();
        setSearchHistory();
    }

    private void setSearchHistory(){
        ArrayList<String> history = logic.getSearchHistory();
        for (int i = history.size()-1; i >= 0; i--) {
            searchHistory.getItems().add(history.get(i));
        }
    }

    private void setAList(){
        for (String word : lstWords.getItems()){
            if (word.charAt(0) == 'A' || word.charAt(0) == 'a'){
                lstA.getItems().add(word);
            }
        }
    }

    private void setNList(){
        for (String word : lstWords.getItems()){
            if (word.charAt(0) == 'N' || word.charAt(0) == 'n'){
                lstN.getItems().add(word);
            }
        }
    }
    @FXML
    private void search(){
        addToHistory(logic.writeDownTheSentence(prompt.getText()));
        int index = logic.searchWord(prompt.getText());
        if (index != -1){
            lstWords.getSelectionModel().select(index);
            lstWords.scrollTo(index);

        }
    }

    private void addToHistory(String sentence){
        searchHistory.getItems().add(0, sentence);
    }

}
