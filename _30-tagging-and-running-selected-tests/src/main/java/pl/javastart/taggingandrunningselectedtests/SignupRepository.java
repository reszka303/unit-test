package pl.javastart.taggingandrunningselectedtests;

import java.util.Set;

public interface SignupRepository {

    Set<Signup> findByUserId(Long userId);
    void save(Signup signup);

}
