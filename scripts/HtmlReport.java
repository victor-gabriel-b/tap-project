import java.io.*;


public class HtmlReport extends Report{


    protected void saveReport(){
        try{

            //Cria um arquivo HTML(Se existir ele é sobrescrito) e salva o relatório nele

            FileWriter writer = new FileWriter("Report.html");
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write("<html>");
            bw.newLine();
            bw.write("<body>");
            bw.newLine();

            for(int i = 1; i <= loginList.size(); i++){
                bw.write("<h1>" + " Login " + (i) + ": </h1>");
                bw.newLine();
                bw.write("<h2>Id: " + loginList.get(i-1).getId() + "| UserId: " + loginList.get(i-1).getUserId() + "| Date and Time: " + loginList.get(i-1).getDataHora() + " </h2>");
                bw.newLine();
                bw.newLine();
            }
            
            bw.write("</body>");
            bw.newLine();
            bw.write("</html>");

            bw.close();

            System.out.println("Arquivo HTML salvo!");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
