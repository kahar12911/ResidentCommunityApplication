//package com.example.residentcommunityapp.security.jwt;
//
//import java.util.logging.Logger;
//
//public class JwtUtils {
//    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
//
//    // @Value("${security.jwt.secrete}")
//    private String secret;
//    //@Value("${security.jwt.expirationTime}")
//    private Long expiration;
//
//
//    public String getSecret() {
//        return secret;
//    }
//
//    public void setSecret(String secret) {
//        this.secret = secret;
//    }
//    public Long getExpiration() {
//        return expiration;
//    }
//    public void setExpiration(Long expiration) {
//        this.expiration = expiration;
//    }
//
//    public String getJwtTokenForUser(Authentication authentication) {
//        HotelUserDetails userPrincipal = (HotelUserDetails) authentication.getPrincipal();
//        List<String> roles = userPrincipal.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority).toList();
//        return Jwts.builder()
//                .setSubject(userPrincipal.getUsername())
//                .claim("roles",roles)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + expiration))
//                .signWith(key(), SignatureAlgorithm.HS256).compact();
//    }
//
//    private Key key() {
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
//    }
//
//    public String getUserNameFromToken(String token) {
//        return Jwts.parserBuilder().setSigningKey(key()).build()
//                .parseClaimsJws(token).getBody().getSubject();
//
//    }
//
//    public boolean validateToken(String token) {
//        try{
//            Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token);
//            return true;
//        }catch (MalformedJwtException e){
//            logger.error("Invalid JWT token : {}", e.getMessage());
//        }catch (ExpiredJwtException e){
//            logger.error( "expired JWT token : {}", e.getMessage());
//        }catch (UnsupportedJwtException e){
//            logger.error( "unsupported JWT token : {}", e.getMessage());
//        }catch (IllegalArgumentException e){
//            logger.error("JWT token could not be parsed");
//        }
//        return false;
//    }
//}
