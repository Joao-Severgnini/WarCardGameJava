public class Card {
  private int rank; // iniciar rank (2, 3, 4... KIng, Ace)
  private int suit; // iniciar naipe (Espadas, Paus, Copas, Ouro)

  // contructor
  public Card(int rank, int suit) {
    this.rank = rank;
    this.suit = suit;
  }

  // getter method
  public int getCard() {
    return rank;
  }

  public int getSuit() {
    return suit;
  }

  // setter method
  public void setCard(int rank) {
    this.rank = rank;
  }

  @Override
  public String toString() {
    // combinar rank e naipe em uma string só (3 de copas)

    // StringBuilder para modificar depois
    StringBuilder displayCards = new StringBuilder();

    switch (rank) {
      // ja que rank foi declarado como int combinamos com seu respectivo numero
      case 11: displayCards.append("Valete"); break;
      case 12: displayCards.append("Dama"); break;
      case 13: displayCards.append("Rei"); break;
      case 14: displayCards.append("Ás"); break;
      default: displayCards.append(rank); break;
    }

    displayCards.append(" de ");

    switch (suit) {
      case 0: displayCards.append("Espadas"); break;
      case 1: displayCards.append("Copas"); break;
      case 2: displayCards.append("Paus"); break;
      case 3: displayCards.append("Ouro"); break;
    }
    return displayCards.toString();
  }
}
