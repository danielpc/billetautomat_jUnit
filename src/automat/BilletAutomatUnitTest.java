package automat;

import static org.junit.Assert.*;

import org.junit.Test;

public class BilletAutomatUnitTest {

	@Test
	public void testGetBilletpris() 
	{
		Billetautomat b = new Billetautomat();
		assertEquals(10, b.getBilletpris());
	}

	
	@Test
	public void testNegativeValue()
	{
		Billetautomat b = new Billetautomat();
		b.indsætPenge(-10);
		assertEquals(0, b.getBalance());
	}
	
	@Test
	public void testSetNegativeTicketValue()
	{
		Billetautomat b = new Billetautomat();
		b.montørLogin("1234");
		b.setBilletpris(-10);
		assertEquals(10, b.getBilletpris());
	} 
	
	@Test
	public void testSetTicketValue()
	{
		Billetautomat b = new Billetautomat();
		b.setBilletpris(20);
		assertEquals(10, b.getBilletpris());
	}
	
	@Test
	public void testTotalAfterPriceChange()
	{
		Billetautomat b = new Billetautomat();
		b.indsætPenge(20);
		b.udskrivBillet();
		b.montørLogin("1234");
		int oldTotal = b.getTotal();
		b.setBilletpris(100);
		assertEquals(oldTotal, b.getTotal());
	}
	

}
