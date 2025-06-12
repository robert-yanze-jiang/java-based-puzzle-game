package robert.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    int [][] data = new int [4][4];

    int [][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    int step = 0;

    //条目

    JMenuItem CUHK = new JMenuItem("CUHK");
    JMenuItem HK = new JMenuItem("Hong Kong");

    JMenuItem replayJMenuItem = new JMenuItem("Replay");
    JMenuItem reLoginJMenuItem = new JMenuItem("Login");
    JMenuItem closeJMenuItem = new JMenuItem("Close");

    JMenuItem RobertJMenuItem = new JMenuItem("Robert");




    public GameJFrame() {

        initJFrame();

        initMenuBar();

        initData(); //初始化数据

        initImage(); //初始化图片

        this.setVisible(true);

    }

    int x = 0;
    int y = 0;

    String path = "image/HK/HK02/";

    private void initData() {
        int [] temper = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Random r = new Random();

        for (int i = 0; i < temper.length; i++) {
            int index = r.nextInt(temper.length);
            int temp = temper[i];
            temper[i] = temper[index];
            temper[index] = temp;
        }

        for (int i = 0; i < temper.length; i++) {

            if (temper[i] == 0) {
                x = i/4;
                y = i%4;
                data[x][y] = 0;
            } else{
                data[i/4][i%4] = temper[i];
            }
        }
    }

    private void initImage() {

        this.getContentPane().removeAll();

        if (this.isWin()) {
            JLabel win_icon = new JLabel(new ImageIcon("image/win.png"));
            win_icon.setBounds(71, 280, 460, 300);
            this.getContentPane().add(win_icon);
        }

        JLabel stepCount = new JLabel("Step: "+step);
        stepCount.setBounds(20, 5, 100, 20);
        this.getContentPane().add(stepCount);



        for (int i = 0; i<4; i++) {
            for (int j = 0; j<4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new  ImageIcon(path+num+".jpg"));
                jLabel.setBounds(90 + 105*j, 238 + 105*i, 105, 105);
                this.getContentPane().add(jLabel);
                jLabel.setBorder(new BevelBorder(1));

            }
        }

        JLabel title = new JLabel(new ImageIcon("image/title.png"));
        title.setBounds(100, 10, 397, 200);
        this.getContentPane().add(title);

        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(47, 185, 500, 500);
        this.getContentPane().add(background);





        this.getContentPane().repaint();
    }

    private void initMenuBar() {
        //菜单
        JMenuBar jMenuBar = new JMenuBar();
        JMenu functionJmenu = new JMenu("Function");
        JMenu aboutJmenu = new JMenu("About Robert");

        JMenu changeImage = new JMenu("Change Image");

        changeImage.add(CUHK);
        changeImage.add(HK);



        //将条目加入到选项
        functionJmenu.add(changeImage);
        functionJmenu.add(replayJMenuItem);
        functionJmenu.add(reLoginJMenuItem);
        functionJmenu.add(closeJMenuItem);

        aboutJmenu.add(RobertJMenuItem);

        replayJMenuItem.addActionListener(this);
        reLoginJMenuItem.addActionListener(this);
        closeJMenuItem.addActionListener(this);
        RobertJMenuItem.addActionListener(this);

        //
        CUHK.addActionListener(this);
        HK.addActionListener(this);

        //将选项加入到菜单

        jMenuBar.add(functionJmenu);
        jMenuBar.add(aboutJmenu);



        this.setJMenuBar(jMenuBar);

    }

    private void initJFrame() {
        this.setSize(603, 800);

        this.setTitle("Puzzle Game 1.0");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3); //关闭窗口的同时关闭JVM
        this.setLayout(null);

        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();

            JLabel all = new JLabel(new ImageIcon(path+"all"+".jpg"));
            all.setBounds(90, 238, 420, 420);
            this.getContentPane().add(all);


            JLabel title = new JLabel(new ImageIcon("image/title.png"));
            title.setBounds(100, 10, 397, 200);
            this.getContentPane().add(title);

            JLabel background = new JLabel(new ImageIcon("image/background.png"));
            background.setBounds(47, 185, 500, 500);
            this.getContentPane().add(background);

            this.getContentPane().repaint();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (this.isWin()) {
            return;
        }

        int code = e.getKeyCode();
        if  (code == 37) {
            if (y==3) {
                return;
            }
            data [x][y] = data [x][y+1];
            data [x][y+1] = 0;
            y++;
            step++;
            initImage();
        }else if  (code == 38) {
            if (x==3){
                return;
            }
            data [x][y] = data [x+1][y];
            data [x+1][y] = 0;
            x++;
            step++;
            initImage();
        }else if  (code == 39) {
            if (y==0) {
                return;
            }
            data [x][y] = data [x][y-1];
            data [x][y-1] = 0;
            y--;
            step++;
            initImage();
        }else if  (code == 40) {
            if (x==0) {
                return;
            }
            data [x][y] = data [x-1][y];
            data [x-1][y] = 0;
            x--;
            step++;
            initImage();

        }else if  (code == 65) {
            initImage();
        }else if  (code == 87) {
            data = new int [][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            x = 3;
            y = 3;
            step ++;
            initImage();

        }

    }

    public boolean isWin() {
        for (int i = 0; i<4; i++) {
            for (int j = 0; j<4; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == replayJMenuItem) {
            step = 0;
            initData();
            initImage();
        }else if (source == reLoginJMenuItem) {
            this.setVisible(false);
            new LoginJFrame();

        }else if (source == closeJMenuItem) {
            System.exit(0);

        }else if (source == RobertJMenuItem) {
            JDialog robert =  new JDialog();
            JLabel robert_icon = new JLabel(new ImageIcon("image/robert.png"));
            robert_icon.setBounds(0, 0, 540, 480);

            JLabel remind = new JLabel("Close this page to go back to the game!");
            remind.setBounds(145, 520,500,50);

            robert.getContentPane().add(remind);
            robert.getContentPane().add(robert_icon);


            robert.setSize(540, 600);
            robert.setAlwaysOnTop(true);
            robert.setLocationRelativeTo(null);

            robert.setModal(true);
            robert.setVisible(true);
        } else if (source == CUHK) {
            Random t = new Random();
            int i = t.nextInt(3) + 1;
            path = "image/CUHK/CUHK0"+i+"/";
            step = 0;
            initData();
            initImage();
        } else if (source == HK) {
            Random t = new Random();
            int i = t.nextInt(2) + 1;
            path = "image/HK/HK0"+i+"/";
            step = 0;
            initData();
            initImage();
        }

    }
}
