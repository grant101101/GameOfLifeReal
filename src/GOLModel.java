import java.util.Arrays;

public class GOLModel {

    private int counter;

    private int sizeGrid;

    public int[][] theGrid;


    public GOLModel(){
       this.sizeGrid=5;
       this.theGrid= new int[][]{{0, 0, 0, 0, 0},
               {0, 0, 0, 0, 0},
               {0, 0, 0, 0, 0},
               {0, 0, 0, 0, 0},
               {0, 0, 0, 0, 0}
       };
    }

    public GOLModel(int sizeGrid, int[][] theGrid){
        this.sizeGrid=sizeGrid;
        this.theGrid=theGrid;
    }

    public void initGrid(String[] args) {
        int M = 10, N = 10;

        int[][] theGrid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    }

    void nextTurn(){
        /*int[][] next = new int[M][M];
        for (int l = 1; 1<M-1;l++){
            for (int m=1;m<N-1;m++){
                int activatedNeighbors = 0;
                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j <=1; j++){
                        activatedNeighbors+=grid[1+i][m+j];
                    }
                }
                activatedNeighbors -= grid[1][m];

                if ((grid[1][m]==1) && (activatedNeighbors<2)){
                    next[1][m]=1;
                }
            }
        }*/
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

        int[][] aGridThreeCells = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        int[][] aGridSquare = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        GOLModel testBlank = new GOLModel();
        if (!testBlank.equals(new GOLModel())) {
            System.out.println("Did not make accurate new model");
        }
        testBlank.nextTurn();
        if (!testBlank.equals(new GOLModel())){
            System.out.println("Incorrect changed an empty model");
        }

        GOLModel test1= new GOLModel(10, aGridOneCell);
        if (test1.equals(new GOLModel())){
            System.out.println("Incorrect did not make unique grid with parameters");
        }

        test1.nextTurn();
        if (!test1.equals(new GOLModel())){
            System.out.println("Incorrect did not kill only cell");
        }

        GOLModel test2 = new GOLModel(10, aGridThreeCells);
        if (test2.equals(new GOLModel())) {
            System.out.println("Incorrect did not make unique grid with parameters");
        }
        test2.nextTurn();
        if (!test2.equals(new GOLModel(10,aGridSquare))){
            System.out.println("Incorrect did not follow rules of the game");
        }



    }


}
