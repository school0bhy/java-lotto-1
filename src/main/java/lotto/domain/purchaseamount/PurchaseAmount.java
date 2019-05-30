package lotto.domain.purchaseamount;

import lotto.domain.lotto.LottoTicket;

public class PurchaseAmount {
    private int money;

    private PurchaseAmount(int money) {
        this.money = money;
        validatePurchaseAmount();
    }

    private void validatePurchaseAmount() {
        if (money <= LottoTicket.PRICE) {
            throw new PurchaseAmountException("최소 구입 금액은 " + LottoTicket.PRICE + "입니다.");
        }
    }

    public static PurchaseAmount create(String moneyText) {
        try {
            return new PurchaseAmount(Integer.parseInt(moneyText.trim()));
        } catch (NumberFormatException e) {
            throw new PurchaseAmountException("금액은 숫자로 구성하세요.");
        }
    }

    public boolean buy(LottoTicket lottoTicket) {
        if (lottoTicket.PRICE > money) {
            return false;
        }
        money -= lottoTicket.PRICE;
        return true;
    }

    public int available() {
        return money;
    }

    @Override
    public String toString() {
        return "잔액 : " + money;
    }
}
