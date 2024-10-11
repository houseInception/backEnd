package houseInception.gptComm.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long tokenValidTime;

    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwt<Header, Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            log.error("ExpiredJwtException: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("UnsupportedJwtException: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("MalformedJwtException: {}", e.getMessage());
        } catch (SignatureException e) {
            log.error("SignatureException: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
        }
        return false;
    }
}
