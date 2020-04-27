package tv.codely.mooc.email.application.send;

import lombok.AllArgsConstructor;
import tv.codely.mooc.email.domain.IUserProfileRegistrationCodeRepository;
import tv.codely.mooc.email.domain.UserProfileRegistrationCode;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.Service;

@Service
@AllArgsConstructor(onConstructor_= {@InjectDependency})
public final class UserProfileRegistrationCodeStatusFinder {
    private final IUserProfileRegistrationCodeRepository userProfileRegistrationCodeRepository;

    public UserProfileRegistrationCodeStatusResponse find(){
        UserProfileRegistrationCode userProfileRegistrationCode = userProfileRegistrationCodeRepository.search().findFirst().get();
        return new UserProfileRegistrationCodeStatusResponse(userProfileRegistrationCode.status().value());
    }
}
