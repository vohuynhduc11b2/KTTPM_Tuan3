package Domain_Decomposition.service;

import Domain_Decomposition.domain.dto.AuthResponse;
import Domain_Decomposition.domain.dto.LoginRequest;
import Domain_Decomposition.domain.dto.RegisterRequest;

public interface AuthService {
    
    AuthResponse register(RegisterRequest request);
    
    AuthResponse login(LoginRequest request);
}
