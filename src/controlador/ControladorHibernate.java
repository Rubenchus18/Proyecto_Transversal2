package controlador;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import modelo.JugadorCsv;
import persistencias.Jugador;

public class ControladorHibernate {
	
	private  static SessionFactory  sessionFactory;
	
	
	public ControladorHibernate() throws Exception{
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}
	
	public static void main(String[]args) {
		try {
			ControladorHibernate pru=new ControladorHibernate();
			try {
				/*List<Jugador> salida=pru.extraerJugadoresIdEquipo(sessionFactory, 1);
				for(Jugador clave: salida) {
					System.out.println(clave);
				}*/
				System.out.println("funciona");
				pru.cargarJugadores();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void close() {
		if(null!=sessionFactory) {
			sessionFactory.close();
		}
	}
	
	private List<JugadorCsv> abrirCSV(String rutaCSV)throws Exception{
		List<JugadorCsv> jugadores = null;
		try  {
			FileReader reader = new FileReader(rutaCSV);
			
			CsvToBeanBuilder<JugadorCsv> csvBuilder = new CsvToBeanBuilder<JugadorCsv>(reader);
			CsvToBean<JugadorCsv> csv = csvBuilder.withType(JugadorCsv.class).withIgnoreLeadingWhiteSpace(true).build();

			jugadores = csv.parse();

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
		
		return jugadores;
	}
	
	private void insertarJugadores(SessionFactory sesion,List<JugadorCsv> jugadores) throws Exception{
		Session session = null;
		
		try {
			session = sesion.getCurrentSession();
			session.beginTransaction();
			int num=0;
			String query="insert into jugador (id_jugador,equipo,nombre,posicion,fuerza_ataque,fuerza_tecnica,fuerza_defensa,fuerza_portero)values"
					+ "(:num,:equipo,:nombre,:posicion,:fA,:fT,:fD,:fP)";
			Query insert=session.createSQLQuery(query);
			
			for(JugadorCsv clave:jugadores) {
				System.out.println("Empieza "+num);
				
				num++;
				String nombre=clave.getNombre();
				String equipo=clave.getEquipo();
				String posicion=clave.getPosicion();
				
				int fA=clave.getFuerzaAtaque();
				int fT=clave.getFuerzaTecnica();
				int fD=clave.getFuerzaDefensa();
				int fP=clave.getFuerzaPortero();
				
				insert.setParameter("num", num);
				insert.setParameter("nombre", nombre);
				insert.setParameter("equipo", equipo);
				insert.setParameter("posicion", posicion);
				
				insert.setParameter("fA", fA);
				insert.setParameter("fT", fT);
				insert.setParameter("fD", fD);
				insert.setParameter("fP", fP);
				
				System.out.println(clave);
				//session.saveOrUpdate(temp);
				insert.executeUpdate();
				System.out.println("Fin "+num);
				
			}

			
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			if (null != session) {
				session.getTransaction().rollback();
			}
			throw e;
		}
		finally {
			if (null != session) {
				session.close();
			}
		}
		
		
	}
	
	public void cargarJugadores() throws Exception{
		try {		
			insertarJugadores(sessionFactory, abrirCSV("ficheros/jugadores_ligaFantasy.csv"));
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<Jugador> extraerJugadoresPosicion(SessionFactory session,String pos)throws Exception{
		List<Jugador> jugadoresSalida=new ArrayList<Jugador>();
		Session sesion=null;
		
		try {
			sesion=session.getCurrentSession();
			sesion.beginTransaction();
			
			
			String rr="from Jugador where posicion =:pos and equipo=null";
			
			Query query= sesion.createQuery(rr);
			query.setParameter("pos", pos);
			
			jugadoresSalida=query.list();

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(null!=sesion) {
				sesion.close();
			}
		}
		
		return jugadoresSalida;
	}
	
	public List<Jugador> extraerJugadoresIdEquipo(SessionFactory session,int idEquipo){
		List<Jugador> jugadoresSalida=new ArrayList<Jugador>();
		Session sesion=null;
		
		try {
			sesion=session.getCurrentSession();
			sesion.beginTransaction();
			
			
			String rr="select * from Jugador where  id_equipo=:idEquipo";
			
			Query query= sesion.createSQLQuery(rr);
			query.setParameter("idEquipo", idEquipo);
			
			jugadoresSalida=query.list();

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(null!=sesion) {
				sesion.close();
			}
		}
		
		return jugadoresSalida;
	}
	
}
