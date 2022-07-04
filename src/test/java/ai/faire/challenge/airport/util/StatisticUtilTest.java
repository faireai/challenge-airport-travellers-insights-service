package ai.faire.challenge.airport.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static ai.faire.challenge.airport.util.StatisticUtil.probabilityOfIndependentEvents;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StatisticUtilTest {

  @ParameterizedTest
  @MethodSource("probabilityFixtures")
  void probabilityOfIndependentEventsShouldSucceed(List<BigDecimal> probabilities, BigDecimal expectedProbability) {
    // when
    BigDecimal probability = probabilityOfIndependentEvents(probabilities);

    // then
    assertThat(probability).isEqualByComparingTo(expectedProbability);
  }

  @Test
  void probabilityOfIndependentEventsShouldFailWhenInputIsNull() {
    // when/then
    var error = assertThrows(IllegalArgumentException.class, () -> probabilityOfIndependentEvents(null));
    assertThat(error.getMessage()).isEqualTo("Probabilities list cannot be null");
  }

  @Test
  void probabilityOfIndependentEventsShouldFailWhenInputIsEmpty() {
    // when/then
    var error = assertThrows(IllegalArgumentException.class, () -> probabilityOfIndependentEvents(List.of()));
    assertThat(error.getMessage()).isEqualTo("Probabilities list cannot be empty");
  }

  private static Stream<Arguments> probabilityFixtures() {
    return Stream.of(
      Arguments.of(
        List.of(probabilityOf("0.00")),
        probabilityOf("0.00")
      ),
      Arguments.of(
        List.of(probabilityOf("0.59"), probabilityOf("0.98")),
        probabilityOf("0.5782")
      ),
      Arguments.of(
        List.of(probabilityOf("0.59"), probabilityOf("0.98"), probabilityOf("1.00")),
        probabilityOf("0.5782")
      )
    );
  }

  private static BigDecimal probabilityOf(String probability) {
    return new BigDecimal(probability);
  }
}
