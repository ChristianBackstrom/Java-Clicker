import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class view extends JFrame {

    private JButton plusClicks;
    private JPanel panel;
    private JTextField value;
    private JButton shopButton;
    private JTextField clicksPerSec;
    private JList users;
    private JButton topScores;
    private DefaultListModel list;

    public view(){
        this.add(panel);
        list = new DefaultListModel();

        users.setVisible(false);

        users.setModel(list);

        value.setEditable(false);
        clicksPerSec.setEditable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }

    public void showTopScores(user[] user){
        if (!users.isVisible()){
            topScores.setText("back to game");
            users.setVisible(true);
            plusClicks.setVisible(false);
            value.setVisible(false);
            shopButton.setVisible(false);
            clicksPerSec.setVisible(false);
            for (int i = 0; i < 10; i++){
                list.addElement(user[i].getName() + "  " + user[i].getScore());
            }
        } else {
            topScores.setText("Show top scores");
            users.setVisible(false);
            plusClicks.setVisible(true);
            value.setVisible(true);
            shopButton.setVisible(true);
            clicksPerSec.setVisible(true);
            list.clear();
        }

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

    void addTopScoreListener(ActionListener actionListener){
        this.topScores.addActionListener(actionListener);
    }

    void addWindowClosingListener(WindowAdapter a){
        this.addWindowListener(a);
    }
}
