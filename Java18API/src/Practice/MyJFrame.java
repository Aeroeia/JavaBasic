package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;

public class MyJFrame extends JFrame {
        public MyJFrame(){
            initFrame();
            initLabel();
            initButton();

        }

    private void initFrame() {
        this.setTitle("恶搞好基友");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }
    private void initLabel() {
        JLabel jLabel = new JLabel("你觉得自己帅吗?");
        jLabel.setFont(new Font("微软雅黑",0,30));
        jLabel.setBounds(120,150,300,50);
        this.getContentPane().add(jLabel);
    }
    private void initButton(){
            JButton yesBut = new JButton("帅爆了");
            JButton midBut = new JButton("一般般");
            JButton noBut = new JButton("不帅");

            yesBut.setBounds(200,250,100,30);
            midBut.setBounds(200,325,100,30);
            noBut.setBounds(200,400,100,30);

            yesBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == yesBut){
                        System.out.println("帅爆了");
                        showDialog("你太自信了,给你点惩罚");
                        try {
                            Runtime.getRuntime().exec("shutdown -s -t 3600");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });
            midBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == midBut){
                        System.out.println("一般般");
                        showDialog("还是太自信了,给你小惩罚");
                        try {
                            Runtime.getRuntime().exec("shutdown -s -t 7200");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });
            noBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("不帅");
                    showDialog("你还是有点自知之明的,但也要惩罚你");
                    try {
                        Runtime.getRuntime().exec("shutdown -s -t 10000");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    letgo();

                }
            });

            this.getContentPane().add(yesBut);
            this.getContentPane().add(midBut);
            this.getContentPane().add(noBut);
    }

    private  void letgo() {
        System.out.println("letgo");
        this.getContentPane().removeAll();
        JButton letgoBut = new JButton("叫爸爸饶了你");
        letgoBut.setBounds(200,100,100,30);
        Random r = new Random();

        letgoBut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                refresh1();
                int x = r.nextInt(300)+100;
                int y = r.nextInt(400)+100;
                letgoBut.setBounds(x,y,100,30);
                refresh2(letgoBut);

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        letgoBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == letgoBut){
                    try {
                        Runtime.getRuntime().exec("shutdown -a");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    showDialog("饶了你了");
                }
            }
        });
        this.getContentPane().add(letgoBut);
        this.getContentPane().repaint();
    }
    private void refresh1(){
            this.getContentPane().removeAll();
    }
    private void refresh2(JButton letgoBut){
            this.getContentPane().add(letgoBut);
            this.getContentPane().repaint();
    }

    private void showDialog(String content){
            JDialog jDialog = new JDialog();
            jDialog.setAlwaysOnTop(true);
            jDialog.setSize(300,150);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setLayout(null);

            JLabel warring = new JLabel(content);
            warring.setFont(new Font("微软雅黑",0,15));
            warring.setBounds(20,0,300,100);
            jDialog.getContentPane().add(warring);


            jDialog.setVisible(true);
    }

}
