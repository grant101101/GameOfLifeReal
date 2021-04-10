import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {
    private GOLModel model;
    private GOLView view;
    private ActionListener forwardHandler;
    private MouseListener[][] gridHandlers;

    public Controller(){
        this.forwardHandler= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.nextTurn();
                view.updateBoard();
                System.out.println("The board went forward a turn");
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
}
