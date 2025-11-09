package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Integer> { }
