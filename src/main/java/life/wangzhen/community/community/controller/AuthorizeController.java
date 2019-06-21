package life.wangzhen.community.community.controller;

import life.wangzhen.community.community.dto.AccessTokenDTO;
import life.wangzhen.community.community.dto.GithubUser;
import life.wangzhen.community.community.mapper.UserMapper;
import life.wangzhen.community.community.model.User;
import life.wangzhen.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUserer = githubProvider.getUser(accessToken);
        if(githubUserer !=null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUserer.getName());
            user.setAccountId(String.valueOf(githubUserer.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGetModified(user.getGetModified());
            userMapper.insert(user);
            //登录成功，写cookie和session
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else{
            return "redirect:/";
            //登录失败
        }
    }
}
