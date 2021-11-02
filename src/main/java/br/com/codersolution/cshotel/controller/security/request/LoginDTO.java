package br.com.codersolution.cshotel.controller.security.request;

import lombok.Data;

@Data
public class LoginDTO {

    private String user;
    private String pass;

}