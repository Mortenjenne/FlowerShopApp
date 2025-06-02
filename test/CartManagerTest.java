import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {
    private CartManager cartManager;
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        cartManager = new CartManager();
        inventory = new Inventory();
    }

    @Test
    void testAddFlowerToShoppingCart() {
        Flower flower = inventory.getFlowerByIndex(4);
        cartManager.addToShoppingCart(flower);

        assertEquals(1, cartManager.getShoppingCart().size());
    }

    @Test
    void testUserWantsBouquet() {
        cartManager.addBouquet();

        assertTrue(cartManager.getUserWantsFlowerBouquet());
        assertEquals(50.0, cartManager.getTotal());
    }

    @Test
    void testTotalAddsUp() {
        Flower flower1 = new Flower("Raunkle", 58.50);
        Flower flower2 = new Flower("Nellike", 48.75);
        Flower flower3 = new Flower("Pæon", 75.50);

        cartManager.addToShoppingCart(flower1);
        cartManager.addToShoppingCart(flower2);
        cartManager.addToShoppingCart(flower3);

        double expected = 58.50 + 48.75 + 75.50;

        assertEquals(expected, cartManager.getTotal());
    }


    @Test
    void testResetCartClearsEverything() {
        Flower flower = new Flower("Tulipan", 30.0);
        cartManager.addToShoppingCart(flower);
        cartManager.addBouquet();

        assertTrue(cartManager.getShoppingCart().size() > 0);
        assertTrue(cartManager.getUserWantsFlowerBouquet());

        cartManager.clearCart();

        assertEquals(0, cartManager.getShoppingCart().size());
        assertFalse(cartManager.getUserWantsFlowerBouquet());
        assertEquals(0.0, cartManager.getTotal());
    }
}