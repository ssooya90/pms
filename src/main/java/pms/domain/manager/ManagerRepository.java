package pms.domain.manager;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository extends JpaRepository<Manager , Long> {

	@Query("SELECT m FROM Manager m WHERE m.member.userId = :member_id ORDER BY m.id DESC")
	Page<Manager> findAllByMemberId(Pageable pageable, @Param("member_id") String member_id);

//	Page<Manager> findAllByMemberId(Pageable pageable, String member_id);
}
