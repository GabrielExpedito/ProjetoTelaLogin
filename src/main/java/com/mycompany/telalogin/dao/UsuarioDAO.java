package com.mycompany.telalogin.dao;

import com.mycompany.telalogin.model.Usuario;
import com.mycompany.telalogin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Gabriel Expedito
 */
public class UsuarioDAO {
    
    public Usuario autenticarLogin(String login, String senha) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        String hql = "FROM Usuario WHERE login = :login AND senha = :senha";
        Query<Usuario> query = session.createQuery(hql, Usuario.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        
        Usuario usuario = query.uniqueResult();
        session.close();
        
        return usuario;
    }
}
