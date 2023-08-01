package by.academyit.itBootcampJavaTestTask.imp;

import by.academyit.itBootcampJavaTestTask.dao.ClientsRepository;
import by.academyit.itBootcampJavaTestTask.entity.Clients;
import by.academyit.itBootcampJavaTestTask.ClientsService;
import by.academyit.itBootcampJavaTestTask.converter.impl.ClientsConverter;
import by.academyit.itBootcampJavaTestTask.dto.ClientsDto;
import by.academyit.itBootcampJavaTestTask.enumConverter.ResponseClients;
import by.academyit.itBootcampJavaTestTask.exceptions.ClientsException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {

    private final ClientsRepository clientsRepository;
    private final ClientsConverter clientConverter;

    @Override
    public ResponseClients getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Clients> page = clientsRepository.findAll(pageable);
        List<Clients> catalog_classOfDangerList = page.getContent();
        if (catalog_classOfDangerList.isEmpty()) {

        }
        List<ClientsDto> clientsDtos =
                catalog_classOfDangerList.stream().map(catalog -> clientConverter.entityToDto(catalog)).collect(Collectors.toList());

        ResponseClients responseClient = new ResponseClients();
        responseClient.setClientsDtos(clientsDtos);
        responseClient.setPageNo(page.getNumber());
        responseClient.setPageSize(page.getSize());
        responseClient.setTotalElements(page.getTotalElements());
        responseClient.setLast(page.isLast());
        return responseClient;
    }

    @Override
    public ClientsDto findById(Long clientId) {
        return clientConverter.entityToDto(clientsRepository.findById(clientId)
                .orElseThrow(() -> new ClientsException("Client with this id " + clientId + "not found")));

    }

    @Override
    public ClientsDto create(ClientsDto clientsDto) {
        clientsRepository.save(clientConverter.dtoToEntity(clientsDto));
        return clientsDto;
    }

    @Override
    public Clients update(ClientsDto clientsDto) {
        return clientsRepository.save(clientConverter.dtoToEntity(clientsDto));
    }

    @Override
    public void deleteById(Long clientId) {
        try {
            clientsRepository.deleteById(clientId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
    }
}
