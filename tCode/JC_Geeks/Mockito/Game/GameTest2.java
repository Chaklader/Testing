


@RunWith(MockitoJUnitRunner.class)
public class GameTest {

  @Mock Player player;

  @Spy List<String> enemies = new ArrayList<>();

  @InjectMocks Game game;

  @Test public void attackWithSwordTest() throws Exception {
    Mockito.when(player.getWeapon()).thenReturn("Sword");

    enemies.add("Dragon");
    enemies.add("Orc");

    assertEquals(2, game.numberOfEnemies());

    assertEquals("Player attack with: Sword", game.attack());
  }
  
}
