package com.bbva.e2e.model;

public class ApxTransactionResume {

    private String servicio;
    private String fecha;
    private Long maxejecuciones;
    private Long avgtime;
    private Long ejecuciones;

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getMaxejecuciones() {
        return maxejecuciones;
    }

    public void setMaxejecuciones(Long maxejecuciones) {
        this.maxejecuciones = maxejecuciones;
    }

    public Long getAvgtime() {
        return avgtime;
    }

    public void setAvgtime(Long avgtime) {
        this.avgtime = avgtime;
    }

    public Long getEjecuciones() {
        return ejecuciones;
    }

    public void setEjecuciones(Long ejecuciones) {
        this.ejecuciones = ejecuciones;
    }

    @Override
    public String toString() {
        return "ApxTransactionResume{" +
                "servicio='" + servicio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", maxejecuciones=" + maxejecuciones +
                ", avgtime=" + avgtime +
                ", ejecuciones=" + ejecuciones +
                '}';
    }
}
