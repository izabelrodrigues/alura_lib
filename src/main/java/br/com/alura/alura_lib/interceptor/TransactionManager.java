package br.com.alura.alura_lib.interceptor;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.alura.alura_lib.annotation.Transacional;

@Interceptor
@Transacional
public class TransactionManager implements Serializable {

	private static final long serialVersionUID = 3594531802425343718L;

	@Inject
	private EntityManager em;

	public Object efetuaComTransacao(InvocationContext context) {
		em.getTransaction().begin();

		try {
			Object resultado = context.proceed();
			em.getTransaction().commit();
			return resultado;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}

	}

}
