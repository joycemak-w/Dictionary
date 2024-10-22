/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocab;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author joyce
 */
public class VocabController {
    
    private VocabView view;
    private VocabModel model;
    private VocabData data;
    
    public void setView(VocabView v) {
        this.view = v;        
    }
    
    public void setModel(VocabModel m) {
        this.model = m;        
    }
    
    public void setData(VocabData d) {
        this.data = d;        
    }
    
    public void addToModel(String word, String meaning, String word_class){
        boolean isOK = model.add(word, meaning, word_class);
        if (isOK)
            view.showMessage("New entry added");               
        else
            view.showMessage("Add Command not successful:" + word + " " + meaning + " " + word_class);       
    }
    
    public void deleteFromModel(String word){
        boolean isOK = model.delete(word);
        if (isOK)
            view.showMessage("Entry deleted");        
        else
            view.showMessage("Record not found");        
    }
    
    public void lookupFromModel(String word){
//        String meaning = model.lookup(word);
        VocabData vd = model.lookup(word); 
        if (vd == null)
//            view.showMessage("Entry not found");     
            view.showMessage("'" + word + "'" + " is not found");      
        else
            view.showMessage("'" + word + "'" + " (" + vd.word_class + ") " + " means " + vd.meaning);        
    }
    
}
