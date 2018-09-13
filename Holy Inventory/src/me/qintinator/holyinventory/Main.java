package me.qintinator.holyinventory;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.qintinator.holyinventory.commandlisteners.HolyInventoryCommand;
import me.qintinator.holyinventory.eventlisteners.OnPlayerDeath;
import me.qintinator.holyinventory.statics.Bootstrapper;

public class Main extends JavaPlugin{

	
	public void onEnable() {
		
		Bootstrapper.getBootstrapper().Run();
		Bootstrapper.getBootstrapper();
		Bukkit.getServer().getPluginCommand("hi").setExecutor(new HolyInventoryCommand(Bootstrapper.getHiPlayerService()));
		
		Bootstrapper.getBootstrapper();
		Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerDeath(Bootstrapper.getHiPlayerService()), this);
	}
	
	
}
