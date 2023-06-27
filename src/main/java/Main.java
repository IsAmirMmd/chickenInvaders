import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet {
    public static PApplet pro;

    // Constants
    final int WINDOW_WIDTH = 900;
    final int WINDOW_HEIGHT = 700;
    final Chicken chicken = new Chicken(null, 0, 0, 0);


    //    variables
    public static boolean onMenu;
    boolean gameOver;
    public static boolean inGame;
    boolean winGame;
    public static boolean helpCent;
    public static boolean scoreList;
    PImage gameBG;

    public static ArrayList<Chicken> chickenArrayList = new ArrayList<>();


    public void settings() {
        size(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void setup() {
        pro = this;

        chicken.makeChicken();

        gameBG = loadImage("universe-bg.jpg");

        onMenu = true;
        gameOver = false;
        inGame = false;
        winGame = false;
        helpCent = false;
        scoreList = false;
    }

    public void draw() {
        background(gameBG);

        if (onMenu) {
            Menu.mouseCur();
            Menu.menuOption();
        }
    }
    public static void main(String[] args) {
        PApplet.main("Main");

    }
}