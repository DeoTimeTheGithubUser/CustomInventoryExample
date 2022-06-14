import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

// Singleton class for managing CustomInventories
public class CustomInventoryManager implements Listener {

    private static CustomInventoryManager instance;

    CustomInventoryManager() {
        instance = this;
    }

    public static CustomInventoryManager getCustomInventoryManager() {
        return instance;
    }

    // Set used to keep track of all created CustomInventories
    private final Set<CustomInventory> CUSTOM_INVENTORIES = new HashSet<>();

    // Methods that listen for when an InventoryEvent happens, checks
    // if the Inventory is a Custom one, and if so triggers the corresponding method.
    @EventHandler
    private void onInventoryOpen(InventoryOpenEvent event) {
        final CustomInventory customInventory = findCustomInventory(event.getInventory());
        if(customInventory != null) customInventory.onOpen(event);
    }

    @EventHandler
    private void onInventoryClose(InventoryCloseEvent event) {
        final CustomInventory customInventory = findCustomInventory(event.getInventory());
        if(customInventory != null) customInventory.onClose(event);
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        final CustomInventory customInventory = findCustomInventory(event.getClickedInventory());
        if(customInventory != null) customInventory.onClick(event);
    }

    @EventHandler
    private void onInventoryDrag(InventoryDragEvent event) {
        final CustomInventory customInventory = findCustomInventory(event.getInventory());
        if(customInventory != null) customInventory.onDrag(event);
    }

    public void addCustomInventory(CustomInventory customInventory) {
        this.CUSTOM_INVENTORIES.add(customInventory);
    }

    // Finds a CustomInventory given a normal Inventory
    private CustomInventory findCustomInventory(Inventory inventory) {
        if(!(inventory instanceof CustomInventory)) return null;
        return this.CUSTOM_INVENTORIES
                .stream()
                .filter(custom -> custom.equals(inventory))
                .findFirst()
                .orElse(null);
    }
}
