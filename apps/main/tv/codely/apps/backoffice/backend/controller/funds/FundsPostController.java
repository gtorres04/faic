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
import tv.codely.backoffice.funds.application.create.CreateFundCommand;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.exceptions.CreatorException;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public final class FundsPostController extends ApiController {

    @InjectDependency
    public FundsPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/funds")
    public ResponseEntity create(@RequestBody Request request) {
        try {
            dispatch(new CreateFundCommand(request.name()));
        } catch (CommandHandlerExecutionError commandHandlerExecutionError) {
            CreatorException creatorException = (CreatorException) commandHandlerExecutionError.getCause();
            List<RequestError> list = creatorException.exceptions().stream()
                .map(e -> new RequestError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "N/A"))
                .collect(Collectors.toList());
            return new ResponseEntity(list, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

@Getter
@AllArgsConstructor
final class RequestError {
    @JsonProperty("error-code")
    private Integer errorCode;
    @JsonProperty("user-message")
    private String userMessage;
    @JsonProperty("technical-message")
    private String technicalMessage;
}

@Getter
@Setter(onMethod_ = {@JsonSetter})
@ToString
final class Request {
    private String name;
}
