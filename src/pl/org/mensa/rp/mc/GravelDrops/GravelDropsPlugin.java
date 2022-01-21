package pl.org.mensa.rp.mc.GravelDrops;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class GravelDropsPlugin extends JavaPlugin {
	public static final String prefix = "&3[&bGravelDrops&3]&e";
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdesc = getDescription();
		
		this.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
		
		Utils.log("&a" + pdesc.getFullName() + " enabled");
	}
}
