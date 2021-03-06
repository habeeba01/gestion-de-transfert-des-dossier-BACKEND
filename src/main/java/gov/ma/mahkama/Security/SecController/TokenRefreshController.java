package gov.ma.mahkama.Security.SecController;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.ma.mahkama.Security.Config.JwtUtil;
import gov.ma.mahkama.Security.SecModel.Utilisateur;
import gov.ma.mahkama.Security.SecService.AccountService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TokenRefreshController {

    private AccountService accountService;

    public TokenRefreshController(@Autowired AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping(path = "/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String authToken = request.getHeader(JwtUtil.AUTH_HEADER);
        System.out.println(authToken);
        System.out.println(authToken.startsWith("\""+JwtUtil.PREFIX));
        if(authToken!=null && authToken.startsWith(JwtUtil.PREFIX)){
            try {
                String jwt = authToken.substring(JwtUtil.PREFIX.length());
                System.out.println(new Date(System.currentTimeMillis()+(5*60*1000)));
                String jwtAccessToken = JwtUtil.createAccessTokenFromRefreshToken(jwt, request.getRequestURL().toString(), accountService);

                Map<String, String> idToken = new HashMap<>();
                idToken.put("accesstoken", jwtAccessToken);
                idToken.put("refreshtoken", jwt);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), idToken);
            }catch (Exception e){
                throw e;
            }

        }
        else throw new RuntimeException("Refresh Token Required");
    }
}
