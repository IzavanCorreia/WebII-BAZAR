package com.ifpe.recife.bazar.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifpe.recife.bazar.entites.Produto;

public class ProdutoRepository implements GenericRepository<Produto, Integer>{

	protected ProdutoRepository() {}
	
	@Override
	public void create(Produto c) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into produto(nome, descricao) values (?,?)";
		
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
	public void update(Produto c) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update produto set nome = ?, "
				+ "descricao = ?, "
				+ "where codigo = ?";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getDescricao());
			pstm.setInt(3, c.getCodigo());
			
			pstm.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public Produto read(Integer k) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from produto where codigo = ?";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setInt(1, k);
			
			ResultSet rs = pstm.executeQuery();
			
			Produto p = null;
			
			if(rs.next()) {
				p = new Produto();
				
				p.setCodigo(k);
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
			}
			
			return p;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public void delete(Integer k) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from produto where codigo = ?";
		
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
	public List<Produto> readAll() throws SQLException {
		String sql = "select * from produto";
		
		List<Produto> produtos = new ArrayList<>();
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
				
			ResultSet rs = pstm.executeQuery();
					
			while(rs.next()) {
				
				Produto p = new Produto();
				
				p.setCodigo(rs.getInt("codigo"));
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				
				produtos.add(p);
			}	
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return produtos;
	}

}
