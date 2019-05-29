

class Game2 {

  private Player player;

  private List<String> opponents;

  public Game(Player player, List<String> opponents) {
    this.player = player;
    this.opponents = opponents;
  }

  public int numberOfEnemies() {
    return opponents.size();
  }

  // ...

}