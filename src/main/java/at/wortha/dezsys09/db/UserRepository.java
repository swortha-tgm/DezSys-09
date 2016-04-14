package at.wortha.dezsys09.db;

import org.springframework.data.repository.CrudRepository;


/**
 * CRUD Operations for User
 *
 * @author Simon Wortha 5BHIT
 * @version 20160311.1
 */
public interface UserRepository extends CrudRepository<User, String> {
}