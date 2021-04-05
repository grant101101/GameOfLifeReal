import java.util.Arrays;

public class GOLModel {

    private int counter;

    public int sizeGrid;

    public int[][] theGrid;


    public GOLModel(){
       this.sizeGrid=10;
       this.theGrid= new int[10][10];
       for (int i=0;i<(theGrid.length); i++){
           for(int j=0;j<theGrid[i].length; j++){
               this.theGrid[i][j]=0;
           }
       }
    }
//anArray = new int[10];
    public GOLModel(int sizeGrid){
        this.sizeGrid=sizeGrid;
        this.theGrid=new int [sizeGrid][sizeGrid];
        for (int i=0;i<(theGrid.length); i++){
            for(int j=0;j<theGrid[i].length; j++){
                this.theGrid[i][j]=0;
            }
        }
    }

    public GOLModel(int sizeGrid, int[][] theGrid){
        this.sizeGrid=sizeGrid;
        this.theGrid=theGrid;
    }

    void nextTurn(int sizeGrid){
        int[][] next = new int[sizeGrid][sizeGrid];
        for (int l = 1; l<sizeGrid-1;l++){
            for (int m=1;m<sizeGrid-1;m++){
                int activatedNeighbors = 0;
                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j <=1; j++){
                        activatedNeighbors+=theGrid[1+i][m+j];
                    }
                }
                activatedNeighbors -= theGrid[1][m];

                if ((theGrid[1][m]==1) && (activatedNeighbors<2)){
                    next[1][m]=0;
                }
                else if ((theGrid[1][m]==1)&&(activatedNeighbors>3)){
                    next[1][m]=0;
                }
                else if ((theGrid[1][m]==0)&&(activatedNeighbors==3)){
                    next[1][m]=1;
                }
                else{
                    next[1][m]=theGrid[1][m];
                }
            }
        }
        theGrid=next;
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
        System.out.println(testBlank.theGrid.toString());
        if (!testBlank.equals(new GOLModel())) {
            System.out.println("Did not make accurate new model");
        }
        testBlank.nextTurn(testBlank.sizeGrid);
        if (!testBlank.equals(new GOLModel())){
            System.out.println("Incorrect changed an empty model");
        }

        GOLModel test1= new GOLModel(10, aGridOneCell);
        if (test1.equals(new GOLModel())){
            System.out.println("Incorrect did not make unique grid with parameters");
        }

        test1.nextTurn(test1.sizeGrid);
        if (!test1.equals(new GOLModel())){
            System.out.println("Incorrect did not kill only cell");
        }

        GOLModel test2 = new GOLModel(10, aGridThreeCells);
        if (test2.equals(new GOLModel())) {
            System.out.println("Incorrect did not make unique grid with parameters");
        }
        test2.nextTurn(test2.sizeGrid);
        if (!test2.equals(new GOLModel(10,aGridSquare))){
            System.out.println("Incorrect did not follow rules of the game");
        }



    }


}
