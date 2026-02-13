package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
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
        cp.add(canvas, BorderLayout.NORTH);

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
        cp.add(gameBoardPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,1));
        cp.add(southPanel, BorderLayout.SOUTH);


        JPanel radioPanel = new JPanel();
        radioPanel.setBorder(new TitledBorder("Play strategy"));
        radioPanel.add(vsHumanButton);
        radioPanel.add(vsComputerButton);
        ButtonGroup strategyGroup = new ButtonGroup();
        strategyGroup.add(vsHumanButton);
        strategyGroup.add(vsComputerButton);
        southPanel.add(radioPanel);

        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(new TitledBorder("Action"));
        actionPanel.add(newGameButton);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        actionPanel.add(exitButton);
        southPanel.add(actionPanel);
    }

}
