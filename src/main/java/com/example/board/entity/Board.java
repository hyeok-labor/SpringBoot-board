package com.example.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// DB에 테이블 보드를 인식하게 한다.
/**
 * @author Hyeok
 *
 */
@Entity
@Table(name="board")	// 데이터베이스 테이블과 매핑시킨다
public class Board {	// 테이블과 매핑시키는 역할을하는 클래스
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_idx")
	private int boardIdx;

	@Column(name="content")
	private String content;

	@Column(name="create_date")
	private String createDate="오늘날짜";

	@Column(name="create_id")
	private String createId;

	@Column(name="del_yn")
	private String delYn;

	@Column(name="hit_cnt")
	private int hitCnt;

	@Column(name="title")
	private String title;

	@Column(name="update_date")
	private String updateDate="오늘날짜";

	@Column(name="update_id")
	private String updateId;

	@Column(name="write_name")
	private String writeName;

	public int getBoardIdx() {
		return boardIdx;
	}

	public String getContent() {
		return content;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getCreateId() {
		return createId;
	}

	public String getDelYn() {
		return delYn;
	}

	public int getHitCnt() {
		return hitCnt;
	}

	public String getTitle() {
		return title;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public String getWriteName() {
		return writeName;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}

	@Override
	public String toString() {
		return "Board [boardIdx=" + boardIdx + ", title=" + title + ", content=" + content + ", hitCnt=" + hitCnt
				+ ", createDate=" + createDate + ", createId=" + createId + ", updateDate=" + updateDate + ", updateId="
				+ updateId + ", delYn=" + delYn + ", writeName=" + writeName + "]";
	}


}
