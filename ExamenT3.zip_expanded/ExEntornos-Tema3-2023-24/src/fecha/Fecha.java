package fecha;
/**
 * En esta clase llamada Fecha tenemos varias variables privadas
 * declaradas 
 * 
 * @author hectoraias
 */
public class Fecha {
	/**
	 * Variable int declarada para el dia
	 */
	private int d; //d�a
	/**
	 * Variable int declarada para el mes
	 */
	private int m; //mes
	/**
	 * Variable int declarada para el año
	 */
	private int a; //a�o

	/**
	 * Constructor sin parametros
	 */
	public Fecha() {

	}

	/**
	 * Constructor con parámetros
	 * @param dia Este parámetro es el dia
	 * @param mes Este parámetro es el mes
	 * @param anio Este parámetro es el anio
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Este metodo te calcula si la fecha es correcta
	 * @return devolvera un true/false dependiendo del resulta
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}
	/**
	 * Metodo para calcular si es anio bisiesto, solo usa la fecha correcta
	 * @return envia un boolean es decir true/false dependiendo del resultado
	 */
	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}
	/**
	 * Metodo para calcular el dia siguiente de la fechaCorrecta 
	 */
	// M�todo diaSiguiente
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}
	/**
	 * En este metodo  es para enviar el mensaje del dia mes y anio
	 * @return dependiendo de la fecha manda un orden del mensaje difrente
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
