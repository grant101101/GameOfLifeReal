import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //GOLModel model = new GOLModel();
        int[][] aGridThreeCells = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
        };
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter size: ");
        int size = myObj.nextInt();
        GOLModel model = new GOLModel(size);
        GOLView view = new GOLView();
        Controller controller = new Controller();
        view.registerModel(model);
        controller.registerMV(model,view);
        view.registerForwardHandler(controller.getForwardHandler());
        view.registerGridHandlers(controller.getGridHandlers());
        view.registerResetHandler(controller.getResetHandler());
        view.registerStopStartHandler(controller.getStartStopHandler());
        view.registerTimerHandler(controller.getTimerHandler());
    }
}
