package de.leuphana.shop.connector;

import de.leuphana.shop.connector.dto.AuthenticationTokenDTO;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class ShopRestRequesterIntercepter implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        AuthenticationTokenDTO authenticationToken = ShopRestDecoder.getAuthenticationToken();

        if (authenticationToken != null) {
            String token = authenticationToken.getToken();
            requestTemplate.header("Authorization", String.format("Bearer %s", token));
        }
    }

}
