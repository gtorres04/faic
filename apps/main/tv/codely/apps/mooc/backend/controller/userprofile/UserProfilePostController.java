package tv.codely.apps.mooc.backend.controller.userprofile;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.userprofile.application.create.CreateUserProfileRequest;
import tv.codely.mooc.userprofile.application.create.UserProfileCreator;
import tv.codely.shared.domain.InjectDependency;

import java.util.UUID;

@RestController
@AllArgsConstructor(onConstructor_={@InjectDependency})
final public class UserProfilePostController {
    private final UserProfileCreator userProfileCreator;

    @PostMapping("/user-profile")
    public ResponseEntity create(@RequestBody Request request) {
        userProfileCreator.create(new CreateUserProfileRequest(UUID.nameUUIDFromBytes(request.toString().getBytes()).toString(), request.name(), request.lastName(), request.cellPhoneNumber(), request.email(), request.username(), request.password(), request.passwordConfirm()));
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

@Getter
@Setter(onMethod_= {@JsonSetter})
@ToString
final class Request {
    private String name;
    private String lastName;
    private Long cellPhoneNumber;
    private String email;
    private String username;
    private String password;
    private String passwordConfirm;
}
