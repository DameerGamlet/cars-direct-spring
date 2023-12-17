package cars.direct.service.imp;

import cars.direct.model.User;
import org.springframework.stereotype.Service;

@Service
interface UserService {
    void create();

    void delete();

    User getUserById();

    boolean isExists(String email);
}
