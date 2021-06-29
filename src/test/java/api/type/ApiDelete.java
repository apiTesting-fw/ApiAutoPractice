package api.type;

import controller.GlobalConfig;
import io.restassured.response.Response;

public class ApiDelete extends GlobalConfig {

    GlobalConfig apiConf = new GlobalConfig();

    public Response deleteRepo(String owner, String repo) {
        apiConf.authenticationWithPrivateToken(apiConf.BASE_URL, apiConf.token);
        response = apiConf.request.delete("/repos/" + owner + repo);
        return response;
    }
//    testsource
}