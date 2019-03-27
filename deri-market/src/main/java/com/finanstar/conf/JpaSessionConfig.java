/**  
* @Title: JpaSessionConfig.java 
* @Description: 
* @Copyright: Copyright (c) 2018
* @Company: www.finanstar.cn 
* @author Daniel Pine  
* @date 2018年8月20日  
* @version 1.0  
*/  
package com.finanstar.conf;

/**
* @Title: JpaSessionConfig 
* @Description: 
 * @author DanielPine
 * @date 2018年8月20日  
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@Configuration
public class JpaSessionConfig {

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        HibernateJpaSessionFactoryBean sessionFactory=new HibernateJpaSessionFactoryBean();
        return sessionFactory;
    }
}