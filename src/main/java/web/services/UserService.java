package web.services;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> userAll() {
        return userRepository.findAll();
    }

    public User userById(long id) {
      Optional<User> userFound = userRepository.findById(id);
      return userFound.orElse(null);
    }
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(long id, User userUpdate) {
        userUpdate.setId(id);
        userRepository.save(userUpdate);
    }

    @Transactional
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
