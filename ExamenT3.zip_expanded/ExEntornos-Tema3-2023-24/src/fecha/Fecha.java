package fecha;

public class Fecha {
	private static final int DIEZ = 10;
	private int d; //d�a
	private int mes; //mes
	private int a; //a�o

	
	public Fecha() {

	}

	
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.mes = mes;
		this.a = anio;
	}

	
	
	public boolean fechaCorrecta() {
		boolean diaCorrecto; 
		boolean mesCorrecto; 
		boolean anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = d >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && d <= 29;
			} else {
				diaCorrecto = diaMayor1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && d <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		return a % 4 == 0 && a % 100 != 0 || a % 400 == 0;
	}

	// M�todo diaSiguiente
	public void  nextDay() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				a++;
			}
		}
	}

	// M�todo toString
	public String toString() {
		if (d < DIEZ && mes < DIEZ) {
			return "0" + d + "-0" + mes + "-" + a;
		} else if (d < DIEZ && mes >= DIEZ) {
			return "0" + d + "-" + mes + "-" + a;
		} else if (d >= DIEZ && mes < DIEZ) {
			return d + "-0" + mes + "-" + a;
		} else {
			return d + "-" + mes + "-" + a;
		}
	}

}
