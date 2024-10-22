/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocab;

/**
 *
 * @author joyce
 */
public class VocabData {
    private String entry;
    String meaning;
    String word_class;

    public VocabData(String entry, String meaning, String word_class) {
        this.entry = entry;
        this.meaning = meaning;
        this.word_class = word_class;
    }

    public String getEntry() {
        return entry;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getWord_class() {
        return word_class;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setWord_class(String word_class) {
        this.word_class = word_class;
    }
    
    
}
