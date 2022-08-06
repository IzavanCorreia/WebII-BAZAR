package com.ifpe.recife.bazar.repository;

import java.sql.SQLException;
import java.util.List;

import com.ifpe.recife.bazar.entites.Lote;
import com.ifpe.recife.bazar.entites.OrgaoDonatario;
import com.ifpe.recife.bazar.entites.OrgaoFiscalizador;
import com.ifpe.recife.bazar.entites.Produto;

public class Facade {
private static Facade myself = null;
    
    private GenericRepository<OrgaoDonatario, Integer> rOrgaoDonatario = null; 
    private GenericRepository<OrgaoFiscalizador, Integer> rOrgaoFiscalizador = null;
    private GenericRepository<Produto, Integer> rProduto = null;
    private GenericRepository<Lote, Integer> rLote = null;
    
    private Facade(){
        
        this.rOrgaoDonatario = new OrgaoDonatarioRepository();
        this.rOrgaoFiscalizador = new OrgaoFiscalizadorRepository();
        this.rProduto = new ProdutoRepository();
        this.rLote = new LoteRepository();
        
    }
    
    public static Facade getCurrentInstance(){
        
        if(myself == null){
            myself = new Facade();
        }
        
        return myself;
        
    }
    
    public void create(OrgaoDonatario o) throws SQLException{
        this.rOrgaoDonatario.create(o);
    }
    
    public void update(OrgaoDonatario o) throws SQLException{
        this.rOrgaoDonatario.update(o);
    }
    
    public OrgaoDonatario readOrgaoDonatario(int id) throws SQLException{
    	
       return this.rOrgaoDonatario.read(id);
    }
    
    public void deleteOrgaoDonatario(int id) throws SQLException{
        this.rOrgaoDonatario.delete(id);
    }
    
    public List<OrgaoDonatario> readAllOrgaoDonatario() throws SQLException{
        return this.rOrgaoDonatario.readAll();
    }
    
    public void create(OrgaoFiscalizador f) throws SQLException{
        this.rOrgaoFiscalizador.create(f);
    }
    
    public void update(OrgaoFiscalizador f) throws SQLException{
        this.rOrgaoFiscalizador.update(f);
    }
    
    public OrgaoFiscalizador readOrgaoFiscalizador(int id) throws SQLException{
    	
       return this.rOrgaoFiscalizador.read(id);
    }
    
    public void deleteOrgaoFiscalizador(int id) throws SQLException{
        this.rOrgaoFiscalizador.delete(id);
    }
    
    public List<OrgaoFiscalizador> readAllOrgaoFiscalizador() throws SQLException{
        return this.rOrgaoFiscalizador.readAll();
    }
    
    public void create(Produto p) throws SQLException{
        this.rProduto.create(p);
    }
    
    public void update(Produto p) throws SQLException{
        this.rProduto.update(p);
    }
    
    public Produto readProduto(int codigo) throws SQLException{
    	
       return this.rProduto.read(codigo);
    }
    
    public void deleteProduto(int codigo) throws SQLException{
        this.rProduto.delete(codigo);
    }
    
    public List<Produto> readAllProduto() throws SQLException{
        return this.rProduto.readAll();
    }
    
    public void create(Lote l) throws SQLException{
        this.rLote.create(l);
    }
    
    public void update(Lote l) throws SQLException{
        this.rLote.update(l);
    }
    
    public Lote readLote(int id) throws SQLException{
    	
       return this.rLote.read(id);
    }
    
    public void deleteLote(int id) throws SQLException{
        this.rLote.delete(id);
    }
    
    public List<Lote> readAllLote() throws SQLException{
        return this.rLote.readAll();
    }
    
}
