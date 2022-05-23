package mk.kalitek.firstapp.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import mk.kalitek.firstapp.constant.SecurityConstant;
import mk.kalitek.firstapp.domain.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.util.Date;


public class JWTTokenProvider {
    @Value("jwt.secret")
    private String secret;

    public String generateJwtToken(UserPrincipal userPrincipal) {
        String[] claims = getClaimsFromUser(userPrincipal);
        return JWT.create()
                .withIssuer(SecurityConstant.KALITEK_LLC)
                .withAudience(SecurityConstant.KALITEK_ADMINISTRATION)
                .withIssuedAt(new Date())
                .withSubject(userPrincipal.getUsername())
                .withArrayClaim(SecurityConstant.AUTHORITIES, claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(secret.getBytes(StandardCharsets.UTF_8)));
    }

    private String[] getClaimsFromUser(UserPrincipal userPrincipal){
        return null;
    }

}
