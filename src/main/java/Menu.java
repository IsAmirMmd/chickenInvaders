import processing.core.PApplet;
import processing.core.PImage;

public class Menu extends PApplet {
    public Menu() {

    }

    public static void menuOption() {
        PImage welcomeMenu = Main.pro.loadImage("bg-text.png");
        Main.pro.textSize(25);
        Main.pro.image(welcomeMenu, 250, 25, 400, 150);
        Main.pro.text("1. Start", 250, 250);
        Main.pro.text("2. Score List", 250, 325);
        Main.pro.text("3. Help Center", 250, 400);
        Main.pro.text("4. Exit", 250, 475);

        if (Main.pro.mousePressed) {
            if (Main.pro.mouseX > 245 && Main.pro.mouseX < 350 && Main.pro.mouseY > 210 && Main.pro.mouseY < 280) {
                // Start game
                Main.onMenu = false;
                Main.inGame = true;
            } else if (Main.pro.mouseX > 245 && Main.pro.mouseX < 370 && Main.pro.mouseY > 300 && Main.pro.mouseY < 360) {
                Main.onMenu = false;
                Main.scoreList = true;

            } else if (Main.pro.mouseX > 245 && Main.pro.mouseX < 400 && Main.pro.mouseY > 390 && Main.pro.mouseY < 435) {
                Main.onMenu = false;

                Main.helpCent = true;
            } else if (Main.pro.mouseX > 245 && Main.pro.mouseX < 340 && Main.pro.mouseY > 450 && Main.pro.mouseY < 500) {
                // Exit program
                Main.pro.exit();
            }
        }
    }

    public static void mouseCur() {
        PImage rocketCur = Main.pro.loadImage("rocket.png");
        Main.pro.image(rocketCur, Main.pro.mouseX - 16, Main.pro.mouseY - 16, 32, 32);
    }
}
