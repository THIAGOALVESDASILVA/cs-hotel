package br.com.codersolution.cshotel.model.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Perfil")
public class Perfil implements GrantedAuthority {


    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }

}