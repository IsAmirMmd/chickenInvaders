import processing.core.*;

import java.util.ArrayList;

public class Chicken extends PApplet {
    public static ArrayList<Chicken> chickens = new ArrayList<>();

    private float speedY = -50;
    PImage chickenImage;
    float chickenX;
    float chickenY;
    int chickenLife;
    float chickenWidth;
    float chickenHeight;


    public Chicken(PImage chickenImage, float chickenX, float chickenY, int chickenLife) {
        this.chickenImage = chickenImage;
        this.chickenX = chickenX;
        this.chickenY = chickenY;
        this.chickenLife = chickenLife;
        this.chickenWidth = 50;
        this.chickenHeight = 50;
    }

    public void makeChicken() {

        for (int i = 0; i < 10; i++) {
            if (i < 9) {

                chickenImage = Main.pro.loadImage("bird1.png");

                Main.chickenArrayList.add(new Chicken(chickenImage, Main.pro.random(210, 305), speedY, 1));
                speedY -= 30;

                chickenImage = Main.pro.loadImage("bird2.png");
                Main.chickenArrayList.add(new Chicken(chickenImage, Main.pro.random(325, 430), speedY, 2));
                speedY -= 30;

                chickenImage = Main.pro.loadImage("bird1.png");
                Main.chickenArrayList.add(new Chicken(chickenImage, Main.pro.random(450, 555), speedY, 1));
                speedY -= 30;

                chickenImage = Main.pro.loadImage("bird2.png");
                Main.chickenArrayList.add(new Chicken(chickenImage, Main.pro.random(575, 640), speedY, 2));
                speedY -= 30;
            } else {
                chickenImage = Main.pro.loadImage("bird1.png");

                Main.chickenArrayList.add(new Chicken(chickenImage, Main.pro.random(210, 305), speedY, 1));
                speedY -= 30;

                chickenImage = Main.pro.loadImage("bird2.png");
                Main.chickenArrayList.add(new Chicken(chickenImage, Main.pro.random(325, 430), speedY, 2));
                speedY -= 30;

                chickenImage = Main.pro.loadImage("bird1.png");
                Main.chickenArrayList.add(new Chicken(chickenImage, Main.pro.random(450, 555), speedY, 1));
                speedY -= 30;

                chickenImage = Main.pro.loadImage("bird2.png");
                Main.chickenArrayList.add(new Chicken(chickenImage, Main.pro.random(575, 640), speedY, 2));
                speedY -= 500;

                chickenImage = Main.pro.loadImage("boss.png");
                Chicken boss = new Chicken(chickenImage, 275, speedY, 30);
                boss.setChickenWidth(350);
                boss.setChickenHeight(350);
                Main.speedFly = 1;
                Main.chickenArrayList.add(boss);
            }
        }
    }

    public void showChicken() {
        for (Chicken chic : Main.chickenArrayList) {
            if (chic.getChickenImage() == null) continue;
            Main.pro.image(chic.getChickenImage(), chic.getChickenX(), chic.getChickenY(), chic.getChickenWidth(), chic.getChickenHeight());
        }
    }

    public void moveChicken(float speed) {
        for (Chicken chic : Main.chickenArrayList) {
            chic.setChickenY(chic.getChickenY() + speed);
        }
    }

    public float getChickenX() {
        return chickenX;
    }

    public float getChickenY() {
        return chickenY;
    }

    public void setChickenY(float chickenY) {
        this.chickenY = chickenY;
    }

    public int getChickenLife() {
        return chickenLife;
    }

    public void setChickenLife(int chickenLife) {
        this.chickenLife = chickenLife;
    }

    public PImage getChickenImage() {
        return chickenImage;
    }

    public void setChickenImage(PImage chickenImage) {
        this.chickenImage = chickenImage;
    }

    public float getChickenWidth() {
        return chickenWidth;
    }

    public void setChickenWidth(float chickenWidth) {
        this.chickenWidth = chickenWidth;
    }

    public float getChickenHeight() {
        return chickenHeight;
    }

    public void setChickenHeight(float chickenHeight) {
        this.chickenHeight = chickenHeight;
    }

    public void setChickenX(float chickenX) {
        this.chickenX = chickenX;
    }
}
