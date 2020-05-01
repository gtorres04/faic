package tv.codely.backoffice.funds.infrastructure;

import tv.codely.backoffice.funds.domain.Fund;
import tv.codely.backoffice.funds.domain.IFundRepository;
import tv.codely.shared.infrastructure.Adapter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Adapter
public final class InMemoryFundsRespository implements IFundRepository {
    Map<String, Fund> map = new HashMap<>();
    @Override
    public void save(Fund fund) {
        map.put(fund.id().value(), fund);
    }

    @Override
    public boolean doesNameOfFundExists(String value) {
        return map.values().stream().anyMatch(fund -> value.equals(fund.name().value()));
    }
}
