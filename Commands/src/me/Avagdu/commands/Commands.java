package me.Avagdu.commands;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Commands extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Commands plugin;
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("heal") || commandLabel.equalsIgnoreCase("h")){
				if(args.length == 0){ 
					//heal = 0 args / heal Avagdu = 1 args
					player.setHealth(20);
					player.setFoodLevel(20);
					player.sendMessage(ChatColor.GREEN + "Healed!");
				}else if(args.length == 1){
					if(player.getServer().getPlayer(args[0])!=null){
					Player targetPlayer = player.getServer().getPlayer(args[0]);
					targetPlayer.setHealth(20);
					targetPlayer.setFoodLevel(20);
					player.sendMessage(ChatColor.GREEN + "Healed!");
				}else{
					player.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE!");
				}
				}
		
				}
		if(commandLabel.equalsIgnoreCase("extinguish") || commandLabel.equalsIgnoreCase("ex")){
			if(args.length == 0){ 
				//ex = 0 args / ex Avagdu = 1 args
				player.setFireTicks(0);
				player.sendMessage(ChatColor.GREEN + "You are no longer on Fire!");
			}else if(args.length == 1){
				if(player.getServer().getPlayer(args[0])!=null){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				targetPlayer.setFireTicks(0);
				player.sendMessage(ChatColor.GREEN + "You are no longer on Fire!");
			}else{
				player.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE!");
			}
			}
	
			}
			
		
		return false;
	}
	
	
	

}
