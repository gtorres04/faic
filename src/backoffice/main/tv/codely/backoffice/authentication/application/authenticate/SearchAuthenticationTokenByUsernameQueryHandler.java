package tv.codely.backoffice.authentication.application.authenticate;

import tv.codely.backoffice.authentication.domain.AuthUsername;
import tv.codely.backoffice.authentication.usecases.authenticate.AuthenticationTokenSearcher;
import tv.codely.shared.domain.bus.query.QueryHandler;

import java.util.Optional;

@tv.codely.shared.application.QueryHandler
public final class SearchAuthenticationTokenByUsernameQueryHandler implements QueryHandler<SearchAuthenticationTokenByUsernameQuery, AuthenticationTokenResponse> {
    private final AuthenticationTokenSearcher searcher;

    public SearchAuthenticationTokenByUsernameQueryHandler(AuthenticationTokenSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public AuthenticationTokenResponse handle(SearchAuthenticationTokenByUsernameQuery query) {
        return searcher.searchByUsername(new AuthUsername(query.username().get()))
            .map(authToken -> AuthenticationTokenResponse.createAfterAuthenticate(Optional.ofNullable(authToken.value())))
            .orElseThrow(()->new RuntimeException("Token no encontrado, el usuario no se ha autenticado"));
    }
}
