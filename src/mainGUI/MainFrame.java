package src.mainGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.LinkedQueue.EmptyQueueException;
import src.LinkedQueue.LinkedQueue;
import src.Manage;
import src.Player;
import src.TicTacToe ;

public class MainFrame extends JFrame implements ActionListener{
    private JTextField textFieldName1;
    private JTextField textFieldName2;
    private JPanel panelLeft;
    private JPanel gamePanel;
    private JButton button1;
    private JButton queueXButton;
    private JButton playButton;
    private JTextField textFieldAge1;
    private JTextField textFieldAge2;
    private JButton queueOButton;

    private Manage manager;


    public MainFrame() {

        //Set title, size, layout (grid [2x1]), and location of GUI window
        setTitle("Tic Tac Toe");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panelLeft.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        //Add panels
        getContentPane().add(gamePanel);

        //Set GUI window to visible and disable resizing
        setVisible(true);
        setResizable(false);

        // add ActionListener to buttons
        button1.addActionListener(this);
        queueXButton.addActionListener(this);

        queueOButton.addActionListener(this);
        playButton.addActionListener(this);

        this.manager = new Manage(new LinkedQueue(), new LinkedQueue());
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    public static void update(){ // to update data in stacks, queues, .. everything.
    }
    public void checkWinning(TicTacToe status){
        if (status.playerXWin){
            this.manager.setStackWinners();
        }
        if (status.playerOWin){
            this.manager.setStackLosers();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            Player temptPlayerX = new Player(Integer.parseInt(textFieldAge1.getText()), textFieldName1.getText()); // for age, convert to integer
            Player temptPlayerO = new Player(Integer.parseInt(textFieldAge2.getText()), textFieldName2.getText()); // for age, convert to integer
            this.manager.addQueue(temptPlayerX, temptPlayerO);
        }
        if (e.getSource() == queueXButton) {
            manager.displayQueueX();
        }
        if (e.getSource() == queueOButton) {
            manager.displayQueueO();
        }
        if (e.getSource() == playButton) {
            try {
                manager.getPlayersReady();
            } catch (EmptyQueueException emptyQueueException) {
                emptyQueueException.printStackTrace();
            }
            TicTacToe tictactoeGame = new TicTacToe();

            if (!tictactoeGame.playing){
                checkWinning(tictactoeGame);
            }
        }

    }
}
