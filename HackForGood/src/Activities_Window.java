import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Activities_Window {

	public JFrame frame;
	public Fecha fecha;
	JButton[][] matrix;
	int index=0;
	int[][] parciales = new int[3][2];
	Calendar c = Calendar.getInstance();
	
	Color fondo = new Color(0x5CCDC9);
	Color selecion = new Color(0x009E8E);
	Color error = new Color(0xFB000D);
	Color acierto = new Color(0x48DD00);
	
	CustomFont cf = new CustomFont();

	/**
	 * Create the application.
	 */
	public Activities_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		frame = new JFrame();
		fecha = new Fecha(c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.MONTH)-1,c.get(Calendar.YEAR));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(new GridLayout(5,6));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener event = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() instanceof JButton){
					index++;
					if(index==1) verde();
					JButton botonpulsado = (JButton)arg0.getSource();
					botonpulsado.setBackground(selecion);
					String s = botonpulsado.getToolTipText();
					String[] xy  = s.split(",");
					int x = Integer.parseInt(xy[0].trim());
					int y = Integer.parseInt(xy[1].trim());
					
					parciales[index-1][0]=x-1;
					parciales[index-1][1]=y-1;
					
					matrix[x-1][y-1].setBackground(selecion);
					if(index==3){
						for(int i=0; i<3; i++){
							if(!fecha.is(matrix[parciales[i][0]][parciales[i][1]])){
								matrix[parciales[i][0]][parciales[i][1]].setBackground(error);
							}else{
								matrix[parciales[i][0]][parciales[i][1]].setBackground(acierto);
								index--;
							}
						}
						if(index==0){
							JOptionPane.showMessageDialog(null, (Object)"Enhorabuena!");
							frame.dispose();
						
						}
						index=0;
					}
					
				}
				
			}
		};
		matrix = new JButton[5][6];
		
		for(int i=0; i<5; i++){
			for(int j=0;j<6; j++){
				JButton boton; 
				boton = new JButton(Integer.toString(i+1)+","+Integer.toString(j+1));
				frame.getContentPane().add(boton);
				boton.setToolTipText(Integer.toString(i+1)+","+Integer.toString(j+1));
				boton.addActionListener(event);
				boton.setBackground(fondo);
				boton.setFont(cf.MyFont(1, 28f));
				matrix[i][j]=boton;
			}
		}
		frame.getContentPane().repaint();
		fillMatrix(this.fecha,matrix);
		
	}
	public JFrame getFrame(){
		return this.frame;
	}
	public void  fillMatrix(Fecha fech, JButton[][] jb){
		///Llenamos la matriz con la fecha de hoy y valores aletorios
		String [][] valores = new String[5][6];
		
		for(int i=0; i<5; i++){
			for(int j=0;j<6; j++){
				String s;
				int aleat = (int)(Math.random()*10%3);
				if(aleat==1){
					//dia
					s = Integer.toString((int)((Math.random()*100)%31));
				}else if(aleat==2){
					//mes
					s = Fecha.meses[(int) (Math.random()*100)%11];
				}else{
					//a�o
					s = Integer.toString((int)Math.floor(Math.random()*(1950-2020+1)+2020));
				}
				matrix[i][j].setText(s);
			}
		}
		matrix[2][3].setText(Integer.toString(fecha.dia));
		matrix[4][1].setText(fecha.mes_s);
		matrix[4][5].setText(Integer.toString(fecha.agno));
	}
	public boolean comprobar(Fecha f, int[] array){
		return false;
	}
	public void verde(){
		for(int i=0; i<5; i++){
			for(int j=0;j<6; j++){
				matrix[i][j].setBackground(fondo);
			}
		}
	}
}
