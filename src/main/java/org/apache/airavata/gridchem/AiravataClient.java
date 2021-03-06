package org.apache.airavata.gridchem;

import org.apache.airavata.api.Airavata;
import org.apache.airavata.auth.OAuthAuthorisationException;
import org.apache.airavata.auth.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.thrift.protocol.TProtocol;

/**
 * Created by dimuthuupeksha on 4/16/15.
 */
public class AiravataClient extends Airavata.Client{


    public AiravataClient(TProtocol prot) {
        super(prot);
    }

    public AiravataClient(TProtocol iprot, TProtocol oprot) {
        super(iprot, oprot);
    }

    public String login(String userName,String password) throws OAuthAuthorisationException {

        String endPoint = "https://localhost:9443/oauth2/token";
        String clientId = "Nifi3ZoSxnsmkOcsIwfW9mK0xM4a";
        String clientSecret = "9yvwzBepE9CuSR7mjMljuEUys7Ea";
        OAuthClient oAuthClient= new OAuthClient(endPoint,clientId,clientSecret);

        OAuthClient.AuthResponse authResponse=oAuthClient.authenticate(userName, password);
        return authResponse.getAccess_token();
    }

    public String getProfile(String accessToken) throws OAuthSystemException, OAuthProblemException {
        OAuthClientRequest request = new OAuthBearerClientRequest("https://localhost:9443/oauth2/userinfo?schema=openid").
                buildQueryMessage();
        URLConnectionClient ucc = new URLConnectionClient();

        request.setHeader("Authorization","Bearer "+accessToken);

        org.apache.oltu.oauth2.client.OAuthClient oAuthClient = new org.apache.oltu.oauth2.client.OAuthClient(ucc);

        OAuthResourceResponse resourceResponse = oAuthClient.resource(request, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
        return resourceResponse.getBody();
    }



}
