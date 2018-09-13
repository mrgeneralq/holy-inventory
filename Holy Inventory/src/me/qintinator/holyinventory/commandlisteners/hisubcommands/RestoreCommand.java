package me.qintinator.holyinventory.commandlisteners.hisubcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.qintinator.holyinventory.interfaces.IHiPlayerService;
import me.qintinator.holyinventory.interfaces.ISubCommand;
import me.qintinator.holyinventory.model.HiPlayer;
import me.qintinator.holyinventory.statics.Message;

public class RestoreCommand implements ISubCommand{
	
	private final IHiPlayerService hiPlayerService;
	
	public RestoreCommand(IHiPlayerService hiPlayerService) {
		this.hiPlayerService = hiPlayerService;
	}

	@Override
	public void execute(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		
		if(!sender.hasPermission("holyinventory.restore")) {
			sender.sendMessage(Message.prefix + ChatColor.RED + "You don't have permission to that command!");
		}
		
		if(args.length != 2) {
			sender.sendMessage(Message.prefix + ChatColor.RED + "Use /hi restore <player>");
			return;
		}
		
		
		if(Bukkit.getServer().getPlayer(args[1]) == null) {
			sender.sendMessage(Message.prefix + ChatColor.RED + "Invalid player! Make sure this player is online!");
			return;
		}
		
		Player target = Bukkit.getServer().getPlayer(args[1]);
		
		HiPlayer hiPlayer = hiPlayerService.getHiPlayer(target.getUniqueId());
		
		if(hiPlayer == null || hiPlayer.getDrops() == null) {
			sender.sendMessage(Message.prefix + ChatColor.RED + "This player did not die yet!");
			return;
		}
		
		
		target.playSound(target.getLocation(),Sound.BLOCK_PORTAL_TRAVEL, 1, 0.5F);
		target.getInventory().setContents(hiPlayer.getDrops());
		target.setTotalExperience(hiPlayer.getExp());
		
		target.sendMessage(Message.prefix + ChatColor.GREEN + "Your inventory just got restored!");
		sender.sendMessage(Message.prefix + ChatColor.GREEN + "You restored the inventory of " + target.getName());
		
		hiPlayer.setDrops(null);
		hiPlayerService.setHiPlayer(hiPlayer);
		return;
		
	}

	
	
}
