package ejercicio_1;

public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    public Hora(int h, int m, int s){
        setHoras(h);
        setMinutos(m);
        setSegundos(s);
    }

    public Hora() {
        setHoras(12);
        setMinutos(0);
        setSegundos(0);
    }


    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if(horas >= 0 && horas < 24){
            this.horas = horas;
        } else if (horas >= 24) {
            this.horas = horas % 24;
        }
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        if(minutos >= 0 && minutos < 60){
            this.minutos = minutos;
        } else if (minutos >= 60) {
            this.minutos = minutos % 60;
            this.incHoras();
        }
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        if(segundos >= 0 && segundos < 60){
            this.segundos = segundos;
        } else if (segundos >= 60) {
            this.segundos = segundos % 60;
            incMinutos();
        }
    }

    public void incMinutos(){
        var aux = this.getMinutos() + 1;
        this.setMinutos(aux);
    }
    public void incHoras(){
        var aux = this.getHoras() + 1;
        this.setHoras(aux);
    }

    public String toString(){
        return String.format("%d:%d:%d",this.getHoras(),this.getMinutos(),this.getSegundos());
    }
    public void mostrarHora(){
        System.out.println(this);
    }
}
