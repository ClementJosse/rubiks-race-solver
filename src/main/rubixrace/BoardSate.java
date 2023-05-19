package java;

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

    public void swapVoidTile(int i, int j){

        Tile temp=new Tile(board[void_tile_i+i][void_tile_j+j].getTileColor());
        System.out.print("avant: "+temp.getTileColorString()+board[void_tile_i][void_tile_j].getTileColorString()+board[void_tile_i+i][void_tile_j+j].getTileColorString());
        board[void_tile_i][void_tile_j]=temp;
        board[void_tile_i+i][void_tile_j+j]= new Tile(TileColor.EMPTY);
        System.out.println("apres: "+temp.getTileColorString()+board[void_tile_i][void_tile_j].getTileColorString()+board[void_tile_i+i][void_tile_j+j].getTileColorString());

    }

    public String getHistoric() {
        return historic;
    }

    public void appendHistoric(String newStep){
        historic=historic+newStep;
    }
}
