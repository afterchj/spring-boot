package jit.wxs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}


	/**
	 * 注入验证码servlet
	 */
//	@Bean
//	public ServletRegistrationBean indexServletRegistration() {
//		ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
//		registration.addUrlMappings("/getVerifyCode");
//		return registration;
//	}
}
