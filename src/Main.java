import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {


    private String[] arr_button =  {"MC", "MR", "MS", "M+", "M-", "←", "CE", "C", "±",
            "√", "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2",
            "3", "-", ".", "0", "00", "+", "=", "," };
    private JButton[] button = new JButton[arr_button.length];
    private JPanel panel_buttons;

    public void init() {
        panel_buttons = new JPanel();
        panel_buttons.setLayout(new GridLayout(6, 5, 4, 4));
        for (int i = 0; i<arr_button.length; i++) {
            button[i] = new JButton(arr_button[i]);
            button[i].addActionListener(this);
            panel_buttons.add(button[i]);
        }
        add("South", panel_buttons);
    }
    public Main() {
        super("Calculator");
        setBounds(500,300,300,300);
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String args[]) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
