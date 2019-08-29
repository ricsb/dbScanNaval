package boliu.dbscansd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        double epsilon = 0.005;
        int minPt = 4;
        int dSpd = 15;
        double dCOG = 10.0;
        String name;

//        name = "AVIN_tanques" + Double.toString(epsilon) + "_" + Integer.toString(minPt) + "_" + Integer.toString(dSpd) + "_" + Double.toString(dCOG) + "_veloc1_5";
//        System.out.println("Criando arquivo " + name + "_movingclusters.csv");
//        executeAlgorithm("Dados_AVIN_Tanques_SOG1_5.csv", name, 5591, epsilon, minPt, dSpd, dCOG, false);
//        CriaDerrotas(name + "_movingclusters.csv", "saida_douglaPeucker/" + name + "_mc.xml");
        
        name = "Mau" + Double.toString(epsilon) + "_" + Integer.toString(minPt) + "_" + Integer.toString(dSpd) + "_" + Double.toString(dCOG) + "_" + "_todos";
        System.out.println("Criando arquivo " + name + "_movingclusters.csv");
        
        executeAlgorithm("dados/CargoTankerRJ2.csv", name, 32522, epsilon, minPt, dSpd, dCOG, false);
        CriaDerrotas(name + "_movingclusters.csv", "saida_douglaPeucker/" + name + "_ru.xml",100);
//        CriaDerrotas(name + "_gv.csv", "saida_douglaPeucker/" + name + "_gv.xml");
//        
//        name = "AVIN_Barcas" + Double.toString(epsilon) + "_" + Integer.toString(minPt) + "_" + Integer.toString(dSpd) + "_" + Double.toString(dCOG) + "_" + "_todos";
//        System.out.println("Criando arquivo " + name + "_movingclusters.csv");
//        executeAlgorithm("Dados_AVIN_Barcas.csv", name, 50902, epsilon, minPt, dSpd, dCOG, false);
//        CriaDerrotas(name + "_movingclusters.csv", "saida_douglaPeucker/" + name + "_mc.xml");
//        
//        name = "AVIN_Rebocadores" + Double.toString(epsilon) + "_" + Integer.toString(minPt) + "_" + Integer.toString(dSpd) + "_" + Double.toString(dCOG) + "_" + "_todos";
//        System.out.println("Criando arquivo " + name + "_movingclusters.csv");
//        executeAlgorithm("Dados_AVIN_Rebocadores.csv", name, 8634, epsilon, minPt, dSpd, dCOG, false);
//        CriaDerrotas(name + "_movingclusters.csv", "saida_douglaPeucker/" + name + "_mc.xml");
//        
//        name = "AVIN_Cargueiros" + Double.toString(epsilon) + "_" + Integer.toString(minPt) + "_" + Integer.toString(dSpd) + "_" + Double.toString(dCOG) + "_" + "_todos";
//        System.out.println("Criando arquivo " + name + "_movingclusters.csv");
//        executeAlgorithm("Dados_AVIN_Cargueiros.csv", name, 6, epsilon, minPt, dSpd, dCOG, false);
//        CriaDerrotas(name + "_movingclusters.csv", "saida_douglaPeucker/" + name + "_mc.xml");

//        double epsilon[] = {0.001, 0.01, 0.1};
//        int minPt[] = {3, 5, 10};
//        int dSpd[] = {5, 10, 20};
//        double dCOG[] = {5, 10, 50, 90};
//        for (double e : epsilon) {
//            for (int p : minPt) {
//                for (int s : dSpd) {
//                    for (double c : dCOG) {
//                        
//                        String name = "clusters_" + Double.toString(e) + "_" + Integer.toString(p) + "_" + Integer.toString(s) + "_" + Double.toString(c) + "_" + "_todos";
//                        System.out.println("Criando arquivo " + name + "_movingclusters.csv");
//                        executeAlgorithm("Dados_AVIN_Todos_filtroLatLong.csv", name, 50902, e, p, s, c, false);
//                        CriaDerrotas(name + "_movingclusters.csv", "saida_douglaPeucker/" + name + "_mc.xml");
//                    }
//                }
//            }
//        }
//        
//        for (double e : epsilon) {
//            for (int p : minPt) {
//                for (int s : dSpd) {
//                    for (double c : dCOG) {
//                        
//                        String name = "clusters_" + e + "_" + p + "_" + s + "_" + c + "_" + "_todos";
//                        System.out.println("Criando arquivo " + name + "_stoppingclusters.csv");
//                        executeAlgorithm("Dados_AVIN_Todos_filtroLatLong.csv", name, 50902, e, p, s, c, true);
//                        CriaDerrotas(name + "_stoppingclusters.csv", "saida_douglaPeucker/" + name + "_sc.xml");
//                    }
//                }
//            }
//        }
//        if (args.length == 8) {
//            for (String s : args) {
//
//                System.out.println(s);
//            }
//            try {
//                int lineNum = Integer.parseInt(args[2]);
//                double eps = Double.parseDouble(args[3]);
//                int minPts = Integer.parseInt(args[4]);
//                double maxSpd = Double.parseDouble(args[5]);
//                double maxDir = Double.parseDouble(args[6]);
//                boolean isStopPoint = Integer.parseInt(args[7]) == 0 ? false : true;
//                executeAlgorithm(args[0], args[1], lineNum, eps, minPts, maxSpd, maxDir, isStopPoint);
//            } catch (NumberFormatException e) {
//                //e.printStackTrace();
//                System.out.println("Please check your input parameters are in correct format and order. ");
//            }
//
//        } else {
//
//            System.out.println("pegou, length = " + args.length);
//
//            System.out.println("Please run the program with 8 input parameters:\n"
//                    + "args[0]: the input file path\n"
//                    + "args[1]: the output file path\n"
//                    + "args[2]: the designated number of trajectory points for clustering\n"
//                    + "args[3]: eps  	   1st parameter of DBSCANSD, the radius\n"
//                    + "args[4]: minPoints 2nd parameter of DBSCANSD, the minimum number of points\n"
//                    + "args[5]: maxSpd	   3rd parameter of DBSCANSD, the maximum Speeds' difference\n"
//                    + "args[6]: maxDir	   4th parameter of DBSCANSD, the maximum Directions' difference\n"
//                    + "args[7]: boolean value (0/1), if you would like to cluster stopping points (1) or moving points (0)\n"
//                    + "e.g. java Main toy_data.csv output 70000 0.03 50 2 2.5 1\n");
//        }
    }

    /**
     *
     * @param inPath the input file path
     * @param outPath the output file path
     * @param lineNum the designated number of trajectory points for clustering
     * @param eps 1st parameter of DBSCANSD, the radius
     * @param minPoints 2nd parameter of DBSCANSD, the minimum number of points
     * @param maxSpd	3rd parameter of DBSCANSD, the maximum SOG difference
     * @param maxDir	4th parameter of DBSCANSD, the maximum COG difference
     * @param isStopPoint	boolean condition, if the trajectory points are
     * stopping points
     */
    private static void executeAlgorithm(String inPath, String outPath, int lineNum, double eps, int minPoints, double maxSpd, double maxDir, boolean isStopPoint) {
        //Runtime rt = Runtime.getRuntime();
        ArrayList<TrajectoryPoint> points = FileIO.readFile(inPath, lineNum, isStopPoint);

        DBScanSD dbs = new DBScanSD();

        ArrayList<Cluster> clusteringResults = dbs.applyDBScanSD(points, eps, minPoints, maxSpd, maxDir, isStopPoint);

        System.gc();

        for (int i = 0; i < clusteringResults.size(); i++) {

            clusteringResults.get(i).NaoGrude(400.0);
            clusteringResults.get(i).SimplificaCluster(1000.0, 0);
            clusteringResults.get(i).LimpaCluster(200.0);
            clusteringResults.get(i).AcertaRumos(maxSpd);
            if (isStopPoint) {
                ArrayList<TrajectoryPoint> ppl = clusteringResults.get(i).getCluster();
                FileIO.writeClustersToFile(outPath + "_stoppingclusters.csv", ppl, i);
            } else {
                ArrayList<GravityVector> ppl = GravityVectorExtraction.extractGravityVector(clusteringResults.get(i));
                FileIO.writeGVsToFile(outPath + "_gv.csv", ppl, i);
                ArrayList<TrajectoryPoint> tpl = clusteringResults.get(i).getCluster();
                FileIO.writeClustersToFile(outPath + "_movingclusters.csv", tpl, i);
            }
        }

    }

    private static void CriaDerrotas(String pathIn, String pathOut, int tamanhoDerrota) throws IOException {
        String dr = "";
        String radius = "0, ";
        String header = "<objects>\n"
                + "    <WindMap name=\"CartaDeVentos\" manager=\"WindManager\">\n"
                + "        <attributes>\n"
                + "            <enable>true</enable>\n"
                + "            <filename>../Wind Maps/Rio-Terral.txt</filename>\n"
                + "            <global>true</global>\n"
                + "            <globalDirection>0</globalDirection>\n"
                + "            <globalSpeed>0</globalSpeed>\n"
                + "            <load-from-exercise>true</load-from-exercise>\n"
                + "        </attributes>\n"
                + "    </WindMap>\n";
        String routeName = "    <Route name=\"Machine_Learning";
        String color;

        String tag1 = "\">\n"
                + "        <attributes>\n"
                + "            <color>";
        String tagColor = "</color>\n"
                + "            <load-from-exercise>true</load-from-exercise>\n"
                + "            <waypoints>";
        String tag2 = "</waypoints>\n"
                + "        </attributes>\n"
                + "    </Route>\n";
        String tagFinal = "    <Environment name=\"Environment\">\n"
                + "        <attributes>\n"
                + "            <Date>2014, 1, 1</Date>\n"
                + "            <Time>12, 0, 0</Time>\n"
                + "            <ambient-light-intensity>20</ambient-light-intensity>\n"
                + "            <apply-fog-to-clouds>true</apply-fog-to-clouds>\n"
                + "            <apply-fog-to-sky-dome>true</apply-fog-to-sky-dome>\n"
                + "            <atmospheric-pressure>54</atmospheric-pressure>\n"
                + "            <cloud>0</cloud>\n"
                + "            <cumulus-coverage>4</cumulus-coverage>\n"
                + "            <cumulus-ellipse-bounds>true</cumulus-ellipse-bounds>\n"
                + "            <fog-color>0.560000002384186</fog-color>\n"
                + "            <fog-distance>10</fog-distance>\n"
                + "            <has-cirrus-clouds>true</has-cirrus-clouds>\n"
                + "            <has-cumulus-clouds>true</has-cumulus-clouds>\n"
                + "            <has-stratus-clouds>false</has-stratus-clouds>\n"
                + "            <lightning-intensity>0</lightning-intensity>\n"
                + "            <load-from-exercise>true</load-from-exercise>\n"
                + "            <magnetic-deviation>-22.6599998474121</magnetic-deviation>\n"
                + "            <moon-light-intensity>30</moon-light-intensity>\n"
                + "            <ocean-beaufort>0</ocean-beaufort>\n"
                + "            <ocean-bottom>0</ocean-bottom>\n"
                + "            <ocean-color-blue>0.0</ocean-color-blue>\n"
                + "            <ocean-color-green>0.156863</ocean-color-green>\n"
                + "            <ocean-color-red>0.0</ocean-color-red>\n"
                + "            <ocean-direction>0.0</ocean-direction>\n"
                + "            <ocean-direction-same-as-wind>false</ocean-direction-same-as-wind>\n"
                + "            <ocean-spray>true</ocean-spray>\n"
                + "            <rain-intensity>0</rain-intensity>\n"
                + "            <sea-current-depth>100.0</sea-current-depth>\n"
                + "            <sea-current-direction>0</sea-current-direction>\n"
                + "            <sea-current-speed>0.0</sea-current-speed>\n"
                + "            <sun-light-intensity>10</sun-light-intensity>\n"
                + "            <use-global-depth>0</use-global-depth>\n"
                + "            <wave-spectrum>1</wave-spectrum>\n"
                + "            <wind-direction>0</wind-direction>\n"
                + "            <wind-speed>0.0</wind-speed>\n"
                + "            <wrap-cumulus-clouds>true</wrap-cumulus-clouds>\n"
                + "        </attributes>\n"
                + "    </Environment>\n"
                + "    <OwnShip name=\"NossoNavio\">\n"
                + "        <attributes>\n"
                + "            <ais>1</ais>\n"
                + "            <ais-call-sign>PWGH</ais-call-sign>\n"
                + "            <ais-destination>Rio de Janeiro</ais-destination>\n"
                + "            <ais-dim-to-bow>39</ais-dim-to-bow>\n"
                + "            <ais-dim-to-port>7</ais-dim-to-port>\n"
                + "            <ais-dim-to-starboard>7</ais-dim-to-starboard>\n"
                + "            <ais-dim-to-stern>92</ais-dim-to-stern>\n"
                + "            <ais-draught>6.09999990463257</ais-draught>\n"
                + "            <ais-eta-day>24</ais-eta-day>\n"
                + "            <ais-eta-hour>14</ais-eta-hour>\n"
                + "            <ais-eta-minute>48</ais-eta-minute>\n"
                + "            <ais-eta-month>2</ais-eta-month>\n"
                + "            <ais-fail>0,0</ais-fail>\n"
                + "            <ais-imo>5267548</ais-imo>\n"
                + "            <ais-mmsi>749896221</ais-mmsi>\n"
                + "            <ais-ship-type>35</ais-ship-type>\n"
                + "            <ais-vessel-name>BS GREENHALGH</ais-vessel-name>\n"
                + "            <alarm-panel-fail>0,0</alarm-panel-fail>\n"
                + "            <anchor-command>0, 0</anchor-command>\n"
                + "            <anchor-command-length-shackles>0.0, 0.0</anchor-command-length-shackles>\n"
                + "            <anchor-command-strain-tons>0.0, 0.0</anchor-command-strain-tons>\n"
                + "            <anchor-control>0</anchor-control>\n"
                + "            <anchor-dropping>0.0, 0.0, 0.0, 0.0</anchor-dropping>\n"
                + "            <anchor-position>0.0, 0.0, 0.0, 0.0</anchor-position>\n"
                + "            <anchor-status>0,0</anchor-status>\n"
                + "            <anchoring-id>-1</anchoring-id>\n"
                + "            <angle-haws-pipe>0.0, 0.0</angle-haws-pipe>\n"
                + "            <astern-thruster-fail>0,0</astern-thruster-fail>\n"
                + "            <bow-thruster>0</bow-thruster>\n"
                + "            <bow-thruster-command>0.0</bow-thruster-command>\n"
                + "            <bow-thruster-fail>0,0</bow-thruster-fail>\n"
                + "            <class>BulkCarrier_Ballast</class>\n"
                + "            <course>181.173996</course>\n"
                + "            <danger-of-collision>0,0</danger-of-collision>\n"
                + "            <danger-of-grounding>0,0</danger-of-grounding>\n"
                + "            <distance-haws-pipe>0.0, 0.0</distance-haws-pipe>\n"
                + "            <echo-sounder>0,0</echo-sounder>\n"
                + "            <engine-control>0</engine-control>\n"
                + "            <engine-shut-down>0, 0</engine-shut-down>\n"
                + "            <engine-slow-down>0, 0</engine-slow-down>\n"
                + "            <engine-start-failure>0, 0</engine-start-failure>\n"
                + "            <engine-telegraph>-1</engine-telegraph>\n"
                + "            <engine-thruster-failure>0, 0</engine-thruster-failure>\n"
                + "            <equipment-ais>0</equipment-ais>\n"
                + "            <equipment-alarm-panel>0</equipment-alarm-panel>\n"
                + "            <equipment-ecosounder>0</equipment-ecosounder>\n"
                + "            <equipment-gps>0</equipment-gps>\n"
                + "            <equipment-log>0</equipment-log>\n"
                + "            <equipment-radar-s>0</equipment-radar-s>\n"
                + "            <equipment-radar-x>0</equipment-radar-x>\n"
                + "            <fenders-enabled>0</fenders-enabled>\n"
                + "            <fire>0,0</fire>\n"
                + "            <gps>0,0</gps>\n"
                + "            <gyro-a-alarm-enabled>0</gyro-a-alarm-enabled>\n"
                + "            <gyro-a-error>0.0</gyro-a-error>\n"
                + "            <gyro-a-state>0</gyro-a-state>\n"
                + "            <gyro-b-alarm-enabled>0</gyro-b-alarm-enabled>\n"
                + "            <gyro-b-error>0.0</gyro-b-error>\n"
                + "            <gyro-b-state>0</gyro-b-state>\n"
                + "            <gyro-fail>0,0</gyro-fail>\n"
                + "            <heading-deviation>0,0</heading-deviation>\n"
                + "            <helm-indicator-malfunction>false</helm-indicator-malfunction>\n"
                + "            <helm-input-malfunction>false</helm-input-malfunction>\n"
                + "            <hydraulic-pump-clogged-filter>false, false</hydraulic-pump-clogged-filter>\n"
                + "            <hydraulic-pump-high-oil-temperature>false, false</hydraulic-pump-high-oil-temperature>\n"
                + "            <hydraulic-pump-hydraulic-lock>false, false</hydraulic-pump-hydraulic-lock>\n"
                + "            <hydraulic-pump-low-oil-level>false, false</hydraulic-pump-low-oil-level>\n"
                + "            <hydraulic-pump-overload>false, false</hydraulic-pump-overload>\n"
                + "            <hydraulic-pump-phase-failure>false, false</hydraulic-pump-phase-failure>\n"
                + "            <hydraulic-pump-power-failure>false, false</hydraulic-pump-power-failure>\n"
                + "            <hydraulic-pump-power-failure-control>false, false</hydraulic-pump-power-failure-control>\n"
                + "            <id>0</id>\n"
                + "            <initial-speed>0.0</initial-speed>\n"
                + "            <lifeboat>0,0</lifeboat>\n"
                + "            <lifeboatt>&apos;&apos;,&apos;&apos;,&apos;&apos;,&apos;&apos;,&apos;&apos;,&apos;&apos;,&apos;&apos;,&apos;&apos;</lifeboatt>\n"
                + "            <load-from-exercise>true</load-from-exercise>\n"
                + "            <log>0,0</log>\n"
                + "            <machine-command-percentage>0, 0</machine-command-percentage>\n"
                + "            <machine-command-state>0, 0</machine-command-state>\n"
                + "            <machine-rpm>0.0,0.0,0.0,0.0,0.0,0.0</machine-rpm>\n"
                + "            <max-rpm-pitch-angle>0.0</max-rpm-pitch-angle>\n"
                + "            <mim-rpm-pitch-angle>0.0</mim-rpm-pitch-angle>\n"
                + "            <mini-icon>arrow.svg</mini-icon>\n"
                + "            <mini-icon-size>25</mini-icon-size>\n"
                + "            <mob></mob>\n"
                + "            <mob-fail>0,0</mob-fail>\n"
                + "            <nfu-input-malfunction>false</nfu-input-malfunction>\n"
                + "            <operator-disability>0,0</operator-disability>\n"
                + "            <pitch-command-percentage>0.0, 0.0</pitch-command-percentage>\n"
                + "            <port-shut-down>0,0</port-shut-down>\n"
                + "            <port-slow-down>0,0</port-slow-down>\n"
                + "            <port-start-fail>0,0</port-start-fail>\n"
                + "            <position>-43.0899391174316, -23.0062694549561</position>\n"
                + "            <radar-s>0,0</radar-s>\n"
                + "            <radar-x>0,0</radar-x>\n"
                + "            <rate-of-turn>-2.060673993e-010</rate-of-turn>\n"
                + "            <rudder-angle>0</rudder-angle>\n"
                + "            <rudder-angle-command>0.181818</rudder-angle-command>\n"
                + "            <rudder-control>0</rudder-control>\n"
                + "            <rudder-fail>0,0</rudder-fail>\n"
                + "            <speed>0.02938494086</speed>\n"
                + "            <status>0</status>\n"
                + "            <stbd-shut-down>0,0</stbd-shut-down>\n"
                + "            <stbd-slow-down>0,0</stbd-slow-down>\n"
                + "            <stbd-start-fail>0,0</stbd-start-fail>\n"
                + "            <stern-thruster>0</stern-thruster>\n"
                + "            <stern-thruster-command>0.0</stern-thruster-command>\n"
                + "            <true-heading>310</true-heading>\n"
                + "            <visible>1</visible>\n"
                + "        </attributes>\n"
                + "    </OwnShip>\n"
                + "    <ExerciseArea name=\"RJ_1501\">\n"
                + "        <attributes>\n"
                + "            <AreaName>Rio_Map</AreaName>\n"
                + "            <BoundBox>-43.318333, -23.091667, -43, -22.66667</BoundBox>\n"
                + "            <Exercisename>../Exercises/_0ML</Exercisename>\n"
                + "            <Filename>../Charts/1501.tif</Filename>\n"
                + "            <Lat-Reference>23</Lat-Reference>\n"
                + "            <LoadFromFile>true</LoadFromFile>\n"
                + "            <load-from-exercise>true</load-from-exercise>\n"
                + "        </attributes>\n"
                + "    </ExerciseArea>\n"
                + "    <CurrentMap name=\"Vazante\" manager=\"CurrentManager\">\n"
                + "        <attributes>\n"
                + "            <enable>true</enable>\n"
                + "            <filename>../Current Maps/Rio-DownStream.txt</filename>\n"
                + "            <global>true</global>\n"
                + "            <globalDirection>180</globalDirection>\n"
                + "            <globalSpeed>0</globalSpeed>\n"
                + "            <load-from-exercise>true</load-from-exercise>\n"
                + "        </attributes>\n"
                + "    </CurrentMap>\n"
                + "</objects>";

        File entrada = new File(pathIn); // "in.03_5_5_20_0_todos_movingclusters.csv"
        File saida = new File(pathOut); //"saida/derrotas.03_5_5_20_0_todos.xml"
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(saida));
        Scanner sc = null;
        ArrayList<String> linhas = new ArrayList<String>();
        ArrayList<String> clustersSingulares = new ArrayList<String>();

        dr = dr + header;

        sc = new Scanner(entrada);

        while (sc.hasNext()) {
            String s = sc.next();
            if (!s.contains("cluster")) {
                String nrCluster = s.split(",")[0];
                if (!clustersSingulares.contains(nrCluster)) {
                    clustersSingulares.add(nrCluster);
                }
                linhas.add(s);
            }
        }
        for (int n = 0; n < clustersSingulares.size(); n++) {

            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);

            color = r + ", " + g + ", " + b;

            dr = dr + routeName + n + tag1 + color + tagColor;

            Iterator<String> itLinhas = linhas.iterator();

            int counter = 0;
            int subcounter = 1;
            while (itLinhas.hasNext()) {

                String linhaCrua = itLinhas.next();

                String[] linhaSeparada = linhaCrua.split(",");
                if (linhaSeparada[0].equals("" + n)) {

                    dr = dr + radius + linhaSeparada[2] + ", " + linhaSeparada[1] + ", " + linhaSeparada[3] + ", false";

                    if (linhas.indexOf(linhaCrua) < linhas.size() - 1) {
                        dr = dr + ", ";
                    }
                    counter++;
                    if (counter == tamanhoDerrota) { //se a derrota tiver tamanhoDerrota posições inicia outra
                        
                        r = random.nextInt(256);
                        g = random.nextInt(256);
                        b = random.nextInt(256);

                        color = r + ", " + g + ", " + b;

                        dr = dr + tag2 + routeName + n + "." + subcounter + tag1 + color + tagColor;
                        subcounter++;
                        counter = 0;
                    }

                } else {
                    continue;
                }
            }

            dr = dr + tag2;

        }

        dr = dr + tagFinal;

        writer.write(dr);
        if (writer != null) {
            writer.close();
        }
        if (sc != null) {
            sc.close();
        }
    }

}
