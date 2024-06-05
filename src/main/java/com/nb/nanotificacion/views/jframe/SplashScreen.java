package com.nb.nanotificacion.views.jframe;


import javax.swing.JFrame;
import javax.swing.JPanel;

import com.nb.nanotificacion.core.Core;
import com.nb.nanotificacion.core.CoreJob;
import com.nb.nanotificacion.core.Ln;
import com.nb.nanotificacion.models.Notificacion;
import com.nb.nanotificacion.models.Opciones;
import com.nb.nanotificacion.models.TiempoNotificacion;
import com.nb.nanotificacion.models.core.EM;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;
import java.io.File;
import java.awt.Font;


import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;

public class SplashScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textAreaLog;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	
	public SplashScreen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SplashScreen.class.getResource("/com/nb/nanotificacion/resources/iconNaNo.png")));
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 440);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(0, 426, 550, 14);
		contentPane.add(progressBar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.setBounds(100, 165, 440, 260);
		contentPane.add(scrollPane);
		
		textAreaLog = new JTextArea();
		textAreaLog.setFont(new Font("Monospaced", Font.BOLD, 11));
		textAreaLog.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textAreaLog.setEditable(false);
		textAreaLog.setOpaque(false);
		scrollPane.setViewportView(textAreaLog);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/com/nb/nanotificacion/resources/fondo NA Notificacion.png")));
		lblNewLabel.setBounds(0, 0, 550, 427);
		contentPane.add(lblNewLabel);
		scrollPane.getViewport().setOpaque(false);
		cargaSplash();
	}
	
	
	public void cargaSplash() {
		final JFrame This = this;
		Runnable run = new Runnable() {
			
			
			
			public void log(String text) {
				textAreaLog.append(text+"\n");
				textAreaLog.setCaretPosition(textAreaLog.getDocument().getLength());
				//System.out.println(text);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void run() {
				
				try {
					progressBar.setIndeterminate(true);
					//progressBar.setStringPainted(true);
					//Buscando que no sea la primera vez
					log("Buscando elementos para iniciar correctamente");
					File root = new File("");
					File dbCarp = new File(root.getAbsolutePath()+"/BD/");
					File db = new File(dbCarp.getAbsolutePath()+"/DB_NA.mv.db");
					//System.out.println(root.getAbsolutePath());
				    log("Buscando Base de datos en la ruta:");
				    log(db.getAbsolutePath());
					log("Existe: "+db.exists());
					if(!db.exists()) {
						log("Creando ruta:"+String.valueOf(dbCarp.mkdirs()).toUpperCase()   );
						log("Iniciando Base de datos");
						//System.out.println(db.getAbsolutePath());
					    EM.initManager(dbCarp.getAbsolutePath()+"/DB_NA");
					    log("Creando datos iniciales para: Prioridad Notificacion");
					    TiempoNotificacion not =  new TiempoNotificacion("Cada 1 Min.", "0 0/1 * * * ?").save();
					    new TiempoNotificacion("Cada 5 Min.", "0 0/5 * * * ?").save();
					    new TiempoNotificacion("Cada 10 Min.", "0 0/10 * * * ?").save();
					    new TiempoNotificacion("Cada 15 Min.", "0 0/15 * * * ?").save();
					    new TiempoNotificacion("Cada 30 Min.", "0 0/30 * * * ?").save();
					    new TiempoNotificacion("Cada Hora", "0 0 0/2 * * ?").save();
					    new TiempoNotificacion("Cada 2 Horas", "0 0 0/2 * * ?").save();
					    new TiempoNotificacion("Cada 3 Horas", "0 0 0/3 * * ?").save();
					    new TiempoNotificacion("Cada 2 Horas los Lun,Mier,Vier","0 0 0/2 ? * MON,WED,FRI *").save();
					    //System.out.println("Notificacion insertada : "+not.getId());
					    new Notificacion("Ejemplo inicial", "Ejemplo:\nSe cargo automaticamente este ejmplo y se ejecuta cada minuto", not).save();
					}else {
						log("Iniciando Base de datos");
						//System.out.println(db.getAbsolutePath());
					    EM.initManager(dbCarp.getAbsolutePath()+"/DB_NA");
					}
				
					
					
				
					Ln ln =null;
				    
				    
					//Buscando carpeta de idiomas
					log("Verificando carpeta de idiomas");
					File carpIdioma = new File(root.getAbsolutePath()+"/idiomas/");
					if(!carpIdioma.exists()) {
						log("Creando carpeta de idiomas");
						carpIdioma.mkdir();
					}
					
					//Creando archivo es.properties
//					File lnEspa = new File(carpIdioma.getAbsolutePath()+"/es.properties");
//					if(!lnEspa.exists()) {
//						lnEspa.createNewFile();
//					}
//					
					//verificando que idioma esta activo
					if(db.exists()) {
						log("Buscando ubicacion de idiomas");
						Opciones idiomaUbi = Opciones.find("llave = ?", "sistema.idiomas.ubicacion").first();
						if(idiomaUbi== null) {
							idiomaUbi = new Opciones("sistema.idiomas.ubicacion",carpIdioma.getAbsolutePath()).save();
						}
						//System.out.println("carpetaidiomas: "+idiomaUbi.getValor());
						Opciones opt = Opciones.find("llave = ?", "sistema.idiomas.activo").first();
						if(opt==null) {
							opt = new Opciones("sistema.idiomas.activo","esp").save();
						}
							//System.out.println("Idioma Activo: "+opt.getValor());
							File idioma = new File(idiomaUbi.getValor());
							idioma = new File(idioma.getAbsolutePath()+"/"+opt.getValor()+".properties");
							//System.out.println("IDIOMA ACTIVOOOO::::::::::: "+opt.getValor());
							
							
							
							
							
							if("esp".equals(opt.getValor())) {
								//verificando si existe
								//System.out.println("Buscando archivo: ");
								//System.out.println(idioma.getAbsolutePath());
								if(!idioma.exists()) {
									//En caso de que no exista se genera
									idioma.createNewFile();
									ln = new Ln(idioma.getAbsolutePath());
									ln.inicializaIdiomaEspa();
								}
								
								//Cargando los valores
								ln = new Ln(idioma.getAbsolutePath());
								ln.loadProperties();
								
									
								
							}else {
								//solo se cargara el archivo
								//System.out.println("Buscando archivo: ");
								//System.out.println(idioma.getAbsolutePath());
								//Cargando los valores
								ln = new Ln(idioma.getAbsolutePath());
								ln.loadProperties();
							}
						
						
						
					}
					
					log("Cargando idioma");
					
					
					
//					log("Verificando el archivo con idioma español");
//					File lnEspa = new File(carpIdioma.getAbsolutePath()+"/es.properties");
//					if(!lnEspa.exists()) {
//						System.out.println("No existe");
//						lnEspa.createNewFile();
//						System.out.println("Archivo creado en:");
//						System.out.println(lnEspa.getAbsolutePath());
//						try {
//							ln = new Ln(lnEspa.getAbsolutePath());
//							ln.inicializaIdiomaEspañol();						} catch (Exception e) {
//							// TODO: handle exception
//						}
//					
//					}else {
//						//carga properti idioma
//						
//					}
//					//verificando que la tabla opciones
//					if(db.exists()) {
//						log("Buscando Opciones");
//						List<Opciones> opciones = Opciones.findAll();
//						System.out.println("Opciones: "+opciones.size());
//						if(opciones.isEmpty()) {
//							//ingresando opciones iniciales
//							new Opciones("sistema.idiomas.activo", "esp").save();
//							new Opciones("sistema.idiomas.ubicacion",carpIdioma.getAbsolutePath()).save();
//						}else {
//							//buscando la opcion deseada
//							
//						}
//						
//					}
					
					//obteniendo idioma
					//Opciones opt = Opciones.find("llave between ? AND ? ","s","d").first();
//					List<Opciones> opts = Opciones.find("llave like ? orderBy id asc","").all();
//					
//					System.out.println("-------***********------*******");
//					System.out.println("Valor:");
//					System.out.println(opts.size());
//					Ln ln = new Ln();
//				    Core.getCore().setIdioma(ln);
//					
				    
				
						
						
					    
					   
					   
					    Core.instanciaCore();
					    //System.out.println("Core 1: "+Core.getCore());
						Core.getCore().setIdioma(ln);
						//System.out.println("Core 2: "+Core.getCore());
						
					    
					    log("Inicializando Quartz");
						//Logger log = LoggerFactory.getLogger(CoreJob.class);
						CoreJob coreJob = new CoreJob();
						coreJob.init();
						
						log("Inicializando ventana");	
						 This.setVisible(false);
						    This.dispose();
						   
							log("Iniciando el sistema de notificaciones");
							    //System.out.println("Core 3 "+Core.getCore());
							TrayNotificacion.initTray();
					        
							VentanaPrincipal vent = new VentanaPrincipal();
							vent.setVisible(true);
						    Core.getCore().setVentanaPrincipal(vent);
						   
					    
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(This, "Ocurrio un error:\n"+e.getMessage(), "No se pudo iniciar la aplicacion", JOptionPane.ERROR_MESSAGE);
					This.setVisible(false);
					This.dispose();
					System.exit(0);
					// TODO: handle exception
				}
				
//				Notificacion noti = new Notificacion("Alta", "BackupGH", null);
//				noti.save();
//				new Notificacion("Normal", "Backup normal", null).save();
//				Notificacion noti = Notificacion.findById(1L);
//				
//				if(noti!=null) {
//					System.out.println(":::: "+noti.getId());
//					System.out.println("Eliminando dato");
//					noti.delete();
//					//noti.save();
//				}
				// TODO Auto-generated method stub
//				Boolean exist = DB.existDB();
//				log("Verificando si existe la BD: "+exist);
//				if(!exist) {
//					log("Creando BD");
//					try {
//						DB.getConnecion();
//						String sql = "";
//						sql = PrioridadNotificacion._sqlCreateTable(PrioridadNotificacion.class.getName());
//						
//						PreparedStatement stm = DB.getConnecion().prepareStatement(sql);
//						System.out.println("Creando :"+sql);
//						log("Creando Tabla PrioridadNotificacion:"+stm.execute());
//						sql = Notificacion._sqlCreateTable(Notificacion.class.getName());
//						System.out.println("Creando :"+sql);
//						stm = DB.getConnecion().prepareStatement(sql);
//						log("Creando Tabla PrioridadNotificacion:"+stm.execute());
//						
//						
//					} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//				
//				PrioridadNotificacion priordad = new PrioridadNotificacion("Normal", "* * * * ");
//				priordad.save();
//				//Notificacion not = new Notificacion("Backup GH","adasdasd",priordad);
//				//not.setId(130L);
//				
//				//not.setComentarios("Comentarios de informacion");
//				//not =  not.save();
//				
////				PrioridadNotificacion noti = new PrioridadNotificacion();
////				
////				noti.setNombre("Alta");
////				noti.save();
////				try {
////					String sqlPriori = Model._sqlCreateTable(PrioridadNotificacion.class.getName());
////					String sql = Model._sqlCreateTable(Notificacion.class.getName());
////					System.out.println("--> SQL:\n"+sqlPriori);
////					System.out.println("--> SQL:\n"+sql);
////				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
//				//PrioridadNotificacion.findAll();
////				for(int i=0; i<=100; i++) {
////					textAreaLog.append("Cargando : "+i+"\n");
////					textAreaLog.setCaretPosition(textAreaLog.getDocument().getLength());
////					progressBar.setValue(i);
////					progressBar.setString(i+"");
////					
////					try {
////						Thread.sleep(100);
////					} catch (InterruptedException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////					//textAreaLog.setCaretPosition(textAreaLog.getDocument().getLength());
////				}
				
			
			
			}
		};
		
		Thread th = new Thread(run);
		th.start();
		
	}
}
