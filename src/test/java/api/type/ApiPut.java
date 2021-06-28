package api.type;


import controller.GlobalConfig;
import controller.JsonHandle;
import controller.Utilities;
import io.restassured.response.Response;

public class ApiPut extends GlobalConfig {

    GlobalConfig apiConf = new GlobalConfig();
    JsonHandle json = new JsonHandle();
    Utilities ultil = new Utilities();

    String[] keyUpdate = {"name"};
    String[] valueUpdate = {"tuyenrepo1update2"};

    public Response  updateRepo(String oldRepoName) {
        apiConf.authenticationWithPrivateToken(apiConf.BASE_URL, apiConf.token);
        response = apiConf.request
                .body(json.readOrUpdateJsonBodyFromFile("createRepo",true, keyUpdate,valueUpdate))
                .patch("repos/"+ "apiTesting-fw/"+ oldRepoName);
        System.out.println(response.toString());
        return response;
    }

}
