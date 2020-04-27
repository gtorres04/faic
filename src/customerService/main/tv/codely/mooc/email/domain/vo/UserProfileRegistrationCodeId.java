package tv.codely.mooc.email.domain.vo;

import lombok.ToString;
import tv.codely.shared.domain.Identifier;

@ToString(callSuper = true)
public final class UserProfileRegistrationCodeId extends Identifier {
    public UserProfileRegistrationCodeId(String value){
        super(value);
    }
}
