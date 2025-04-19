public class Card {
  private int rank; // initialize rank (2, 3, 4... King, Ace)
  private int suit; // initialize suit (Spades, Hearts, Clubs, Diamonds)

  // Constructor
  public Card(int rank, int suit) {
    this.rank = rank;
    this.suit = suit;
  }

  // Getter methods
  public int getCard() {
    return rank;
  }

  public int getSuit() {
    return suit;
  }

  // Setter method
  public void setCard(int rank) {
    this.rank = rank;
  }

  @Override
  public String toString() {
    // combine rank and suit into a single string, e.g., (3 of Hearts)

    // StringBuilder to modify later
    StringBuilder displayCards = new StringBuilder();

    switch (rank) {
      // since rank is declared as int, we combine it with its respective name
      case 11:
        displayCards.append("Jack");
        break;
      case 12:
        displayCards.append("Queen");
        break;
      case 13:
        displayCards.append("King");
        break;
      case 14:
        displayCards.append("Ace");
        break;
      default:
        displayCards.append(rank);
        break;
    }

    displayCards.append(" of ");

    switch (suit) {
      // also combine the suits
      case 0:
        displayCards.append("Spades");
        break;
      case 1:
        displayCards.append("Hearts");
        break;
      case 2:
        displayCards.append("Clubs");
        break;
      case 3:
        displayCards.append("Diamonds");
        break;
    }
    return displayCards.toString();
  }
}
