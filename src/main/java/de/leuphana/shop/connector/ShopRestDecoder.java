package de.leuphana.shop.connector;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;

import de.leuphana.shop.connector.dto.AuthenticationTokenDTO;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;

public class ShopRestDecoder implements Decoder {

    private static AuthenticationTokenDTO authenticationToken;

    public static AuthenticationTokenDTO getAuthenticationToken() {
        return authenticationToken;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        Decoder jsonDecoder = new GsonDecoder();
        Object object = jsonDecoder.decode(response, type);

        URL url = new URL(response.request().url());

        if (url.getPath().equals("/authentication/authenticate")) {
            authenticationToken = (AuthenticationTokenDTO) object;
        }

        return object;
    }
}
