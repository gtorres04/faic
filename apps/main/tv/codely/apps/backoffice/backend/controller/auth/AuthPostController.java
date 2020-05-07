package tv.codely.apps.backoffice.backend.controller.auth;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.codely.backoffice.auth.application.authenticate.AuthenticateUserCommand;
import tv.codely.backoffice.courses.application.BackofficeCoursesResponse;
import tv.codely.backoffice.courses.application.search_by_criteria.SearchBackofficeCoursesByCriteriaQuery;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.bus.query.QueryHandlerExecutionError;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public final class AuthPostController extends ApiController {
    public AuthPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/auth")
    public ResponseEntity index(
        @RequestBody RequestAuth requestAuth
    ) {
        AuthenticateUserCommand authenticateUserCommand = new AuthenticateUserCommand(requestAuth.username(), requestAuth.password());
        dispatch(authenticateUserCommand);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

@Getter
@Setter(onMethod_ = {@JsonSetter})
@ToString
class RequestAuth {
    private String username;
    private String password;
}
