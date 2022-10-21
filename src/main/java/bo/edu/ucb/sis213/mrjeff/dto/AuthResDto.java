package bo.edu.ucb.sis213.mrjeff.dto;

public class AuthResDto {
    private String token;
    private String refresh;

    public AuthResDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    @Override
    public String toString() {
        return "AuthResDto{" +
                "token='" + token + '\'' +
                ", refresh='" + refresh + '\'' +
                '}';
    }
}
