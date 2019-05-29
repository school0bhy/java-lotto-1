package lotto.domain;

import java.util.List;

public class WinningLotto{
    private final LottoTicket winningLotto;

    private WinningLotto(LottoTicket winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static WinningLotto create(List<Integer> lottoNumbers) {
        return new WinningLotto(LottoTicket.create(lottoNumbers));
    }

    public LottoRank checkLottoRank(LottoTicket userLottoTicket) {
        return LottoRank.rankOf(winningLotto.countOfMatch(userLottoTicket));
    }
}
