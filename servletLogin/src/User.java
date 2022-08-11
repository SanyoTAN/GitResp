import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;
    private String realname;
    private String username;
    private String pasword;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", realname='" + realname + '\'' +
                ", username='" + username + '\'' +
                ", pasword='" + pasword + '\'' +
                '}';
    }

    public User(Integer uid, String realname, String username, String pasword) {
        this.uid = uid;
        this.realname = realname;
        this.username = username;
        this.pasword = pasword;
    }

    public User() {
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public Integer getUid() {
        return uid;
    }

    public String getRealname() {
        return realname;
    }

    public String getUsername() {
        return username;
    }

    public String getPasword() {
        return pasword;
    }
}
