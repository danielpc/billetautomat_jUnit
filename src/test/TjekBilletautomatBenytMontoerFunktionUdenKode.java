package test;

import automat.BenytBilletautomat;
import automat.Billetautomat;


public class TjekBilletautomatBenytMontoerFunktionUdenKode
{
	public static void main(String[] arg)
	{
		Billetautomat automat = new Billetautomat();

		int antalFejl = 0;
		int retur;
		
		System.out.println("*** Tjek af, at brugere ikke kan bruge montørfunktionen, og sætte ny billetpris");
		automat.setBilletpris(50);
		retur = automat.getBilletpris();
		if (retur == 50) {
			System.out.println("FEJL,getBilletpris(); skulle give 10, men den gav: "+retur);
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