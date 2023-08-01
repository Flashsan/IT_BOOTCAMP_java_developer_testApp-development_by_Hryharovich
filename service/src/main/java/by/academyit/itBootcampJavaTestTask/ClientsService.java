package by.academyit.itBootcampJavaTestTask;

import by.academyit.itBootcampJavaTestTask.entity.Clients;
import by.academyit.itBootcampJavaTestTask.dto.ClientsDto;
import by.academyit.itBootcampJavaTestTask.enumConverter.ResponseClients;

public interface ClientsService {
    ResponseClients getAll(int pageNo, int pageSize, String sortBy, String sorDir);

    ClientsDto findById(Long clientId);

    ClientsDto create(ClientsDto clientsDto);

    Clients update(ClientsDto clientsDto);

    void deleteById(Long clientId);

}
