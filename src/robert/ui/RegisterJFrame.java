package robert.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    public RegisterJFrame() {
        this.setSize(488, 500);
        this.setVisible(true);
        this.setTitle("Register | Puzzle Game 1.0");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);

        this.setDefaultCloseOperation(3); //关闭窗口的同时关闭JVM

    }
}
