package com.projetojava.erp.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projetojava.erp.enums.TipoEmpresa;
import com.projetojava.erp.model.Empresa;
import com.projetojava.erp.model.RamoAtividade;

public class PersistenceRamoAtividade {
	public static void main(String[] args) throws ParseException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		EntityManager em = emf.createEntityManager();

		/**
		 * Criando Ramo Atividade
		 */
		RamoAtividade ramoAtividade1 = new RamoAtividade();
		ramoAtividade1.setDescricao("Distribuição de alimentos");

		RamoAtividade ramoAtividade2 = new RamoAtividade();
		ramoAtividade2.setDescricao("Telecomunicações");

		RamoAtividade ramoAtividade3 = new RamoAtividade();
		ramoAtividade3.setDescricao("Vestuário");

		RamoAtividade ramoAtividade4 = new RamoAtividade();
		ramoAtividade4.setDescricao("Lavanderia");

		RamoAtividade ramoAtividade5 = new RamoAtividade();
		ramoAtividade5.setDescricao("Gráfica");

		RamoAtividade ramoAtividade6 = new RamoAtividade();
		ramoAtividade6.setDescricao("Mecânica");

		RamoAtividade ramoAtividade7 = new RamoAtividade();
		ramoAtividade7.setDescricao("Turismo");

		RamoAtividade ramoAtividade8 = new RamoAtividade();
		ramoAtividade8.setDescricao("Saúde");

		RamoAtividade ramoAtividade9 = new RamoAtividade();
		ramoAtividade9.setDescricao("Educação");

		RamoAtividade ramoAtividade10 = new RamoAtividade();
		ramoAtividade10.setDescricao("Educação");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
		Empresa empresa1 = new Empresa();
		empresa1.setNomeFantasia("Mercado do João");
		empresa1.setCnpj("70.311.193/0001-87");
		empresa1.setRazaoSocial("João Mercado e Distribuidor de Alimentos Ltda");
		empresa1.setTipoEmpresa(TipoEmpresa.LTDA);
		empresa1.setDataFundacao(formatter.parse("24/07/2020"));
		empresa1.setRamoAtividade(ramoAtividade1);
		
		Empresa empresa2 = new Empresa();
		empresa2.setNomeFantasia("Fale Mais");
		empresa2.setCnpj("52.822.994/0001-25");
		empresa2.setRazaoSocial("Fale Mais Telecom S.A.");
		empresa2.setTipoEmpresa(TipoEmpresa.SA);
		empresa2.setDataFundacao(formatter.parse("10/12/1997"));
		empresa2.setRamoAtividade(ramoAtividade2);
		
		Empresa empresa3 = new Empresa();
		empresa3.setNomeFantasia("Maria de Souza da Silva");
		empresa3.setCnpj("41.952.519/0001-57");
		empresa3.setRazaoSocial("Maria de Souza da Silva");
		empresa3.setTipoEmpresa(TipoEmpresa.MEI);
		empresa3.setDataFundacao(formatter.parse("15/10/2014"));
		empresa3.setRamoAtividade(ramoAtividade3);
		
		Empresa empresa4 = new Empresa();
		empresa4.setNomeFantasia("Gomes Inovação");
		empresa4.setCnpj("16.134.777/0001-89");
		empresa4.setRazaoSocial("José Fernando Gomes EIRELI ME");
		empresa4.setTipoEmpresa(TipoEmpresa.EIRELI);
		empresa4.setDataFundacao(formatter.parse("02/03/2009"));
		empresa4.setRamoAtividade(ramoAtividade4);
		
		Empresa empresa5 = new Empresa();
		empresa5.setNomeFantasia("João da Silva");
		empresa5.setCnpj("41.952.519/0001-57");
		empresa5.setRazaoSocial("João da Silva 41952519000157");
		empresa5.setTipoEmpresa(TipoEmpresa.MEI);
		empresa5.setDataFundacao(new Date());
		empresa5.setRamoAtividade(ramoAtividade1);

		em.getTransaction().begin();

		em.persist(ramoAtividade1);
		em.persist(ramoAtividade2);
		em.persist(ramoAtividade3);
		em.persist(ramoAtividade4);
		em.persist(ramoAtividade5);
		em.persist(ramoAtividade6);
		em.persist(ramoAtividade7);
		em.persist(ramoAtividade8);
		em.persist(ramoAtividade9);
		em.persist(ramoAtividade10);
		
		em.persist(empresa1);
		em.persist(empresa2);
		em.persist(empresa3);
		em.persist(empresa4);
		em.persist(empresa5);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
