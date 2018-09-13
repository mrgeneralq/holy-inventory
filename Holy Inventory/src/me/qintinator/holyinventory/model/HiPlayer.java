package me.qintinator.holyinventory.model;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class HiPlayer {
	
	private UUID ownerId;
	private Location deathLocation;
	private ItemStack[] drops;
	private int exp;
	
	public UUID getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(UUID ownerId) {
		this.ownerId = ownerId;
	}
	public Location getDeathLocation() {
		return deathLocation;
	}
	public void setDeathLocation(Location deathLocation) {
		this.deathLocation = deathLocation;
	}
	public ItemStack[] getDrops() {
		return this.drops;
	}
	public void setDrops(ItemStack[] drops) {
		this.drops = drops;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	

}
