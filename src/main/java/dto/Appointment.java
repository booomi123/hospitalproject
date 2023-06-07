package dto;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

  @Entity
	public class Appointment {
	  @Id
		private int id;
		private String Problem;
		private LocalDateTime DateTime;

		
		@ManyToOne
		Doctor11 doctor;
		
		@ManyToOne
		Paitent p;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getProblem() {
			return Problem;
		}

		public void setProblem(String problem) {
			Problem = problem;
		}

		public LocalDateTime getDateTime() {
			return DateTime;
		}

		public void setDateTime(LocalDateTime dateTime) {
			DateTime = dateTime;
		}

		public Doctor11 getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor11 doctor) {
			this.doctor = doctor;
		}

		public Paitent getP() {
			return p;
		}

		public void setP(Paitent p) {
			this.p = p;
		}

}
