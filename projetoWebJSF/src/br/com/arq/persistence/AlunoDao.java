package br.com.arq.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.arq.entity.Aluno;

public class AlunoDao extends Dao {
	
	
	 public void  create(Aluno a)throws Exception{
		  open();
		    stmt = con.prepareStatement("insert into aluno values (null,?,?,?,?,?,?) ");
		     stmt.setString(1, a.getNome());
		     stmt.setString(2, a.getDisciplina());
		     stmt.setDouble(3, a.getNota1());
		     stmt.setDouble(4, a.getNota2());
		     stmt.setDouble(5, a.getMedia());
		     stmt.setString(6, a.getSituacao());
		     stmt.execute();
		     stmt.close();
		  close();   
	 }
	
	public List<Aluno> findAll() throws Exception{
		open();
		 stmt = con.prepareStatement("select * from aluno"); 
		  List<Aluno> lista =new ArrayList<>();
		  rs = stmt.executeQuery();
		  while(rs.next()) {
			  Aluno a = new Aluno();
			        a.setId(rs.getInt("id"));
			        a.setNome(rs.getString("nome"));
                    a.setDisciplina(rs.getString("disciplina"));
                    a.setNota1(rs.getDouble("nota1"));
                    a.setNota2(rs.getDouble("nota2"));
                    a.setMedia(rs.getDouble("media"));
                    a.setSituacao(rs.getString("situacao"));
		           lista.add(a);
		  }
		close();
		return lista;
	}
	
	
	
	
	

}
