package com.mycompany.blackj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author MW
 */
public class CardDeck {

	private List<Card> cards;
	private Stack<Card> shuffleCards;

	public CardDeck() {
		cards = new ArrayList<>();
		for (Card.Pattern pattern : Card.Pattern.values()) {
			for (Card.Point point : Card.Point.values()) {
				cards.add(new Card(pattern, point));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
		shuffleCards = new Stack<Card>();
		cards.forEach(card -> shuffleCards.add(card));
	}

	public Stack<Card> getShuffleCards() {
		return shuffleCards;
	}

	public Card draw() {

		return shuffleCards.isEmpty() ? null : shuffleCards.pop();
	}

	public void showCards() {
		shuffleCards.forEach(card -> System.out.println("pattern : " + card.getPattern().getText() + ",    point : " + card.getPoint().getText()));
		System.out.println("card count :  " + shuffleCards.size());
	}

}
