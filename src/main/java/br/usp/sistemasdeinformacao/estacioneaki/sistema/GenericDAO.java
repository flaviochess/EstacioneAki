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

/**
 *
 * @author flavio
 * @param <T> Classe da camada model que será manipulada pelo DAO
 * @param <PK> Tipo da chava primaria da classe model que será manipulada pelo DAO
 */
public abstract class GenericDAO<T extends Entityable,PK extends Serializable> {
    
    public abstract SessionFactory getSessionFactory();
    
    public List<T> list(){
        return getSessionFactory().getCurrentSession().createQuery("from "+getClassType().getSimpleName()).list();
    }
    
    private Class<T> getClassType(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
