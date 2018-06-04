package Controleur;

import java.sql.Date;
import java.sql.Time;

public class Datel {

	private Date date;
        private Time heure;

	public Datel(Date date, Time heure) {
		this.date = date;
                this.heure = heure;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
        
        public Time getHeureDepart(){
            return this.heure;
        }
        
        public void setHeureDepart(Time heure){
            this.heure = heure;
        }
        
        @Override
        public String toString(){
            return this.date.toString() + " " + this.heure.toString();
        }
	
	
}
