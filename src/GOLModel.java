public class GOLModel {

    private int counter;

    private int[][] theGrid;

    public GOLModel(){



    }

    public static void initGrid(String[] args) {
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

    static void nextTurn(int grid[][], int M, int N){
        int[][] next = new int[M][M];

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
        }
    }

}
