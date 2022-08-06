package com.ifpe.recife.bazar.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository <Classe, Key> {

	public void create(Classe c) throws SQLException;
	public void update(Classe c) throws SQLException;
	public Classe read(Key k) throws SQLException;
	public void delete(Key k) throws SQLException;
	public List<Classe> readAll() throws SQLException;
}
