package example.atp.repositories;

import java.util.List;
import java.util.Optional;

import example.atp.domain.Owner;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;

// The @JdbcRepository annotation indicates the database dialect
@JdbcRepository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    @Override
    List<Owner> findAll();

    // This method will compute at compilation time a query such as
    // SELECT ID, NAME, AGE FROM OWNER WHERE NAME = ?
    Optional<Owner> findByName(String name);
}