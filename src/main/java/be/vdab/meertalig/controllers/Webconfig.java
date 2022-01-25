package be.vdab.meertalig.controllers;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


/*Bepaling hoe de taal geselecteerd moet worden:
*   - FixedLocaleResolver
*           LocaleResolver localeResolver() {
                return new FixedLocaleResolver(new Locale("en", "US"));
            }
*   - SessionLocalResolver
*           SessionLocaleResolver localeResolver() {
                return new SessionLocaleResolver();
            }
*   - localChangeInterceptor
*       keuze via hyperlinks
*   - cookieLocaleResolver
* */
@Configuration
class Webconfig implements WebMvcConfigurer {
    private static final int ZEVEN_DAGEN = 604_800;
    @Bean
    LocaleResolver localeResolver() {
        var resolver = new CookieLocaleResolver();
        resolver.setCookieMaxAge(ZEVEN_DAGEN);
        return resolver;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
    registry.addInterceptor(new LocaleChangeInterceptor());
}
}
