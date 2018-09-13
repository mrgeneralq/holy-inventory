package me.qintinator.holyinventory.eventlisteners;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.qintinator.holyinventory.interfaces.IHiPlayerService;
import me.qintinator.holyinventory.model.HiPlayer;

public class OnPlayerDeath implements Listener {
	
	private final IHiPlayerService hiPlayerService;
	
	public OnPlayerDeath(IHiPlayerService hiPlayerService) {
		this.hiPlayerService = hiPlayerService;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		
		Player player = e.getEntity();
		HiPlayer hiPlayer = new HiPlayer();
		
		hiPlayer.setOwnerId(player.getUniqueId());
		hiPlayer.setDeathLocation(player.getLocation());
		hiPlayer.setExp(e.getDroppedExp());
		
		ItemStack[] drops = e.getDrops().toArray(new ItemStack[e.getDrops().size()]);
		
		hiPlayer.setDrops(drops);
		
		hiPlayerService.setHiPlayer(hiPlayer);
	}

}
