package in.nit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@EnableTransactionManagement
@EnableWebMvc

@PropertySource("classpath:app.properties")
@ComponentScan("in.nit")
public class Appconfig implements WebMvcConfigurer{	
	@Autowired
	private Environment env;
	@Bean
	public DataSource ds() {
		BasicDataSource b=new BasicDataSource();
		b.setDriverClassName(env.getProperty("db.driver_class"));
		b.setUrl(env.getProperty("db.url"));
		b.setUsername(env.getProperty("db.username"));
		b.setPassword(env.getProperty("db.passord"));
		return b;
	}
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean s= new LocalSessionFactoryBean();
		s.setDataSource(ds());
		s.setHibernateProperties(props());
		//s.setAnnotatedClasses(UomType.class);
		//s.setAnnotatedClasses(ShipmentType.class);
		s.setPackagesToScan("in.nit.model");
		return s;
	}
	@Bean
	public Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql", env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql", env.getProperty("orm.fromatsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("orm.hbm2ddl"));
		return p;
	}
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(sf().getObject());
		return h;
	}
	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager hm=new HibernateTransactionManager();
		hm.setSessionFactory(sf().getObject());
		return hm;
	}
	 
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver v=new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("mvc.prefix"));
		v.setSuffix(env.getProperty("mvc.suffix"));
		System.out.println(v.toString());		
		return v;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		System.out.println("Appconfig.multipartResolver()");
		return new CommonsMultipartResolver();
	}
	
	
	public Appconfig() {
		System.out.println("Appconfig downloaded");	// TODO Auto-generated constructor stub
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		System.out.println("Appconfig.addResourceHandlers()");
	}
}
