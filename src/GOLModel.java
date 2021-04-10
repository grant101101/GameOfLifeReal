import java.util.Arrays;

public class GOLModel {

    private int counter;

    public int sizeGrid;

    public int[][] theGrid;

    public GOLModel(int[][] grid){
        this.theGrid=grid;
        this.sizeGrid=grid.length;
    }

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

    void nextTurn(){
        int[][] next = new int[this.sizeGrid][this.sizeGrid];
        for (int l = 1; l<this.sizeGrid-1;l++){
            for (int m=1;m<this.sizeGrid-1;m++){
                int activatedNeighbors = 0;
                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j <=1; j++){
                        activatedNeighbors+=this.theGrid[l+i][m+j];
                    }
                }
                activatedNeighbors -= this.theGrid[l][m];

                if ((this.theGrid[l][m]==1) && (activatedNeighbors<2)){
                    next[l][m]=0;
                }
                else if ((this.theGrid[l][m]==1)&&(activatedNeighbors>3)){
                    next[l][m]=0;
                }
                else if ((this.theGrid[l][m]==0)&&(activatedNeighbors==3)){
                    next[l][m]=1;
                }
                else{
                    next[l][m]=this.theGrid[l][m];
                }
            }
        }
        this.theGrid=next;
    }

    boolean isAlive(int x, int y){
        return this.theGrid[x][y]==1;
    }

    int getSize(){
        return this.sizeGrid;
    }

    public int[][] getTheGrid(){
        return this.theGrid;
    }

    public int getSizeGrid(){
        return this.sizeGrid;
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
        GOLModel testBlank2 = new GOLModel();

        System.out.println(testBlank.theGrid.toString());
        if (!Arrays.deepEquals(testBlank.theGrid, testBlank2.theGrid)) {
            System.out.println("Did not make accurate new model");
        }
        testBlank.nextTurn();
        if(!Arrays.deepEquals(testBlank.theGrid, testBlank2.theGrid)){
            System.out.println("Incorrect changed an empty model");
        }

        GOLModel test1= new GOLModel(10, aGridOneCell);
        if (test1.equals(new GOLModel())){
            System.out.println("Incorrect did not make unique grid with parameters");
        }

        test1.nextTurn();
        if(!Arrays.deepEquals(test1.theGrid, testBlank2.theGrid)){
            System.out.println("Incorrect did not kill only cell");
        }

        GOLModel test2 = new GOLModel(10, aGridThreeCells);
        GOLModel testCompare = new GOLModel(10,aGridSquare);
        if (test2.equals(new GOLModel())) {
            System.out.println("Incorrect did not make unique grid with parameters");
        }
        test2.nextTurn();
        if(!Arrays.deepEquals(test2.theGrid, testCompare.theGrid)){
            System.out.println("Incorrect did not follow rules of the game");
        }



    }


}
