package life;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameOfLife extends JFrame {

    Grid grid;
    JLabel generationLabel;
    JLabel aliveLabel;
//    JButton playToggleButton;
    JToggleButton playToggleButton;
    JButton resetButton;
    boolean isPaused;
    boolean isReset;
    int gen = 0;

    public GameOfLife() {
        super("Game of Life");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Pause/Play button
        playToggleButton = new JToggleButton();
        playToggleButton.setName("PlayToggleButton");
        playToggleButton.setText("PlayPause");
        playToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                isPaused = !isPaused;
            }
        });
        add(playToggleButton);


        // Reset start evolution over with different initial state
        resetButton = new JButton();
        resetButton.setName("ResetButton");
        resetButton.setText("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                isReset = true;
            }
        });
        add(resetButton);

        generationLabel = new JLabel();
        generationLabel.setName("GenerationLabel");
        generationLabel.setText("GenerationLabel #" + getGen());
        add(generationLabel);

        aliveLabel = new JLabel();
        aliveLabel.setName("AliveLabel");
        aliveLabel.setText("AliveLabel: 0");
        add(aliveLabel);

        grid = new Grid();
        add(grid);


        setVisible(true);
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public boolean isReset() {
        return isReset;
    }

    public void resetToFalse() {
        isReset = false;
    }

}
