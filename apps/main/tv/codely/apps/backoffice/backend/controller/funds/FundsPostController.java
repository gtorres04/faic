package tv.codely.apps.backoffice.backend.controller.funds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.backoffice.funds.application.create.CreateFundsRequest;
import tv.codely.backoffice.funds.usecases.FundsCreator;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.exceptions.CreatorException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor(onConstructor_={@InjectDependency})
@Slf4j
public final class FundsPostController {
    private final FundsCreator creator;
    @PostMapping("/funds")
    public ResponseEntity create(@RequestBody Request request){
        try{
            creator.create(new CreateFundsRequest(UUID.nameUUIDFromBytes(request.toString().getBytes()).toString(),
                request.name()));
        }catch (CreatorException creatorException){
            List<RequestError> list = creatorException.exceptions().stream()
                .map(e -> new RequestError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "N/A"))
                .collect(Collectors.toList());
            return new ResponseEntity(list, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

@Getter
@AllArgsConstructor
final class RequestError{
    @JsonProperty("error-code")
    private Integer errorCode;
    @JsonProperty("user-message")
    private String userMessage;
    @JsonProperty("technical-message")
    private String technicalMessage;
}

@Getter
@Setter(onMethod_= {@JsonSetter})
@ToString
final class Request {
    private String name;
}
