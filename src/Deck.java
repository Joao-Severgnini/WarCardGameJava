import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Deck {
  // Criação do arraylist deck
  private ArrayList<Card> deck;

  // Chamado para asignmet
  public Deck() {
    deck = new ArrayList<>();

    for (int i = 0; i < 4; i++) { // 0-3 Iterar pelas suits (4 suits)
      for (int j = 2; j < 15; j++) { // 2-14 Iterar sobre os ranks (13 ranks)
        deck.add(new Card(j, i));
      }
    }

    // Embaralhar o deck
    Collections.shuffle(deck, new Random());
  }

  // Criamos novas listas para as metades de cada jogador
  // Cada player recebe uma sublist do deck
  public List<Card> getFirstHalf() {
    return new LinkedList<>(deck.subList(0, 26));
  }

  public List<Card> getSecondHalf() {
    return new LinkedList<>(deck.subList(26, 52));

  }
}
