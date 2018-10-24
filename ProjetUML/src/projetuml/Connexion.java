package projetuml;

import java.util.*;

public class Connexion {
	HashMap<String, String> conn;
	HashMap<String, String> auth;
	
	public Connexion() {
		this.conn = new HashMap<String, String>();
		this.auth = new HashMap<String, String>();
	}
	
	//pout tester
	public HashMap<String, String> getConn() {
		return conn;
	}

	public void addNewConn(String em, String mdp, String au) {
		this.conn.put(em, mdp);
		this.auth.put(em, au);
	}
	
	public boolean checkConn(String em, String mdp) {
		return this.conn.get(em)==mdp;
	}
	
	public String getAuth(String em) {
		return this.auth.get(em);
	}
}
