package de.leuphana.shop.connector.mapper;

import de.leuphana.shop.component.structure.PostAddress;
import de.leuphana.shop.connector.dto.PostAddressDTO;

public class PostAddressMapper {

    public static PostAddressDTO mapPostAddresstoPostAddressDTO(PostAddress postAddress) {

        PostAddressDTO postAddressDTO = new PostAddressDTO();

        postAddressDTO.setCity(postAddress.getCity());
        postAddressDTO.setHousenumber(postAddress.getHousenumber());
        postAddressDTO.setStreet(postAddress.getStreet());
        postAddressDTO.setZipcode(postAddress.getZipcode());

        return postAddressDTO;
    }

    public static PostAddress mapPostAddressDTOtoPostAddress(PostAddressDTO postAddressDTO) {

        PostAddress postAddress = new PostAddress();

        postAddress.setCity(postAddressDTO.getCity());
        postAddress.setHousenumber(postAddressDTO.getHousenumber());
        postAddress.setStreet(postAddressDTO.getStreet());
        postAddress.setZipcode(postAddressDTO.getZipcode());

        return postAddress;
    }

}
