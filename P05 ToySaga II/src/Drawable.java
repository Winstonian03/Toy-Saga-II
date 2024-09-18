//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05 Toy Saga II - Drawable
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
 * An interface representing drawable objects.
 * Any class implementing this interface should provide an implementation of the draw method.
 */
public interface Drawable {

  /**
   * Draws the object on the screen.
   */
  public void draw();
}