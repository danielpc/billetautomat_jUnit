package test;

import automat.BenytBilletautomat;
import automat.Billetautomat;

public class TjekBilletautomatBestilBilletUdenPenge
{
	public static void main(String[] arg)
	{
		Billetautomat automat = new Billetautomat();

		int antalFejl = 0;
		int retur;
		
		
		System.out.println("*** Tjek af, at der ikke kan købes en billet uden penge");
		System.out.println("Balancen er: "+automat.getBalance()+"\nDer bestilles billet");
		automat.udskrivBillet();
		System.out.println("");
		retur = automat.getBalance();
		if (retur <0 ) {
			System.out.println("Der kan udskrives en billet uden nogen penge, balancen er: "+retur);
			antalFejl = antalFejl + 1;
		}
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("Der blev fundet "+antalFejl+" fejl i automaten");
		if (antalFejl == 0) {
			System.out.println("Automaten er fejlfri, HURRA!!!");
		} else {
			System.out.println("Automaten har fejl, ØV!!!");			
		}
	}
}