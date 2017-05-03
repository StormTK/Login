package Codigo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login_201212925 extends JFrame {

	JTextField tfd_usuario, tfd_contraseña; 
	JLabel txt_login, txt_nombre, txt_contraseña;
	JButton btn_aceptar;
	
	public Login_201212925(){
		Componentes();
	}
	
	public void Componentes(){
		setTitle("Login");
		setSize(406,286);//El tamaño es de 800x600
		setResizable(false);//No permite cambiar el tamaño de la pantalla
		setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Poder cerrar la aplicacion
		setLayout(null);
		
		btn_aceptar = new JButton();
		txt_login = new JLabel();
		txt_nombre = new JLabel();
		txt_contraseña = new JLabel();
		tfd_usuario = new JTextField();
		tfd_contraseña = new JTextField();
		
		txt_login.setText("Login");
		txt_login.setBounds(160,20,150,30);
		txt_login.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		txt_nombre.setText("Usuario");
		txt_nombre.setBounds(20,70,100,30);
		txt_nombre.setFont(new Font("Helvetica", Font.BOLD, 12));
		
		tfd_usuario.setBounds(140,70,150,30);
		
		txt_contraseña.setText("Password");
		txt_contraseña.setBounds(20,120,100,30);
		txt_contraseña.setFont(new Font("Helvetica", Font.BOLD, 12));
		
		tfd_contraseña.setBounds(140,120,150,30);
		
		btn_aceptar.setText("Acceder");
		btn_aceptar.setBounds(140,180,100,30);
		btn_aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean usuarioexiste = false;
				try {
					 FileReader Archivo = new FileReader("src\\Usuarios.txt");
					 BufferedReader lector = new BufferedReader(Archivo);
					 String txt_leido;
					 while((txt_leido = lector.readLine()) != null){
						 StringTokenizer Token = new StringTokenizer(txt_leido,",");
						 String No_Usuario = Token.nextToken();
						 String Name_Usuario = Token.nextToken();
						 String Pass_Usuario = Token.nextToken();
						 String Tipo_Usuario = Token.nextToken();
						 
						 if(Name_Usuario.equals(tfd_usuario.getText())){
							 if(Pass_Usuario.equals(tfd_contraseña.getText())){
								 InterfazUsuario_201212925 iniciar = new InterfazUsuario_201212925(Tipo_Usuario);
								 iniciar.setVisible(true);
								 usuarioexiste = true;
								 setVisible(false);
							 }else{
								 JOptionPane.showMessageDialog(null,"Contraseña Incorrecta");
								 usuarioexiste = true;
							 }
						 }
					 }
					 if(usuarioexiste == false){
						 JOptionPane.showMessageDialog(null,"Este Usuario no existe");
					 }
					 Archivo.close();
			     } catch (IOException evt) {
			    	 JOptionPane.showMessageDialog(null,"Error en el Programa! Vuela a intentarlo otra vez...");
			     }
	        }
	    });
		
		getContentPane().add(txt_login);
		getContentPane().add(txt_nombre);
		getContentPane().add(txt_contraseña);
		getContentPane().add(tfd_usuario);
		getContentPane().add(tfd_contraseña);
		getContentPane().add(btn_aceptar);
	}
	
}
