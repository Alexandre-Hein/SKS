package ui;

import gamestates.GameState;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import static utils.Constants.UI.Buttons.*;
import utils.LoadSave;

/**
 * Class used to create a button in the menu.
 */
public class MenuButton {
    private int xPos, yPos, rowIndex, index;
    private int xOffsetCenter = B_WIDTH / 2;
    private GameState state;
    private BufferedImage[] imgs;
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;

    /**
     * Constructor of the MenuButton class.
     * @param xPos
     * @param yPos
     * @param rowIndex
     * @param state
     */
    public MenuButton(int xPos, int yPos, int rowIndex, GameState state) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImgs();
        initBounds();
    }

    /**
     * Method used to initialize the bounds of the button.
     */
    private void initBounds() {
        bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);

    }

    /**
     * Method used to load the images of the button.
     */
    private void loadImgs() {
        imgs = new BufferedImage[3];
        BufferedImage temp = LoadSave.loadImage(LoadSave.MENU_BUTTONS);
        for (int i = 0; i < imgs.length; i++)
            imgs[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
    }

    /**
     * Method used to draw the button.
     * @param g
     */
    public void draw(Graphics g) {
        g.drawImage(imgs[index], xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT, null);
    }

    /**
     * Method used to update the button.
     */
    public void update() {
        index = 0;
        if (mouseOver)
            index = 1;
        if (mousePressed)
            index = 2;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void applyGameState() {
        GameState.state = state;
    }

    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
    }

}