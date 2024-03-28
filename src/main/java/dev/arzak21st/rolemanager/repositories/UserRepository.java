package dev.arzak21st.rolemanager.repositories;

import dev.arzak21st.rolemanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByUserId(int userId);

    int countByRolesName(String name);
}
