package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Parola;
import it.polito.tdp.model.Ricerca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController 
{
	Ricerca r = new Ricerca();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button buttonCerca;

    @FXML
    private TextFlow txtResult;

    @FXML
    private Button buttonReset;

    @FXML
    void doCerca(ActionEvent event) 
    {
    	
    	r.doPermutazioni(txtParola.getText());
    	List<String> anagrammi = r.getSoluzioni();
    	List<Parola> parolePresenti = r.getParoleDatabase(anagrammi);
    	for (String string : anagrammi) 
    	{
    		boolean trovato = false;
    		Text t = new Text(string+"\n");
    		for (Parola parola : parolePresenti)
    		{
    			if(parola.getParola().compareTo(string) == 0)
    			{
    				trovato = true;
    			}
			}
    		if(trovato)
    		{
    			t.setFill(Color.BLACK);
    		}
    		else
    		{
    			t.setFill(Color.RED);
    		}
    		txtResult.getChildren().add(t);
		}
    }
    
    @FXML
    void doReset(ActionEvent event) 
    {
    	txtParola.clear();
    	txtResult.getChildren().clear();
    	r.getSoluzioni().clear();
    }

    @FXML
    void initialize()
    {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert buttonCerca != null : "fx:id=\"buttonCerca\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert buttonReset != null : "fx:id=\"buttonReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}

