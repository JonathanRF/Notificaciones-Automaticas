package com.nb.nanotificacion.core;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.nb.nanotificacion.models.Notificacion;

public class CoreJob {
	
	private SchedulerFactory sf;
	private Scheduler sc;
	private HashMap<Long, JobDetail> jobs;
    
	public void init() throws SchedulerException, ParseException {
		//dehabilitando log Quartz
		
	    sf = new StdSchedulerFactory();
		sc = sf.getScheduler();
		jobs = new HashMap<>();
		
        //Buscando todas las notificaciones
        List<Notificacion> notificaciones = Notificacion.findAll();
        for(Notificacion noti: notificaciones) {
        	if(noti!=null) {
        		//System.out.println("Creando job ID: "+"noti-"+noti.getId());
            	JobDetail job = JobBuilder.newJob(CoreNotificaciones.class).withIdentity("noti-"+noti.getId(), "groupNotificaciones").build();
            	Trigger t = null;
            	if(noti.getPrioridad() != null) {
            		t = TriggerBuilder.newTrigger().withIdentity("tNotificacion-"+noti.getId(), "triggerNotificaciones").withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression(noti.getPrioridad().getCron()))).forJob("noti-"+noti.getId(), "groupNotificaciones").build();
            		job.getJobDataMap().put(CoreNotificaciones.CONCURRENCIA, noti.getPrioridad().getNombre());
                    
            	}else {
            		if(noti.getCron()!=null) {
            			t = TriggerBuilder.newTrigger().withIdentity("tNotificacion-"+noti.getId(), "triggerNotificaciones").withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression(noti.getCron()))).forJob("noti-"+noti.getId(), "groupNotificaciones").build();
            			job.getJobDataMap().put(CoreNotificaciones.CONCURRENCIA, "Notifiación personalizada");
                        
            		}else {
            			throw new SchedulerException("No hay ningun cron para la notificacion: "+noti.getId());
            		}
            	}
            	job.getJobDataMap().put(CoreNotificaciones.TITULO, noti.getNombre());
                job.getJobDataMap().put(CoreNotificaciones.COMENTARIOS, noti.getComentarios());
              
            	//System.out.println("ID: "+noti.getId()+noti.getNombre()+noti.getPrioridad().getCron());
            	 sc.scheduleJob(job, t);
            	 jobs.put(noti.getId(), job);
        	}else {
        		throw new SchedulerException("La notificacion es nula");
        	}
        	
        	 
        }
       
        sc.start();
        Core.getCore().setCoreJob(this);
	}
	
	public void AddJob(Notificacion notificacion) throws Exception {
		    if(notificacion!=null) {
		    	JobDetail job = JobBuilder.newJob(CoreNotificaciones.class).withIdentity("noti-"+notificacion.getId(), "groupNotificaciones").build();
		    	Trigger t = null; 
		    	if(notificacion.getPrioridad()!=null) {
		    		t = TriggerBuilder.newTrigger().withIdentity("tNotificacion-"+notificacion.getId(), "triggerNotificaciones").withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression(notificacion.getPrioridad().getCron()))).forJob("noti-"+notificacion.getId(), "groupNotificaciones").build();
		        	job.getJobDataMap().put(CoreNotificaciones.CONCURRENCIA, notificacion.getPrioridad().getNombre());
		        	
		        }else {
		        	if(notificacion.getCron()!=null) {
		        		t = TriggerBuilder.newTrigger().withIdentity("tNotificacion-"+notificacion.getId(), "triggerNotificaciones").withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression(notificacion.getCron()))).forJob("noti-"+notificacion.getId(), "groupNotificaciones").build();
		        		job.getJobDataMap().put(CoreNotificaciones.CONCURRENCIA, "Notificacion personalizada");
		        	}else {
		        		throw new Exception("La notificacion es nula");
		        	}
		        	
		        }
		    	
		        job.getJobDataMap().put(CoreNotificaciones.TITULO, notificacion.getNombre());
		        job.getJobDataMap().put(CoreNotificaciones.COMENTARIOS, notificacion.getComentarios());
			    jobs.put(notificacion.getId(), job);
		        sc.scheduleJob(job, t);
	            sc.start();
		    }else {
		    	throw new Exception("Error la notificacion es nula");
		    }
			
	}
	
	public void detenerNotificacion(Long idNotificacion) throws SchedulerException {
        //System.out.println("Deteniendo Job: "+idNotificacion);
        
		if(jobs.get(idNotificacion)!= null) {
			if (sc.deleteJob(jobs.get(idNotificacion).getKey())) {
				jobs.remove(idNotificacion);
			} else {
				JOptionPane.showMessageDialog(Core.getCore().getVentanaPrincipal(), "No se completar la notificacion",
						"Error", JOptionPane.ERROR_MESSAGE);

			}
		}
		

	}

}
