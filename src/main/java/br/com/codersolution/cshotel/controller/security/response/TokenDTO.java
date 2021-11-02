package br.com.codersolution.cshotel.controller.security.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {

    private String type;
    private String token;

}