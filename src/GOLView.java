import java.awt.*;
import javax.swing.*;
//import java.util.*;

public class GOLView {
        public GOLView(){
// create objects (buttons, textfields, and speed slider
                JFrame frame;
                JPanel panel;
                JButton startstop;
                JButton backward;
                JButton forward;
                JTextField turnnumber;
                JSlider speed;
                //private GameBoard gol_gameboard;
                final int speed_min = 1;
                final int speed_max = 10;
                final int speed_init = 5;

                frame = new JFrame();
                frame.getContentPane().setLayout(new BorderLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 120);
                frame.setLocationRelativeTo(null);

                // Create actual UI
                startstop = new JButton("Start/Stop");
                backward = new JButton("Look Back");
                forward = new JButton("Look Forward");
                turnnumber = new JTextField();
                speed = new JSlider(JSlider.HORIZONTAL, speed_min, speed_max, speed_init);

                // Add these to a Panel at bottom of page
                panel = new JPanel();
                panel.add(startstop);
                panel.add(backward);
                panel.add(forward);
                panel.add(turnnumber);
                panel.add(speed);

                frame.add(panel);
                frame.setVisible(true);
        }
        public static void main(String[] args){
                GOLView theview = new GOLView();
        }
        }
//private class GameBoard() extends JPanel {
    //private Dimension d_gameBoardSize = null;
    //private ArrayList<Point> point = new ArrayList<Point>(0);

    //private void updateSize() {
        //ArrayList<Point> removeList = new ArrayList<Point>(0);
        //for (Point current : point) {
            //if ((current.x > d_gameBoardSize.width-1) || (current.y > d_gameBoardSize.height-1)) {
                //removeList.add(current);
            //}
        //}
        //point.removeAll(removeList);
        //repaint();

