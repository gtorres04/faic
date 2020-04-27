package tv.codely.mooc.email.domain.vo;

import lombok.ToString;
import tv.codely.shared.domain.Identifier;

@ToString(callSuper = true)
public final class UserProfileRegistrationCodeCode extends Identifier {
    public UserProfileRegistrationCodeCode(String value){
        super(value);
    }
}
