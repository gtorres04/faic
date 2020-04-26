package tv.codely.mooc.userprofile.application.create;

import lombok.AllArgsConstructor;
import tv.codely.mooc.userprofile.domain.*;
import tv.codely.mooc.userprofile.domain.vo.UserProfileName;
import tv.codely.shared.domain.InjectDependency;
import tv.codely.shared.domain.Service;

@AllArgsConstructor(onConstructor_={@InjectDependency})
@Service
public final class UserProfileCreator {

    private final IUserProfileRepository userProfileRepository;

    public void create(CreateUserProfileRequest request){
        UserProfile userProfile = new UserProfile(new UserProfileId(request.id()), new UserProfileName(request.name()), new UserProfileLastName(request.lastName()),
            new UserProfileCellPhoneNumber(request.cellPhoneNumber()), new UserProfileEmail(request.email()), new UserProfileUsername(request.username()),
            UserProfilePassword.createPasswordTheFirstTime(request.password(), request.passwordConfirm()));
        userProfileRepository.save(userProfile);
    }
}
