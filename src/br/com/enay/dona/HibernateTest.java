package br.com.enay.dona;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select NOME, VALOR, PROMOCAO, QUANTIDADE from MERCADORIA;");
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			Mercadoria mercadoria = new Mercadoria();
			System.out.println(row[0].toString());
			System.out.println(row[1].toString());
			System.out.println(row[2].toString());
			System.out.println(row[3].toString());
			
			mercadoria.setNome(row[0].toString());
			mercadoria.setValor(row[1].toString());
			mercadoria.setPromocao(row[2].toString());
			mercadoria.setQuantidade(row[3].toString());
			
		}
		session.close();
		
	}
}
