/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.usp.sistemasdeinformacao.estacioneaki.sistema;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author flavio
 * @param <T> Classe da camada model que será manipulada pelo DAO
 * @param <PK> Tipo da chava primaria da classe model que será manipulada pelo DAO
 */
public abstract class GenericDAO<T extends Entityable,PK extends Serializable> {
    
    public abstract SessionFactory getSessionFactory();
    
    @Transactional(readOnly = true)
    public List<T> list(){
        return getSessionFactory().getCurrentSession().createQuery("from "+getClassType().getSimpleName()).list();
    }
    
    @Transactional
    public void persist(T entity){
        getSessionFactory().getCurrentSession().persist(entity);
    }
    
    @Transactional
    public Entityable update(T entity){
        return (T) getSessionFactory().getCurrentSession().merge(entity);
    }
    
    private Class<T> getClassType(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
