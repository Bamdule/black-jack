package test;

import com.mycompany.blackj.CardDeck;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author MW
 */
public class ApplicationTest {

	@Test
	public void test_카드덱생성() {

		CardDeck cardDeck = new CardDeck();
		cardDeck.shuffle();
		cardDeck.showCards();

	}

}
