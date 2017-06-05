package dao;

import org.springframework.stereotype.Component;
import vaildation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by root on 5/30/17.
 */

@Component("offers")
public class Offers {
    private int id;

    @Size(min=5,max=100, message="Name must be between 5 and 100 characters")
    private String name;

    @NotNull
    //@Pattern(regexp =".*\\@.*\\..*",message="This does not appear to be a vaild email address")
    @ValidEmail(min = 6)
    private String email;

    @Size(min=20,max=255, message="Text must be between 20 and 255 characters")
    private String text;

    public Offers() {

    }

    public Offers(String name, String email, String text) {
        this.name = name;
        this.email = email;
        this.text = text;
    }



    public Offers(int id, String name, String email, String text) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Offers [id=" + id + ", name=" + name + ", email=" + email
                + ", text=" + text + "]";
    }

}