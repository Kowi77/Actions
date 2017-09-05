package kov.improve.action.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class InitConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Создание корневого контекста Spring
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        rootContext.register(DataConfig.class);

        // Листенер для управления жизненным циклом корневого контекста Spring
        container.addListener(new ContextLoaderListener(rootContext));

        // Создание контекста Spring для сервлета-диспетчера Spring MVC
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);

        // Регистрация сервлета-диспетчера Spring MVC
        ServletRegistration.Dynamic dispatcher =
                container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        // Отдельный маппинг для главной страницы приложения
        dispatcher.addMapping("/index");

        // Установка параметров контейнера
        container.setInitParameter("defaultHtmlEscape", "true");

        // Регистрация других сервлетов и фильтров

        // Например, фильтра для установки кодировки символов приложения
        FilterRegistration charEncodingFilterReg =
                container.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
        charEncodingFilterReg.setInitParameter("forceEncoding", "true");
        charEncodingFilterReg.addMappingForUrlPatterns(null, false, "/*");

        // ...
    }

}

