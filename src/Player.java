import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Player {
  private String name;
  private List<Card> hand;

  // Constructor
  public Player(String name, List<Card> hand) {
    this.name = name;
    this.hand = hand;
  }

  // Getter methods
  public String getName() {
    return name;
  }

  public int getHandSize() {
    return hand.size();
  }

  // Implementação de comprar uma carta
  public Card drawCard() {
    if (hand.isEmpty()) {
      return null; // Retorna null se não houver cartas
    }
    return hand.remove(0); // Remove e retorna a primeira carta da mão
  }

  // Adiciona uma carta só ao seu baralho / hand
  public void addCard(Card card) {
    int position = new Random().nextInt(hand.size() + 1);
    hand.add(position, card);
  }

  // Adiciona 2 ou mais cartas ao seu baralho / hand
  public void addCards(List<Card> cards) {
    List<Card> cardsCopy = new LinkedList<>(cards);
    // Importante retornar aleatóriamente para nao acontecer de o jogo ficar em loop
    Collections.shuffle(cardsCopy);
    hand.addAll(cardsCopy);
  }

  // Verificação de existecia de cartas
  public boolean hasCards() {
    return !hand.isEmpty();
  }
}
