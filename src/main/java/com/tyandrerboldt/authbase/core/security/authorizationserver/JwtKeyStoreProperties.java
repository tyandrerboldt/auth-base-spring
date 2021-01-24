package com.tyandrerboldt.authbase.core.security.authorizationserver;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
@Component
@ConfigurationProperties("authbase.jwt.keystore")
public class JwtKeyStoreProperties {

    
	@NotNull
    private Resource jksLocation;
    
    @NotBlank
    private String password;
    
    @NotBlank
    private String keypairAlias;
}