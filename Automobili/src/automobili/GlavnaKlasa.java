package automobili;

public class GlavnaKlasa {

	public static void main(String[] args) {
		
		Metode metode = new Metode();
		//metode.ubaciMarku("Fiat", "Italija");
		Marke m = metode.vratimarkuAutomobila(2);
		System.out.println(m.getImeMarke() + " " + m.getZemlja());
		Marke x = new Marke();
		x.setImeMarke("Pera");
		System.out.println(x.getImeMarke());
	}

}
