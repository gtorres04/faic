package tv.codely.apps.mooc.backend.controller.email;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.email.application.send.UserProfileRegistrationCodeStatusFinder;
import tv.codely.mooc.userprofile.application.create.CreateUserProfileRequest;
import tv.codely.mooc.userprofile.application.create.UserProfileCreator;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.util.HashMap;
import java.util.UUID;

@RestController
final public class UserProfileRegistrationCodeStatusGetController extends ApiController {
    private final UserProfileRegistrationCodeStatusFinder userProfileRegistrationCodeStatusFinder;

    @InjectDependency
    public UserProfileRegistrationCodeStatusGetController(UserProfileRegistrationCodeStatusFinder userProfileRegistrationCodeStatusFinder, QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
        this.userProfileRegistrationCodeStatusFinder = userProfileRegistrationCodeStatusFinder;
    }

    @GetMapping("/user-profile-registration-code-status")
    public HashMap<String, String> getUserProfileRegistrationCodeStatus() {
        return new HashMap<String, String>() {{
            put("status", userProfileRegistrationCodeStatusFinder.find().status());
        }};
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
