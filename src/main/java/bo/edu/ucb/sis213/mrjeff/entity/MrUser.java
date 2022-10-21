package bo.edu.ucb.sis213.mrjeff.entity;

import java.util.Date;
import java.util.Objects;

public class MrUser {
    private Integer userId;
    private String username;
    private String secret;
    private Boolean status;
    private String txUsername;
    private String txHost;
    private Date txDate;

    public MrUser() {
    }

    public MrUser(Integer userId, String username, String secret, Boolean status, String txUsername, String txHost, Date txDate) {
        this.userId = userId;
        this.username = username;
        this.secret = secret;
        this.status = status;
        this.txUsername = txUsername;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTxUsername() {
        return txUsername;
    }

    public void setTxUsername(String txUsername) {
        this.txUsername = txUsername;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "MrUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", secret='" + secret + '\'' +
                ", status=" + status +
                ", txUsername='" + txUsername + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MrUser mrUser = (MrUser) o;
        return userId.equals(mrUser.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
