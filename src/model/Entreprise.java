package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the entreprise database table.
 * 
 */
@Entity
@NamedQuery(name="Entreprise.findAll", query="SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="chiffre_affaire")
	private String chiffreAffaire;

	private String effectif;

	private String nom;

	private String secteur;

	@Column(name="site_web")
	private String siteWeb;

	private byte valide;

	//bi-directional many-to-one association to Contract
	@OneToMany(mappedBy="entreprise")
	private List<Contract> contracts;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="entreprise")
	private List<Utilisateur> utilisateurs;

	public Entreprise() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChiffreAffaire() {
		return this.chiffreAffaire;
	}

	public void setChiffreAffaire(String chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}

	public String getEffectif() {
		return this.effectif;
	}

	public void setEffectif(String effectif) {
		this.effectif = effectif;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSecteur() {
		return this.secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public String getSiteWeb() {
		return this.siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public byte getValide() {
		return this.valide;
	}

	public void setValide(byte valide) {
		this.valide = valide;
	}

	public List<Contract> getContracts() {
		return this.contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public Contract addContract(Contract contract) {
		getContracts().add(contract);
		contract.setEntreprise(this);

		return contract;
	}

	public Contract removeContract(Contract contract) {
		getContracts().remove(contract);
		contract.setEntreprise(null);

		return contract;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setEntreprise(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setEntreprise(null);

		return utilisateur;
	}

}