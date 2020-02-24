/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionentrepot.enteties;

import java.util.Objects;

/**
 *
 * @author PC
 */
public class Vehicule {
    private int mat;
	private String marque;
	private String etat;
	
	public Vehicule() {
		
	}

	public Vehicule(int mat, String marque , String etat) {
		
		this.mat = mat;
		this.marque = marque;
		this.etat=etat;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicule other = (Vehicule) obj;
        if (this.mat != other.mat) {
            return false;
        }
        if (!Objects.equals(this.marque, other.marque)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        return true;
    }

	


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Vehicule [mat=" + mat + ", marque=" + marque + ", etat=" + etat + "]";
	}
}

