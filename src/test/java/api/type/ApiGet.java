package api.type;

import controller.GlobalConfig;
import io.restassured.response.Response;
import controller.JsonHandle;

public class ApiGet extends GlobalConfig {

    GlobalConfig apiConf = new GlobalConfig();
    JsonHandle json = new JsonHandle();

    public Response getUser() {
        apiConf.authenticationWithPrivateToken(apiConf.BASE_URL, apiConf.token);
        response = apiConf.request.get("/user");
        return response;
    }

    public Response getRepos(String owner) {
        apiConf.authenticationWithPrivateToken(apiConf.BASE_URL, apiConf.token);
        response = apiConf.request.get("/" + owner +"/repos");
        return response;
    }
}