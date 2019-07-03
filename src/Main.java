import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// calculator
public class Main extends JFrame implements ActionListener {

    // operator buttons
    private String[] arr_button =  {"MC", "MR", "MS", "M+", "M-", "←", "CE", "C", "±",
            "√", "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2",
            "3", "-", ".", "0", "00", "+", "=", "," };

    // The number of buttons is 30.
    private JButton[] button = new JButton[arr_button.length];

    private JPanel panel_buttons;
    private JPanel panel_text;

    private JTextField textField_input;
    private JTextField textField_output;

    public void init() {
        panel_buttons = new JPanel();
        panel_text = new JPanel();

        panel_text.setLayout(new BorderLayout());
        panel_text.setPreferredSize(new Dimension(280, 60));

        textField_input = new JTextField("Input");
        textField_input.setPreferredSize(new Dimension(240,30));
        textField_input.setBorder(null);
        textField_input.setEnabled(false);
        textField_input.setHorizontalAlignment(JTextField.RIGHT);

        textField_output = new JTextField("OutPut");
        textField_output.setPreferredSize(new Dimension(240, 30));
        textField_output.setBorder(null);
        textField_output.setFont(new Font("Gulim Che", Font.PLAIN, 20));
        textField_output.setEnabled(false);
        textField_output.setHorizontalAlignment(JTextField.RIGHT);

        panel_buttons.setLayout(new GridLayout(6, 5, 4, 4));
        for (int i = 0; i<arr_button.length; i++) {
            button[i] = new JButton(arr_button[i]);
            button[i].addActionListener(this);
            panel_buttons.add(button[i]);
        }
        panel_text.add("North", textField_input);
        panel_text.add("South", textField_output);
        add("North", panel_text);
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
