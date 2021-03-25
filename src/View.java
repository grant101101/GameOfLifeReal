public class View {
    public View(){}

    public void registerModel(GOLModel model){
    }

    public static void main(String[] args){
        GOLModel testmodel1 = new GOLModel();
        GOLModel testmodel2 = new GOLModel(10, aGridOneCell)
        View testview = new View();
        testview.registerModel(testmodel1);

        testmodel1.nextTurn(testmodel1.theGrid, 10, 10);
    }
}
