import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {
    private GOLModel model;
    private GOLView view;
    private ActionListener forwardHandler;
    private ActionListener gridHandlers;
    private ActionListener resetHandler;
    private ActionListener startStopHandler;
    private ActionListener tickerHandler;
    private boolean isBoardActive=true;
    private boolean isTimerOn=false;

    public Controller(){
        this.forwardHandler= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.nextTurn();
                view.updateBoard();
                view.updateTurnCounter();
                System.out.println("The board went forward a turn");
            }
        };
        this.gridHandlers= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String action=e.getActionCommand();
                String[] strArr=action.split(":");
                int[] intArr = new int[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    String num = strArr[i];
                    intArr[i] = Integer.parseInt(num);
                }
                int xCoord = intArr[0];
                int yCoord = intArr[1];
                if (model.isAlive(xCoord,yCoord)){
                    model.deactivateCell(xCoord,yCoord);
                }
                else{
                    model.activateCell(xCoord,yCoord);
                }
                view.updateBoard();

            }
        };
        this.resetHandler = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isTimerOn){
                    view.toggleTimer();
                }
                for (int y = 0; y < view.boardLength; y++) {
                    for (int x = 0; x < view.boardWidth; x++) {
                        view.gridButton[x][y].setEnabled(true);
                        isBoardActive = true;
                        isTimerOn = false;
                    }
                }
                model.resetGame();
                view.updateBoard();
                view.updateTurnCounter();
                System.out.println("The board was reset");
            }
        };
        this.startStopHandler = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.toggleTimer();
                if (isBoardActive){
                    for (int y = 0; y < view.boardLength; y++) {
                        for (int x = 0; x < view.boardWidth; x++) {
                            view.gridButton[x][y].setEnabled(false);
                            isBoardActive=false;
                            isTimerOn=true;
                        }
                    }
                }
                else{
                    for (int y = 0; y < view.boardLength; y++) {
                        for (int x = 0; x < view.boardWidth; x++) {
                            view.gridButton[x][y].setEnabled(true);
                            isBoardActive = true;
                            isTimerOn=false;
                        }
                    }
                }

            }
        };

        this.tickerHandler = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.nextTurn();
                view.updateBoard();
                view.updateTurnCounter();
            }
        };

    }

    public static void main(String[] args){
        int[][] aGridOneCell = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        GOLModel testmodel1 = new GOLModel();
        GOLModel testmodel2 = new GOLModel(10, aGridOneCell);
        View testview = new View();
        testview.registerModel(testmodel1);
        Controller testctrl = new Controller();

    }

    public void registerMV(GOLModel model, GOLView view) {
        this.model= model;
        this.view=view;
    }

    public ActionListener getForwardHandler(){
        return this.forwardHandler;
    }

    public ActionListener getGridHandlers(){
        return this.gridHandlers;
    }

    public ActionListener getResetHandler(){
        return this.resetHandler;
    }

    public ActionListener getStartStopHandler(){
        return this.startStopHandler;
    }

    public ActionListener getTimerHandler(){
        return this.tickerHandler;
    }
}
