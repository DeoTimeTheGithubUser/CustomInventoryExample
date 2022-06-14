import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftInventoryCustom;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

// The base class for all CustomInventories
public abstract class CustomInventory extends CraftInventoryCustom {

    // Called when the inventory is created, and adds it to the CustomInventoryManager
    public CustomInventory(String name, int size) {
        super(null, validateSize(size), name);
        CustomInventoryManager.getCustomInventoryManager().addCustomInventory(this);
    }

    // Optional methods to implement to give the custom inventory functionality
    void onOpen(InventoryOpenEvent event){}
    void onClose(InventoryCloseEvent event){}
    void onClick(InventoryClickEvent event){}
    void onDrag(InventoryDragEvent event){}

    // Validate that the inventory is a valid size
    private static int validateSize(int size) {
        if(size % 9 != 0) throw new IllegalArgumentException("Inventory size must be a multiple of 9.");
        return size;
    }



}
