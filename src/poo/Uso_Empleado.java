package poo;
import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    /* 
	Empleado empleado1 = new Empleado("Alex Quintos",2300,2019,10,2);
	
	Empleado empleado2 = new Empleado("Michel Pinedo",1500,2020,2,15);
	
	Empleado empleado3 = new Empleado("Roberto Rosales",1200,2018,5,25);
	
	empleado1.subeSueldo(5);
	empleado2.subeSueldo(5);
	empleado3.subeSueldo(5);
	
	System.out.println("Nombre: "+ empleado1.dameNombre() + "\tSueldo: "+empleado1.dameSueldo()
	+"\t Fecha de Alta: "+ empleado1.dameFechaContrato());
	
	System.out.println("Nombre: "+ empleado2.dameNombre() + "\tSueldo: "+empleado2.dameSueldo()
	+"\t Fecha de Alta: "+ empleado2.dameFechaContrato());
	
	System.out.println("Nombre: "+ empleado3.dameNombre() + "\tSueldo: "+empleado3.dameSueldo()
	+"\t Fecha de Alta: "+ empleado3.dameFechaContrato());*/

	Jefatura jefe_RRHH=new Jefatura("Juan",55000,2006,9,25);
	jefe_RRHH.estableceIncentivo(2570);



	Empleado[] misEmpleados = new Empleado[6];
	 
	misEmpleados[0]=new Empleado("Alex Quintos",2300,2019,10,2);
	
	misEmpleados[1]=new Empleado("Michel Pinedo",1500,2020,2,15);
	
	misEmpleados[2]=new Empleado("Roberto Rosales",1200,2018,5,25);

	misEmpleados[3]=new Empleado("Antonio Fernandez");

	misEmpleados[4]=jefe_RRHH;//polimorfismo en accion. Principio de sustitucion

	misEmpleados[5]=new Jefatura("Maria",95000,199,5,26);

	Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
	jefa_Finanzas.estableceIncentivo(55000);

	System.out.println(jefa_Finanzas.tomar_decisiones("Dar mas dias de vacaciones a los empleados"));
	System.out.println("El jefe "+jefa_Finanzas.dameNombre()+" tiene un bonus de "+jefa_Finanzas.establece_bonus(500));

		System.out.println(misEmpleados[3].dameNombre()+" tiene un bonus "+misEmpleados[3].establece_bonus(200));
	for(int i=0;i<misEmpleados.length;i++) {
		
		misEmpleados[i].subeSueldo(5);
	}
	
	/*for(Empleado e:misEmpleados) {
		
		e.subeSueldo(5);
	}
	/*
	for(int i=0;i<misEmpleados.length;i++) {
		System.out.println("Nombre: "+ misEmpleados[i].dameNombre() + "\tSueldo: "+misEmpleados[i].dameSueldo()
		+"\t Fecha de Alta: "+ misEmpleados[i].dameFechaContrato());*/
	
	Arrays.sort(misEmpleados);
		for(Empleado e:misEmpleados) {
		
		System.out.println("Nombre: "+ e.dameNombre() + "\tSueldo: "+e.dameSueldo()
				+"\t Fecha de Alta: "+ e.dameFechaContrato());
		
	}
	
	}

}

class Empleado implements Comparable,Trabajadores{
	
	public Empleado(String nom,double sue,int agno,int mes,int dia) {
		
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario= new GregorianCalendar(agno, mes-1,dia);
		altaContrato=calendario.getTime();
		++IdSiguiente;
		Id=IdSiguiente;
	}

	public Empleado(String nom){
		this(nom,30_000,2000,01,01);

	}

	public String dameNombre() {//getter
		
		return nombre+" Id:"+Id;
	}
	
	public double dameSueldo() {//getter
		
		return sueldo;
	}
	
	public Date dameFechaContrato() {//getter
		
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {//setter
		
		double aumento=sueldo*porcentaje/100;
		
		sueldo+=aumento;
	}

	@Override
	public int compareTo(Object o) {

		Empleado otroEmpleado=(Empleado) o;

		if (this.Id<otroEmpleado.Id){
			return -1;
		}

		if (this.Id> otroEmpleado.Id){
			return 1;
		}
		return 0;
	}

	@Override
	public double establece_bonus(double gratificacion) {
		return Trabajadores.bonus_base+gratificacion;
	}

	private String nombre;
	private double sueldo;
    private Date altaContrato;
    private static  int IdSiguiente=0;
    private  int Id;


}

 class  Jefatura extends  Empleado implements Jefes{

	public Jefatura(String nom, double sue,int agno, int mes, int dia){

		super(nom, sue, agno, mes, dia);
	}

	 @Override
	 public String tomar_decisiones(String decision) {
		 return "Un miembro de la direccion ha tomado la desicion de: "+decision;
	 }

	 @Override
	 public double establece_bonus(double gratificacion) {
		 double prima=2_000;
		 return Trabajadores.bonus_base+gratificacion+prima;
	 }

	 public void estableceIncentivo(double b){

		incentivo=b;
	}

	public double dameSueldo(){
		double sueldoJefe= super.dameSueldo();

		return sueldoJefe+incentivo;
	}
	private double incentivo;

}

class Director extends Jefatura{
	public Director(String nom, double sue,int agno, int mes, int dia){
		super(nom, sue, agno, mes, dia);
	}
}


