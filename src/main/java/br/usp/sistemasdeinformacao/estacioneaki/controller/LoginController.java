package br.usp.sistemasdeinformacao.estacioneaki.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.usp.sistemasdeinformacao.estacioneaki.entity.Acesso;
import br.usp.sistemasdeinformacao.estacioneaki.entity.Estacionamento;

@ManagedBean
@ViewScoped
public class LoginController {
	private Estacionamento estacionamento = new Estacionamento();
	private String senha;
	private String email;

	public String autentica() {
		Acesso acesso = new Acesso();
		try {
			Estacionamento user = acesso.autentica(this.email, this.senha);
			return "/view/index?faces-redirect=true";
		} catch (NullPointerException ex) {
			FacesContext.getCurrentInstance().addMessage(
					":form:messages",
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Aviso: Estacionamento não encontrado: Por favor"
									+ " verifique login e a senha", ""));
			ex.printStackTrace();
		}

		return "";
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
