
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rsBastos <your.name at your.org>
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // formatação do arquivo do Maurício
        File original = new File("dados/CargoTankerRJ2.pts");
        Scanner s = new Scanner(original);
//        s.skip(" ");
        File saida = new File("dados/CargoTankerRJ2.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(saida));

        bw.write("MMSI,Time,SOG,Longitude,Latitude,COG\n");

        while (s.hasNext()) {
            String linha = s.next();
            if (linha.contains("COMPRIMENTO")) {
                System.out.println("Lida primeira linha");
                continue;
            }

            String[] linhaDividida = linha.split(",");
            
//            for (String st : linhaDividida){
//                System.out.println(st);
//            }

            if (linhaDividida.length == 13) {
                String[] dtDiv = linhaDividida[6].split("_");
                String data[] = dtDiv[0].split("/");
                String hora[] = dtDiv[1].split(":");

                String mmsi = linhaDividida[4];
                String time = data[2] + data[1] + data[0] + "_" + hora[0] + hora[1] + hora[2];
                String sog = linhaDividida[7];
                String lon = linhaDividida[12];
                String lat = linhaDividida[11];
                String cog = linhaDividida[8];

                bw.append(mmsi + "," + time + "," + sog + "," + lon + "," + lat + "," + cog + "\n");
            }else{
                
            System.out.println(linhaDividida.length);
            for (String st : linhaDividida){
                System.out.println(st);
            }
            }
            
        }
        if (s != null) {
            s.close();
        }
        if (bw != null) {
            bw.close();
        }
    }

}
