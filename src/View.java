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
        testmodel1.nextTurn(testmodel1.sizeGrid);

        testview.registerModel(testmodel2);
        testmodel2.nextTurn(testmodel2.sizeGrid);
    }
}
