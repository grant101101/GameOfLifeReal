
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GOLView {
        private GOLModel model;
        JFrame gameframe;
        JPanel buttonpanel;
        JPanel gamegrid;
        JPanel mainpanel;
        JPanel controlpanel;
        JPanel sliderpanel;
        JButton startstop;
        JButton backward;
        JButton forward;
        JTextField turnnumber;
        JSlider speed;
        JButton[][] gridButton;
        int boardWidth;
        int boardLength;

        final int speed_min = 0;
        final int speed_max = 10;
        final int speed_init = 5;
        public GOLView() {
// create objects (buttons, textfields, and speed slider
                gameframe = new JFrame();
                gameframe.getContentPane().setLayout(new BorderLayout());
                gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameframe.setSize(700,500);
                gameframe.setLocationRelativeTo(null);

                // Create actual UI
                startstop = new JButton("Start/Stop");
                backward = new JButton("Look Back");
                turnnumber = new JTextField("0");
                forward = new JButton("Look Forward");
                speed = new JSlider(JSlider.HORIZONTAL, speed_min, speed_max, speed_init);

                // Add these to a Panel at bottom of page
                FlowLayout buttonLayout = new FlowLayout();
                controlpanel = new JPanel();
                controlpanel.setLayout(new BoxLayout(controlpanel, BoxLayout.Y_AXIS));
                sliderpanel = new JPanel();
                buttonpanel = new JPanel();
                buttonpanel.setLayout(buttonLayout);
                buttonpanel.add(startstop);
                buttonpanel.add(backward);
                buttonpanel.add(turnnumber);
                buttonpanel.add(forward);
                sliderpanel.add(speed);
                controlpanel.add(buttonpanel);
                controlpanel.add(sliderpanel);

        }

        public void updateBoard(){
                for (int y = 0; y < boardLength; y++) {
                        for (int x = 0; x < boardWidth; x++) {
                                if(this.model.isAlive(x,y)){
                                        this.gridButton[x][y].setBackground(Color.red);
                                }
                                else{
                                        this.gridButton[x][y].setBackground(Color.white);
                                }
                        }
                }
        }
        public static void main(String[] args){
                GOLView theview = new GOLView();
        }

        public void registerModel(GOLModel model) {
                this.model=model;
                boardWidth=this.model.getSize();
                boardLength=this.model.getSize();
                gamegrid = new JPanel();
                gridButton = new JButton[boardWidth][boardLength];
                gamegrid.setLayout(new GridLayout(boardWidth, boardLength, 0, 0));
                for (int y = 0; y < boardLength; y++) {
                        for (int x = 0; x < boardWidth; x++) {
                                gridButton[x][y] = new JButton(x + ":" + y);
                                gridButton[x][y].setActionCommand(x + ":" + y);
                                gridButton[x][y].setText(" ");
                                gamegrid.add(gridButton[x][y]);
                        }
                }
                mainpanel = new JPanel();
                mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
                mainpanel.add(gamegrid);
                mainpanel.add(controlpanel);
                gameframe.add(mainpanel);
                gameframe.setVisible(true);
                this.updateBoard();
        }

        public void registerForwardHandler(ActionListener handler){
                this.forward.addActionListener(handler);
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

