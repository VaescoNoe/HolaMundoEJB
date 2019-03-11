package test;

import static org.junit.Assert.assertEquals;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;

import beans.HolaMundoEJB;

public class HolaMundoEJBTest {
	
	private static EJBContainer contenedor;
	private static Context contexto;
	private static HolaMundoEJB ejb;
	
	@Before
	public void iniciarContenedor() throws Exception{
		System.out.println("Iniciando EJB Container");
		contenedor  = EJBContainer.createEJBContainer();
		contexto = contenedor.getContext();
		ejb = (HolaMundoEJB) contexto.lookup("java:global/classes/HolaMundoEJB!beans.HolaMundoEJB");
	}
	
	@Test
	public void testAddNumbers() throws Exception {
		int a = 2;
		int b = 4;
		int resultado = ejb.sumar(a, b);
		assertEquals ((a+b), resultado);
		System.out.println("Operacion Terminada, resultado ".concat(Integer.toString(resultado)));
	}
}
