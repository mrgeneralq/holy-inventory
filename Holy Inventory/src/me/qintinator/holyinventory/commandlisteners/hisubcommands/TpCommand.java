package me.qintinator.holyinventory.commandlisteners.hisubcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import me.qintinator.holyinventory.interfaces.IHiPlayerService;
import me.qintinator.holyinventory.interfaces.ISubCommand;
import me.qintinator.holyinventory.model.HiPlayer;
import me.qintinator.holyinventory.statics.Message;

public class TpCommand implements ISubCommand{
	
	private final IHiPlayerService hiPlayerService;
	
	public TpCommand(IHiPlayerService hiPlayerService) {
		this.hiPlayerService = hiPlayerService;
	}

	@Override
	public void execute(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		
		if(!sender.hasPermission("holyinventory.teleport")) {
			sender.sendMessage(Message.prefix + ChatColor.RED + "You don't have permission to that command!");
		}
		
		if(args.length != 2) {
			sender.sendMessage(Message.prefix + ChatColor.RED + "Use /hi tp <player>");
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
		
		if(!(sender instanceof Player)){
			sender.sendMessage(Message.prefix + ChatColor.RED + "You must be a player to teleport!");
			return;
		}
		
		Location deathLocation = hiPlayer.getDeathLocation();
		Player user = (Player) sender;
		
		user.teleport(deathLocation, TeleportCause.PLUGIN);
		user.sendMessage(Message.prefix + ChatColor.GREEN + "You have been teleported to the death location of " + target.getName());
		
		return;
		
	}

	
	
}
