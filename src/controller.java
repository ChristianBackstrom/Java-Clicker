import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller {
    private view view;
    private clicker clicker;

    public controller(view view, clicker clicker) {
        this.view = view;
        this.clicker = clicker;
        this.view.addPlusClicksListener(new plusClicks());
    }

    private class plusClicks implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clicker.increaseClicks();
            view.updateClicks(clicker.getClicks());
        }
    }
}
