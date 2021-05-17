import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class controller {
    private view view;
    private clicker clicker;
    private dbModel db;

    public controller() {
        this.view = new view();
        this.clicker = new clicker();
        this.db = new dbModel();
        this.view.addPlusClicksListener(new plusClicks());
        this.view.addClicksPerSecListener(new plusClicksPerSec());
        this.view.addWindowListener(new closingWindow());
        this.view.addTopScoreListener(new topScores());
    }

    private class plusClicks implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clicker.increaseClicks();
            view.updateClicks(clicker.getClicks());
        }
    }

    private class plusClicksPerSec implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clicker.inreaseTenCPS();
            view.updateClicksPerSec(clicker.getClicksPerSec());
        }
    }

    private class topScores implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                view.showTopScores(db.dbShow());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class closingWindow extends WindowAdapter {
        public void windowClosing(WindowEvent e){
            try {
                db.dbStore(JOptionPane.showInputDialog(null, "write your name here"), clicker.getClicks());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
