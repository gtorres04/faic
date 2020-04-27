package tv.codely.mooc.email.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tv.codely.mooc.email.domain.IUserProfileRegistrationCodeSenderEmail;
import tv.codely.mooc.email.domain.UserProfileRegistrationCode;

@Component
@Slf4j
public class UserProfileRegistrationCodeSenderEmailImpl implements IUserProfileRegistrationCodeSenderEmail {
    @Override
    public void send(UserProfileRegistrationCode userProfileRegistrationCode) {
        System.out.println(userProfileRegistrationCode.toString());
    }
}
