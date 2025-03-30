import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Player {
  // Cada jogador tem um nome e sua metade do baralho (hand)
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

  // Adiciona uma carta só ao seu baralho / hand, aleatóriamente
  public void addCard(Card card) {
    /*
     * Criar uma variavel de posição alearória que vai apontar para onde a carta
     * deve ir utilizando a função Random.nextInt que gera uma posição
     * baseando se em uma aleatório que eteja na banda de hand.size+1
     */
    int position = new Random().nextInt(hand.size() + 1);
    hand.add(position, card);
  }

  // Adiciona 2 ou mais cartas ao seu baralho / hand, aleatóriamente
  public void addCards(List<Card> cards) {
    List<Card> cardsCopy = new LinkedList<>(cards);
    // Importante retornar aleatóriamente para nao acontecer de o jogo ficar em loop
    Collections.shuffle(cardsCopy);
    // E usamos o .addAll() para adicionar mais de um elemento ao fim da lista
    hand.addAll(cardsCopy);
  }

  // Verificação de existecia de cartas
  public boolean hasCards() {
    return !hand.isEmpty();
  }
}
