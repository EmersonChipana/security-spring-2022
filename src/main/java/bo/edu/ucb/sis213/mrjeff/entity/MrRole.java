package bo.edu.ucb.sis213.mrjeff.entity;

public class MrRole {

    private Integer roleId;
    private String name;
    private String description;
    private Boolean status;
    private String txUsername;
    private String txHost;
    private String txDate;

    public MrRole() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getTxDate() {
        return txDate;
    }

    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "MrRole{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", txUsername='" + txUsername + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate='" + txDate + '\'' +
                '}';
    }
}
