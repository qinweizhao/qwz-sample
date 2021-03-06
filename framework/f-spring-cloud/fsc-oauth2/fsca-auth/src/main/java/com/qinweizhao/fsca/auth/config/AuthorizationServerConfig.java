package com.qinweizhao.fsca.auth.config;

import com.qinweizhao.fsca.auth.excepion.OAuthServerAuthenticationEntryPoint;
import com.qinweizhao.fsca.auth.excepion.OAuthServerWebResponseExceptionTranslator;
import com.qinweizhao.fsca.auth.filter.OAuthServerClientCredentialsTokenEndpointFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;

/**
 * @author qinweizhao
 * @since 2022/6/7
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private OAuthServerAuthenticationEntryPoint authenticationEntryPoint;

    /**
     * ????????????????????????????????????????????????????????????
     *
     * @param security security
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        //?????????ClientCredentialsTokenEndpointFilter????????????????????????id????????????????????????
        OAuthServerClientCredentialsTokenEndpointFilter endpointFilter = new OAuthServerClientCredentialsTokenEndpointFilter(security, authenticationEntryPoint);
        endpointFilter.afterPropertiesSet();
        security.addTokenEndpointAuthenticationFilter(endpointFilter);

        security
                // ?????? /oauth/token_key ????????????????????????
                .tokenKeyAccess("permitAll()")
                // ?????? /oauth/check_token ????????????????????????
                .checkTokenAccess("permitAll()");
        // ???????????? client_id ??? client_secret ??????????????? ,?????????????????? OAuthServerClientCredentialsTokenEndpointFilter ?????????????????????
        // .allowFormAuthenticationForClients();
    }

    /**
     * ?????????????????????
     *
     * @param clients clients
     * @throws Exception e
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // ????????????
        clients.inMemory()
                // ????????? id
                .withClient("c1")
                // ???????????????
                .secret(new BCryptPasswordEncoder().encode("123"))
                // ?????? id ??? ?????????????????????????????????????????????????????????
                .resourceIds("resource1")
                // ????????????  ???????????????1. authorization_code????????????????????????password?????????????????????client_credentials????????????????????????implicit??????????????????
                // refresh_token????????????????????????
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
                // ?????????????????????????????????????????????????????? all ?????????????????????????????????????????????????????????????????????????????????
                .scopes("all")
                // false ????????????????????????
                .autoApprove(false)
                // ???????????????
                .redirectUris("https://www.qinweizhao.com");

    }


    /**
     * Security?????????????????????????????????????????????
     */
    @Resource
    AuthenticationManager authenticationManager;

    /**
     * ??????????????????service????????????????????????authorization_code????????????
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }


    /**
     * ?????????????????????????????????????????????????????????????????????????????????
     */
    @Resource
    private ClientDetailsService clientDetailsService;

    /**
     * ??????????????????
     */
    @Resource
    private TokenStore tokenStore;

    @Resource
    private JwtAccessTokenConverter jwtAccessTokenConverter;


    /**
     * ???????????????????????????
     */
    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        //????????????????????????
        services.setClientDetailsService(clientDetailsService);
        //?????????????????????
        services.setSupportRefreshToken(true);
        //????????????
        services.setTokenStore(tokenStore);
        //access_token???????????????
        services.setAccessTokenValiditySeconds(60 * 60 * 2);
        //refresh_token???????????????
        services.setRefreshTokenValiditySeconds(60 * 60 * 24 * 3);

        // * ????????????
        services.setTokenEnhancer(jwtAccessTokenConverter);
        return services;
    }


    /**
     * ??????????????????????????????????????????????????????
     *
     * @param endpoints endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                //????????????WebResponseExceptionTranslator????????????????????????????????????????????????????????????????????????
                .exceptionTranslator(new OAuthServerWebResponseExceptionTranslator())
                // ??????????????????????????? service
                .authorizationCodeServices(authorizationCodeServices())
                // ????????????????????????????????????
                .authenticationManager(authenticationManager)
                // ?????????????????????????????????
                .tokenServices(tokenServices())
                // ?????????????????????/oauth/token???????????? POST ??????
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }


}
