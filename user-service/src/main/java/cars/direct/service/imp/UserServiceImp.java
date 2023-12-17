package cars.direct.service.imp;

import cars.direct.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Override
    public void create() {

    }

    @Override
    public void delete() {

    }

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public boolean isExists(String email) {
        return false;
    }
}
