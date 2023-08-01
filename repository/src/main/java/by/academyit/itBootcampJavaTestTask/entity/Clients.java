package by.academyit.itBootcampJavaTestTask.entity;

import by.academyit.itBootcampJavaTestTask.enumConverter.RoleConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "clients")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Clients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "surname_client", length = 40)
    @NotNull
    @Size(min = 1, max = 40, message = "Длинна должна быть от 1 до 20 символов")
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    private String surnameClient;

    @Column(name = "first_name_client", length = 20)
    @NotNull
    @Size(min = 1, max = 20, message = "Длинна должна быть от 1 до 20 символов")
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    private String firstNameClient;

    @Column(name = "patronymic_name_client", length = 40)
    @NotNull
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    @Size(min = 1, max = 40, message = "Длинна должна быть от 1 до 20 символов")
    private String patronymicNameClient;

    @Column(name = "email_client", length = 50)
    @NotNull
    @Email(regexp =
            "^(?=.{1,50}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String emailClient;

    @Convert(converter = RoleConverter.class)
    @Column(name = "role_client")
    private Role roleClient;


}
