package Domain_Decomposition.service.impl;

import Domain_Decomposition.domain.User;
import Domain_Decomposition.domain.dto.AuthResponse;
import Domain_Decomposition.domain.dto.LoginRequest;
import Domain_Decomposition.domain.dto.RegisterRequest;
import Domain_Decomposition.repository.UserRepository;
import Domain_Decomposition.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public AuthResponse register(RegisterRequest request) {
        // Kiểm tra username đã tồn tại
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }
        
        // Kiểm tra email đã tồn tại
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }
        
        // Tạo user mới
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        
        // Lưu vào database
        User savedUser = userRepository.save(user);
        
        return new AuthResponse(
            savedUser.getId(),
            savedUser.getUsername(),
            savedUser.getEmail(),
            "Đăng ký thành công"
        );
    }
    
    @Override
    public AuthResponse login(LoginRequest request) {
        // Tìm user theo username
        User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new RuntimeException("Username hoặc password không đúng"));
        
        // Kiểm tra password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Username hoặc password không đúng");
        }
        
        return new AuthResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            "Đăng nhập thành công"
        );
    }
}
