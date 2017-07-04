package br.com.itsstecnologia.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.itsstecnologia.bo.UserBO;
import br.com.itsstecnologia.model.User;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class SystemAccesController {
	
	private User usuario;

	private String username;
	private String senha;

	private boolean loggedIn;

	private User usuarioLogado;


	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String envia() {

		usuario = new UserBO().isUsuarioReadyToLogin(username, senha);
		if (usuario == null) {
			usuario = new User();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			loggedIn = true;
			setUsuarioLogado(usuario);
			return "/main";
		}

	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public User getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(User usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}
