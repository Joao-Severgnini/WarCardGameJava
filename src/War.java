
import java.util.LinkedList;
import java.util.List;

public class War {
  public void handleWar(Player player1, Player player2, List<Card> wars1, List<Card> wars2) {
    // Se algum player nao for elegível
    if (player1.getHandSize() < 4) {
      System.out.println(player1.getName() + " não tem cartas suficientes! " + player2.getName() + " vence a guerra!");
      player2.addCards(wars1);
      player2.addCards(wars2);
      return;
    } else if (player2.getHandSize() < 4) {
      System.out.println(player2.getName() + " não tem cartas suficientes! " + player1.getName() + " vence a guerra!");
      player1.addCards(wars1);
      player1.addCards(wars2);
      return;
    }

    // Adiciona as 3 cartas
    for (int i = 0; i < 3; i++) {
      wars1.add(player1.drawCard());
      wars2.add(player2.drawCard());
    }

    // Antes de sacar a última carta, verifica se os jogadores ainda têm cartas**
    if (!player1.hasCards()) {
      System.out.println(player1.getName() + " ficou sem cartas! " + player2.getName() + " vence a guerra!");
      player2.addCards(wars1);
      player2.addCards(wars2);
      wars1.clear();
      wars2.clear();
      return;
    } else if (!player2.hasCards()) {
      System.out.println(player2.getName() + " ficou sem cartas! " + player1.getName() + " vence a guerra!");
      player1.addCards(wars1);
      player1.addCards(wars2);
      wars1.clear();
      wars2.clear();

      return;
    }

    // Saca a carta decisiva de cada um
    Card warCard1 = player1.drawCard();
    Card warCard2 = player2.drawCard();

    // Adiciona a carta na guerra para ser coletada pelo vencedor
    wars1.add(warCard1);
    wars2.add(warCard2);

    System.out.println("⚔\uFE0F Guerra: ");
    System.out.println(player1.getName() + " jogou: " + warCard1);
    System.out.println(player2.getName() + " jogou: " + warCard2);

    // Cria uma lista lincada unica para todas as cartas da guerra
    List<Card> allWarCards = new LinkedList<>();
    allWarCards.addAll(wars1);
    allWarCards.addAll(wars2);

    if (warCard1.getCard() > warCard2.getCard()) {
      System.out.println("🏆 " + player1.getName() + " venceu a guerra!");
      player1.addCards(allWarCards);
      wars1.clear();
      wars2.clear();

    } else if (warCard1.getCard() < warCard2.getCard()) {
      System.out.println("🏆 " + player2.getName() + " venceu a guerra!");
      player2.addCards(allWarCards);
      wars1.clear();
      wars2.clear();

    } else {
      System.out.println("⚔️ Empate na guerra! Continuando a guerra...");
      // Não adicione as cartas novamente aqui, elas já estão em wars1 e wars2
      handleWar(player1, player2, wars1, wars2);
    }
  }
}
