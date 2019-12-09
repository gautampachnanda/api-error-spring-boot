package org.pachnanda.apierrorspringboot.repository;

import org.pachnanda.apierrorspringboot.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

}
