package de.leuphana.shop.component.structure;

public class Customer {
    private Integer id;
    private String firstname;
    private String lastname;
    private PostAddress postAddress;

    public Integer getId() {
        return id;
    }

    public PostAddress getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(PostAddress postAddress) {
        this.postAddress = postAddress;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}