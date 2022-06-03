package ordinario.ejercicio4;

public class ProbarEjercicio4 {

	public static void main(String[] args) {

		Bicicleta bici1, bici2, bici3;

		Turismo coche1;

		System.out.println("***Pruebas para Bicicleta - Clase padre \n");
		bici1 = new Bicicleta();
		// aceleramos
		bici1.acelerar();
		System.out.println("Después de acelerar, la velocidad es de :" + bici1.getVelocidadActual());
		bici1.acelerar();
		System.out.println("Después de acelerar, la velocidad es de :" + bici1.getVelocidadActual());
		// aceleramos varias veces
		for (int i = 0; i < 10; i++) {
			bici1.acelerar();
		}
		System.out.println("Después de acelerar 10 veces, la velocidad es de :" + bici1.getVelocidadActual());
		// frenamos
		bici1.frenar();
		System.out.println("Después de frenar, la velocidad es de :" + bici1.getVelocidadActual());
		// cambiamos plato y piñon a valores no válidos
		try {
			bici1.cambiarPlato(1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// cambiamos plato y piñon a valores válidos
		bici1.cambiarPlato(3);
		bici1.cambiarPinon(4);
		System.out.println("Después el cambio de marchas, el plato está en " + bici1.getPlatoActual()
				+ " y el pinón está en : " + bici1.getPinonActual());
		// detemenos la bicicleta
		bici1.detener();
		System.out.println("Después de detenerla la velocidad es de :" + bici1.getVelocidadActual());
		// mostramos su información
		bici1.imprime();

		
		
		
		System.out.println("\n\n***Pruebas para Bicicleta de Carrera\n");
		bici2 = new BicicletaCarrera(0, 2, 4);
		// aceleramos
		bici2.acelerar();
		System.out.println("Después de acelerar, la velocidad es de :" + bici2.getVelocidadActual());

		// aceleramos varias veces
		for (int i = 0; i < 4; i++) {
			bici2.acelerar();
		}
		System.out.println("Después de acelerar 4 veces, la velocidad es de :" + bici2.getVelocidadActual());
		// frenamos
		bici2.frenar();
		System.out.println("Después de frenar, la velocidad es de :" + bici2.getVelocidadActual());

		bici2.detener();
		System.out.println("Después de detenerla la velocidad es de :" + bici2.getVelocidadActual());
		// mostramos su información
		bici2.imprime();

		
		
		
		
		
		System.out.println("\n\n***Pruebas para Bicicleta de Tandem");
		try {
			bici3 = new BicicletaTandem(0, 2, 4,1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		bici3 = new BicicletaTandem(0, 2, 4,3);
		// aceleramos
		bici3.acelerar();
		System.out.println("Después de acelerar, la velocidad es de :" + bici3.getVelocidadActual());

		// aceleramos varias veces
		for (int i = 0; i < 10; i++) {
			bici3.acelerar();
		}
		System.out.println("Después de acelerar 10 veces, la velocidad es de :" + bici3.getVelocidadActual());
		// frenamos
		bici3.frenar();
		System.out.println("Después de frenar, la velocidad es de :" + bici3.getVelocidadActual());

		// mostramos su información
		bici3.imprime();
		
		
		
		
		
		System.out.println("\n\n ***Pruebas para Turismo \n");
		try {
			coche1 = new Turismo(50,"999Abc",500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		coche1 = new Turismo(50,"6789XYZ",500);
		// mostramos su información
				coche1.imprime();
		// aceleramos 50 km/h
		coche1.acelerar(50);
		System.out.println("Después de acelerar en 50 kh/h, la velocidad es de :" + coche1.getVelocidadActual());
		
		try {
			coche1.acelerar(50);
			System.out.println("Después de acelerar en 50 kh/h, la velocidad es de :" + coche1.getVelocidadActual());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		coche1.frenar(20);
		System.out.println("Después de frenar en 20 kh/h, la velocidad es de :" + coche1.getVelocidadActual());
		
		try {
			coche1.frenar(100);
			System.out.println("Después de acelerar en 100 kh/h, la velocidad es de :" + coche1.getVelocidadActual());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		coche1.detener();
	
		// detemenos el coche
		System.out.println("Después de detener el coche, su velocidad es  :" +coche1.getVelocidadActual());


	}

}
