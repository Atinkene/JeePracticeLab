package dao;

import java.util.ArrayList;
import beans.Utilisateur;

public class UtilisateurDao {
	private static int currentId = 1;
	private static  ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
	
	
	public static Utilisateur trouverParId(int id) {
		for (Utilisateur utilisateur : listeUtilisateurs) {
			if (utilisateur.getId() == id) {
				return utilisateur;
			}
		}

		return null;
	}
	
	
	public static ArrayList<Utilisateur> lister() {
		return new ArrayList<>(listeUtilisateurs);
	}
	
	
	 public static void ajouter(Utilisateur utilisateur) {
	        utilisateur.setId(currentId++);
	        listeUtilisateurs.add(utilisateur);
	 }
	 
	 
	public static boolean modifier(int id, Utilisateur user) {
		for (Utilisateur utilisateur : listeUtilisateurs) {
			
			if ( utilisateur.getId() == id ) {
				
				utilisateur.setPrenom( user.getPrenom() );
				utilisateur.setNom( user.getNom() );
				utilisateur.setLogin( user.getLogin() );
				utilisateur.setPassword( user.getPassword() );
				
				return true;
				
			}
			
		}
		return false;
	} 
	
	public static boolean supprimer(int id) {
		for (Utilisateur utilisateur : listeUtilisateurs) {
			if ( utilisateur.getId() == id ) {
				listeUtilisateurs.remove(utilisateur);
				return true;
			}
			
		}
		return false;
	}
}

