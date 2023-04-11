package util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Classe interceptadora. A anotação @Interceptor irá informar ao CDI que essa
 * classe é um interceptador. A anotação @Transacional irá informar o CDI para
 * interceptar as classes e ou os métodos anotados com a mesma. A
 * anotação @Priority(Interceptor.Priority.APPLICATION) ativa o interceptador,
 * essa anotação substituí a configuração do arquivo beans.xml.
 */
@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransacionalInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Essa instância de EntityManager será injetada pelo CDI após a chamada do
	 * método produtor da classe EntitymanagerProducer.
	 */
	@Inject
	private EntityManager manager;

	/**
	 * Método interceptador de fato! Todo o método que estiver anotado com
	 * o @Transacional antes de ser executador, o CDI irá chamar o método abaixo,
	 * por conta da anotação @AroundInvoke.
	 */
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		/**
		 * Pegando a transação
		 */
		EntityTransaction trx = manager.getTransaction();
		/**
		 * Criando uma proriedade para que o método verifique se foi ele ou não quem
		 * abriu e fechou a transação, para que apenas esse método tenha esse função
		 */
		boolean criador = false;
		try {
			if (trx.isActive()) {
				// truque para fazer rollback no que já passou
				// (senão, um futuro commit confirmaria até mesmo operações sem
				// transação)
				trx.begin();
				trx.rollback();

				// agora sim inicia a transação
				trx.begin();

				criador = true;
			}
			return context.proceed();
		} catch (Exception e) {
			if (trx != null && criador) {
				trx.rollback();
			}
			throw e;
		} finally {
			if (trx != null && trx.isActive() && criador) {
				trx.commit();
			}
		}

	}

}
