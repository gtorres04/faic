package tv.codely.mooc.email.application.send.domainEventSubscriber;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import tv.codely.mooc.email.application.send.UserProfileRegistrationCodeSender;
import tv.codely.mooc.email.domain.vo.UserProfileRegistrationCodeUserProfile;
import tv.codely.mooc.userprofile.domain.*;
import tv.codely.mooc.userprofile.domain.vo.UserProfileName;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.DomainEventSubscriber;
import tv.codely.shared.domain.userprofile.UserProfileCreatedDomainEvent;

@Service
@DomainEventSubscriber({UserProfileCreatedDomainEvent.class})
@AllArgsConstructor(onConstructor_= {@InjectDependency})
public final class SendRegistrationCodeOfTheUserProfileOnUserProfileCreated {

    private final UserProfileRegistrationCodeSender registrationCodeSender;

    @EventListener
    public void on(UserProfileCreatedDomainEvent event) {
        UserProfileId id = new UserProfileId(event.aggregateId());
        UserProfileEmail email = new UserProfileEmail(event.email());
        UserProfileName name = new UserProfileName(event.name());
        UserProfileLastName lastName = new UserProfileLastName(event.lastName());
        UserProfileCellPhoneNumber cellPhoneNumber = new UserProfileCellPhoneNumber(event.cellPhoneNumber());
        UserProfileUsername username = new UserProfileUsername(event.username());
        UserProfile userProfile = UserProfile.createUserProfileForSendRegistrationCode(id, name, lastName, email, cellPhoneNumber, username);
        registrationCodeSender.send(new UserProfileRegistrationCodeUserProfile(userProfile));
    }
}
