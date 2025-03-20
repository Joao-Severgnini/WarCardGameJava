import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Player {
  private String name;
  private List<Card> hand;

  public Player(String name, List<Card> hand) {
    this.name = name;
    this.hand = hand;
  }

  public String getName() {
    return name;
  }

  public Card drawCard() {
    if (hand.isEmpty()) {
      return null; // Retorna null se não houver cartas
    }
    return hand.remove(0); // Remove e retorna a primeira carta da mão
  }

  public void addCard(Card card) {
    int position = new Random().nextInt(hand.size() + 1);
    hand.add(position, card);
  }

  public void addCards(List<Card> cards) {
    List<Card> cardsCopy = new LinkedList<>(cards);
    Collections.shuffle(cardsCopy);
    hand.addAll(cardsCopy);
  }

  public int getHandSize() {
    return hand.size();
  }

  public boolean hasCards() {
    return !hand.isEmpty();
  }
}
