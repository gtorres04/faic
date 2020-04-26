package tv.codely.mooc.userprofile.application.create;

import lombok.AllArgsConstructor;
import tv.codely.mooc.userprofile.domain.*;
import tv.codely.mooc.userprofile.domain.vo.UserProfileName;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.EventBus;

@AllArgsConstructor(onConstructor_={@InjectDependency})
@Service
public final class UserProfileCreator {

    private final IUserProfileRepository userProfileRepository;
    private final EventBus eventBus;

    public void create(CreateUserProfileRequest request){
        UserProfile userProfile = UserProfile.create(new UserProfileId(request.id()), new UserProfileName(request.name()), new UserProfileLastName(request.lastName()),
            new UserProfileCellPhoneNumber(request.cellPhoneNumber()), new UserProfileEmail(request.email()), new UserProfileUsername(request.username()),
            UserProfilePassword.createPasswordTheFirstTime(request.password(), request.passwordConfirm()));
        userProfileRepository.save(userProfile);
        eventBus.publish(userProfile.pullDomainEvents());
    }
}
