/**
 * Represents a JWTTokenHepper
 *
 * @author P Tr Xuan
 * Created on Sep 14, 2021
 */
package com.vti.ultis;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * Represents a JWTTokenHepper
 *
 * 
 * @author P Tr Xuan Created on Sep 14, 2021
 */
@Component
public class JWTTokenHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	@Value("${app.name}")
	private String APP_NAME;

	@Value("${jwt.secret}")
	private String SECRET;

	@Value("${jwt.expires_in}")
	private int EXPIRES_IN;

	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = this.getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}

		return username;

	}

	public String generateToken(String username) {
		String jws = Jwts.builder().setIssuer(APP_NAME).setSubject(username).setIssuedAt(generateCurrentDate())
				.setExpiration(generateExpirationDate()).signWith(SIGNATURE_ALGORITHM, SECRET).compact();

		return jws;

	}

	/**
	 * @param token
	 * @return
	 *
	 * @author P Tr Xuan Created on Sep 14, 2021
	 */

	public Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(this.SECRET).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	/**
	 * @return
	 *
	 * @author P Tr Xuan Created on Sep 14, 2021
	 */

	private long getCurrentTimeMillis() {
		ZoneId zdt = ZoneId.systemDefault();
		return LocalDateTime.now().atZone(zdt).toEpochSecond() * 1000;
	}

	/**
	 * @return
	 *
	 * @author P Tr Xuan Created on Sep 14, 2021
	 */

	private Date generateExpirationDate() {

		return new Date(getCurrentTimeMillis() + this.EXPIRES_IN * 1000);
	}

	/**
	 * @return
	 *
	 * @author P Tr Xuan Created on Sep 14, 2021
	 */

	private Date generateCurrentDate() {

		return new Date(getCurrentTimeMillis());
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException ex) {
			System.out.println("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			System.out.println("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			System.out.println("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			System.out.println("JWT claims string is empty.");
		}
		return false;
	}
}
