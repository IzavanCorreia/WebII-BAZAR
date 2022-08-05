package com.ifpe.recife.bazar.entites;

import java.util.Date;

public class Lote {
	
	private int id;
	private long dataEntrega;
	private String observacao;
	private OrgaoDonatario orgaodonatario;
	private OrgaoFiscalizador orgaofiscalizador;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public OrgaoDonatario getOrgaodonatario() {
		return orgaodonatario;
	}
	public void setOrgaodonatario(OrgaoDonatario orgaodonatario) {
		this.orgaodonatario = orgaodonatario;
	}

	public OrgaoFiscalizador getOrgaofiscalizador() {
		return orgaofiscalizador;
	}
	public void setOrgaofiscalizador(OrgaoFiscalizador orgaofiscalizador) {
		this.orgaofiscalizador = orgaofiscalizador;
	}
	
	  public Date getData() {
	        return new Date(this.dataEntrega);
	    }

	    public void setData(Date data) {
	        this.dataEntrega = data.getTime();
	    }
	
}
