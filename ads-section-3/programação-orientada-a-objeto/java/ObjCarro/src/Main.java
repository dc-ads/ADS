import main.*;

public class Main {
    public static void  main(String[] args) {
		Carro carro1 = new Carro("Honda Civic", "BR20E4", "Preto");

		Pessoa pessoa1 = new Pessoa("Fernanda", 25, true);
		
		pessoa1.showDatas();

		pessoa1.setWinCar(carro1);
		pessoa1.sairDoCarro();

		// pessoa1.entrarNoCarro();
		// pessoa1.dirigirCarro();

		// pessoa1.carro.acelerar();
		// pessoa1.carro.acelerar();

		// pessoa1.entrarNoCarro();

		// pessoa1.sairDoCarro();
		// pessoa1.dirigirCarro();

		// pessoa1.carro.acelerar();
		// pessoa1.carro.acelerar();
		// pessoa1.carro.acelerar();
		// pessoa1.carro.acelerar();

		// pessoa1.pararOCarro();
		// pessoa1.carro.frear();
		// pessoa1.desligarCarro();

		// pessoa1.carro.acelerar();

		// pessoa1.showPersonalData();
	}
}
