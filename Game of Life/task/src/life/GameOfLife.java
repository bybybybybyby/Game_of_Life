package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    Grid grid;
    JLabel GenerationLabel;
    JLabel AliveLabel;

    int gen = 0;

    public GameOfLife() {
        super("Game of Life");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        GenerationLabel = new JLabel();
        AliveLabel = new JLabel();

        GenerationLabel.setName("GenerationLabel");
        GenerationLabel.setText("GenerationLabel #" + getGen());

        AliveLabel.setName("AliveLabel");
        AliveLabel.setText("AliveLabel: 0");

        add(GenerationLabel);
        add(AliveLabel);

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

}
