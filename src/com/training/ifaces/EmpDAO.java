package com.training.ifaces;

import java.util.List;

public interface EmpDAO<T> {
	public int add(T t);

	public T find(int key);

	public List<T> findAll();

	public int update(int key, long phone);

	public int delete(int key);
}
