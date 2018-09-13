package me.qintinator.holyinventory.repositories;

import java.util.UUID;

import me.qintinator.holyinventory.interfaces.IRepository;
import me.qintinator.holyinventory.model.HiPlayer;
import me.qintinator.holyinventory.statics.DataManager;

public class HiPlayerRepository implements IRepository<HiPlayer>{

	@Override
	public void set(HiPlayer hiPlayer) {
		// TODO Auto-generated method stub
		DataManager.hiPlayers.put(hiPlayer.getOwnerId(), hiPlayer);
	}

	@Override
	public HiPlayer get(UUID object) {
		return DataManager.hiPlayers.get(object);
	}

	@Override
	public void remove(UUID object) {
		DataManager.hiPlayers.remove(object);	
	}

}
