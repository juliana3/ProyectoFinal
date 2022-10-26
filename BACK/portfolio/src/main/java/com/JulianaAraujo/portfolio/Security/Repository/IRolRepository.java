
package com.JulianaAraujo.portfolio.Security.Repository;

import com.JulianaAraujo.portfolio.Security.Entity.Rol;
import com.JulianaAraujo.portfolio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
