package automat;

public class Tjekmontør
{
	public static void main(String[] arg)
	{
		Billetautomat automat = new Billetautomat();

		int antalFejl = 0;
		int retur;
		
	
		System.out.println("*** Tjek af at man ikke kan sætte en billet til negative værdier");
		automat.setBilletpris(-20);
		if (automat.getBilletpris() <= 0) {
			System.out.println("FEJL, setBilletpris(-20) fejl, men gav billetpris til: " + automat.getBilletpris());
			antalFejl = antalFejl + 1;
		}
		
		System.out.println("\n\n");
		
		System.out.println("*** Tjek af at man ikke ændre billetpris uden at være logget ind som montør");
		automat.setBilletpris(20);
		if(automat.getBilletpris() == 20 && automat.erMontør() == false){
			System.out.println("FEJL, du kan ændre setBilletpris() uden at være logget ind, "
								+ "billetprisen burde koste 10, men koster: " + automat.getBilletpris());
			antalFejl = antalFejl + 1;		
		}
		
		System.out.println("\n\n");
		
		System.out.println("*** Tjek at ved ændring af billetpris, ikke ændre pris for de tidligere købte billeter");
		automat.returpenge();// vi nullstiller balancen. 
		automat.setBilletpris(10); // nulstil til 10 igen
		automat.indsætPenge(20);
		System.out.println("Der er " + automat.getBalance() + " på kontoen");
		automat.udskrivBillet();
		automat.montørLogin("1234"); 
		int gammelindkomst = automat.getTotal();
		automat.setBilletpris(100);
		int nyindkomst = automat.getTotal();
		if(gammelindkomst != nyindkomst){
			System.out.println("FEJL, inkomdst burde være  " + gammelindkomst + " men er " + nyindkomst);
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