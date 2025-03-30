
import java.util.LinkedList;
import java.util.List;

public class War {
  public void handleWar(Player player1, Player player2, List<Card> warCards1, List<Card> warCards2) {

    // Verificar se algum player não é elegível para a Guerra
    if (player1.getHandSize() < 4) {
      System.out.println(player1.getName() + " não tem cartas suficientes! " + player2.getName() + " vence a guerra!");
      player2.addCards(warCards1);
      player2.addCards(warCards2);
      return;
    } else if (player2.getHandSize() < 4) {
      System.out.println(player2.getName() + " não tem cartas suficientes! " + player1.getName() + " vence a guerra!");
      player1.addCards(warCards1);
      player1.addCards(warCards2);
      return;
    }

    // Adiciona as 3 cartas de cada jogador
    for (int i = 0; i < 3; i++) {
      warCards1.add(player1.drawCard());
      warCards2.add(player2.drawCard());
    }

    // Saca a carta decisiva de cada jogador
    Card warCard1 = player1.drawCard();
    Card warCard2 = player2.drawCard();

    // Adiciona a carta na guerra para ser coletada pelo vencedor
    warCards1.add(warCard1);
    warCards2.add(warCard2);

    System.out.println("⚔\uFE0F Guerra: ");
    System.out.println(player1.getName() + " jogou: " + warCard1);
    System.out.println(player2.getName() + " jogou: " + warCard2);

    // Cria LinkedList unica para todas as cartas da guerra
    List<Card> allWarCards = new LinkedList<>();
    allWarCards.addAll(warCards1);
    allWarCards.addAll(warCards2);

    // Exibir o vencedor da Guerra com base na carta decisíva e
    // Atribuir todas as cartas envolvidas na Guerra para esse jogador
    if (warCard1.getCard() > warCard2.getCard()) {
      System.out.println("🏆 " + player1.getName() + " venceu a guerra!");
      player1.addCards(allWarCards);
      warCards1.clear();
      warCards2.clear();

    } else if (warCard1.getCard() < warCard2.getCard()) {
      System.out.println("🏆 " + player2.getName() + " venceu a guerra!");
      player2.addCards(allWarCards);
      warCards1.clear();
      warCards2.clear();

    } else {
      System.out.println("⚔️ Empate na guerra! Continuando a guerra...");
      // Não adicione as cartas novamente aqui, elas já estão em warCards1 e warCards2
      handleWar(player1, player2, warCards1, warCards2);
    }
  }
}
