package giovanni_565123.agrosatalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import giovanni_565123.agrosatalert.entity.Talhao;

@Repository
public interface TalhaoRepository extends JpaRepository<Talhao, Long> {
}