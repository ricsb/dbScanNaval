package boliu.dbscansd;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Cluster class, each cluster includes a set of trajectory points
 *
 * @author Bo Liu
 */
public class Cluster {

    private ArrayList<TrajectoryPoint> cluster;

    private double avgSOG;	//the average speed of the whole cluster, not useful so far
    private double avgCOG;	//the average direction of the whole cluster, which is useful for calculating the GV

    public Cluster() {
    }

    public ArrayList<TrajectoryPoint> getCluster() {
        return cluster;
    }

    public void setCluster(ArrayList<TrajectoryPoint> cluster) {
        this.cluster = cluster;
    }

    public double getAvgSOG() {
        return avgSOG;
    }

    public void setAvgSOG(double avgSOG) {
        this.avgSOG = avgSOG;
    }

    public double getAvgCOG() {
        return avgCOG;
    }

    public void setAvgCOG(double avgCOG) {
        this.avgCOG = avgCOG;
    }

    public double calculateAverageDirection(boolean verbose) {
        double sum = 0;
        double maxCOG = -1000;
        double minCOG = 1000;

        for (int i = 0; i < this.cluster.size(); i++) {
            sum = sum + this.cluster.get(i).getCOG();

            if (this.cluster.get(i).getCOG() > maxCOG) {
                maxCOG = this.cluster.get(i).getCOG();
            }
            if (this.cluster.get(i).getCOG() < minCOG) {
                minCOG = this.cluster.get(i).getCOG();
            }
        }
        double avg = sum / (double) (this.cluster.size());
        if (verbose) {
            System.out.println("O Rumo máximo do cluster é " + maxCOG + " e o mínimo é " + minCOG);
        }

        return avg;
    }

    public double calculateCOGsd() {
        double sum = 0;
        double avg = this.calculateAverageDirection(true);
        double sd = 0;

        for (TrajectoryPoint cluster1 : this.cluster) {
            double dif = cluster1.getCOG() - avg;
            sum += dif * dif;
        }
        double variance = sum / (double) (this.cluster.size());
        sd = Math.sqrt(variance);
        System.out.println("O Rumo médio do cluster é " + avg + " e o desvio pádrão é " + sd);
        return sd;
    }

    private static double DistanciaPontos(TrajectoryPoint a, TrajectoryPoint b) {

        double Lat1 = a.getLatitude();
        double Long1 = a.getLongitude();
        double Lat2 = b.getLatitude();
        double Long2 = b.getLongitude();

        double dLat = Lat1 - Lat2;
        double dLong = Long1 - Long2;

        return Math.sqrt(dLat * dLat + dLong * dLong);
    }

    private static double DistanciaPontoReta(TrajectoryPoint primeiro, TrajectoryPoint terceiro, TrajectoryPoint meio) {

        double x1 = primeiro.getLongitude();
        double y1 = primeiro.getLatitude();
        double x2 = terceiro.getLongitude();
        double y2 = terceiro.getLatitude();
        double x0 = meio.getLongitude();
        double y0 = meio.getLatitude();

        if (DistanciaPontos(primeiro, terceiro) == 0.0) {
            return DistanciaPontos(meio, primeiro);
        }

        // fórmula: https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line
        double numerador = (y2 - y1) * x0 - (x2 - x1) * y0 + x2 * x1 - y2 * y1;
        numerador = Math.sqrt(numerador * numerador); // módulo

        return numerador / DistanciaPontos(primeiro, terceiro);
    }

    public boolean mesmaLatLong(TrajectoryPoint tp1, TrajectoryPoint tp2) {

        return tp1.getLatitude() == tp2.getLatitude() && tp1.getLongitude() == tp2.getLongitude();

    }

    private boolean Simplificavel(int indice) {
        return this.cluster.size() - indice > 3;
    }

    public void LimpaCluster(double distMinima) {

        ArrayList<TrajectoryPoint> removiveis = new ArrayList<TrajectoryPoint>();
        ArrayList<TrajectoryPoint> clusterAtual = this.getCluster();

        Iterator<TrajectoryPoint> it = clusterAtual.iterator();
        while (it.hasNext()) {

            TrajectoryPoint tp = it.next();
            int indice = clusterAtual.indexOf(tp);
            for (int j = 0; j < clusterAtual.size(); j++) {

                if (j != indice
                        && (mesmaLatLong(clusterAtual.get(j), tp) //|| DistanciaPontos(clusterAtual.get(j), tp) < distMinima
                        )) {
                    removiveis.add(clusterAtual.get(j));

                }

            }
        }

        Iterator<TrajectoryPoint> ir = removiveis.iterator();
        while (ir.hasNext()) {
            TrajectoryPoint n = ir.next();
            if (clusterAtual.contains(n)) {
                System.out.println("Removendo o TrajectoryPoint da posição: " + n.getLatitude() + ", " + n.getLongitude());
                clusterAtual.remove(n);
            }
        }
    }

    public void SimplificaCluster(double epsilon, int indice) {

//        ArrayList <TrajectoryPoint> cluster1 = this.getCluster();
        while (Simplificavel(indice)) {
//            TrajectoryPoint primeiro = this.getCluster().get(indice);
//            TrajectoryPoint meio = this.getCluster().get(indice + 1);
//            TrajectoryPoint terceiro = this.getCluster().get(indice + 2);
            ArrayList<TrajectoryPoint> clusterAtual = this.getCluster();

            if (DistanciaPontoReta(clusterAtual.get(indice),
                    clusterAtual.get(indice + 2),
                    clusterAtual.get(indice + 1)) <= epsilon) {
                if (clusterAtual.contains(clusterAtual.get(indice + 1))) {
                    System.out.println("Simplificando o TrajectoryPoint da posição: " + clusterAtual.get(indice).getLatitude() + ", " + clusterAtual.get(indice).getLongitude());
                    clusterAtual.remove(indice + 1);
                }

            } else {
                indice++;
            }
        }

    }
}
