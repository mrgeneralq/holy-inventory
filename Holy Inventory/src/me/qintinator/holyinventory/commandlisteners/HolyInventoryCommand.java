package me.qintinator.holyinventory.commandlisteners;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.qintinator.holyinventory.commandlisteners.hisubcommands.RestoreCommand;
import me.qintinator.holyinventory.interfaces.IHiPlayerService;
import me.qintinator.holyinventory.interfaces.ISubCommand;
import me.qintinator.holyinventory.statics.Message;

public class HolyInventoryCommand implements CommandExecutor {
	

	private HashMap<String, ISubCommand> subCommands = new HashMap<String, ISubCommand>();
	
	
	private final IHiPlayerService hiPlayerService;
	
	
	public HolyInventoryCommand(IHiPlayerService hiPlayerService) {
		this.hiPlayerService = hiPlayerService;
		subCommands.put("restore", new RestoreCommand(this.hiPlayerService));
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(!sender.hasPermission("holyinventory.hi")) {
			sender.sendMessage(Message.prefix + ChatColor.RED + "You don't have permission to that command!");
			return false;
		}	
		
		if(args.length == 0) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f++++++++ &6HolyIventory &f++++++++" ));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/hi restore <player> &frestore the inventory of the player"));			
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f++++++++++++++++++++++++++++++" ));
			return false;
		}
		
		subCommands.getOrDefault(args[0].toLowerCase(),new ErrorCommand()).execute(sender,cmd,commandLabel,args);
		
		return false;
	}
	

}
