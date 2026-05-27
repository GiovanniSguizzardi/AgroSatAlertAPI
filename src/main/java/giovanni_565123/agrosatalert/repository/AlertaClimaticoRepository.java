package giovanni_565123.agrosatalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import giovanni_565123.agrosatalert.entity.AlertaClimatico;

import java.util.List;

@Repository
public interface AlertaClimaticoRepository extends JpaRepository<AlertaClimatico, Long> {
    List<AlertaClimatico> findByTalhaoId(Long talhaoId);
}
