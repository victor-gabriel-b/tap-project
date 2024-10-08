package report;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvReport extends Report {

    protected void saveReport() {
        try{

            //Cria um arquivo CSV(Se existir ele é sobrescrito) e salva o relatório nele

            FileWriter writer = new FileWriter("Report.csv");

            writer.append("Login, Id, UserId, Date and Time");
            writer.append("\n");

            for(int i = 1; i <= loginList.size(); i++){

                writer.append(i + ", " +loginList.get(i-1).getId() + ", " + loginList.get(i-1).getUserId() + ", " + loginList.get(i-1).getDataHora());
                writer.append("\n");
            }
        
            writer.close();
            System.out.println("Arquivo CSV salvo!");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
