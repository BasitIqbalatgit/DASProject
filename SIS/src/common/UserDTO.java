
package common;


public class UserDTO {
    private String email;
    private String username;
    private String password;
    private String role;
    
    
    public UserDTO(){
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public UserDTO(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email=email;
    }
     public UserDTO(String email, String password) {
        this.email=email;
        this.password = password;
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
