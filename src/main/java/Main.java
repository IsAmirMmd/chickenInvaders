import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet pro;

    // Constants
    final int WINDOW_WIDTH = 900;
    final int WINDOW_HEIGHT = 700;

    public void settings() {
        size(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void setup() {
        pro = this;
    }

    public void draw() {
    }
    public static void main(String[] args) {
        PApplet.main("Main");

    }
}