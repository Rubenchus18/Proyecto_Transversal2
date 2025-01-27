package persistencias;
// Generated 27 ene 2025, 13:44:31 by Hibernate Tools 5.4.33.Final

/**
 * Jugador generated by hbm2java
 */
public class Jugador implements java.io.Serializable {

	private int idJugador;
	private Equipo equipo;
	private String nombre;
	private String posicion;
	private int fuerzaAtaque;
	private int fuerzaTecnica;
	private int fuerzaDefensa;
	private int fuerzaPortero;
	private boolean seleccionado;
	private Integer idEquipo;

	public Jugador() {
	}

	public Jugador(Equipo equipo, String nombre, String posicion, int fuerzaAtaque, int fuerzaTecnica,
			int fuerzaDefensa, int fuerzaPortero, boolean seleccionado) {
		this.equipo = equipo;
		this.nombre = nombre;
		this.posicion = posicion;
		this.fuerzaAtaque = fuerzaAtaque;
		this.fuerzaTecnica = fuerzaTecnica;
		this.fuerzaDefensa = fuerzaDefensa;
		this.fuerzaPortero = fuerzaPortero;
		this.seleccionado = seleccionado;
	}

	public Jugador(Equipo equipo, String nombre, String posicion, int fuerzaAtaque, int fuerzaTecnica,
			int fuerzaDefensa, int fuerzaPortero, boolean seleccionado, Integer idEquipo) {
		this.equipo = equipo;
		this.nombre = nombre;
		this.posicion = posicion;
		this.fuerzaAtaque = fuerzaAtaque;
		this.fuerzaTecnica = fuerzaTecnica;
		this.fuerzaDefensa = fuerzaDefensa;
		this.fuerzaPortero = fuerzaPortero;
		this.seleccionado = seleccionado;
		this.idEquipo = idEquipo;
	}

	public int getIdJugador() {
		return this.idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getFuerzaAtaque() {
		return this.fuerzaAtaque;
	}

	public void setFuerzaAtaque(int fuerzaAtaque) {
		this.fuerzaAtaque = fuerzaAtaque;
	}

	public int getFuerzaTecnica() {
		return this.fuerzaTecnica;
	}

	public void setFuerzaTecnica(int fuerzaTecnica) {
		this.fuerzaTecnica = fuerzaTecnica;
	}

	public int getFuerzaDefensa() {
		return this.fuerzaDefensa;
	}

	public void setFuerzaDefensa(int fuerzaDefensa) {
		this.fuerzaDefensa = fuerzaDefensa;
	}

	public int getFuerzaPortero() {
		return this.fuerzaPortero;
	}

	public void setFuerzaPortero(int fuerzaPortero) {
		this.fuerzaPortero = fuerzaPortero;
	}

	public boolean isSeleccionado() {
		return this.seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

}
