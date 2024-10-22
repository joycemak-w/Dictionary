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
    public class Vocab3 {
        public static void main(String[] args) {
            VocabView view = new VocabView();
            VocabModel model = new VocabModel();
            VocabController control = new VocabController();

            view.setController(control);
            control.setModel(model);
            control.setView(view);
            model.setController(control);

            model.setupDBConnection();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    view.setVisible(true);
                }
            });
        }
    }
