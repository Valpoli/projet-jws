package fr.epita.assistant.jws.presentation.rest.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@AllArgsConstructor @NoArgsConstructor
public class AddPlayerRequestDTO {
    public String name;
}
