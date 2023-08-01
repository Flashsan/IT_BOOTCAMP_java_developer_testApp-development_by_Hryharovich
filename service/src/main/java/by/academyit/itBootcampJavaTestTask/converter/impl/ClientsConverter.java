package by.academyit.itBootcampJavaTestTask.converter.impl;

import by.academyit.itBootcampJavaTestTask.entity.Clients;
import by.academyit.itBootcampJavaTestTask.entity.Role;
import by.academyit.itBootcampJavaTestTask.converter.Converter;
import by.academyit.itBootcampJavaTestTask.dto.ClientsDto;
import by.academyit.itBootcampJavaTestTask.enumConverter.RoleConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientsConverter implements Converter<Clients, ClientsDto> {
    RoleConverter roleConverter;
    @Override
    public ClientsDto entityToDto(Clients entity) {
        ClientsDto dto = new ClientsDto();
        dto.setClientId(entity.getClientId());
        dto.setSurnameClient(entity.getSurnameClient());
        dto.setFirstNameClient(entity.getFirstNameClient());
        dto.setPatronymicNameClient(entity.getPatronymicNameClient());
        dto.setEmailClient(entity.getEmailClient());
        dto.setRoleClient(getRoleClientFromEntity(entity.getRoleClient()));
        return dto;
    }

    @Override
    public Clients dtoToEntity(ClientsDto dto) {
                Clients entity = new Clients();
        entity.setClientId(dto.getClientId());
        entity.setSurnameClient(dto.getSurnameClient());
        entity.setFirstNameClient(dto.getFirstNameClient());
        entity.setPatronymicNameClient(dto.getPatronymicNameClient());
        entity.setEmailClient(dto.getEmailClient());
        entity.setRoleClient(getRoleClientFromDto(dto.getRoleClient()));
        return entity;
    }

    private Role getRoleClientFromDto(String role) {
        return Role.valueOf(role);
    }

    private String getRoleClientFromEntity(Role role) {
        return String.valueOf(role);
    }
}
