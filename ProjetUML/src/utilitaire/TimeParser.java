package utilitaire;

public class TimeParser {
	
	public String strRepr;
	public double realRepr;
	
	public TimeParser(String chrono){
		this.strRepr = chrono;
		this.convToReal();
	}
	
	public TimeParser(double secondes){
		this.realRepr = secondes;
		this.convToString();
	}
	
	public String getStrRepr() {
		return strRepr;
	}

	public double getRealRepr() {
		return realRepr;
	}

	private void convToReal(){
		int nombre = 0;
		String[] temps = this.strRepr.split(":");
		nombre += Double.parseDouble(temps[0])*3600;
		nombre += Double.parseDouble(temps[1])*60;
		nombre += Double.parseDouble(temps[2]);
		this.realRepr = nombre;
	}
	
	private void convToString(){
		double nombreTmp = this.realRepr;
		
		int heures = (int)(nombreTmp/3600);
		nombreTmp -= heures*3600;
		int minutes = (int)(nombreTmp/60);
		nombreTmp -= minutes*60;
		int sec = (int)nombreTmp;
		
		String heuresStr = String.valueOf(heures);
		if(heuresStr.length()==1){
			heuresStr = "0" + heuresStr;
		}
		
		String minutesStr = String.valueOf(minutes);
		if(minutesStr.length()==1){
			minutesStr = "0" + minutesStr;
		}
		
		String secondesStr = String.valueOf(sec);
		if(secondesStr.length()==1){
			secondesStr = "0" + secondesStr;
		}		
		
		this.strRepr = heuresStr + ":" + minutesStr + ":" + secondesStr;
	}
	
	public String toString(){
		return this.strRepr;
	}
	
}
