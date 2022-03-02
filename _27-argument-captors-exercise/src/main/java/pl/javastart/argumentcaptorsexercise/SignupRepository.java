package pl.javastart.argumentcaptorsexercise;

import java.util.Set;

public interface SignupRepository {

    Set<Signup> findByUserId(Long userId);
    void save(Signup signup);

}
