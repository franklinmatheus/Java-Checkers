/* Name: Move
 * Author: Devon McGrath
 * Description: This class represents a move.
 */

package model;

import java.awt.Point;

/**
 * The {@code Move} class represents a move and contains a weight associated
 * with the move.
 */
public class Move {
	
	/** The weight corresponding to an invalid move. */
	public static final double WEIGHT_INVALID = Double.NEGATIVE_INFINITY;

	/** The start index of the move. */
	private  /*@ spec_public @*/  byte startIndex;
	//@ public invariant 0 <= startIndex || startIndex == -1;
	
	/** The end index of the move. */
	private /*@ spec_public @*/   byte endIndex;
	//@ public invariant 0 <= endIndex || endIndex == -1;
	
	/** The weight associated with the move. */
	private  /*@ spec_public @*/  double weight;
	
	/*@ 
	  @ requires 0 <= startIndex && 0 <= endIndex;
	  @*/
	public Move(int startIndex, int endIndex) {
		setStartIndex(startIndex);
		setEndIndex(endIndex);
	}
	
	//Constructor
	public Move(Point start, Point end) {
		setStartIndex(Board.toIndex(start));
		setEndIndex(Board.toIndex(end));
	}
	
	public /*@ pure */ int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = (byte) startIndex;
	}
	
	public /*@ pure */ int getEndIndex() {
		return endIndex;
	}
	
	public void setEndIndex(int endIndex) {
		this.endIndex = (byte) endIndex;
	}
	
	public Point getStart() {
		return Board.toPoint(startIndex);
	}
	
	public void setStart(Point start) {
		setStartIndex(Board.toIndex(start));
	}
	
	public Point getEnd() {
		return Board.toPoint(endIndex);
	}
	
	public void setEnd(Point end) {
		setEndIndex(Board.toIndex(end));
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void changeWeight(double delta) {
		this.weight += delta;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "[startIndex=" + startIndex + ", "
				+ "endIndex=" + endIndex + ", weight=" + weight + "]";
	}
}
