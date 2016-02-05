package test.service;

import static org.junit.Assert.assertEquals;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerMethod.class)
public class MyServiceTestCase {
	@Inject
	private BundleContext ctx;
	public static Option config() {
	 
	        return combine(
	            mavenBundle("com.converter.api", "api", "1.0.0-SNAPSHOT"),
	            junitBundles()
	            );
	    }
	 
	    @Test
	    public void getHelloService() {
	    	ServiceReference ref = ctx.getServiceReference(MyService.class.getName());
	        MyService svc = (MyService) ctx.getService(ref);
	        assertEquals("Hello Pax!", helloService.getMessage());
	    }
}
