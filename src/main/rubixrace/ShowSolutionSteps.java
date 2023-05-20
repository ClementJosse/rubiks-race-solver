package rubixrace;

public class ShowSolutionSteps {
    private final String steps;
    private BoardState initialBoard;

    public ShowSolutionSteps(BoardState initialBoard,String steps){
        this.initialBoard=initialBoard;
        this.steps=steps;
    }

    public void ShowSolution(){
        for (char currentChar : steps.toCharArray()) {
            System.out.println(currentChar);
            switch(currentChar){
                case 'u':
                    initialBoard.swapVoidTile(-1, 0);
                    break;
                case 'l':
                    initialBoard.swapVoidTile(0, -1);
                    break;
                case 'd':
                    initialBoard.swapVoidTile(1, 0);
                    break;
                case 'r':
                    initialBoard.swapVoidTile(0, 1);
                    break;
            }
            PrintBoard(initialBoard.getBoard());
            System.out.println("");
        }
    }
    public void PrintBoard(Tile[][] board) {
        for (int i = 0; i<5;i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j].getTileColorString());
            }
            System.out.println();
        }
    }
}
