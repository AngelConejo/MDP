package es.unex.cum.mdp.sesion1;

import java.util.Objects;

/*
Cada alumno deberá implementar una clase Reloj compuesta por los siguientes atributos: int horas; int minutos; int segundos.
Además debe tener los siguientes métodos (CUIDADO: deben llamarse tal y como aparecen a continuación):

• Reloj()
• Reloj(int hora, int minutos, int segundos)
• int getHoras()
• void setHoras(int hora)
• int getMinutos()
• void setMinutos(int minutos)
• int getSegundos()
• void setSegundos(int segundos)
• boolean equals(Reloj obj)
• String toString() deberá devolver la información en el siguiente formato:
◦
"Reloj [horas=" + horas + ", minutos=" + minutos + ", segundos=" + segundos + "]";
• void incrementarSegundos(): Incrementa en uno los segundos
• void incrementarMinutos() : Incrementa en uno los minutos
• void incrementarHoras(): : Incrementa en uno las horas
• void decrementarSegundos(): Decrementa en uno los segundos
• void decrementarMinutos(): Decrementa en uno los minutos
• void decrementarHoras(): Decrementa en uno las horas
• long getTiempo(): Devuelve en número entero las horas, minutos y segundos.
• void setTiempo(long s): Asigna las horas, minutos y segundos en base a un número long
• void anadirTiempo(Reloj r): Añade al reloj actual, la información de otro reloj
• void restarTiempo(Reloj r): Resta al reloj actual, la información de otro reloj
*/
public class Reloj {
	int horas, minutos, segundos;

	public Reloj () {
	horas=0;
	minutos=0;
	segundos=0;
	}
	
	public Reloj(int horas, int minutos, int segundos) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	
	public int getHoras() {
		return horas;
	}
	
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public int getMinutos() {
		return minutos;
	}
	
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	public int getSegundos() {
		return segundos;
	}
	
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	
	public int hashCode() {
		return Objects.hash(horas, minutos, segundos);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reloj other = (Reloj) obj;
		return horas == other.horas && minutos == other.minutos && segundos == other.segundos;
	}
	
	@Override
	public String toString() {
		return "Reloj [horas=" + horas + ", minutos=" + minutos + ", segundos=" + segundos + "]";
	}
	
	void incrementarSegundos()
	{
		if (getSegundos()==59) {
			incrementarMinutos();
			setSegundos(0);
		}
		else {
			setSegundos(getSegundos()+1);
		}
	}
	void incrementarMinutos() {
		
		if ( getMinutos()==59) {
			incrementarHoras();
			setMinutos(0);
		}
		else {
			setMinutos(getMinutos()+1);
		}
	}
	void incrementarHoras() {
		if ( getHoras()==23) {
			setHoras(0);
		}
		else {
			setHoras(getHoras()+1);
		}
	}
	void decrementarSegundos()
	{
		if (getSegundos()==0 && (getHoras()!=0 ||getMinutos()!=0)) {
			decrementarMinutos();
			setSegundos(59);
		}
		else if(getSegundos()>0) {
			setSegundos(getSegundos()-1);
		}
	}
	void decrementarMinutos() {
		
		if ( getMinutos()==0 && getHoras()!=0) {
			decrementarHoras();
			setMinutos(59);
		}
		else if(getMinutos()>0){
			setMinutos(getMinutos()-1);
		}
	}
	void decrementarHoras() {
		if ( getHoras()==0) {
		}
		else {
			setHoras(getHoras()-1);
		}
	}

	void setTiempo(long s) {
		long k=s;
		
		for(int x=1;k>3599;x++) {
			setHoras(x);
			k=k-3600;
		}
		for(int e=1;k>59;e++) {
			setMinutos(e);
			k=k-60;
		}
		setSegundos((int)(k));
			
	}
	long getTiempo(){
		long suma=0;
		for (int x=getSegundos();x>0;x--) {
			suma++;
		}
		for (int x=getMinutos();x>0;x--)
		{
			suma=suma+60;
		}
		for (int x=getHoras();x>0;x--)
		{
			suma=suma+3600;
		}


		return suma;
	}
	void restarTiempo(Reloj r)
	{
		if (r.getMinutos()>getMinutos() && getHoras()!=0)
		{
			setMinutos(60-(r.getMinutos()-getMinutos()));
			decrementarHoras();
		}
		else if(getHoras()==0) {
			setMinutos(0);
		}
		else {
			setMinutos(getMinutos()-r.getMinutos());
		}
		
		
		if (r.getSegundos()>getSegundos() && (getHoras()!=0 || getMinutos()!=0))
		{
			setSegundos(60-(r.getSegundos()-getSegundos()));
			decrementarMinutos();
		}
		else if(getHoras()==0 && getMinutos()==0) {
			setSegundos(0);
		}
		else {
			setSegundos(getSegundos()-r.getSegundos());
		}
		
		if (r.getHoras()==getHoras())
		{
			setHoras(0);
		}
		else if(r.getHoras()>r.getHoras()+1) {
			setHoras(0);
			setMinutos(0);
			setSegundos(0);
		}
		else {
			setHoras(getSegundos()-r.getSegundos());
		}
	}
	void anadirTiempo(Reloj r) {
		
		if (getSegundos()+r.getSegundos()>59)
		{
			setSegundos(getSegundos()+r.getSegundos()-60);
			incrementarMinutos();
		}
		else
		{
			setSegundos(getSegundos()+r.getSegundos());
		}
		if (getMinutos()+r.getMinutos()>59)
		{
			setMinutos(getMinutos()+r.getMinutos()-60);
			incrementarHoras();
		}
		else
		{
			setMinutos(getMinutos()+r.getMinutos());
		}
		setHoras(getHoras()+r.getHoras());
		
	}
	
}