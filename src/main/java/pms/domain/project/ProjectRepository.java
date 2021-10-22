package pms.domain.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project , Long> {

	@Query(
			value = "SELECT p FROM Project p WHERE p.name LIKE %:name%",
			countQuery = "SELECT COUNT(p.id) FROM Project p WHERE p.name LIKE %:name%"
	)
	Page<Project> findAllSearch(String name, Pageable pageable);




}
