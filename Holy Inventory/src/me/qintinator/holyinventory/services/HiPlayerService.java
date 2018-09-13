package me.qintinator.holyinventory.services;

import java.util.UUID;

import me.qintinator.holyinventory.interfaces.IHiPlayerService;
import me.qintinator.holyinventory.interfaces.IRepository;
import me.qintinator.holyinventory.model.HiPlayer;

public class HiPlayerService implements IHiPlayerService{

	
	private final IRepository<HiPlayer> hiPlayerRepository;
	
	
	public HiPlayerService(IRepository<HiPlayer> hiPlayerRepository) {
		this.hiPlayerRepository = hiPlayerRepository;
	}


	@Override
	public void setHiPlayer(HiPlayer hiPlayer) {
		hiPlayerRepository.set(hiPlayer);		
	}


	@Override
	public HiPlayer getHiPlayer(UUID uuid) {
		return hiPlayerRepository.get(uuid);
	}


	@Override
	public void removeHiPlayer(UUID uuid) {
		hiPlayerRepository.remove(uuid);
	}
}
