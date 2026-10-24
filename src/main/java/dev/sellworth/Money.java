package dev.sellworth;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Short money formatting (1.2K, 3.5M ...) and the "Worth: $X" tooltip line. */
public final class Money {

    private static final String[] SUFFIX = {"", "K", "M", "B", "T", "Qa", "Qi"};
    private static final BigDecimal THOUSAND = BigDecimal.valueOf(1000L);

    private Money() { }

    public static String shortFormat(double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount)) return "0";

        BigDecimal value = BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP);
        int i = 0;
        BigDecimal abs = value.abs();
        while (abs.compareTo(THOUSAND) >= 0 && i < SUFFIX.length - 1) {
            abs = abs.movePointLeft(3);
            i++;
        }
        return value.movePointLeft(3 * i).stripTrailingZeros().toPlainString() + SUFFIX[i];
    }

    /** "Worth: " in #00a2ff, then a green "$" and the amount in white. */
    public static Component line(double amount) {
        return Component.text("Worth: ", TextColor.color(0x00a2ff))
                .append(Component.text("$", NamedTextColor.GREEN))
                .append(Component.text(shortFormat(amount), NamedTextColor.WHITE))
                .decoration(TextDecoration.ITALIC, false);
    }
}
