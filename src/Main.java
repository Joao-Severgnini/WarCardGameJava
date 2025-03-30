import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Criação do deck principal
    Deck deck = new Deck();
    Scanner scanner = new Scanner(System.in);

    // Criação do player 1 e sua mão
    System.out.print("Nome do player 1: ");
    String name1 = scanner.nextLine();
    List<Card> hand1 = deck.getFirstHalf();
    // Utilização do contructor Player(name, hand)
    Player player1 = new Player(name1, hand1);

    // Criação do player 2 e sua mão
    System.out.print("Nome do player 2: ");
    String name2 = scanner.nextLine();
    List<Card> hand2 = deck.getSecondHalf();
    // Utilização do contructor Player(name, hand)
    Player player2 = new Player(name2, hand2);

    // Iniciar i cintador e a classe War
    int roundCount = 1;
    War war = new War();

    // Mostrar quantas cartas cada um tem no começo
    System.out.println("--------------------------------------------------");
    System.out.println("Cartas de " + player1.getName() + ": " + player1.getHandSize());
    System.out.println("Cartas de " + player2.getName() + ": " + player2.getHandSize());
    System.out.println("--------------------------------------------------");

    while (player1.hasCards() && player2.hasCards()) {

      // Puxar uma carta de cada jogador
      Card card1 = player1.drawCard();
      Card card2 = player2.drawCard();

      System.out.println("--------------------------------------------------");
      System.out.println("🎴 Rodada " + roundCount + ":");
      System.out.println(player1.getName() + " jogou: " + card1);
      System.out.println(player2.getName() + " jogou: " + card2);

      // Mecanica que lida com vitória e empate
      if (card1.getCard() > card2.getCard()) {
        System.out.println("✅ " + player1.getName() + " venceu esta rodada!");
        player1.addCard(card1);
        player1.addCard(card2);
      } else if (card1.getCard() < card2.getCard()) {
        System.out.println("✅ " + player2.getName() + " venceu esta rodada!");
        player2.addCard(card1);
        player2.addCard(card2);
      } else {

        // Lidar com o caso de empate
        System.out.println("⚔️ EMPATE! Começando a guerra...");
        List<Card> warCards1 = new LinkedList<>();
        List<Card> warCards2 = new LinkedList<>();

        // Adicionar as cartas em questão para a mecânica de War
        warCards1.add(card1);
        warCards2.add(card2);

        war.handleWar(player1, player2, warCards1, warCards2);
      }

      // Verificação para garantir que o número total de cartas é sempre 52
      int totalCards = player1.getHandSize() + player2.getHandSize();
      if (totalCards != 52) {
        System.out.println("ALERTA: O número total de cartas é " + totalCards + " (deveria ser 52)");
      }

      // Mostrar quantas cartas restam para cada jogador
      System.out.println("Cartas restantes -> " + player1.getName() + ": " + player1.getHandSize() +
          " | " + player2.getName() + ": " + player2.getHandSize());
      System.out.println("--------------------------------------------------");
      System.out.println("");

      roundCount++;

      // Fazer o Thread dormir por 0,1 sec para melhor visualização
      try {
        Thread.sleep(100);
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
