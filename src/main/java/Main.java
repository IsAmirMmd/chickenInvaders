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
    final int PLAYER_LIFE = 4;


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
    int playerLife;


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
        playerLife = PLAYER_LIFE;
    }

    public void draw() {
        background(gameBG);

        if (onMenu) {
            Menu.mouseCur();
            Menu.menuOption();
            frameCount = 0;
        } else if (!onMenu && inGame) {
            rocket.showRocket();
            chicken.showChicken();
            chicken.moveChicken(speedFly);

            for (Chicken chicken1 : chickenArrayList) {
                if (chicken1.getChickenWidth() == 350) {
                    if (chicken1.getChickenY() <= 700 && chicken1.getChickenY() >= -350) {
                        textAlign(3, 3);
                        if (chicken1.getChickenY() <= 350 && chicken1.getChickenY() >= -350)
                            text("WELCOME TO BOSS LEVEL", 450, 350);
                        textAlign(1, 1);
                        textSize(32);
                        text("BOSS Life : " + chicken1.getChickenLife(), 710, 40);
                    } else {
                    }
                }
                if (chicken1.getChickenY() <= 600 && chicken1.getChickenY() >= 0) {
                    if (chicken1.getChickenY() > 520 && chicken1.getChickenWidth() == 350) {
                        chicken1.setChickenY(800);
                        chicken1.setChickenX(-200);
                        playerLife = 0;
                    } else if (chicken1.getChickenY() > 520) {
                        chicken1.setChickenY(800);
                        chicken1.setChickenX(-200);
                        playerLife -= 1;
                        break;
                    }
                    if (playerLife <= 0) {
                        gameOver = true;

                        inGame = false;
                        loseScore = frameCount / 5;
                    }

                }
            }

            if (isShoot) {
                if (frameCount % 5 == 0) {
                    ammo.fireAmmo();
                    Ammo.ammoAmount -= 1;
                    if (Ammo.ammoAmount % 20 == 0) {
                        isShoot = false;
                    }
                }
            }
            if (frameCount % 5 == 0) for (Chicken chicken1 : chickenArrayList) {
                for (Ammo ammo1 : ammoArrayList) {
                    checkCrashed(chicken1, ammo1);
                }
            }

            ammo.showAmmo();
            ammo.moveAmmo(5);

            fill(255);
            textSize(32);
            text("Life: " + playerLife, 10, 40);
            text("score: " + (killedChicken * 15 + frameCount / 5), 10, 100);
        } else if (!onMenu && gameOver) {
            gameOverWindow(killedChicken * 15 + loseScore);
        } else if (!onMenu && helpCent) {
            helpCenter();
        } else if (!onMenu && winGame) {
            winnerWindow(loseScore);
        }
    }

    public void gameOverWindow(int score) {
        textAlign(3, 3);

        PImage gameOver = loadImage("gameOver.png");

        image(gameOver, 250, 150, 400, 100);

        text("score :" + score, WINDOW_WIDTH / 2, 300);

        text("1 - Score List", WINDOW_WIDTH / 2, 360);
        text("2 - Exit", 410, 425);
        if (mousePressed) {
            if (mouseX > 367 && mouseX < 600 && mouseY > 350 && mouseY < 390) {
//                score list
            } else if (mouseX > 367 && mouseX < 500 && mouseY > 410 && mouseY < 450) {
                exit();
            }
        }
        textAlign(1, 1);
    }

    public void helpCenter() {
        textAlign(3, 3);
        textSize(64);
        text("Help Center", WINDOW_WIDTH / 2, 100);
        textAlign(1, 1);
        textSize(22);
        text("1- for shoot press left/right click", 200, 200);
        text("2- for increase speed press space", 200, 250);
        text("3- if you don't beat boss you will lose game", 200, 300);
        text("4- we have two type of bird in this game : ", 200, 350);
        text("       -- the green one have to shoot two time", 200, 400);
        text("       -- the black one have to shoot one time", 200, 450);

        PImage chickenImage = loadImage("bird1.png");
        PImage chickenImage2 = loadImage("bird2.png");
        image(chickenImage, 200, 490, 64, 64);
        image(chickenImage2, 300, 490, 64, 64);

        text("back to menu", 200, 600);
        textSize(20);
        if (mousePressed) {
            if (mouseX > 200 && mouseX < 350 && mouseY > 570 && mouseY < 620) {
                helpCent = false;
                onMenu = true;
            }
        }

    }

    public void winnerWindow(int score) {
        textAlign(3, 3);

        PImage gameOver = loadImage("CI1RLogo.png");

        image(gameOver, 250, 150, 400, 200);

        text("score :" + score, WINDOW_WIDTH / 2, 300);

        text("1 - Score List", WINDOW_WIDTH / 2, 360);
        text("2 - Exit", 410, 425);
        if (mousePressed) {
            if (mouseX > 367 && mouseX < 600 && mouseY > 350 && mouseY < 390) {
                text("test-score", 100, 100);
//                score list
            } else if (mouseX > 367 && mouseX < 500 && mouseY > 410 && mouseY < 450) {
                text("exit", 152, 200);
                exit();
            }
        }
        textAlign(1, 1);
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

    @Override
    public void keyPressed() {
        if (!onMenu) if (keyCode == 32) speedFly += 1;
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