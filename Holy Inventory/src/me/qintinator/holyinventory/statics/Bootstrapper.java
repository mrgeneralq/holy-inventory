package me.qintinator.holyinventory.statics;

import me.qintinator.holyinventory.interfaces.IHiPlayerService;
import me.qintinator.holyinventory.interfaces.IRepository;
import me.qintinator.holyinventory.model.HiPlayer;
import me.qintinator.holyinventory.repositories.HiPlayerRepository;
import me.qintinator.holyinventory.services.HiPlayerService;

public class Bootstrapper {

	private static Bootstrapper bootstrapper;
	private static IRepository<HiPlayer> hiPlayerRepository;
	private static IHiPlayerService hiPlayerService;
	
	private Bootstrapper() {}
	
	public static Bootstrapper getBootstrapper() {
		if(bootstrapper == null)
			bootstrapper = new Bootstrapper();
		return bootstrapper;
	}
	
	public void Run() {
		
	 IRepository<HiPlayer> hiPlayerRepository = new HiPlayerRepository();
	 hiPlayerService = new HiPlayerService(hiPlayerRepository);

	}

	public static IHiPlayerService getHiPlayerService() {
		return hiPlayerService;
	}

	public static IRepository<HiPlayer> getHiPlayerRepository() {
		return hiPlayerRepository;
	}
	
	
	
	
	
	
	
	
	
}
