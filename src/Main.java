import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        super("Calculator");

        setBounds(500,300,300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String args[]) {
        new Main();
    }
}
