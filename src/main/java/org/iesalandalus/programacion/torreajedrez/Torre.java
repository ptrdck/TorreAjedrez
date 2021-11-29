package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

public class Torre {
	private Color color;
	private Posicion posicion;
	
	public Torre() {
		color= Color.NEGRO;
		posicion= new Posicion(8,'a');
	}
	public Torre (Color color){
		this();
		setColor(color);
		if (color==null) {
			throw new IllegalArgumentException("ERROR: no se puede asignar un color nulo");	
		}
		if(color == Color.BLANCO) {
			posicion = new Posicion(1,'a');
		}
		
	}
	public Torre (Color color,char columna ) {
		setColor(color);
		if (color == null) {
			throw new IllegalArgumentException("ERROR: no se puede asignar un color nulo");
		}
		if (columna != 'a' && columna != 'h') {
			throw new IllegalArgumentException("ERROR: columna inicial no válida");
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, columna);
		}else {
			posicion= new Posicion(8,columna);
		}
	}
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	private void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	public void enrocar(Direccion direccion) throws OperationNotSupportedException{
		if (direccion == null) {
			throw new IllegalArgumentException("ERROR: debe enrrocar de manera larga o corta");
		}
		switch (direccion) {
		case ENROQUE_CORTO:
			try {
				this.posicion = new Posicion((posicion.getFila()), (char) (posicion.getColumna() - 2));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ENROQUE_LARGO:
			try {
				this.posicion = new Posicion((posicion.getFila()), (char) (posicion.getColumna() + 3));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			
		}
		
	}
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un movimiento nulo.");
		}
		if (pasos<1) {
			throw new IllegalArgumentException("ERROR: No puede moverse menos de 1 espacio");
		}
		switch (direccion) {
		case ARRIBA:
			try {
				this.posicion = new Posicion((posicion.getFila() + pasos), (char) (posicion.getColumna()));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException exception) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case DERECHA:
			try {
				this.posicion = new Posicion((posicion.getFila()), (char) (posicion.getColumna() + pasos));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ABAJO:
			try {
				this.posicion = new Posicion((posicion.getFila() - pasos), (char) (posicion.getColumna()));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case IZQUIERDA:
			try {
				this.posicion = new Posicion((posicion.getFila()), (char) (posicion.getColumna() - pasos));
				if (this.posicion.getFila() < 1 | this.posicion.getFila() > 8 | this.posicion.getColumna() < 'a'
						| this.posicion.getColumna() > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento no válido.");
				}
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		
		}
	}
}
		
	