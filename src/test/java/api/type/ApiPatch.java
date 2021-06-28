package api.type;

import controller.GlobalConfig;
import controller.JsonHandle;
import io.restassured.response.Response;

public class ApiPatch extends GlobalConfig {
    GlobalConfig apiConf = new GlobalConfig();
    JsonHandle json = new JsonHandle();

    String[] keyUpdate = {"name"};
    String[] valueUpdate = {"tnhanphu_testing_01"};

    public Response updateRepoName (String NewName) {
        apiConf.authenticationWithPrivateToken(apiConf.BASE_URL, apiConf.token);
        response = apiConf.request
                .body(json.readOrUpdateJsonBodyFromFile("createRepo",true, keyUpdate,valueUpdate))
                .put("/user/repos/apiTesting-fw/" + NewName);
        return response;
    }
}
