//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05 Toy Saga II - Teddy Bear
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

import processing.core.PApplet;

/**
 * This is the teddy bear class and is responsible for creating the teddy bear objet.
 */
public class TeddyBear extends Toy {
    // Callout for displaying additional image or text
    private Callout callout;

    // Current rotation of the TeddyBear
    private float rotation;

    // Direction of the rotation (true for clockwise, false for counter-clockwise)
    private boolean rotationDirection;

    /**
     * Constructor to initialize a TeddyBear object with a position.
     * @param x The initial x-coordinate of the TeddyBear.
     * @param y The initial y-coordinate of the TeddyBear.
     */
    public TeddyBear(int x, int y) {
        super(ToySaga.BEAR, x, y);
        this.rotation = 0;
        this.rotationDirection = true;
        this.callout = new Callout(x, y);
    }

    /**
     * Gets the current rotation of the TeddyBear.
     * @return The current rotation in radians.
     */
    public float getRotation() {
        return this.rotation;
    }

    /**
     * Sets the rotation of the TeddyBear.
     * @param rotation The rotation in radians.
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * Sets the direction of the rotation.
     * @param direction True for clockwise, false for counter-clockwise.
     */
    public void setRotationDirection(boolean direction) {
        this.rotationDirection = direction;
    }

    /**
     * Gets the direction of the rotation.
     * @return True if the rotation is clockwise, otherwise false.
     */
    public boolean getRotationDirection() {
        return this.rotationDirection;
    }

    /**
     * Overrides the draw method from the Toy class.
     * Draws the TeddyBear differently depending on the mode (DAY or NIGHT).
     */
    @Override
    public void draw() {
        if (toySaga.isNightMode()) {
            drawTeddyBearNightMode();
        } else {
            super.draw();
        }
    }

    /**
     * Draws the TeddyBear in night mode with rotation and a callout.
     */
    private void drawTeddyBearNightMode() {
        move();
        toySaga.pushMatrix();
        toySaga.translate(x, y);
        toySaga.rotate(rotation * PApplet.PI / 2);
        if (toySaga.getMode().equals("NIGHT")) {
            toySaga.image(callout.image, 20f, -90f);
        }
        toySaga.image(image, 0.0f, 0.0f);
        toySaga.popMatrix();
    }

    /**
     * Overrides the move method from the Toy class.
     * Rotates the TeddyBear back and forth in night mode.
     */
    @Override
    public void move() {
        if (toySaga.isNightMode()) {
            if (getRotation() >= PApplet.radians(30)) {
                setRotationDirection(false);
            } else if (getRotation() <= PApplet.radians(-30)) {
                setRotationDirection(true);
            }
            if (getRotationDirection()) {
                setRotation(getRotation() + PApplet.radians(3));
            } else {
                setRotation(getRotation() - PApplet.radians(3));
            }
        } else {
            super.move();
        }
    }
}
