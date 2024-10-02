import java.time.ZonedDateTime;

public class main {
    

    public static void main(String[] args) {


        var users = new UserManager();
        var scores = new ScoreManager();
        var musics = new MusicManager();
        var logins = new LoginManager();

    


        var userA = new User(0, "WesleySilva", "wesley.abc@hotmail.com", "Abcdefg1!");
        int id = users.add_user(userA);
        userA.setId(id);

        var scoreA = new Score(0, 1, 9999.0);
        id = scores.add_score(scoreA);
        scoreA.setId(id);

        Music musicA = new Music(0, "One Winged Angel", "youtube.com/mmYdf0yqK_Fc", "Final Fantasy VII", "RPG", 1997);
        id = musics.add_music(musicA);
        musicA.setId(id);

        //users.add_user("WesleySilva", "wesley.abc@hotmail.com", "Abcdefg1!");  //Válido
        //users.add_user("ZeAlysson", "ze.aly@hotmail.com", "Senha@123");  //Válido
        //users.add_user("Ze", "ze@hotmail.com", "Senha@123");  //Válido
        //users.add_user("Zezin", "ze@hotmail.com", "Senha@123");  //Válido


        // Testes para username inválidos:
        /* 
        #UserManager
        #UserManager.add_user("NomeMuitoGrandeDeUsuario", "wesley.abc@hotmail.com", "Abcdefg1!")  # Username com mais de 12 caracteres
        #UserManager
        #.add_user("", "ze.alysson@hotmail.com", "Senha@123")  # Erro: O login não pode ser vazio.
        #UserManager
        #.add_user("ZeAlysson123", "ze.alysson@hotmail.com", "Senha@123")  # Erro: O login não pode conter números.
        #UserManager
        #.add_user("ZeAlyssonnnn", "ze.alysson@hotmail.com", "Senha@123")  # Erro: O login deve ter no máximo 12 caracteres.
        #UserManager
        #.add_user("ZeAlysson", "ze.alysson@hotmail.com", "1234567")  # Erro: A senha deve ter no mínimo 8 caracteres.
        #UserManager
        #.add_user("ZeAlysson", "ze.alysson@hotmail.com", "senhasegura")  # Erro: A senha deve conter pelo menos uma letra maiúscula.
        #UserManager
        #.add_user("ZeAlysson", "ze.alysson@hotmail.com", "SENHASEGURA")  # Erro: A senha deve conter pelo menos uma letra minúscula.
        #UserManager
        #.add_user("ZeAlysson", "ze.alysson@hotmail.com", "SenhaSegura")  # Erro: A senha deve conter pelo menos um número.
        #UserManager
        #.add_user("ZeAlysson", "ze.alysson@hotmail.com", "Senha1234")  # Erro: A senha deve conter pelo menos um caractere especial.
        #UserManager
        #.add_user("ZeAlysson", "ze.alysson@hotmail.com", "Senha123456789!")  # Erro: A senha deve ter no máximo 12 caracteres.
        */

        /* 
        for(int i = 1; i <2; i ++){
            User user = users.read_user(i);
            System.out.println(i + " " + user.getUsername() + " " + user.getEmail()+ " " + user.getPassword());
        }

        userA.setUsername("Spines");
        users.update_user(userA);

        for(int i = 1; i <2; i ++){
            User user = users.read_user(i);
            System.out.println(i + " " + user.getUsername() + " " + user.getEmail()+ " " + user.getPassword());
        }

        users.delete(userA);

        for(int i = 1; i <2; i ++){
            User user = users.read_user(i);
            System.out.println(i + " " + user.getUsername() + " " + user.getEmail()+ " " + user.getPassword());
        }
        */

        for(int i = 1; i <2; i ++){
            Score score = scores.read_score(i);
            System.out.println(i + " " + score.getUserId() + " " + score.getScore());
        }

        for(int i = 1; i <2; i ++){
            Music music = musics.read_music(i);
            System.out.println(i + " " + music.getName() + " " + music.getLink() + " " + music.getGameName() + " " + music.getGenre() + " " + music.getLaunchYear());
        }


        ZonedDateTime dataHora;
        var loginA = new Login(0, 1, dataHora = ZonedDateTime.now());
        id = logins.add_login(loginA);
        loginA.setId(id);

        logins.delete(6);


        HtmlReport report = new HtmlReport();
        CsvReport report2 = new CsvReport();
        
        report.generateReport();
        report2.generateReport();

    }
}
