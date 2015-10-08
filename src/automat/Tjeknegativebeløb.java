package automat;

public class Tjeknegativebeløb
{
	public static void main(String[] arg)
	{
		Billetautomat automat = new Billetautomat();

		int antalFejl = 0;
		int retur;
		


		System.out.println("*** Tjek af salg af en billet");
		automat.indsætPenge(-10);
		automat.udskrivBillet();
		retur = automat.returpenge();
		if (retur != 0) {
			System.out.println("FEJL, returpenge() skulle give 0, men den gav: "+retur);
			antalFejl = antalFejl + 1;
		}
		
		
		System.out.println("*** Tjek at man ikke kan købe billet hvis en billet hvis balancen er lig 0 eller under billetprisen");
		if(automat.getBalance() <= automat.getBilletpris()){
			System.out.println("Balancen er under eller lig 0: " + automat.getBalance());
			int oldbalance = automat.getBalance();
			automat.udskrivBillet(); // køb billet
			if(automat.getBalance() == oldbalance - automat.getBilletpris()){
				System.out.println("FEJL, du har netop købt en billet og har en negativ balance, "
						+ "din balance er: " + automat.getBalance());
				antalFejl = antalFejl + 1;
			}
				
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