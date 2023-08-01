package by.academyit.itBootcampJavaTestTask.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientsDto implements Serializable {
    private Long clientId;
    private String surnameClient;
    private String firstNameClient;
    private String patronymicNameClient;
    private String emailClient;
    private String roleClient;
}
