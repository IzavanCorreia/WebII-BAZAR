package com.ifpe.recife.bazar.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ifpe.recife.bazar.entites.Lote;
import com.ifpe.recife.bazar.entites.OrgaoDonatario;
import com.ifpe.recife.bazar.entites.OrgaoFiscalizador;
import com.ifpe.recife.bazar.entites.Produto;

public class LoteRepository implements GenericRepository<Lote, Integer> {

	protected LoteRepository() {}
	
	@Override
	public void create(Lote c) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "insert into lote(dataentrega, observacao, fk_orgaodonatario, fk_produto, fk_orgaofiscalizador) values (?,?,?,?,?)";
		
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
			
			pstm.setLong(1, c.getData().getTime());
			pstm.setString(2, c.getObservacao());
			pstm.setInt(3, c.getOrgaodonatario().getId());
			pstm.setInt(4, c.getProduto().getCodigo());
			pstm.setInt(5, c.getOrgaofiscalizador().getId());
			
			pstm.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(Lote c) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update lote set (dataentrega = ?, observacao = ?, fk_orgaodonatario = ?, fk_produto = ?, fk_orgaofiscalizador = ?) "
				+ "where id = ?";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
			
			pstm.setLong(1, c.getId());
			
			pstm.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Lote read(Integer k) throws SQLException {
		// TODO Auto-generated method stub
				String sql = "select * lote as l join orgaodonatario as o join produto as p join orgaofiscalizador as f"
						+ "on (l.fk_orgaodonatario = o.id and l.fk_produto = p.codigo and l.fk_orgaofiscalizador = f.id) where l.id = ?";
				
				try {
					PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
					
					pstm.setInt(1, k);
					
					ResultSet rs = pstm.executeQuery();
					
					Lote l = new Lote();
					
					if(rs.next()) {
						
						l.setId(rs.getInt("id"));
						l.setData(new Date(rs.getLong("dataentrega")));
						l.setObservacao(rs.getString("observacao"));
						
						OrgaoDonatario o = new OrgaoDonatario();
						o.setId(rs.getInt("id"));
						o.setNome(rs.getString("nome"));
						o.setEndereco(rs.getString("endereco"));
						o.setTelefone(rs.getString("telefone"));
						o.setNome(rs.getString("horariofuncionamento"));
						o.setDescricao(rs.getString("descricao"));
						
						
						Produto p = new Produto();
						p.setCodigo(rs.getInt("codigo"));
						p.setNome(rs.getString("nome"));
						p.setDescricao(rs.getString("descricao"));
						
						OrgaoFiscalizador f = new OrgaoFiscalizador();
						f.setId(rs.getInt("id"));
						f.setNome(rs.getString("nome"));
						f.setDescricao(rs.getString("descricao"));
						
						l.setOrgaodonatario(o);
						l.setProduto(p);
						l.setOrgaofiscalizador(f);
						
					}
					
					return l;
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
	}

	@Override
	public void delete(Integer k) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from lote where id = ?";
		
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
	public List<Lote> readAll() throws SQLException {

		List<Lote> lotes = new ArrayList<>();
		
		String sql = "select * lote as l join orgaodonatario as o join produto as p join orgaofiscalizador as f"
				+ "on (l.fk_orgaodonatario = o.id and l.fk_produto = p.codigo and l.fk_orgaofiscalizador = f.id)";
		
		try {
			PreparedStatement pstm = com.ifpe.recife.bazar.dao.ConnectionManager.getCurrentConnection().prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			Lote l = new Lote();
			
			while(rs.next()) {
				
				l.setId(rs.getInt("id"));
				l.setData(new Date(rs.getLong("dataentrega")));
				l.setObservacao(rs.getString("observacao"));
				
				OrgaoDonatario o = new OrgaoDonatario();
				o.setId(rs.getInt("id"));
				o.setNome(rs.getString("nome"));
				o.setEndereco(rs.getString("endereco"));
				o.setTelefone(rs.getString("telefone"));
				o.setNome(rs.getString("horariofuncionamento"));
				o.setDescricao(rs.getString("descricao"));
				
				Produto p = new Produto();
				p.setCodigo(rs.getInt("codigo"));
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				
				OrgaoFiscalizador f = new OrgaoFiscalizador();
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setDescricao(rs.getString("descricao"));
				
				l.setOrgaodonatario(o);
				l.setProduto(p);
				l.setOrgaofiscalizador(f);
				
				lotes.add(l);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lotes;
	}

}
