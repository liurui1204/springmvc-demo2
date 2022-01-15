package com.LiuR.springmvc.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@ComponentScan("com.LiuR.springmvc.*.controller")
@EnableWebMvc//开启mvc注解驱动
public class WebConfig implements WebMvcConfigurer {

    //使用默认的servlet处理静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //配置拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        FirstInterceptor firstInterceptor = new FirstInterceptor();
//        registry.addInterceptor(firstInterceptor).addPathPatterns("/**");
//    }

    //配置试图控制
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
    }

//    //配置生成模板解析器
//    @Bean
//    public ITemplateResolver templateResolver(){
//        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
//        ServletContextTemplateResolver templateResolver =
//                new ServletContextTemplateResolver(webApplicationContext.getServletContext());
//        templateResolver.setPrefix("/WEB-INF/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("UTF-8");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        return templateResolver;
//    }

    //配置试图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/templates/"); //设置前缀
        viewResolver.setSuffix(".html");	//设置后缀
        return viewResolver;
    }
//    //生成模板引擎并为模板引擎注入模板解析器
//    @Bean
//    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        return templateEngine;
//    }

    //生成视图解析器并未解析器注入模板引擎
//    @Bean
//    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setCharacterEncoding("UTF-8");
//        viewResolver.setTemplateEngine(templateEngine);
//        return viewResolver;
//    }

    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();

        resolver.addStatusCode("error/404",404);
        resolver.addStatusCode("error/error",500);
        properties.put("Exception","error/error");
        resolver.setExceptionMappings(properties);
        return resolver;
    }

}
