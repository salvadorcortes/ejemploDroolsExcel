package com.bbva.e2e.model;

public class ApxTransactionResumeJson extends ApxTransactionResume {
    private String uso;
    private String estatus;

    public ApxTransactionResumeJson(ApxTransactionResume apxTransactionResume){
        this.setServicio(apxTransactionResume.getServicio());
        this.setAvgtime(apxTransactionResume.getAvgtime());
        this.setEjecuciones(apxTransactionResume.getEjecuciones());
        this.setFecha(apxTransactionResume.getFecha());
        this.setMaxejecuciones(apxTransactionResume.getMaxejecuciones());
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "ApxTransactionResumeJson{" +
                "servicio='" + getServicio() + '\'' +
                ", fecha='" + getFecha() + '\'' +
                ", maxejecuciones=" + getMaxejecuciones() +
                ", avgtime=" + getAvgtime() +
                ", ejecuciones=" + getEjecuciones() +
                ", uso='" + uso + '\'' +
                ", estatus='" + estatus + '\'' +
                '}';
    }

}
