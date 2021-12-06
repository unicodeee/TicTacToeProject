package src.mainGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.LinkedQueue.LinkedQueue;
import src.Manage;
import src.Player;
import src.TicTacToe ;

public class MainFrame extends JFrame implements ActionListener{
    private JTextField textFieldName1;
    private JCheckBox checkBoxWin1;
    private JCheckBox checkBoxLose1;
    private JTextField textFieldName2;
    private JCheckBox checkBoxWin2;
    private JCheckBox checkBoxLose2;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JPanel gamePanel;
    private JButton button1;
    private JButton button2;
    private JButton playButton;
    private JTextField textFieldAge1;
    private JTextField textFieldAge2;

    private JLabel label1 = new JLabel("AAAAAAAAAA");
    private Manage manager;


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


        this.manager = new Manage(new LinkedQueue(), new LinkedQueue());
    }

    public static void main(String[] args) {
        new MainFrame();

    }

    public static void update(){ // to update data in stacks, queues, .. everything.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            Player temptPlayer = new Player(Integer.parseInt(textFieldAge1.getText()), textFieldName1.getText(), (checkBoxWin1.isSelected()) ? true : false); // for age, convert to integer
            this.manager.addQueueX(temptPlayer);
        }
        if (e.getSource() == button2) {
            System.out.println(textFieldName2.getText());  // get Player2's name in textfiled2
        }
        if (e.getSource() == playButton) {

            new TicTacToe();
        }

    }
}
