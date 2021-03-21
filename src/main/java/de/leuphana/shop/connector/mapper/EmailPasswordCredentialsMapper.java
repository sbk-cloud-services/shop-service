package de.leuphana.shop.connector.mapper;

import de.leuphana.shop.component.structure.EmailPasswordCredentials;
import de.leuphana.shop.connector.dto.EmailPasswordCredentialsDTO;

public class EmailPasswordCredentialsMapper {

    // Guinness World Record: Longest method name in history. 56 charachters!!!

    public static EmailPasswordCredentialsDTO mapEmailPasswordCredentialsToEmailPasswordCredentialsDTO(
            EmailPasswordCredentials emailPasswordCredentials) {
        EmailPasswordCredentialsDTO emailPasswordCredentialsDTO = new EmailPasswordCredentialsDTO();

        emailPasswordCredentialsDTO.setEmail(emailPasswordCredentials.getEmail());
        emailPasswordCredentialsDTO.setPassword(emailPasswordCredentials.getPassword());

        return emailPasswordCredentialsDTO;
    }

}
