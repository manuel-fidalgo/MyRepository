import javax.swing.JButton;

public class Fecha {
	public int dia;
	
	public String mes_s;
	public int mes_i;
	
	public int agno;
	
	public static String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre",
			"Octubre","Noviembre","Diciembre"};

	public Fecha(int dia, int mes, int agno){
		this.dia = dia;
		this.mes_s = meses[mes+1];
		this.mes_i = mes;
		this.agno = agno;
	}

	public boolean is(JButton matrix) {
		String s = matrix.getText();
		if(s.equalsIgnoreCase(mes_s)||s.equalsIgnoreCase(Integer.toString((agno)))||s.equalsIgnoreCase(Integer.toString(dia)))
			return true;
		else
			return false;
	}
}
