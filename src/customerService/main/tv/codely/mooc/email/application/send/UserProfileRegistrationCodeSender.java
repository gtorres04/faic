package tv.codely.mooc.email.application.send;

import lombok.AllArgsConstructor;
import tv.codely.mooc.email.domain.IUserProfileRegistrationCodeRepository;
import tv.codely.mooc.email.domain.IUserProfileRegistrationCodeSenderEmail;
import tv.codely.mooc.email.domain.UserProfileRegistrationCode;
import tv.codely.mooc.email.domain.vo.UserProfileRegistrationCodeCode;
import tv.codely.mooc.email.domain.vo.UserProfileRegistrationCodeId;
import tv.codely.mooc.email.domain.vo.UserProfileRegistrationCodeStatus;
import tv.codely.mooc.email.domain.vo.UserProfileRegistrationCodeUserProfile;
import tv.codely.mooc.shared.domain.enums.StatusUserProfileRegistrationCode;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.UuidGenerator;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
@AllArgsConstructor(onConstructor_= {@InjectDependency})
public final class UserProfileRegistrationCodeSender {
    private final IUserProfileRegistrationCodeRepository userProfileRegistrationCodeRepository;
    private final IUserProfileRegistrationCodeSenderEmail registrationCodeSenderEmail;
    private final UuidGenerator uuidGenerator;
    private final EventBus eventBus;
    public void send(UserProfileRegistrationCodeUserProfile userProfile) {
        if(!userProfileRegistrationCodeRepository.search()
            .filter(userProfileRegistrationCode -> userProfile.value().email().equals(userProfileRegistrationCode.userProfile().value().email()))
            .findFirst().isPresent()){
            UserProfileRegistrationCode userProfileRegistrationCode = UserProfileRegistrationCode.create(new UserProfileRegistrationCodeId(uuidGenerator.generate()),
                userProfile, new UserProfileRegistrationCodeCode(uuidGenerator.generate()), new UserProfileRegistrationCodeStatus(StatusUserProfileRegistrationCode.SENT.name()));
            registrationCodeSenderEmail.send(userProfileRegistrationCode);
            userProfileRegistrationCodeRepository.save(userProfileRegistrationCode);
            eventBus.publish(userProfileRegistrationCode.pullDomainEvents());
        }

    }
}
