package lotto.printer;

import java.util.List;
import java.util.Map;
import lotto.data.Lotto;
import lotto.config.enumerate.WinningInfo;
import lotto.data.WinningResult;

public class ResultPrinter {

    public static void printLottoesBought(List<Lotto> lottoes) {
        System.out.println("\n" + lottoes.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoes) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<WinningInfo, Integer> entry : winningResult.getWinningCount().entrySet()) {
            WinningInfo info = entry.getKey();
            int count = entry.getValue();

            if (info.getPrize() == 0) {
                continue;
            }
            StringBuffer winningResultString = new StringBuffer();
            winningResultString.append(info.getMatchingNumbers()).append("개 일치");
            if (info.isBonus()) {
                winningResultString.append(", 보너스 볼 일치");
            }
            winningResultString.append(" (").append(String.format("%,d", info.getPrize())).append("원)");
            winningResultString.append(" - ");

            winningResultString.append(count).append("개");

            System.out.println(winningResultString);
        }
        System.out.println("총 수익률은 " + Math.round(winningResult.getProfitRate() * 10) / 10.0 + "%입니다.");
    }
}
