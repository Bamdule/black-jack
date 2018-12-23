package com.mycompany.blackj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MW
 */
public class GameRule {

	private CardDeck cardDeck = new CardDeck();
	private final int INIT_DRAW_CARD_CNT = 2;
	private final int BLACK_JACK_POINT = 21;

	private Scanner scanner = new Scanner(System.in);

	public void play() {

		cardDeck.shuffle();

		List<Player> players = new ArrayList<>(Arrays.asList(new Gamer("player1"), new Dealer()));

		initDrawCard(players);

		players.forEach(play -> {
			System.out.println("======== " + play.getName() + " ========");
			play.showCards();
		});

		drawAdditionalCard(players);

		showResult(players);
	}

	private void drawAdditionalCard(List<Player> players) {

		System.out.println("hit 또는 stand를 입력해주세요.");
		players.forEach(player -> {

			System.out.println(player.getName() + " 님 차례입니다.");
			while (true) {
				Player.Action action = Player.Action.valueOf(scanner.nextLine().toLowerCase());

				if (Player.Action.hit.equals(action)) {
					player.receiveCard(cardDeck.draw());
					player.showCards();
				} else if (Player.Action.stand.equals(action)) {
					break;
				} else {

				}
				if (checkBurst(player)) {
					return;
				}
			}

		});

	}

	private boolean checkBurst(Player player) {
		return player.getTotalCardPoint() > BLACK_JACK_POINT;
	}

	private void showResult(List<Player> players) {
		List<Player> winners = getWinner(players);

		if (winners.size() == 1) {
			System.out.println("======== Game Winner ========");
			System.out.println(winners.get(0).getName());
			System.out.println(winners.get(0).getTotalCardPoint());
		} else {
			System.out.println("======== Game Draw ========");
			winners.forEach(player -> {
				System.out.println(player.getName());
				System.out.println(player.getTotalCardPoint());
			});
		}
	}

	private List<Player> getWinner(List<Player> players) {
		int highestPoint = 0;
		int playerPoint = 0;
		List<Player> winners = new ArrayList<>();

		for (Player player : players) {
			if (checkBurst(player)) {
				continue;
			}
			playerPoint = player.getTotalCardPoint();
			if (playerPoint > highestPoint) {
				highestPoint = playerPoint;
				winners.clear();

				winners.add(player);
			} else if (playerPoint == highestPoint) {
				winners.add(player);
			}
		}

		return winners;
	}

	private void initDrawCard(List<Player> players) {
		for (int cnt = 0; cnt < INIT_DRAW_CARD_CNT; cnt++) {
			players.forEach(player -> player.receiveCard(cardDeck.draw()));
		}
	}

}
