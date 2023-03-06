public class BoardSate {
    private Tile[][] board = new Tile[5][5];
    private String historic;
    public final String previousStep;
    public final int void_tile_i;
    public final int void_tile_j;
    BoardSate(Tile[][] board, String historic, String previousStep, int void_tile_i, int void_tile_j){
        this.board=board;
        this.historic=historic;
        this.previousStep = previousStep;
        this.void_tile_i = void_tile_i;
        this.void_tile_j = void_tile_j;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public String getHistoric() {
        return historic;
    }

    public void appendHistoric(String newStep){
        historic=historic+newStep;
    }
}
