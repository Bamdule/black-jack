package com.mycompany.blackj;

/**
 *
 * @author MW
 */
public class Card {

	private Pattern pattern;
	private Point point;

	public Card(Pattern pattern, Point point) {
		this.pattern = pattern;
		this.point = point;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public enum Pattern {
		SPADE("spade"),
		HEART("heart"),
		DIAMOND("diamond"),
		CLUB("club");

		private String text;

		private Pattern(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

	}

	public enum Point {
		ACE("A", 1),
		TWO("2", 2),
		THREE("3", 3),
		FOUR("4", 4),
		FIVE("5", 5),
		SIX("6", 6),
		SEVEN("7", 7),
		EIGHT("8", 8),
		NINE("9", 9),
		TEN("10", 10),
		J("J", 10),
		Q("Q", 10),
		K("K", 10);

		private String text;
		private int point;

		private Point(String text, int point) {
			this.text = text;
			this.point = point;
		}

		public String getText() {
			return text;
		}

		public int getPoint() {
			return point;
		}

	}

	@Override
	public String toString() {
		return "Card{" + "pattern=" + pattern + ", point=" + point.getText() + '}';
	}
}
