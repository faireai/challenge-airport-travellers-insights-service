package ai.faire.challenge.airport.util;

import java.math.BigDecimal;
import java.util.List;

public final class StatisticUtil {

  private StatisticUtil() {
  }

  /**
   * Calculate the probability of events that are statistically independent.
   *
   * @param probabilities List of the event probabilities. It cannot be empty
   * @return The probability of the events.
   */
  public static BigDecimal probabilityOfIndependentEvents(List<BigDecimal> probabilities) {
    if (probabilities == null) {
      throw new IllegalArgumentException("Probabilities list cannot be null");
    }
    return io.vavr.collection.List.ofAll(probabilities)
      .reduceOption(BigDecimal::multiply)
      .getOrElseThrow(() -> new IllegalArgumentException("Probabilities list cannot be empty"));
  }
}
