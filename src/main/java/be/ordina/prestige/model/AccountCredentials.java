package be.ordina.prestige.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"password"})
@EqualsAndHashCode
@Getter
@Setter
public class AccountCredentials {
    private String username;
    private String password;
}
