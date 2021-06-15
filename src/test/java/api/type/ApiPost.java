package api.type;

import controller.GlobalConfig;
import controller.JsonHandle;
import controller.Utilities;
import io.restassured.response.Response;

public class ApiPost extends GlobalConfig {
    GlobalConfig apiConf = new GlobalConfig();
    JsonHandle json = new JsonHandle();
    Utilities ultil = new Utilities();

    String[] keyUpdate = {"name"};
    String[] valueUpdate = {ultil.generateRandomText()};

    public Response createRepo() {
        apiConf.authenticationWithPrivateToken(apiConf.BASE_URL, apiConf.token);
        response = apiConf.request
                .body(json.readOrUpdateJsonBodyFromFile("createRepo",true, keyUpdate,valueUpdate))
                .post("/user/repos");
        return response;
    }

}