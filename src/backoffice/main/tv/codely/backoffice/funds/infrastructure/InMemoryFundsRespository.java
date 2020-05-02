package tv.codely.backoffice.funds.infrastructure;

import tv.codely.backoffice.funds.domain.Fund;
import tv.codely.backoffice.funds.domain.IFundsRepository;
import tv.codely.shared.infrastructure.Adapter;

import java.util.HashMap;
import java.util.Map;

@Adapter
public final class InMemoryFundsRespository implements IFundsRepository {
    Map<String, Fund> map = new HashMap<>();
    @Override
    public void save(Fund fund) {
        map.put(fund.id().value(), fund);
    }

    @Override
    public boolean doesNameOfFundExists(String name) {
        return map.values().stream().anyMatch(fund -> name.equals(fund.name().value()));
    }

    @Override
    public boolean doesIdOfFundExists(String id) {
        return null != map.get(id);
    }
}
