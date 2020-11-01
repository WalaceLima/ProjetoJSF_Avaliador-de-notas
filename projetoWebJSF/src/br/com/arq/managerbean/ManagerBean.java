package br.com.arq.managerbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.arq.entity.Aluno;
import br.com.arq.persistence.AlunoDao;


@ManagedBean(name="mb")
@RequestScoped
public class ManagerBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private Aluno aluno;   // A unidade o  gravacao
	 private List<Aluno> alunos; //é a busca.. alunos ==> é a busca...
	 
	 public ManagerBean() {
	  this.aluno = new Aluno();
	  this.alunos = new ArrayList<Aluno>();
	 }
	 
	 public void carregar() {
		 AlunoDao dao = new AlunoDao();
		try {		 
		 this.alunos = dao.findAll(); 
	  }catch(Exception ex) {
		 ex.printStackTrace();
	 }
 }
	 
	 
	 public void gravar() {
	  FacesContext fc = FacesContext.getCurrentInstance();	 
	  AlunoDao dao = new AlunoDao();
	  try {
               dao.create(this.aluno); //gravo a unidade ( o um)			
               this.carregar();			 
			  fc.addMessage("",new FacesMessage("Dados Gravados"));
		 }catch(Exception ex) {
			  fc.addMessage("",new FacesMessage("Nao Gravados Ocorreu um Erro "));
		 }
	 }
	 
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public void calcular() {
		  FacesContext fc = FacesContext.getCurrentInstance();	 
		  try {
	              aluno.setMedia((aluno.getNota1() + aluno.getNota2())/2);
	              aluno.setSituacao((aluno.getMedia()>=7)?"aprovado":"reprovado");
				  fc.addMessage("",new FacesMessage("Resultado do Aluno:" + aluno));
			 }catch(Exception ex) {
				  fc.addMessage("",new FacesMessage("Calculo nao, Ocorreu um Erro "));
			 }
		  }
    public void limpar() {
    	 FacesContext fc = FacesContext.getCurrentInstance();
    	  this.aluno = new Aluno();
    	  fc.addMessage("",new FacesMessage("Aluno Atualizado"));
      }
    	
 }



