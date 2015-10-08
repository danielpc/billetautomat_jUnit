package test2;

import automat.BenytBilletautomat;
import automat.Billetautomat;

public class TjekNegativeBeloeb
{
	public static void main(String[] arg)
	{
		Billetautomat automat = new Billetautomat();

		int antalFejl = 0;
		int retur;
		
		retur = automat.getBilletpris();
		if (retur != 10) {
			System.out.println("FEJL, getBilletpris() != 10");
		}

		System.out.println("*** Tjek af salg af en billet");
		automat.indsætPenge(-10); //Burde ikke kunne indsætte penge til negativt beløb.
		automat.udskrivBillet();
		retur = automat.returpenge();
		if (retur != 0) {
			System.out.println("FEJL, returpenge() skulle give 0, men den gav: "+retur);
			antalFejl = antalFejl + 1;
		}

		System.out.println("*** Tjek af, at penge kan komme retur");
		automat.indsætPenge(-100); //ændret indsatte penge til negativt beløb.
		automat.udskrivBillet();
		retur = automat.returpenge();
		if (retur != 90) {
			System.out.println("FEJL, returpenge() skulle give 90, men den gav: "+retur);
			antalFejl = antalFejl + 1;
		}
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("Der blev fundet "+antalFejl+" fejl i automaten");
		if (antalFejl == 0) {
			System.out.println("Automaten er fejlfri, HURRA!!!");
		} else {
			System.out.println("Automaten har fejl, ØV!!!");	//programmet kører selvom brugeren indkaster negative beløb.		
		}
	}
}