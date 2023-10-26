package kr.spring.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity // MySQL에 데이터 테이블을 생성해줌(CREATE TABLE)
@Data
@ToString
public class Member {
	
	@Id
	private String username; //Spring Sequrity에서는 id가 아닌 username으로 지정, 기본키이므로 Id
	
	private String password; //Spring sequrity에서는 pw가 아닌 password로 지정
	
	@Enumerated(EnumType.STRING)  //@Enumerated ->열거형(권한이 여러개 이기 떄문에)
	private Role role;  //권한 정보                         role, username,password는 필수
	
	private String name; //이름
	
	private boolean ebled; // 계정 활성화/비활성화 
}
