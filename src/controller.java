import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
    private boolean running;
    private long time;

    public controller() {
        this.view = new view();
        this.clicker = new clicker();
        this.db = new dbModel();
        this.running = true;
        this.view.addPlusClicksListener(new plusClicks());
        this.view.addClicksPerSecListener(new plusClicksPerSec());
        this.view.addWindowListener(new closingWindow());
        this.view.addTopScoreListener(new topScores());
        this.time = System.currentTimeMillis();
        update();
    }

    public void update(){
        while (running){
            if(System.currentTimeMillis() - time >= 100){
                clicker.increaseClicks(clicker.getClicksPerSec()/10);
                view.updateClicks(clicker.getClicks());
                time = System.currentTimeMillis();
            }
        }
    }

    private class plusClicks implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clicker.increaseClicks(clicker.getClicksPerClick());
            view.updateClicks(clicker.getClicks());
        }
    }

    private class plusClicksPerSec implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clicker.inreaseTenCPS();
            view.updateClicksPerSec(clicker.getClicksPerSec(), clicker.priceRange());
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
                String name = JOptionPane.showInputDialog(null, "write your name here");
                while(name.isEmpty()){
                    name = JOptionPane.showInputDialog(null, "please dont leave blank");
                }
                db.dbStore(name , clicker.getClicks());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
