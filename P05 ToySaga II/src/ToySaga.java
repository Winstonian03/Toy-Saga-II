//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05 Toy Saga II - ToySaga
// Course:   CS 300 Spring 2024
//
// Author:   Winston Chan
// Email:    wchan35@wisc.edu
// Lecturer: Andrew Kuemmel
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Ishaan Udia
// Partner Email:   udia@wisc.edu
// Partner Lecturer's Name: Andrew Kuemmel
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Online Sources:  No help given or received.
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class runs the methods and utilizes the objects in the following classes.
 */

public class ToySaga extends PApplet {

    // File path constants for images
    private static final String IMAGES_PATH = "images" + File.separator;
    protected static final String DAY_BACKGROUND = IMAGES_PATH + "backgroundDay.png";
    protected static final String NIGHT_BACKGROUND = IMAGES_PATH + "backgroundNight.png";
    protected static final String BED = IMAGES_PATH + "bed.png";
    protected static final String NIGHTSTAND = IMAGES_PATH + "nightstand.png";
    protected static final String RUG = IMAGES_PATH + "rug.png";
    protected static final String CAR = IMAGES_PATH + "car.png";
    protected static final String BEAR = IMAGES_PATH + "teddyBear.png";
    protected static final String HOVERBALL_ON = IMAGES_PATH + "hoverBallOn.png";
    protected static final String HOVERBALL_OFF = IMAGES_PATH + "hoverBallOff.png";

    // Constants for day and night modes
    protected static final String DAY_MODE = "DAY";
    protected static final String NIGHT_MODE = "NIGHT";

    // Maximum number of toys allowed
    private static final int MAX_TOYS_COUNT = 8;

    // Background image
    private static PImage backgroundImage;

    // List of drawable objects
    private ArrayList<Drawable> drawableObjects = new ArrayList<Drawable>();

    // Current mode (DAY or NIGHT)
    private String mode;

    /**
     * The main method to start the application.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        PApplet.main("ToySaga");
    }

    /**
     * Gets the current mode (DAY or NIGHT).
     * @return The current mode.
     */
    public String getMode() {
        return this.mode;
    }

    /**
     * Checks if the current mode is NIGHT.
     * @return True if the mode is NIGHT, otherwise false.
     */
    public boolean isNightMode() {
        return getMode().equals(NIGHT_MODE);
    }

    /**
     * Switches the mode between DAY and NIGHT.
     * Changes the background image accordingly.
     */
    public void switchMode() {
        if (isNightMode()) {
            this.mode = DAY_MODE;
            backgroundImage = loadImage(DAY_BACKGROUND);
        } else {
            this.mode = NIGHT_MODE;
            backgroundImage = loadImage(NIGHT_BACKGROUND);
        }
    }

    /**
     * Sets the size of the canvas.
     */
    @Override
    public void settings() {
        this.size(800, 600);
    }

    /**
     * Sets up the initial state of the application.
     * Loads the initial background image and initializes drawable objects.
     */
    @Override
    public void setup() {
        this.getSurface().setTitle("P5 Toy Saga v2.0");
        this.textAlign(CENTER, CENTER);
        this.imageMode(CENTER);
        this.rectMode(CORNERS);
        this.focused = true;
        this.mode = DAY_MODE;
        backgroundImage = loadImage(DAY_BACKGROUND);

        this.drawableObjects = new ArrayList<Drawable>(0);
        SwitchButton.setProcessing(this);
        GraphicObject.setProcessing(this);

        drawableObjects.add(new SwitchButton(565, 20));
        drawableObjects.add(new GraphicObject(BED, 520, 270));
        drawableObjects.add(new GraphicObject(RUG, 220, 370));
        drawableObjects.add(new GraphicObject(NIGHTSTAND, 325, 240));
    }

    /**
     * Draws the background and all drawable objects on the canvas.
     */
    @Override
    public void draw() {
        image(backgroundImage, 400, 300);
        for (Drawable d : this.drawableObjects) {
            d.draw();
        }
    }

    /**
     * Handles the mouse pressed event.
     * Calls the onClick method for all MouseListener objects.
     */
    @Override
    public void mousePressed() {
        for (Drawable d : this.drawableObjects) {
            if (d instanceof MouseListener) {
                ((MouseListener) d).onClick();
            }
        }
    }

    /**
     * Handles the mouse released event.
     * Calls the onRelease method for all MouseListener objects.
     */
    @Override
    public void mouseReleased() {
        for (Drawable d : this.drawableObjects) {
            if (d instanceof MouseListener) {
                ((MouseListener) d).onRelease();
            }
        }
    }

    /**
     * Handles key pressed events.
     * Adds new toys or switches modes based on the key pressed.
     */
    @Override
    public void keyPressed() {
        switch (this.key) {
            case ('c'):
            case ('C'):
                if (getToyCount() < MAX_TOYS_COUNT) {
                    drawableObjects.add(new Car(mouseX, mouseY));
                }
                break;
            case ('t'):
            case ('T'):
                if (getToyCount() < MAX_TOYS_COUNT) {
                    drawableObjects.add(new TeddyBear(mouseX, mouseY));
                }
                break;
            case ('h'):
            case ('H'):
                if (getToyCount() < MAX_TOYS_COUNT) {
                    drawableObjects.add(new Hoverball(mouseX, mouseY));
                }
                break;
            case ('d'):
            case ('D'):
                this.mode = DAY_MODE;
                image(loadImage(DAY_BACKGROUND), 400, 300);
                break;
            case ('n'):
            case ('N'):
                this.mode = NIGHT_MODE;
                image(loadImage(NIGHT_BACKGROUND), 400, 300);
                break;
        }
    }

    /**
     * Checks if no toy is currently being dragged.
     * @return True if no toy is being dragged, otherwise false.
     */
    public boolean noToyIsDragging() {
        for (Drawable d : this.drawableObjects) {
            if (d instanceof Toy) {
                if (((Toy) d).isDragging()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Gets the count of Toy objects in the drawableObjects list.
     * @return The number of Toy objects.
     */
    public int getToyCount() {
        int count = 0;
        for (Drawable d : this.drawableObjects) {
            if (d instanceof Toy) {
                count++;
            }
        }
        return count;
    }
}
