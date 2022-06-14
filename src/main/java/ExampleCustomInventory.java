import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

// Example class for the CustomInventory
public class ExampleCustomInventory extends CustomInventory {

    private static final String NAME = "Example";
    private static final int SIZE = 54;

    public ExampleCustomInventory() {
        super(NAME, SIZE);
    }

    @Override
    void onOpen(InventoryOpenEvent event) {
        event.getPlayer().sendMessage("You opened the inventory!");
    }

    @Override
    void onClose(InventoryCloseEvent event) {
        event.getPlayer().sendMessage("You closed the inventory!");
    }

    @Override
    void onClick(InventoryClickEvent event) {
        event.getWhoClicked().sendMessage("You clicked on the inventory!");
    }

    @Override
    void onDrag(InventoryDragEvent event) {
        event.getWhoClicked().sendMessage("You dragged on the inventory!");
    }
}
