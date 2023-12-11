package items.repositories;

import items.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
    List<Item> findItemsByList(String list);
    Optional<Item> findById(UUID id);
    void deleteById(UUID id);
}
