package java;

public enum TileColor {

    EMPTY("\033[1;95m"+" @ "+"\033[0m"),
    RED("\033[1;91m"+" R "+"\033[0m"),
    ORANGE("\033[0;33m"+" O "+"\033[0m"),
    GREEN("\033[1;92m"+" G "+"\033[0m"),
    YELLOW("\033[1;93m"+" Y "+"\033[0m"),
    BLUE("\033[1;94m"+" B "+"\033[0m"),
    WHITE("\033[1;97m"+" W "+"\033[0m");

    private String ColoredLetter;

    TileColor(String ColoredLetter){
        // System.out.println("java.main.TileColor");
        this.ColoredLetter=ColoredLetter;
    }

    public String getColoredLetter() {
        return ColoredLetter;
    }


    // Colors

    // "\033[1;95m"+"@"+"\033[0m"; // PURPLE

    // "\033[1;91m"+" R "+"\033[0m"; // RED
    // "\033[1;92m"+" G "+"\033[0m"; // GREEN
    // "\033[1;93m"+" Y "+"\033[0m"; // YELLOW
    // "\033[43m"+" O "+"\033[0m"; // ORANGE
    // "\033[1;94m"+" B "+"\033[0m"; // BLUE
    // = "\033[1;97m"+" W "+"\033[0m"; // WHITE
}
