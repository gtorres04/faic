package tv.codely.mooc.userprofile.domain.exceptions;

public final class UserProfilePasswordException extends RuntimeException {
    public UserProfilePasswordException(String msn) {
        super(msn);
    }
}
