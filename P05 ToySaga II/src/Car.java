//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05 Toy Saga II - Car
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
 * This is the car class and is responsible for creating the car objet.
 */
public class Car extends Toy {

    // Static variable to store the common speed for all Car instances
    private static int absoluteSpeed = 8;

    // Instance variable to store the direction of movement (true for rightward)
    private boolean isMovingRightward;

    // Instance variable to store the current speed of this Car instance
    private int speed;

    /**
     * Constructor to initialize a Car object with a specific position.
     * @param x The initial x-coordinate of the Car.
     * @param y The initial y-coordinate of the Car.
     */
    public Car(int x, int y) {
        super(ToySaga.CAR, x, y);
        this.speed = absoluteSpeed;
        this.isMovingRightward = true;
    }

    /**
     * Overrides the draw method to handle drawing differently in night mode.
     * Calls the appropriate drawing method based on the current mode.
     */
    @Override
    public void draw() {
        if (toySaga.isNightMode()) {
            move();
            drawCarNightMode();
        } else {
            super.draw();
        }
    }

    /**
     * Flips the movement direction of the Car.
     * If moving rightward, changes to leftward and vice versa.
     * Negates the speed to reflect the change in direction.
     */
    public void flipMoveDirection() {
        if (isMovingRightward) {
            isMovingRightward = false;
            this.speed = -this.speed;
        } else {
            isMovingRightward = true;
            this.speed = -this.speed;
        }
    }

    /**
     * Static method to get the common speed of all Car instances.
     * @return The current absolute speed.
     */
    public static int getSpeed() {
        return absoluteSpeed;
    }

    /**
     * Overrides the move method to handle movement differently in night mode.
     * Updates the Car's position and changes direction if it hits the screen edges.
     */
    @Override
    public void move() {
        if (toySaga.isNightMode()) {
            if (isOver(toySaga.width, this.y) || isOver(0, this.y)) {
                flipMoveDirection();
            }
            this.x += this.speed;
        } else {
            super.move();
        }
    }

    /**
     * Static method to set the common speed for all Car instances.
     * @param speed The new speed to be set.
     */
    public static void setSpeed(int speed) {
        absoluteSpeed = speed;
    }

    /**
     * Draws the Car in night mode with specific transformations.
     * Prepares the drawing environment and applies necessary transformations
     * before drawing the Car image.
     */
    private void drawCarNightMode() {
        toySaga.pushMatrix();
        toySaga.rotate(0.0f);
        toySaga.translate(x, y);
        if (!isMovingRightward) {
            toySaga.scale(-1.0f, 1.0f);
        }
        toySaga.image(image, 0.0f, 0.0f);
        toySaga.popMatrix();
    }
}