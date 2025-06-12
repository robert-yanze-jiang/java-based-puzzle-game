package robert.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements ActionListener {

    static ArrayList<User> list = new ArrayList<>();
    static {
        list.add(new User("admin", "123456"));
        list.add(new User("robert", "123456"));
        list.add(new User("robert1", "123456"));
    }

    JButton loginButton = new JButton();
    JButton registerButton = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();


    public LoginJFrame(){

        initJFrame();

        initView();

        this.setVisible(true);

    }

    private void initView() {

        JLabel usernameLabel = new JLabel(new ImageIcon("image/username.png"));
        usernameLabel.setBounds(140, 288, 105,38);
        this.getContentPane().add(usernameLabel);

        username.setBounds(300, 288, 150, 38);
        this.getContentPane().add(username);

        JLabel passwordLabel = new JLabel(new ImageIcon("image/password.png"));
        passwordLabel.setBounds(140, 338, 105,38);
        this.getContentPane().add(passwordLabel);

        password.setBounds(300, 338, 150, 38);
        this.getContentPane().add(password);


        loginButton.setBounds(160, 438, 115, 53);
        loginButton.setIcon(new ImageIcon("image/login_a.png"));
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        this.getContentPane().add(loginButton);


        registerButton.setBounds(330, 438, 115, 53);
        registerButton.setIcon(new ImageIcon("image/register_a.png"));
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        this.getContentPane().add(registerButton);

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);







        JLabel title = new JLabel(new ImageIcon("image/title.png"));
        title.setBounds(100, 10, 397, 200);
        this.getContentPane().add(title);

        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(47, 185, 500, 500);
        this.getContentPane().add(background);



    }

    private void initJFrame() {
        this.setSize(603, 800);
//        this.setVisible(true);
        this.setTitle("Login | Puzzle Game 1.0");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(3); //关闭窗口的同时关闭JVM
    }

    public void showJDialog(String content){
        JDialog jDialog = new JDialog();
        jDialog.setSize(400,200);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);

        JLabel warning =  new JLabel(content);
        warning.setBounds(0,0,400,200);
        jDialog.getContentPane().add(warning);

        jDialog.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == loginButton){
            //
            loginButton.setIcon(new ImageIcon("image/login_b.png"));
            this.getContentPane().repaint();
            String inputUsername = username.getText();
            String inputPassword = password.getText();

            if (checkUser(inputUsername, inputPassword)){
                showJDialog("Login successfully!");
                new GameJFrame();
                this.setVisible(false);
            } else{
                showJDialog("Username or password is incorrect! Please try again!");
                loginButton.setIcon(new ImageIcon("image/login_a.png"));
                this.getContentPane().repaint();
            }

        }else if (source == registerButton){
            //
            registerButton.setIcon(new ImageIcon("image/register_b.png"));
            this.getContentPane().repaint();

            showJDialog("Register Function is under construction.");

            registerButton.setIcon(new ImageIcon("image/register_a.png"));
            this.getContentPane().repaint();
        }
    }

    public boolean checkUser(String username, String password){
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.username.equals(username) && user.password.equals(password)){
                return true;
            }
        }
        return false;
    }

}
