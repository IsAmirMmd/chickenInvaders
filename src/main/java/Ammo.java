import processing.core.*;

import java.util.ArrayList;

public class Ammo extends PApplet {
    int bulletX;
    int bulletY;
    PImage ammoFire;
    public static int ammoAmount = 2500;

    public Ammo(PImage ammoFire, int x, int y) {
        this.bulletX = x;
        this.bulletY = y;
        this.ammoFire = ammoFire;
    }

    public void fireAmmo() {
        ammoFire = Main.pro.loadImage("ammo.png");
        Main.ammoArrayList.add(new Ammo(ammoFire, Main.pro.mouseX - 16, 520));
    }

    public void showAmmo() {
        for (Ammo tempAmmo : Main.ammoArrayList) {
            if (tempAmmo.getAmmoFire() == null) continue;
            Main.pro.image(ammoFire, tempAmmo.getBulletX(), tempAmmo.getBulletY(), 32, 32);
        }
    }


    public void moveAmmo(int speed) {
        for (Ammo tempAmmo : Main.ammoArrayList) {
            tempAmmo.setBulletY(tempAmmo.getBulletY() - speed);
        }
    }

    public int getBulletX() {
        return bulletX;
    }

    public void setBulletX(int bulletX) {
        this.bulletX = bulletX;
    }

    public int getBulletY() {
        return bulletY;
    }

    public void setBulletY(int bulletY) {
        this.bulletY = bulletY;
    }

    public PImage getAmmoFire() {
        return ammoFire;
    }

    public void setAmmoFire(PImage ammoFire) {
        this.ammoFire = ammoFire;
    }
}
