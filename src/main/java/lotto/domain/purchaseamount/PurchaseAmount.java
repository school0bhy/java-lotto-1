package lotto.domain.purchaseamount;

import lotto.domain.LottoQuantity;
import lotto.domain.lotto.LottoTicket;

public class PurchaseAmount {
    private static final int MIN_MONEY = 0;

    private int money;

    private PurchaseAmount(int money) {
        validatePurchaseAmount(money);
        this.money = money;
    }

    public static PurchaseAmount create(String moneyText) {
        try {
            return new PurchaseAmount(Integer.parseInt(moneyText.trim()));
        } catch (NumberFormatException e) {
            throw new PurchaseAmountException("구입 금액은 숫자로 구성하세요.");
        }
    }

    private void validatePurchaseAmount(int money) {
        if (money < MIN_MONEY) {
            throw new PurchaseAmountException("구입금액은 음수로 설정할 수 없습니다.");
        }
    }

    public LottoQuantity maxLottoQuantity() {
        return LottoQuantity.create(money / LottoTicket.PRICE);
    }

    public PurchaseAmount buy(int price) {
        if (canBuy(price)) {
            return new PurchaseAmount(money - price);
        }
        return this;
    }

    public boolean canBuy(int price) {
        return money >= price;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "잔액 : " + money;
    }
}
