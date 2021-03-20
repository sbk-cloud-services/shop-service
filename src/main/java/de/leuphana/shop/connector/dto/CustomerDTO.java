package de.leuphana.shop.connector.dto;

public class CustomerDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private PostAddressDTO postAddress;

    public Integer getId() {
        return id;
    }

    public PostAddressDTO getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(PostAddressDTO postAddress) {
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