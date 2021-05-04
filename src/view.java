import javax.swing.*;
import java.awt.event.ActionListener;

public class view extends JFrame {

    private JButton plusClicks;
    private JPanel panel;
    private JTextField value;

    public view(){
        panel = new JPanel();
        value = new JTextField("0 glizzys", 40);
        plusClicks = new JButton("+1 glizzys");

        panel.add(value);
        panel.add(plusClicks);

        this.add(panel);

        value.setEditable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }

    public void updateClicks(int i){
        value.setText(i + " glizzys");
    }

    public void updateClickValue(int i){
        plusClicks.setText("+" + i + " glizzys");
    }

    void addPlusClicksListener(ActionListener listenForLoadListener) {
        this.plusClicks.addActionListener(listenForLoadListener);
    }
}
