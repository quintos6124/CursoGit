package defecto;

public enum DiasSemana {
    LUNES("Es laborable"),
    MARTES("Es laborable"),
    MIERCOLES("Es laborable"),
    JUEVES("Es laborable"),
    VIERNES("Es laborable"),
    SABADO("No es laborable"),
    DOMINGO("No es laborable");

    private String laborable;

    private DiasSemana(String laborable){

        this.laborable=laborable;
    }

    public String getLaborable() {
        return laborable;
    }
}
