package tv.codely.mooc.email.domain;

public interface IUserProfileRegistrationCodeSenderEmail {
    void send(UserProfileRegistrationCode userProfileRegistrationCode);
}
