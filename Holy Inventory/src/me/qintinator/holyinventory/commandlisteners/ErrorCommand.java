package me.qintinator.holyinventory.commandlisteners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.qintinator.holyinventory.interfaces.ISubCommand;
import me.qintinator.holyinventory.statics.Message;
import net.md_5.bungee.api.ChatColor;

public class ErrorCommand implements ISubCommand {

	@Override
	public void execute(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		sender.sendMessage(Message.prefix + ChatColor.RED + "Unknown command!");
		return;

	}

}
