package com.mycompany.blackj;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MW
 */
public class Gamer implements Player {

	private String name;
	private List<Card> cards;
	private Action action;

	public Gamer(String name) {
		this.name = name;
		cards = new ArrayList<>();
	}

	@Override
	public void receiveCard(Card card) {
		this.cards.add(card);
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getTotalCardPoint() {
		return cards.stream().mapToInt(card -> card.getPoint().getPoint()).sum();
	}

	@Override
	public void showCards() {
		cards.forEach(card -> System.out.println("pattern : " + card.getPattern().getText() + ",    point : " + card.getPoint().getText()));
	}
}
