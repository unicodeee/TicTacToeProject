package src.mainGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.Manage;
import src.Player;
import src.TicTacToe ;


public class MainFrame extends JFrame implements ActionListener{
    private JTextField textFieldName1;
    private JTextField textFieldName2;
    private JPanel panelLeft;
    private JPanel gamePanel;
    private JButton submitInputButton;
    private JButton queueXButton;
    private JButton playButton;
    private JTextField textFieldAge1;
    private JTextField textFieldAge2;
    private JButton queueOButton;
    private JButton sortWinnersButton;
    private JTextField searchField;
    private JButton searchButton;

    private Manage manager;


    public MainFrame() {
        //Set title, size, layout (grid [2x1]), and location of GUI window
        setTitle("Tic Tac Toe");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panelLeft.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        //Add panels
        getContentPane().add(gamePanel);

        //Set GUI window to visible and disable resizing
        setVisible(true);
        setResizable(false);

        // add ActionListener to buttons
        submitInputButton.addActionListener(this);
        queueXButton.addActionListener(this);
        queueOButton.addActionListener(this);
        playButton.addActionListener(this);
        sortWinnersButton.addActionListener(this);
        searchButton.addActionListener(this);
        this.manager = new Manage();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
    public void clearTextFields(){
        textFieldAge1.setText("");
        textFieldAge2.setText("");
        textFieldName1.setText("");
        textFieldName2.setText("");
    }
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitInputButton) {
            Player temptPlayerX = new Player(Integer.parseInt(textFieldAge1.getText()), textFieldName1.getText()); // for age, convert to integer
            Player temptPlayerO = new Player(Integer.parseInt(textFieldAge2.getText()), textFieldName2.getText()); // for age, convert to integer
            this.manager.add(temptPlayerX, temptPlayerO);
            clearTextFields();
        }
        if (e.getSource() == queueXButton) {
            manager.displayQueueX();
        }
        if (e.getSource() == queueOButton) {
            manager.displayQueueO();
        }
        if (e.getSource() == playButton) {
                manager.whoIsPlaying();
                TicTacToe tictactoeGame = new TicTacToe();
                tictactoeGame.attach(manager);
                playButton.setVisible(false);

        }
        if (e.getSource() == sortWinnersButton) {
            manager.sortArrayPlayer(); //  print  winners in sorted order
        }
        if (e.getSource() == searchButton) {
            String searchKey = searchField.getText();
            if (isNumeric(searchKey)){
                manager.searchHashMap(Integer.parseInt(searchKey));
            }else {
                manager.searchTree(searchKey);
            }

        }
    }
}
