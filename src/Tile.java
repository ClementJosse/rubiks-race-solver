public class Tile {
    private final TileColor tileColor;
    private final int tileId;

    public Tile(TileColor tileColor,int tileId){
        // System.out.println("Tile");
        this.tileColor=tileColor;
        this.tileId=tileId;
    }

    public TileColor getTileColor() {
        return this.tileColor;
    }
    public String getTileColorString() {
        return this.tileColor.getColoredLetter();
    }

    public int getTileId() {
        return tileId;
    }
}
