package dmp.beeline.ru.demo.service;

import dmp.beeline.ru.demo.model.User;
import dmp.beeline.ru.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(RuntimeException::new);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(long id, User user) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setEmail(user.getEmail());
                    u.setFirstName(user.getFirstName());
                    u.setPhone(user.getPhone());
                    u.setLastName(user.getLastName());
                    return userRepository.save(u);
        }).orElseThrow();
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
