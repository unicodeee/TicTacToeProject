package src.mainGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.TicTacToe ;

public class MainFrame extends JFrame implements ActionListener{
    private JTextField textField1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JTextField textField2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JPanel gamePanel;
    private JButton button1;
    private JButton button2;
    private JButton playButton;

    private JLabel label1 = new JLabel("AAAAAAAAAA");


    //Add panels

    public MainFrame() {



        //Set title, size, layout (grid [2x1]), and location of GUI window
        setTitle("Tic Tac Toe");
        setSize(1000, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Add panels
        getContentPane().add(gamePanel);
//Set GUI window to visible and disable resizing
        setVisible(true);
        setResizable(false);

        // add ActionListener to buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        playButton.addActionListener(this);
    }

    public static void main(String[] args) {
        new MainFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            System.out.println(textField1.getText());  // get Player1's name in textfiled1
        }
        if (e.getSource() == button2) {
            System.out.println(textField2.getText());  // get Player2's name in textfiled2
        }
        if (e.getSource() == playButton) {

            new TicTacToe();
        }

    }
}
