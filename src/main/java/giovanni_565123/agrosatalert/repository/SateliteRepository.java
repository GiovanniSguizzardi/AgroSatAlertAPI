package giovanni_565123.agrosatalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import giovanni_565123.agrosatalert.entity.Satelite;

@Repository
public interface SateliteRepository extends JpaRepository<Satelite, Long> {
}
