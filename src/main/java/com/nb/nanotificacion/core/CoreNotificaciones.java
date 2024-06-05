package com.nb.nanotificacion.core;


import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;



@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class CoreNotificaciones implements Job{
	
	public static final String CONCURRENCIA = "concurrencia";
	public static final String TITULO = "titulo";
	public static final String COMENTARIOS = "comentarios";
	
    
	
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDataMap data = context.getJobDetail().getJobDataMap();
		String concurrencia = data.getString(CONCURRENCIA);
		String titulo = data.getString(TITULO);
		String comentarios = data.getString(COMENTARIOS);
		//System.out.println("Job: "+date);
		//TrayNotificacion.getTray().displayMessage("Job", "Notificaciones: \n Respaldo de GH\nOtra cosa \n"+date, TrayIcon.MessageType.NONE);
		//Core.getCore().getNotificacion().addNotificacion("Cada 1 minuto", "Noti: "+date, "Comentario extra");
		Core.getCore().getNotificacion().addNotificacion(concurrencia, titulo, comentarios);

	}

}
