package tv.codely.mooc.userprofile.application.create;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateUserProfileRequest {
    private String id;
    private String name;
    private String lastName;
    private Long cellPhoneNumber;
    private String email;
    private String username;
    private String password;
    private String passwordConfirm;
}
