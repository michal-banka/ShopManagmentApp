package com.app.security;

public interface SecurityConstants {
    String SECRET = "SecretKeyForJwt";
    long EXPIRATION_TIME = 864_000_000; // 10 days
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
    String REGISTER_URL = "/user/register";
}
