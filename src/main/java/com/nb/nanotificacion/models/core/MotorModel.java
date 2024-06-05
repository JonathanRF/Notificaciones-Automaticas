package com.nb.nanotificacion.models.core;

import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 * Clase encargada de trabajar con los metodos estaticos para los modelos
 * @author Jonathan Ramos Fragoso
 * @version V1.0
 */
public class MotorModel {
	
	
	/**
	 * Metodo estatico para realizar consultas jpql nativas
	 * @param clase Objceto Class
	 * @param jpql
	 * @return Devuelve un objeto generico de la clase hija
	 */
	@SuppressWarnings("unchecked")
	protected static <T extends MotorModel> T _find(Class<?> clase,String jpql) {
		EntityManager em = EM.getEm();
		Object res = null;
		//Obteniendo anotacion
//		Entity ent = clase.getAnnotation(Entity.class);
//		if(ent!=null) {
//			claseString = ent.name().toLowerCase();
//		}else {
//			claseString = clase.getSimpleName().toLowerCase();
//		}		
		Query q = em.createQuery(jpql,clase);
		
		
		List<T> lRes = q.getResultList();
		if(lRes !=null) {
			if(!lRes.isEmpty()) {
				res = lRes.get(0);
			}
		}
			
		return (T) res;
	}
	
	/**
	 * Metodo encargado de busar un elemento por id
	 * @param clase Objeto Class
	 * @param id Objeto Long
	 * @return Devuelve un objeto generico de la clase hija
	 */
	@SuppressWarnings("unchecked")
	protected static  <T extends MotorModel> T _findById(Class<?> clase,Long id) {
		EntityManager em = EM.getEm();
		Object res =em.find(clase, id);
		
		//System.out.println(clase);
		return (T) res;
	}
	
	protected static <T extends MotorModel> T _deleteById(Class<?> clase, Long id) {
		
		return null;
	}
	
	/**
	 * Metodo encargado de busar elementos con consulta basica
	 * 
	 * @param clase Clase Principal
	 * @param jpql consulta corta:</br>
	 * Ejemplo:</br>
	 * import com.nb.notificacion.models.core.Result;</br>
	 * public class Usuario Extends Model{<br>
	 * 	private String Nombre;</br>
	 * 	private Integer Edad;</br>
	 * 	private String eMail;</br></br>
	 * 	public static Result find(String cSql,Object... values) throws Exception{</br>
	 *  	return _find(Usuario.class,cSql,values)</br>
	 *  }</br></br>
	 * 	public static void main(String[] args){</br>
	 * 		Usuario.find("nombre = ? AND edad between ? AND ?","Pedro",10,20);
	 * }
	 * 
	 * @return Devuelve un objeto tipo Result con los posibles resultados
	 * @see Result
	 * 
	 */
	protected static <T extends MotorModel> Result<T> _find(Class<?> clase,String jpql,Object... values) throws Exception {
		EntityManager em = EM.getEm();
		String claseString = "";
		Result<T> r;

		// Obteniendo anotacion
		Entity ent = clase.getAnnotation(Entity.class);
		if (ent != null) {
			claseString = ent.name().toLowerCase();
		} else {
			claseString = clase.getSimpleName().toLowerCase();
		}
		
		String ql = ConversionOB_JER.getJPQL(claseString,jpql, values);
		//System.out.println("Ejecutando consulta:\n"+ql);
        Query query = em.createQuery(ql,clase);
		
        r = new Result<>(query);
		return r;
	}
	/**
	 * Metodo para obtener todos los resultados de la BD
	 * @param clase
	 * @return Lista generica con valores
	 */
	protected static <T extends MotorModel> List<T> _findAll(Class<?> clase){
		EntityManager em = EM.getEm();
		String claseString = "";
		//Obteniendo anotacion
		Entity ent = clase.getAnnotation(Entity.class);
		if(ent!=null) {
			claseString = ent.name().toLowerCase();
		}else {
			claseString = clase.getSimpleName().toLowerCase();
		}
		Query query = em.createQuery("Select a FROM "+claseString+" a",clase);
	
		@SuppressWarnings("unchecked")
		List<T> res = query.getResultList();
		
	    
		return  res;
	}
	
	
	/**
	 * Clase privada exclusiva para utilizar en clase MotorModel
	 * @author Jonathan Ramos Fragoso
	 * @version 1.0
	 */
	private static class ConversionOB_JER{
		/**
		 * Metodo que se encarga de generar el jpql a partir de una CJpql
		 * @param table nombre de la a tabla
		 * @param key String CJpql
		 * @param values Array de Objetos
		 * @return String con JPQL
		 * @throws Exception
		 */
		private static String getJPQL(String table,String key,Object... values) throws Exception{
			String sql="SELECT e FROM "+table+" e where ";
			StringTokenizer tokens = new StringTokenizer(key, " ");
			//System.out.println("Total de tokens: "+tokens.countTokens());
			//System.out.println("Total de valores"+values.length);
			Integer i=0;
			while(tokens.hasMoreTokens()) {
				String token = tokens.nextToken().trim().toLowerCase();
				//System.out.println("\t"+token);
				if(!"from".equals(token)) {
					
					if("=".equals(token)) {
						sql+="=";
					}else if("and".equals(token) || "or".equals(token) || "like".equals(token) || "between".equals(token)) {
						sql+=" "+token+" ";
					}
					else if("orderby".equals(token)) {
						sql+=" "+"ORDER BY ";
						sql+="e."+tokens.nextToken();
						sql+=" "+tokens.nextToken();
					}
					else if("?".equals(token)) {
						if(token instanceof String) {
							sql+="'"+values[i]+"'";
						}else {
							sql+=values[i];
						}
						
						i++;
					} 
					else {
						sql+="e."+token;
					}
				}
				
			}
			
			
			
			return sql;
		}
	}
	

}
