package com.service;

import java.util.List;

public interface CRUD<T> {

	public void create(T parameter);
	public List<T> read(int parameter);
	public void update(T parameter);
	public void delete(int parameter);
	public T get(int parameter);
}