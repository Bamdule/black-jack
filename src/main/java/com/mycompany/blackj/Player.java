package com.mycompany.blackj;

/**
 *
 * @author MW
 */
public interface Player {

	//카드 받기
	void receiveCard(Card card);
	
	//총 카드 점수 반환
	int getTotalCardPoint();

	//액션 반환
	public Action getAction();

	//액션 저장
	public void setAction(Action action);

	//이름 반환
	public String getName();

	public void showCards();

	public enum Action {
		hit,
		stand;
	}
}
