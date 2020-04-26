package tv.codely.mooc.userprofile.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tv.codely.mooc.userprofile.domain.exceptions.UserProfilePasswordException;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserProfilePassword {
    private String value;

    public static UserProfilePassword createPasswordTheFirstTime(String value, String valueConfirm){
        ensureTheSameValue(value, valueConfirm);
        return new UserProfilePassword(value);
    }

    private static void ensureTheSameValue(String value, String valueConfirm) {
        if(!value.equals(valueConfirm)){
            throw new UserProfilePasswordException("El password no cohincide con el password de confirmacion");
        }
    }
}
