package util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * A anotação @ApplicationScoped faz com que a instância da classe gerada
 * sobreviva durante todo o ciclo de vida da aplicação.
 */
@ApplicationScoped
public class EntitymanagerProducer {
 
	private EntityManagerFactory factory;
	
	/**
	 * Criação da Factory
	 */
	public EntitymanagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
	}
	
	/**
	 * Método produtor de EntitysManagers.
	 * Toda vez que uma classe pedir uma instância de EntityManager,
	 * o CDI irá invocar esse método que para que seja criada a instância.
	 */
	@Produces
	@RequestScoped
	public EntityManager createEntitymanager() {
		return this.factory.createEntityManager();
	}
	
	/**
	 * Toda vez que acabar o escopo do EntityManager o CDI por conta da anotação @Disposes,
	 *  irá chamar esse método para encerrar o EntityManager
	 * @param manager
	 */
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
