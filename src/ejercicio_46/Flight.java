package ejercicio_46;

public class Flight {
    boolean[][] flight;
    int rows;
    int seats;

    public Flight() {
        this.flight = new boolean[10][4];
        this.rows = 10;
        this.seats = 4;
    }

    /**
     * Asigna un asiento de primera clase, buscando disponibles de las filas 1 a 5.
     * @return true si lo consigue, false si no consigue asiento
     */
    public boolean assignFirstClass(){
        var reservedSeat = seatSearch(1,5);

        if (!reservedSeat.equals("")) {
            printBoardingPass(reservedSeat,"F. Class");
            return true;
        }
        System.out.println("No First Class Seats Available.");
        return false;
    }

    /**
     * Asigna un asiento de clase economica, buscando disponibles de la fila 6 a 10
     * @return true si lo consigue, false si no lo consigue
     */
    public boolean assignEconomyClass(){
        var reservedSeat = seatSearch(6,10);

        if (!reservedSeat.equals("")) {
            printBoardingPass(reservedSeat,"Economy.");
            return true;
        }
        System.out.println("No Economy Class Seats Available.");
        return false;
    }

    /**
     * Imprime por stdout un boardingpass ficticio
     * @param reservedSeat String que contiene fila y letra de asiento solicitado
     * @param passClass String que contiene la clase del asiento solicitado.
     */
    private void printBoardingPass(String reservedSeat, String passClass) {
        System.out.println("____________________");
        System.out.println("|  BOARDING PASS   |");
        System.out.printf("|     %s     |\n", passClass);
        System.out.printf("|    %s     |\n", reservedSeat);
        System.out.println("____________________");
    }

    /**
     * Metodo que busca un asiento disponible de forma secuencial en la matriz de asientos.
     * @param initialRow Fila inicial de la matriz de asientos donde buscar
     * @param finalRow Fila final de la matriz de asientos donde buscar
     * @return devuelve una cadena con la ubicacion del asiento o la cadena vacía en caso de no hallarlo.
     */
    private String seatSearch(int initialRow, int finalRow) {
        for(var i = initialRow - 1; i < finalRow; i++){
            for(var j = 0;j < seats; j++){
                if (!flight[i][j]){
                    flight[i][j] = true;
                    return getSeatId(i,j);
                }
            }
        }
        return "";
    }

    /**
     * Convierte los indices de fila y columna de la matriz de 2D de asientos en una bonita representacion humana
     * @param row Indice de fila
     * @param seat Indice de columna
     * @return String de representacion humana de fila y asiento.
     */
    private String getSeatId(int row, int seat){
        String[] seat_ids = {"A", "B", "C", "D"};
        return String.format("R: %d S: %s", row + 1, seat_ids[seat]);
    }

    /**
     * Imprime por Stdout una tabla con la disposicion de los asientos y su ocupacion en patalla.
     */
    public void printFlight(){
        System.out.print("\tA\tB\tC\tD\n");
        for (var i = 0; i < this.rows; i ++) {
            System.out.printf("%d \t", i + 1);
            for (var j = 0; j < this.seats; j ++){
                System.out.printf("[%c]\t",this.flight[i][j]? 'X':'O');
            }
            System.out.print("\n");
        }
    }

    /**
     * @return Devuelve true si la matriz de asientos esta completa
     */
    public boolean isFlightFull(){
        for(var row: this.flight){
            for(var seat: row){
                if(!seat) return false;
            }
        }
        return true;
    }
}
