package trimestre2.prueba2;

public class PruebaCuentas {

	public static void main(String[] args) {
		
		//las siguientes pruebas esperamos que produzcan un error de validación
		
		try {
			CuentaPersonal cPer_err1= 
					new CuentaPersonal(999_999, Oficinas.OFICINA1,"Carlos Herrero",10_000_000 );
		} catch (Exception e) {
			System.out.println("Se produjo el siguiente error : "+ e.getMessage());
		}
		

		try {
			CuentaPersonal cPer_err2= 
					new CuentaPersonal(9_999_999, Oficinas.OFICINA1,"Carlos Herrero",100_000_000 );
		} catch (Exception e) {
			System.out.println("Se produjo el siguiente error : "+ e.getMessage());
		}
		

		try {
			CuentaPersonal cPer_err3= 
					new CuentaPersonal(9_999_999, Oficinas.OFICINA1,"Pepe",10_000_000 );
		} catch (Exception e) {
			System.out.println("Se produjo el siguiente error : "+ e.getMessage());
		}
		

		try {
			CuentaEmpresa cEmp_err1= 
					new CuentaEmpresa(20_000_000, Oficinas.OFICINA2,"11122233","Energías Renovables SL" );
		} catch (Exception e) {
			System.out.println("Se produjo el siguiente error : "+ e.getMessage());
		}
		

		try {
			CuentaEmpresa cEmp_err2= 
					new CuentaEmpresa(20_000_000, Oficinas.OFICINA2,"G11122233","Coop" );
		} catch (Exception e) {
			System.out.println("Se produjo el siguiente error : "+ e.getMessage());
		}
		

		try {
			
		} catch (Exception e) {
			System.out.println("Se produjo el siguiente error : "+ e.getMessage());
		}
	
	
		//los siguientes objetos no deben producir errores
		
		CuentaPersonal cPer1= 
				new CuentaPersonal(9_999_999, Oficinas.OFICINA1,"Carlos Herrero",10_000_000 );
		
		CuentaEmpresa cEmp1= 
				new CuentaEmpresa(20_000_000, Oficinas.OFICINA2,"G11122233","Energías Renovables SL" );
		
		//agregamos movimientos a cada cuenta
		cPer1.agregarMovimiento("Nómina", 5000);
		cPer1.agregarMovimiento("Préstamo", -3000);
		cPer1.agregarMovimiento("Financiación", -4500);
		
		//comprobamos el saldo e interés de la cuenta Personal
		System.out.println("Saldo de cuenta personal :"+cPer1.getSaldo());  //esperamos -2500
		System.out.println("Comisión de cuenta personal :"+cPer1.calcularComisionMantenimiento());  //esperamos 100
		System.out.println("Interés de cuenta personal :"+cPer1.calcularInteres());  //esperamos 0
		
		
		cEmp1.agregarMovimiento("Constitución sociedad",100_000);
		cEmp1.agregarMovimiento("Pago proveedores", -5000);
		cEmp1.agregarMovimiento("Alquiler sede", -3500);
		
		//comprobamos el saldo e interés de la cuenta de Movimientos
		System.out.println("Saldo de cuenta empresa :"+cEmp1.getSaldo());  //esperamos +91500
		System.out.println("Comisión de cuenta empresa :"+cEmp1.calcularComisionMantenimiento());  //esperamos 200
		
		//agregamos nuevos movimientos
		cPer1.agregarMovimiento("Traspaso de cuenta", 5500);
		System.out.println("Interés de cuenta personal :"+cPer1.calcularInteres());  //ahora esperamos 15
		cEmp1.agregarMovimiento("Deudas ejercicio anterior", -31501);
		System.out.println("Comisión de cuenta empresa :"+cEmp1.calcularComisionMantenimiento());  //esperamos 400
		
		//ver info y movimientos de cada cuenta
		System.out.println("Información de la cuenta personal:");
		System.out.println(cPer1.toString());
		System.out.println("Movimientos de la cuenta personal:");
		System.out.println(cPer1.listarMovimientos());
		System.out.println("Movimientos de tipo ingreso en cuenta personal:");
		System.out.println(cPer1.listarMovimientos(0));
		
		System.out.println("Información de la cuenta empresarial:");
		System.out.println(cEmp1.toString());
		System.out.println("Movimientos de la cuenta empresarial:");
		System.out.println(cEmp1.listarMovimientos());
		
		

	}

}
