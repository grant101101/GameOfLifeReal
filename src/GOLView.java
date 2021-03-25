import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GOLView {
// create objects (buttons, textfields, and speed slider
    private JFrame frame;
    private JButton start;
    private JButton stop;
    private JButton backwards;
    private JButton forward;
    private JTextField turnnumber;
    private JSlider speed;
    private GameBoard gol_gameboard;

private class GameBoard() extends JPanel {
    private Dimension d_gameBoardSize = null;
    private ArrayList<Point> point = new ArrayList<Point>(0);

    private void updateSize() {
        ArrayList<Point> removeList = new ArrayList<Point>(0);
        for (Point current : point) {
            if ((current.x > d_gameBoardSize.width-1) || (current.y > d_gameBoardSize.height-1)) {
                removeList.add(current);
            }
        }
        point.removeAll(removeList);
        repaint();
    }

}
