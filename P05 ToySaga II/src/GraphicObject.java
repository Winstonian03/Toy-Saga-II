//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05 Toy Saga II - Graphic Object
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

import processing.core.PImage;

/**
 * This class helps build the interface by utilizing the following methods.
 */
public class GraphicObject extends Object implements Drawable {

  // The image associated with this graphic object
  protected PImage image;

  // Static reference to the ToySaga processing environment
  protected static ToySaga toySaga;

  // The x-coordinate of this graphic object
  protected int x;

  // The y-coordinate of this graphic object
  protected int y;

  /**
   * Constructor to initialize a GraphicObject with an image from a file.
   * The position is set to the center of the image.
   * @param filename The filename of the image to load.
   */
  GraphicObject(String filename) {
    this.image = toySaga.loadImage(filename);
    this.x = image.width / 2;
    this.y = image.height / 2;
  }

  /**
   * Constructor to initialize a GraphicObject with an image from a file
   * and a specific position.
   * @param filename The filename of the image to load.
   * @param x The initial x-coordinate of the GraphicObject.
   * @param y The initial y-coordinate of the GraphicObject.
   */
  GraphicObject(String filename, int x, int y) {
    this.image = toySaga.loadImage(filename);
    this.x = x;
    this.y = y;
  }

  /**
   * Overrides the draw method from the Drawable interface.
   * Draws the image at its current position on the ToySaga canvas.
   */
  @Override
  public void draw() {
    toySaga.image(this.image, this.x, this.y);
  }

  /**
   * Gets the current x-coordinate of the GraphicObject.
   * @return The x-coordinate.
   */
  public int getX() {
    return this.x;
  }

  /**
   * Gets the current y-coordinate of the GraphicObject.
   * @return The y-coordinate.
   */
  public int getY() {
    return this.y;
  }

  /**
   * Sets the image of the GraphicObject to a new image loaded from a file.
   * @param filename The filename of the new image.
   */
  public void setImage(String filename) {
    this.image = toySaga.loadImage(filename);
  }

  /**
   * Sets the ToySaga processing environment for all GraphicObject instances.
   * This static method allows all instances to share the same ToySaga environment.
   * @param processing The ToySaga processing environment to set.
   */
  public static void setProcessing(ToySaga processing) {
    GraphicObject.toySaga = processing;
  }
}
