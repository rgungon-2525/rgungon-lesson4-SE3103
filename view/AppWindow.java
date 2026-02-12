package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicButtonListener;

import controller.ButtonListener;

public class AppWindow extends JFrame {

    public static final String vsHumanAction = "vs. Human";
    public static final String vsComputerAction = "vs. Computer";

    private AppCanvas canvas = new AppCanvas();
    private BoardButton[] markingButtons = new BoardButton[9];
    private JButton newGameButton = new JButton("New Game");
    private JRadioButton vsHumanButton = new JRadioButton(vsHumanAction);
    private JRadioButton vsComputerButton = new JRadioButton(vsComputerAction);

    public void init() {
        var cp = getContentPane();
        cp.add(canvas, BorderLayout.CENTER);

        ButtonListener buttonListener = new ButtonListener();
        for (int i = 0; i < markingButtons.length; i++) {
            markingButtons[i] = new BoardButton(i);
            markingButtons[i].addActionListener(buttonListener);
        }

        JPanel gameBoardPanel = new JPanel();
        gameBoardPanel.setLayout(new GridLayout(3,3));
        for (var cell: markingButtons) {
            gameBoardPanel.add(cell);
        }
        cp.add(gameBoardPanel, BorderLayout.SOUTH);
    }

}
