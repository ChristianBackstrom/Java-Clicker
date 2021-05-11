import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller {
    private view view;
    private clicker clicker;

    public controller() {
        this.view = new view();
        this.clicker = new clicker();
        this.view.addPlusClicksListener(new plusClicks());
        this.view.addClicksPerSecListener(new plusClicksPerSec());
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
}
