package practice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grades")
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRADE_ID", unique = true, nullable = false)
	private int gradeId;

	@Column(name = "GRADE_CODE")
	private char gradeCode;

	public Grade(int gradeId, char gradeCode) {
		super();
		this.gradeId = gradeId;
		this.gradeCode = gradeCode;
	}

	@Override
	public String toString() {
		return "Grade [gradeId=" + gradeId + ", gradeCode=" + gradeCode + "]";
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public char getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(char gradeCode) {
		this.gradeCode = gradeCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gradeCode;
		result = prime * result + gradeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (gradeCode != other.gradeCode)
			return false;
		if (gradeId != other.gradeId)
			return false;
		return true;
	}

}
