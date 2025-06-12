package robert.ui;

import javax.swing.*;
import java.util.ArrayList;

public class LoginJFrame extends JFrame {

    static ArrayList<User> list = new ArrayList<>();
    static {
        list.add(new User("admin", "123456"));
        list.add(new User("robert", "123456"));
        list.add(new User("robert1", "123456"));
    }


    public LoginJFrame(){

        initJFrame();

        initView();

        this.setVisible(true);

    }

    private void initView() {

        JLabel usernameLabel = new JLabel(new ImageIcon("image/username.png"));
        usernameLabel.setBounds(140, 288, 105,38);
        this.getContentPane().add(usernameLabel);

        JTextField username = new JTextField();
        username.setBounds(300, 288, 150, 38);
        this.getContentPane().add(username);

        JLabel passwordLabel = new JLabel(new ImageIcon("image/password.png"));
        passwordLabel.setBounds(140, 338, 105,38);
        this.getContentPane().add(passwordLabel);

        JPasswordField password = new JPasswordField();
        password.setBounds(300, 338, 150, 38);
        this.getContentPane().add(password);

        JButton loginButton = new JButton();
        loginButton.setBounds(160, 438, 115, 53);
        loginButton.setIcon(new ImageIcon("image/login_a.png"));
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        this.getContentPane().add(loginButton);

        JButton registerButton = new JButton();
        registerButton.setBounds(330, 438, 115, 53);
        registerButton.setIcon(new ImageIcon("image/register_a.png"));
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        this.getContentPane().add(registerButton);





        JLabel title = new JLabel(new ImageIcon("image/title.png"));
        title.setBounds(100, 10, 397, 200);
        this.getContentPane().add(title);

        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(47, 185, 500, 500);
        this.getContentPane().add(background);



    }

    private void initJFrame() {
        this.setSize(603, 800);
        this.setVisible(true);
        this.setTitle("Login | Puzzle Game 1.0");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);




        this.setLayout(null);



        this.setDefaultCloseOperation(3); //关闭窗口的同时关闭JVM
    }
}
