package kr.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity // Board VO가 Database Table로 만들 때 설정
@Data
@ToString
public class Board { // VO < --- ORM ---> TABLE
   
   @Id // PK 의미   // 1씩 증가하면서 넣기 -> auto_increment와 같음
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idx; // 게시글 고유번호 (호환을 위해서 long형으로 해줌)
   private String title;
   
   @Column(length = 2000) // 길이지정 -> 길이지정 따로 안할 때 길이 255
   private String content;
   
   @Column(updatable = false) // 수정할 때 작성자는 안바꿔 주겠다
   private String writer;
   
   @Column(insertable = false, updatable = false, columnDefinition = "datetime default now()")
   private Date indate;
   
   @Column(insertable = false, updatable = false, columnDefinition = "int default 0")
   private Long count;
}