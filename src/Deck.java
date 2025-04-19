import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Deck {
  // Creation of the deck ArrayList
  private ArrayList<Card> deck;

  // Constructor for initialization
  public Deck() {
    deck = new ArrayList<>();

    for (int i = 0; i < 4; i++) { // 0-3 Iterate through the suits (4 suits)
      for (int j = 2; j < 15; j++) { // 2-14 Iterate through the ranks (13 ranks)
        deck.add(new Card(j, i));
      }
    }

    // Shuffle the deck
    Collections.shuffle(deck, new Random());
  }

  // Create new lists for each player's half of the deck
  // Each player receives a sublist from the deck
  public List<Card> getFirstHalf() {
    return new LinkedList<>(deck.subList(0, 26));
  }

  public List<Card> getSecondHalf() {
    return new LinkedList<>(deck.subList(26, 52));
  }
}
