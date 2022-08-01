package com.ifpe.recife.bazar.repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifpe.recife.bazar.entites.OrgaoFiscalizador;

public class OrgaoFiscalizadorRepository implements GenericRepository<OrgaoFiscalizador, Integer> {

	protected OrgaoFiscalizadorRepository() {}
	
	@Override
	public void create(OrgaoFiscalizador c) throws SQLException {
		
		String sql = "insert into orgaofiscalizador(nome, descricao) values (?,?)";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getDescricao());
			
			pstm.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	

	@Override
	public void update(OrgaoFiscalizador c) throws SQLException {
		String sql = "update orgaofiscalizador set nome = ?, "
				+ "descricao = ?, "
				+ "where id = ?";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getDescricao());
			pstm.setInt(3, c.getId());
			
			pstm.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public OrgaoFiscalizador read(Integer k) throws SQLException {
		String sql = "select * from orgaofiscalizador where id = ?";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setInt(1, k);
			
			ResultSet rs = pstm.executeQuery();
			
			OrgaoFiscalizador o = null;
			
			if(rs.next()) {
				o = new OrgaoFiscalizador();
				
				o.setId(k);
				o.setNome(rs.getString("nome"));
				o.setDescricao(rs.getString("descricao"));
			}
			
			return o;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public void delete(Integer k) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from orgaofiscalizador where id = ?";
		
		try {
			
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setInt(1, k);
			
			pstm.execute();
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public List<OrgaoFiscalizador> readAll() throws SQLException {
		String sql = "select * from orgaofiscalizador";
		
		List<OrgaoFiscalizador> orgaofiscalizadores = new ArrayList<>();
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			
			ResultSet rs = pstm.executeQuery();
			
			
			
			while(rs.next()) {
				
				OrgaoFiscalizador o = new OrgaoFiscalizador();
				
				o.setId(rs.getInt("id"));
				o.setNome(rs.getString("nome"));
				o.setDescricao(rs.getString("descricao"));
				
				orgaofiscalizadores.add(o);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return orgaofiscalizadores;
	}

}
