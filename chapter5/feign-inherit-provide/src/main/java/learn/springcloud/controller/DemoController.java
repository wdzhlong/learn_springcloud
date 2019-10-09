package learn.springcloud.controller;

import java.util.Map;

import learn.springcloud.feignapi.user.User;
import learn.springcloud.feignapi.user.UserRemoteClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController implements UserRemoteClient {

    @Override
    public String getName() {
        return "yinjihuan";
    }

    @Override
    public String getUserInfo(@RequestParam("name") String name) {
        return name;
    }

    @Override
    public String getUserDetail(@RequestParam Map<String, Object> param) {
        System.err.println(param.toString());
        return param.get("name").toString();
    }

    @Override
    public String addUser(@RequestBody User user) {
        return user.getName();
    }

}
