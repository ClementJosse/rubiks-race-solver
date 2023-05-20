package rubixrace;

public class BoardState {
    private Tile[][] board = new Tile[5][5];
    private String historic;
    public int void_tile_i;
    public int void_tile_j;
    public int heuristic;

    BoardState(Tile[][] board, String historic, char nextStep, int void_tile_i, int void_tile_j){
        copyBoardState(board);
        this.historic=historic+nextStep;
        this.void_tile_i = void_tile_i;
        this.void_tile_j = void_tile_j;
    }

    private void copyBoardState(Tile[][] modelBoard) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j]=new Tile(modelBoard[i][j].getTileColor());
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void swapVoidTile(int i, int j){
        Tile temp=new Tile(board[void_tile_i][void_tile_j].getTileColor());
        board[void_tile_i][void_tile_j]=board[void_tile_i+i][void_tile_j+j];
        board[void_tile_i+i][void_tile_j+j]= temp;
        void_tile_i=void_tile_i+i;
        void_tile_j=void_tile_j+j;

    }

    public String getHistoric() {
        return historic;
    }

    public char getPreviousStep(){
        return historic.charAt(historic.length()-1);
    }
}
