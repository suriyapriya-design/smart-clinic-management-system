```java
package com.smartclinic.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenService {

    private final Map<String, String> tokens =
            new ConcurrentHashMap<>();

    public String generateToken(String username) {
        String token = UUID.randomUUID().toString();
        tokens.put(token, username);
        return token;
    }

    public boolean validateToken(String token) {
        return token != null && tokens.containsKey(token);
    }

    public String getUsername(String token) {
        return tokens.get(token);
    }

    public void invalidateToken(String token) {
        tokens.remove(token);
    }
}
```
