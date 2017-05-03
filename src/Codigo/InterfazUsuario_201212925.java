package Codigo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class InterfazUsuario_201212925 extends JFrame {
	
	JTabbedPane Tbp_Tablero;
	JPanel Pnl_Reporte, Pnl_Producto, Pnl_Empleados, Pnl_Clientes, Pnl_Ventas;
	JLabel Modulo_lbl;
	JButton Btn_Salir;
		
	public InterfazUsuario_201212925(String Usuario){
		setTitle("Login");
		setSize(406,326);
		setResizable(false);//No permite cambiar el tamaño de la pantalla
		setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Poder cerrar la aplicacion
		setLayout(null);
		
		Modulo_lbl = new JLabel();
		Tbp_Tablero = new JTabbedPane();
        Pnl_Reporte = new JPanel();
        Pnl_Producto = new JPanel();
        Pnl_Empleados = new JPanel();
        Pnl_Clientes = new JPanel();
        Pnl_Ventas = new JPanel();
        Btn_Salir = new JButton();
        
        if(Usuario.equals("Administrador")){
        	Tbp_Tablero.addTab("Reporte", Pnl_Reporte);
            Tbp_Tablero.addTab("Producto", Pnl_Producto);
            Tbp_Tablero.addTab("Empleados", Pnl_Empleados);
            Tbp_Tablero.addTab("Ventas", Pnl_Ventas);
            Modulo_lbl.setText("Modulo Administrador");
        }else{
            Tbp_Tablero.addTab("Clientes", Pnl_Clientes);
            Tbp_Tablero.addTab("Ventas", Pnl_Ventas);
            Modulo_lbl.setText("Modulo Vendedor");
        }
    
        Modulo_lbl.setBounds(80,10,200,30);
        Modulo_lbl.setFont(new Font("Helvetica", Font.BOLD, 14));
        Tbp_Tablero.setBounds(40, 50, 300, 200);
        
        Btn_Salir.setText("Salir");
        Btn_Salir.setBounds(260,10,80,30);
        Btn_Salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
				Login_201212925 salir = new Login_201212925();
				salir.setVisible(true);
				setVisible(false);
			}
        
        });
        
        getContentPane().add( Btn_Salir);
        getContentPane().add(Modulo_lbl);
        getContentPane().add(Tbp_Tablero);
        
		
	}
}
