package by.academyit.itBootcampJavaTestTask.enumConverter;

import by.academyit.itBootcampJavaTestTask.dto.ClientsDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseClients {
    private List<ClientsDto> clientsDtos;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
