package me.qintinator.holyinventory.interfaces;

import java.util.UUID;

public interface IRepository<T> {

	
	void set(T object);
	T get(UUID object);
	void remove(UUID object);
	
	
}
