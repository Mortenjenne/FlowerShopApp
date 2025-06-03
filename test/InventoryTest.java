import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    void testGetFlowerByInvalidIndex() {
        Flower flower = inventory.getFlowerByIndex(-1);
        assertNull(flower);

        flower = inventory.getFlowerByIndex(11);
        assertNull(flower);
    }
}