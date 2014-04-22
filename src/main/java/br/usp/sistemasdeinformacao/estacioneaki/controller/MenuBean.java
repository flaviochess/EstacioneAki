/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.usp.sistemasdeinformacao.estacioneaki.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Willian
 */
@ManagedBean
@RequestScoped
public class MenuBean {
    
	public String index(){
		return "/pages/index?faces-redirect=true";
	}
        
        public String cadastro(){
            return "/pages/estacionamento/cadastro?faces-redirect=true";
        }
        
        public String login(){
            return "/pages/servicos/login?faces-redirect=true";
        }
        
         public String localizar(){
            return "/pages/servicos/localizar?faces-redirect=true";
        }
    
}
