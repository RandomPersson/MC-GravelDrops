package pl.org.mensa.rp.mc.GravelDrops;

import java.util.List;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {
	private static Random random = new Random();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockDropItem(BlockDropItemEvent e) {
		if (e.getBlockState().getType() == Material.GRAVEL && (e.getPlayer().getGameMode() == GameMode.SURVIVAL || e.getPlayer().getGameMode() == GameMode.ADVENTURE)) {
			if (!e.getItems().isEmpty()) {
				e.getItems().get(0).setItemStack(new ItemStack(random.nextDouble() < 0.05D ? Material.FLINT : Material.GRAVEL, 1));
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onItemSpawn(ItemSpawnEvent e) {
		if (e.getEntity().getItemStack().getType() == Material.GRAVEL || e.getEntity().getItemStack().getType() == Material.FLINT) {
			List<Entity> entities = e.getEntity().getNearbyEntities(0.1D, 0.1D, 0.1D);
			
			for (Entity entity : entities) {
				if (entity.getType() == EntityType.FALLING_BLOCK) {
					if (((FallingBlock)entity).getBlockData().getMaterial() == Material.GRAVEL) {
						e.getEntity().getItemStack().setType(random.nextDouble() < 0.05D ? Material.FLINT : Material.GRAVEL);
						break;
					}
				}
			}
		}
	}
}
