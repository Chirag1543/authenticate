package com.security.oauth;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class UserService {

    @Autowired
    private UserRepository1 userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Update user details using PUT
    @Transactional(rollbackFor = Exception.class)
    public String updateUserDetails(Long id, String name, String email, String password) {
        // Find user by ID
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // Update the name and email
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        // Save the updated user back to the database
        userRepository.save(user);
        return "User updated successfully";
    }

    // Delete user by ID using DELETE
    @Transactional(rollbackFor = Exception.class)
    public String deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}






