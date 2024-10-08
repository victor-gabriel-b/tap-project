package entity;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Login {
    private int id;
    private int userId;
    private ZonedDateTime dataHora;


    public Login(int id, int userId, ZonedDateTime dataHora){
        this.id = id;
        this.userId = userId;
        this.dataHora = dataHora;
    }

    

    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public ZonedDateTime getDataHora() {
        return dataHora;
    }


    public void setDataHora(ZonedDateTime dataHora) {
        this.dataHora = dataHora;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    //retorna o objeto Data Hora no formato de String
    public String getStringDataHora(){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        String dataFormatada = getDataHora().format(formatador);
        return dataFormatada;
    }

    //transforma o objeto Data Hora no formato ZonedDateTime e seta ele no usuário
    public void setStringDataHora(String dataHora){
        if(dataHora == null){
            setDataHora(null);
        } else{
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
            var DateTime = ZonedDateTime.parse(dataHora, formatador);
            setDataHora(DateTime);
        }
        
    }

    
    
}
