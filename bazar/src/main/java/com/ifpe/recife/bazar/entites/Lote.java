package com.ifpe.recife.bazar.entites;

public class Lote {
	
	private int id;
	private long dataentrega;
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
	public OrgaoDonatario getOrgaoDonatario() {
		return orgaodonatario;
	}
	public void setOrgaoDonatario(OrgaoDonatario orgaodonatario) {
		this.orgaodonatario = orgaodonatario;
	}

	public OrgaoFiscalizador getOrgaoFiscalizador() {
		return orgaofiscalizador;
	}
	public void setOrgaoFiscalizador(OrgaoFiscalizador orgaofiscalizador) {
		this.orgaofiscalizador = orgaofiscalizador;
	}
	
		public long getDataentrega() {
			return dataentrega;
		}
		public void setDataentrega(long dataentrega) {
			this.dataentrega = dataentrega;
		
	
}
}
