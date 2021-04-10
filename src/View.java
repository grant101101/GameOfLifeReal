public class View {
    public View(){}

    public void registerModel(GOLModel model){
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
        testmodel1.nextTurn();

        testview.registerModel(testmodel2);
        testmodel2.nextTurn();
    }
}
