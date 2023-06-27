import processing.core.*;

public class Rocket extends PApplet implements RocketInterfaces {
    final int GUN_WIDTH = 50;
    final int GUN_HEIGHT = 50;

    PImage gunImage;
    int gunX;
    int gunY;

    public Rocket() {

    }

    public void rocketPos() {
        gunX = (500 - GUN_WIDTH) / 2;
        gunY = 550;
    }

    public void showRocket() {
        gunImage = Main.pro.loadImage("rocket.png");
        Main.pro.image(gunImage, Main.pro.mouseX - 25, gunY, GUN_WIDTH, GUN_HEIGHT);

    }

}
