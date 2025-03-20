import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Deck deck = new Deck();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Nome do player 1: ");
    String name1 = scanner.nextLine();
    List<Card> hand1 = deck.getFirstHalf();
    Player player1 = new Player(name1, hand1);

    System.out.print("Nome do player 2: ");
    String name2 = scanner.nextLine();
    List<Card> hand2 = deck.getSecondHalf();
    Player player2 = new Player(name2, hand2);

    int roundCount = 1;
    War war = new War();

    while (player1.hasCards() && player2.hasCards()) {
      Card card1 = player1.drawCard();
      Card card2 = player2.drawCard();

      System.out.println("--------------------------------------------------");
      System.out.println("🎴 Rodada " + roundCount + ":");
      System.out.println(player1.getName() + " jogou: " + card1);
      System.out.println(player2.getName() + " jogou: " + card2);

      if (card1.getCard() > card2.getCard()) {
        System.out.println("✅ " + player1.getName() + " venceu esta rodada!");
        player1.addCard(card1);
        player1.addCard(card2);
      } else if (card1.getCard() < card2.getCard()) {
        System.out.println("✅ " + player2.getName() + " venceu esta rodada!");
        player2.addCard(card1);
        player2.addCard(card2);
      } else {
        System.out.println("⚔️ EMPATE! Começando a guerra...");
        List<Card> warCards1 = new LinkedList<>();
        List<Card> warCards2 = new LinkedList<>();

        warCards1.add(card1);
        warCards2.add(card2);

        war.handleWar(player1, player2, warCards1, warCards2);
      }

      // Verificação para garantir que o número total de cartas é sempre 52
      int totalCards = player1.getHandSize() + player2.getHandSize();
      if (totalCards != 52) {
        System.out.println("ALERTA: O número total de cartas é " + totalCards + " (deveria ser 52)");
      }

      System.out.println("Cartas restantes -> " + player1.getName() + ": " + player1.getHandSize() +
          " | " + player2.getName() + ": " + player2.getHandSize());
      System.out.println("--------------------------------------------------");

      roundCount++;
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    // Anunciar o vencedor
    if (player1.hasCards()) {
      System.out.println("🏆 " + player1.getName() + " venceu o jogo!");
    } else {
      System.out.println("🏆 " + player2.getName() + " venceu o jogo!");
    }

    scanner.close();
  }
}
