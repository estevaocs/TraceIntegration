package br.com.itsstecnologia.bo;

import br.com.itsstecnologia.dao.UserDao;
import br.com.itsstecnologia.model.User;
import br.com.itsstecnologia.services.MD5;

public class UserBO {
	
	public User isUsuarioReadyToLogin(String username, String senha) {
               username = username.toLowerCase().trim();
               UserDao dao = new UserDao();
               User retorno = dao.getUsuario(username, MD5.convertStringToMd5(senha));
               return retorno;
  }
}
