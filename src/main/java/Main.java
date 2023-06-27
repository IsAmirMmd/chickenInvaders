import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet {
    public static PApplet pro;

    // Constants
    final int WINDOW_WIDTH = 900;
    final int WINDOW_HEIGHT = 700;
    final Rocket rocket = new Rocket();

    final Chicken chicken = new Chicken(null, 0, 0, 0);
    final Ammo ammo = new Ammo(null, 0, 0);


    //    variables
    public static boolean onMenu;
    boolean gameOver;
    public static boolean inGame;
    boolean winGame;
    public static boolean helpCent;
    public static boolean scoreList;
    boolean isShoot;
    int killedChicken;
    int speedFly;
    int loseScore = 0;

    PImage gameBG;

    public static ArrayList<Chicken> chickenArrayList = new ArrayList<>();
    public static ArrayList<Ammo> ammoArrayList = new ArrayList<>();


    public void settings() {
        size(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void setup() {
        pro = this;

        chicken.makeChicken();
        rocket.rocketPos();


        gameBG = loadImage("universe-bg.jpg");

        onMenu = true;
        gameOver = false;
        inGame = false;
        winGame = false;
        helpCent = false;
        scoreList = false;

        speedFly = 1;
        killedChicken = 0;
    }

    public void draw() {
        background(gameBG);

        if (onMenu) {
            Menu.mouseCur();
            Menu.menuOption();
        } else if (!onMenu && inGame) {
            rocket.showRocket();
            chicken.showChicken();
            chicken.moveChicken(speedFly);

            if (isShoot) {
                if (frameCount % 5 == 0) {
                    ammo.fireAmmo();
                    Ammo.ammoAmount -= 1;
                    if (Ammo.ammoAmount % 20 == 0) {
                        isShoot = false;
                    }
                }
            }

            ammo.showAmmo();
            ammo.moveAmmo(5);
        }
    }

    @Override
    public void mousePressed() {
        if (!onMenu) isShoot = true;
        else {

        }
    }


    @Override
    public void mouseReleased() {
        if (!onMenu) isShoot = false;
        else {

        }
    }

    public void checkCrashed(Chicken chicken1, Ammo ammo1) {
        float leftAmmo = ammo1.bulletX;
        float rightAmmo = ammo1.bulletX + 32;
        float topAmmo = ammo1.bulletY;
        float bottomAmmo = ammo1.bulletY + 32;

        float leftChick = chicken1.chickenX;
        float rightChick = chicken1.chickenX + chicken1.getChickenWidth(); // width is 50
        float topChick = chicken1.chickenY;
        float bottomChick = chicken1.chickenY + chicken1.getChickenHeight(); // height is 50

        if (topAmmo >= 0 && topAmmo <= 600 && leftAmmo >= leftChick && leftAmmo <= rightChick && topAmmo >= topChick && topAmmo <= bottomChick) {
            chicken1.setChickenLife(chicken1.getChickenLife() - 1);

            if (chicken1.getChickenLife() == 0) {
                chicken1.setChickenLife(0);
                chicken1.setChickenY(800);
                chicken1.setChickenX(-200);
                chicken1.setChickenImage(null);
                killedChicken += 1;
            }
            if (chicken1.getChickenLife() == 0 && chicken1.getChickenWidth() == 350) {
                loseScore = frameCount / 5 + killedChicken * 15;
                inGame = false;
                winGame = true;

            }

            ammo1.setAmmoFire(null);
            ammo1.setBulletX(-200);
            ammo1.setBulletY(800);
        }

    }
    public static void main(String[] args) {
        PApplet.main("Main");

    }
}