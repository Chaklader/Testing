

@RunWith(MockitoJUnitRunner.class)
class GameTest {

    @Mock
    Player player;

    @InjectMocks
    Game game;

    @Test
    public void attackWithSwordTest() throws Exception {
        Mockito.when(player.getWeapon()).thenReturn("Sword");

        assertEquals("Player attack with: Sword", game.attack());
    }

}