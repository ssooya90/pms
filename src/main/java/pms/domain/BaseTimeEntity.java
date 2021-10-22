package pms.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Created by ssooya90@naver.com on 2020-03-31
 * Github : http://github.com/ssooya90
 */


// 기존 JAVA의 Date와 Calendar의 문제점을 해결한 객체
// LocalDate, LocalDatetTime;


@Getter
@MappedSuperclass // Jpa entity 클래스들이 해당 Entity를 상속할 경우 필드를 cratedDate, modifedDAte로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) // 해당 클래스에 Auditing 기능을 포함시킴
public abstract class BaseTimeEntity {

	@CreatedDate // Entity가 생성되어 자장될 때 시간이 자동 저장
	@Column(updatable = false)
	private LocalDateTime createdDate;

	@LastModifiedDate // 조회한 entity의 값이 변경될 때 자동저장
	private LocalDateTime modifiedDate;

}
