package in.nit.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import in.nit.config.Appconfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
	//providing input file as Web.xml

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {Appconfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}

}
