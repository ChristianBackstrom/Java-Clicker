import javax.swing.*;
import java.awt.event.ActionListener;

public class view extends JFrame {

    private JButton plusClicks;
    private JPanel panel;
    private JTextField value;
    private JButton shopButton;
    private JTextField clicksPerSec;

    public view(){
        this.add(panel);

        value.setEditable(false);
        clicksPerSec.setEditable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }

    public void updateClicks(int i){
        value.setText(i + " glizzys");
    }

    public void updateClicksPerSec(int i){
        clicksPerSec.setText(i + " glizzys/s");
    }

    public void updateClickValue(int i){
        plusClicks.setText("+" + i + " glizzys");
    }

    void addPlusClicksListener(ActionListener listenForLoadListener) {
        this.plusClicks.addActionListener(listenForLoadListener);
    }

    void addClicksPerSecListener(ActionListener listenForLoadListener) {
        this.shopButton.addActionListener(listenForLoadListener);
    }
}
