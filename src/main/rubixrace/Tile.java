package java;

public class Tile {
    private final TileColor tileColor;

    public Tile(TileColor tileColor){
        // System.out.println("java.main.Tile");
        this.tileColor=tileColor;
    }

    public TileColor getTileColor() {
        return this.tileColor;
    }
    public String getTileColorString() {
        return this.tileColor.getColoredLetter();
    }

}
