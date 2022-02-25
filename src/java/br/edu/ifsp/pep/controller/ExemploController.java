/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author aluno
 */
/*-- Adicionou a biblioteca Java EE 7.
-- Utiliza um construtor sem parametro, caso tiver um construtor com parametros tem que 
colocar um vazio.
-- No index para que ao clicar em enviar funcionasse tirou o 'type= "button"'.
-- Todo maneged bean precisa ter um construtor sem parametro.
 */
@Named
//@RequestScoped
@ViewScoped
public class ExemploController implements Serializable {

    private Pessoa pessoa;
    private List<Pessoa> pessoas = new ArrayList<>();

    public ExemploController() {
        this.pessoa = new Pessoa();
    }

    public void teste() {
        System.out.println("Executou o metodo teste. ");
        System.out.println("Nome: " + this.pessoa.getNome());
    }

    public void adicionar() {
        System.out.println("Adicionou pessoa na lista. ");
        this.pessoas.add(pessoa);
        this.pessoa = new Pessoa();
        addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Cadastro Realizado");
    }

    public void exibir() {
        for (Pessoa p : pessoas) {
            System.out.println(p.getNome());
        }
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
