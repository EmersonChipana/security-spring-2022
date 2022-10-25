package bo.edu.ucb.sis213.mrjeff.dto;

public class CreateUserDto {
    private String username;
    private String secret;
//    private String firstName;
//    private String lastName;

    public CreateUserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
