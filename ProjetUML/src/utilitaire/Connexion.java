package utilitaire;

import java.io.FileNotFoundException;
import java.util.*;
import utilitaire.DataExtractor;

public class Connexion {
    //peut aussi faire une collection
	HashMap<String, String> conn;
	HashMap<String, String> auth;
	
	public Connexion(){
		this.conn = new HashMap<String, String>();
		this.auth = new HashMap<String, String>();
                try{
                    this.chargerConn();                    
                }catch(FileNotFoundException ex){
                    ex.printStackTrace();
                }
	}

	public void addNewConn(String em, String mdp, String au) {
		this.conn.put(em, mdp);
		this.auth.put(em, au);
	}
	
	public boolean checkConn(String em, String mdp) {
            if(this.conn.containsKey(em)){
                return this.conn.get(em).equals(mdp);                
            } else {
                return false;
            }
	}
        
        public boolean checkConnExist(String em){
            return this.conn.containsKey(em);
        }

        public HashMap<String, String> getConn() {
            return conn;
        }
	
	public String getAuth(String em) {
		return this.auth.get(em);
	}
        
        private void chargerConn() throws FileNotFoundException{
            DataExtractor test = new DataExtractor();
            test.extractConn(this, "./data/Connexion.csv");

            Iterator<String> itConn;
            itConn = this.conn.keySet().iterator();
            while(itConn.hasNext()) {
                String em = itConn.next();
                System.out.println("Email : " +em+", Mot de pass : " +this.conn.get(em));
            }
        }
}
