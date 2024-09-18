//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05 Toy Saga II - Toy
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
 * This class runs methods that help modify objects.
 */
public class Toy extends GraphicObject implements MouseListener, Movable {

    // Indicates whether the Toy is currently being dragged
    private boolean isDragging;

    /**
     * Constructor to initialize a Toy object with an image from a file.
     * The position is set to the center of the image.
     * @param filename The filename of the image to load.
     */
    public Toy(String filename) {
        super(filename);
    }

    /**
     * Constructor to initialize a Toy object with an image from a file
     * and a specific position.
     * @param filename The filename of the image to load.
     * @param x The initial x-coordinate of the Toy.
     * @param y The initial y-coordinate of the Toy.
     */
    public Toy(String filename, int x, int y) {
        super(filename, x, y);
    }

    /**
     * Overrides the draw method from the GraphicObject class.
     * Moves the Toy if it is being dragged, then draws the Toy.
     */
    @Override
    public void draw() {
        move();
        super.draw();
    }

    /**
     * Checks if the Toy is currently being dragged.
     * @return True if the Toy is being dragged, otherwise false.
     */
    public boolean isDragging() {
        return this.isDragging;
    }

    /**
     * Starts dragging the Toy.
     */
    public void startDragging() {
        this.isDragging = true;
    }

    /**
     * Stops dragging the Toy.
     */
    public void stopDragging() {
        this.isDragging = false;
    }

    /**
     * Moves the Toy by a specified amount, ensuring it stays within bounds.
     * @param dx The amount to move along the x-axis.
     * @param dy The amount to move along the y-axis.
     */
    protected void move(int dx, int dy) {
        int newX = this.x + dx;
        int newY = this.y + dy;
        if (newX >= 0 && newX <= 800 && newY >= 0 && newY <= 600) {
            this.x = newX;
            this.y = newY;
        }
    }

    /**
     * Overrides the move method from the Movable interface.
     * Moves the Toy if it is being dragged by calculating the distance
     * moved since the last frame.
     */
    @Override
    public void move() {
        if (isDragging) {
            int dx = toySaga.mouseX - toySaga.pmouseX;
            int dy = toySaga.mouseY - toySaga.pmouseY;
            move(dx, dy);
        }
    }

    /**
     * Checks if a point (x, y) is within the bounds of the Toy's image.
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     * @return True if the point is over the Toy, otherwise false.
     */
    public boolean isOver(int x, int y) {
        return x >= getX() - image.width / 2
                && x <= getX() + image.width / 2
                && y >= getY() - image.height / 2
                && y <= getY() + image.height / 2;
    }

    /**
     * Handles the mouse click event.
     * Starts dragging the Toy if no other Toy is being dragged and
     * the mouse is over this Toy.
     */
    @Override
    public void onClick() {
        if (toySaga.noToyIsDragging() && isMouseOver()) {
            startDragging();
        }
    }

    /**
     * Handles the mouse release event.
     * Stops dragging the Toy.
     */
    @Override
    public void onRelease() {
        stopDragging();
    }

    /**
     * Checks if the mouse is currently over the Toy.
     * @return True if the mouse is over the Toy, otherwise false.
     */
    public boolean isMouseOver() {
        return isOver(toySaga.mouseX, toySaga.mouseY);
    }
}
