package test.service;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

@RunWith(PaxExam.class)
public class MyServiceTestCase {
	@Inject
	private BundleContext ctx;
	
	@Configuration
	public static Option[] config() {
	 
	        return CoreOptions.options(
	        		CoreOptions.mavenBundle("com.converter.api", "api", "1.0-SNAPSHOT"),
	        		CoreOptions.junitBundles()
	            );
	    }
	 
	    @Test
	    public void getHelloService() {
	    	ServiceReference ref = ctx.getServiceReference(ExampleService.class.getName());
	    	ExampleService svc = (ExampleService) ctx.getService(ref);
	        assertEquals("Hello Pax!", svc.getMessage());
	    }
}
