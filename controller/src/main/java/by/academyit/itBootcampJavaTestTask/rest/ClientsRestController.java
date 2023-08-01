package by.academyit.itBootcampJavaTestTask.rest;

import by.academyit.itBootcampJavaTestTask.dto.ClientsDto;
import by.academyit.itBootcampJavaTestTask.ClientsService;
import by.academyit.itBootcampJavaTestTask.exceptions.AppError;
import by.academyit.itBootcampJavaTestTask.enumConverter.Constant;
import by.academyit.itBootcampJavaTestTask.enumConverter.ResponseClients;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/api/clients", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class ClientsRestController {

    private final ClientsService clientsService;

    private static final Logger logger = LogManager.getLogger(ClientsRestController.class);
    @GetMapping(value = "/showAll")
    public ResponseEntity<?> showClients(@RequestParam(value = Constant.PAGE_NO,
            defaultValue = Constant.DEFAULT_PAGE_NO) int pageNo,
                                         @RequestParam(value = Constant.PAGE_SIZE,
                                                 defaultValue = Constant.DEFAULT_PAGE_SIZE) int pageSize,
                                         @RequestParam(value = Constant.SORT_BY,
                                                 defaultValue = Constant.DEFAULT_SORT_BY) String sortBy,
                                         @RequestParam(value = Constant.SORT_DIR,
                                                 defaultValue = Constant.DEFAULT_SORT_DIR) String sortDir) {
        ResponseClients responseClientsBody = clientsService.getAll(pageNo, pageSize, sortBy, sortDir);

        if (responseClientsBody == null) {

            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Clients don't found"), HttpStatus.NO_CONTENT);
        }
logger.info("Response: {}", responseClientsBody);
        return new ResponseEntity<>(responseClientsBody, HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{idClient}")
    public ResponseEntity<?> getClientById(@PathVariable(Constant.ID_CLIENT) Long idClient ) {

        ClientsDto clientsDto = clientsService.findById(idClient);

        if (clientsDto == null) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Clients don't found with this id:" + idClient), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(clientsDto, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<ClientsDto> createClient(@Valid ClientsDto clientsDto) {
        ClientsDto clientsDto1 = clientsService.create(clientsDto);
        return new ResponseEntity<>(clientsDto1, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{idClient}", consumes = "application/json")
    public ResponseEntity<?> updateClient(@PathVariable(Constant.ID_CLIENT) Long idClient,
                                          @Valid @RequestBody ClientsDto editClientDto) {

        ClientsDto removedClientDto = clientsService.findById(idClient);
        if (removedClientDto == null) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Clients don't found with this id:" + idClient), HttpStatus.NO_CONTENT);
        }

        removedClientDto.setSurnameClient(editClientDto.getSurnameClient());
        clientsService.update(removedClientDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{idClient}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClientById(@PathVariable(Constant.ID_CLIENT) Long idClient) {
        try {
            clientsService.deleteById(idClient);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
    }

}
