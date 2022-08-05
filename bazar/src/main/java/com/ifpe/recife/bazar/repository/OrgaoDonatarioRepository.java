package com.ifpe.recife.bazar.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifpe.recife.bazar.entites.OrgaoDonatario;


public class OrgaoDonatarioRepository implements GenericRepository<OrgaoDonatario, Integer> {

	protected OrgaoDonatarioRepository() {}
	
	@Override
	public void create(OrgaoDonatario c) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into orgaodonatario(nome, endereco, telefone, horariofuncionamento, descricao) values (?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getEndereco());
			pstm.setString(3, c.getTelefone());
			pstm.setString(4, c.getHorariofuncionamento());
			pstm.setString(5, c.getDescricao());	
			
			pstm.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void update(OrgaoDonatario c) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update produto set nome = ?, "
				+ "endereco = ?, telefone = ?, horariofuncionamento = ?, descricao = ?"
				+ "where id = ?";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setString(1, c.getNome());
			pstm.setString(2, c.getEndereco());
			pstm.setString(3, c.getTelefone());
			pstm.setString(4, c.getHorariofuncionamento());
			pstm.setString(5, c.getDescricao());
			pstm.setInt(6, c.getId());
			
			pstm.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public OrgaoDonatario read(Integer k) throws SQLException {
		String sql = "select * from orgaodonatario where id = ?";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			pstm.setInt(1, k);
			
			ResultSet rs = pstm.executeQuery();
			
			OrgaoDonatario o = null;
			
			if(rs.next()) {
				o = new OrgaoDonatario();
				
				o.setId(k);
				o.setNome(rs.getString("nome"));
				o.setEndereco(rs.getString("endereco"));
				o.setTelefone(rs.getString("telefone"));
				o.setNome(rs.getString("horariofuncionamento"));
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
		String sql = "delete from orgaodonatario where id = ?";
		
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
	public List<OrgaoDonatario> readAll() throws SQLException {
		String sql = "select * from orgaodonatario";
		
		List<OrgaoDonatario> orgaodonatarios = new ArrayList<>();
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
			
			ResultSet rs = pstm.executeQuery();
			
			
			
			while(rs.next()) {
				
				OrgaoDonatario o = new OrgaoDonatario();
				
				o.setId(rs.getInt("id"));
				o.setNome(rs.getString("nome"));
				o.setEndereco(rs.getString("endereco"));
				o.setTelefone(rs.getString("telefone"));
				o.setHorariofuncionamento(rs.getString("horariofuncionamento"));
				o.setDescricao(rs.getString("descricao"));
				
				orgaodonatarios.add(o);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return orgaodonatarios;
	
	}
	
}


