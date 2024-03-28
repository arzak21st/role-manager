package dev.arzak21st.rolemanager.repositories;

import dev.arzak21st.rolemanager.models.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByName(String name);
    List<Role> findRolesByName(String name);
}
