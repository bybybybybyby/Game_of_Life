package life;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {

    private ArrayList<Point> fillCells;

    public Grid() {
        fillCells = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw filled cells
        for (int i = 0; i < fillCells.size(); i++) {
            int cellX = 10 + (fillCells.get(i).x * 10);
            int cellY = 10 + (fillCells.get(i).y * 10);
            g.setColor(Color.BLACK);
            g.fillRect(cellX, cellY, 10, 10);
        }

        // Draw basic grid
        g.setColor(Color.BLUE);
        g.drawRect(10, 10, 200, 200);
        for (int i = 10; i <= 200; i += 10) {
            g.drawLine(i, 10, i, 210);
        }
        for (int i = 10; i <= 200; i += 10) {
            g.drawLine(10, i, 210, i);
        }
    }

    public void fillCell(int x, int y) {
        fillCells.add(new Point(x, y));
        repaint();
    }

    public void removeCell(int x, int y) {
        fillCells.remove(new Point(x, y));
        repaint();
    }

}
