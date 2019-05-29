package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {
    private final WinningLotto winningLotto;
    private final Map<LottoRank, Integer> rankStatistic = new LinkedHashMap<>();

    LottoResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankStatistic.put(rank, 0));
    }

    void update(LottoTicket userLotto) {
        LottoRank rank = winningLotto.checkLottoRank(userLotto);
        rankStatistic.replace(rank, rankStatistic.get(rank) + 1);
    }

    int countOfRank(LottoRank lottoRank) {
        return rankStatistic.get(lottoRank);
    }
}
