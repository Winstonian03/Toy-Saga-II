//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05 Toy Saga II - Hover Ball
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

/**
 * This is the hover ball class and is responsible for creating the hover ball objet.
 */
import processing.core.PApplet;
import java.io.File;

public class Hoverball extends Toy {

    /**
     * Constructor to initialize a Hoverball object with a specific position.
     * @param x The initial x-coordinate of the Hoverball.
     * @param y The initial y-coordinate of the Hoverball.
     */
    Hoverball(int x, int y) {
        super(ToySaga.HOVERBALL_OFF, x, y);
    }

    /**
     * Overrides the draw method to switch the Hoverball's image based on the mode
     * and then draw the Hoverball.
     */
    @Override
    public void draw() {
        this.switchOnOff();
        super.draw();
    }

    /**
     * Overrides the move method to add a floating effect when in night mode.
     * If in night mode, the Hoverball moves vertically in a sinusoidal pattern.
     * Otherwise, it moves according to the superclass's move method.
     */
    @Override
    public void move() {
        if (toySaga.isNightMode()) {
            System.out.println("eree");
            int dy = Math.round(6 * PApplet.sin(toySaga.frameCount * 0.1f));
            super.move(0, dy);
        } else {
            super.move();
        }
    }

    /**
     * Switches the Hoverball's image based on the current mode.
     * If in night mode, sets the image to the "on" state.
     * Otherwise, sets the image to the "off" state.
     */
    private void switchOnOff() {
        if (toySaga.isNightMode()) {
            System.out.println("Afef");
            setImage(toySaga.HOVERBALL_ON);
        } else {
            setImage(toySaga.HOVERBALL_OFF);
        }
    }
}