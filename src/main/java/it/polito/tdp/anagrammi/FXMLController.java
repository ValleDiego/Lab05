/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.RightWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInput"
    private TextField txtInput; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnagramma"
    private Button btnAnagramma; // Value injected by FXMLLoader

    @FXML // fx:id="txtOutputRight"
    private TextArea txtOutputRight; // Value injected by FXMLLoader

    @FXML // fx:id="txtOutputWrong"
    private TextArea txtOutputWrong; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doAnagramma(ActionEvent event) {//AGGIUNGERE IN FUTURO CONTROLLI SUL TESTO INPUT
       // Model model = new Model();
    	txtOutputRight.clear();
    	txtOutputRight.setDisable(false);
    	txtOutputWrong.clear();
    	txtOutputWrong.setDisable(false);
    	String p = txtInput.getText().toLowerCase();
    	if(!Pattern.matches("[a-zA-Z]+", p)) {
    		System.out.println("Inserisci una parola formata da sole lettere!");
    		return;
    	}
    	Map<String, RightWord> risultato = new HashMap<String, RightWord>();
    	risultato = model.getAnagrammi(p);
    	for(String key: risultato.keySet()) {
    		RightWord r = new RightWord(key, risultato.get(key).isRight());
    		if(!r.isRight())
    			txtOutputWrong.appendText(r.getWord()+"\n");
    		else
    			txtOutputRight.appendText(r.getWord()+"\n");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtOutputRight.clear();
    	txtOutputRight.setDisable(true);
    	txtOutputWrong.clear();
    	txtOutputWrong.setDisable(false);
    	txtInput.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutputRight != null : "fx:id=\"txtOutputRight\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutputWrong != null : "fx:id=\"txtOutputWrong\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }


    
    public void setModel(Model model) {
    	this.model = model;
    }
}
