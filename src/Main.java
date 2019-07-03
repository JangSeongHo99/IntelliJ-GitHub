import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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

    // operand and operator
    private String first_num = "";
    private String second_num = "";
    private String op_num = "";
    private String num = "";

    // show expression (input)
    private String op_str = "";

    // show result (output)
    private double result = 0;

    // check plus and minus
    private boolean chk_pm = false;

    // The number of buttons is 30.
    private JButton[] button = new JButton[arr_button.length];

    private JPanel panel_buttons;
    private JPanel panel_text;

    private JTextField textField_input;
    private JTextField textField_output;

    // init method for component in frame
    public void init() {
        panel_buttons = new JPanel();
        panel_text = new JPanel();

        panel_text.setLayout(new BorderLayout());
        panel_text.setPreferredSize(new Dimension(280, 60));

        textField_input = new JTextField("");
        textField_input.setPreferredSize(new Dimension(240,30));
        textField_input.setBorder(null);
        textField_input.setEnabled(false);
        textField_input.setHorizontalAlignment(JTextField.RIGHT);

        textField_output = new JTextField("0");
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

    // Constructor
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

    // Calculate input string to double output by using javascript
    public static double operate(String input) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        double op_num = (Double) scriptEngine.eval(input);
        return op_num;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton jButton = (JButton) e.getSource();
        /*
         * event for special symbol except the four fundamental arithmetic operations
         */
        ///

        /*
         * event that input is the four fundamental arithmetic operations and numbers
         */

        // no input or first input is operator
        if (num.length() == 0) {
            if (jButton.getText().equals("+") || jButton.getText().equals("-")
                    || jButton.getText().equals("*") || jButton.getText().equals("/")) {
                // operand not exist, but operator exist
                if (first_num.length() == 0) {
                    first_num = "0";
                    op_num = jButton.getText();
                    op_str = first_num + op_num;
                    textField_input.setText(op_str);
                }
                // the number of operand is 1 and operator exist
                else {
                    op_num = jButton.getText();
                    op_str = first_num + op_num;
                    textField_input.setText(op_str);
                }
            } else if (jButton.getText().equals("1") || jButton.getText().equals("2")
                    || jButton.getText().equals("3") || jButton.getText().equals("4")
                    || jButton.getText().equals("5") || jButton.getText().equals("6")
                    || jButton.getText().equals("7") || jButton.getText().equals("8")
                    || jButton.getText().equals("9")) {
                // init number after opeartor "="
                if(op_num.equals("=")) {
                    first_num = "";
                    second_num = "";
                    op_num = "";
                    num = "";
                    op_str = "";
                    result = 0;
                }
                num += jButton.getText();
                textField_output.setText(num);
            } else if (jButton.getText().equals("0") || jButton.getText().equals("00")) {
                if(op_num.equals("=")) {
                    first_num = "";
                    second_num = "";
                    op_num = "";
                    num = "";
                    op_str = "";
                    result = 0;
                }
                result = 0;
                textField_output.setText(jButton.getText());
            }
        }
    }
}
