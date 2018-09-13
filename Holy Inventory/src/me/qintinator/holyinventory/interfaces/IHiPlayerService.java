package me.qintinator.holyinventory.interfaces;

import java.util.UUID;

import me.qintinator.holyinventory.model.HiPlayer;

public interface IHiPlayerService {
	
	void setHiPlayer(HiPlayer hiPlayer);
	HiPlayer getHiPlayer(UUID uuid);
	void removeHiPlayer(UUID uuid);

}
