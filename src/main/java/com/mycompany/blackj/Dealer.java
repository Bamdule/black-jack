package com.mycompany.blackj;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MW
 */
public class Dealer implements Player {

	private String name = "Dealer";

	final private int CAN_RECEIVED_POINT = 16;

	private List<Card> cards;
	private Action action;

	public Dealer() {
		cards = new ArrayList<>();
	}

	@Override
	public void receiveCard(Card card) {
		if (canReceiveCard()) {
			this.cards.add(card);
		} else {
			System.out.println("당신의 점수는 " + getTotalCardPoint() + "점 입니다. 16점을 초과할 경우 드로우 할 수 없습니다.");
		}
	}

	private boolean canReceiveCard() {
		return getTotalCardPoint() <= CAN_RECEIVED_POINT;

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

	@Override
	public int getTotalCardPoint() {
		return cards.stream().mapToInt(card -> card.getPoint().getPoint()).sum();
	}

	@Override
	public void showCards() {
		cards.forEach(card -> System.out.println("pattern : " + card.getPattern().getText() + ",    point : " + card.getPoint().getText()));
	}

}
