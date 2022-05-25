import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 100% lines covered (проверил)
 */
class ArrayTransformTest {

    private static ArrayTransform arrayTransform;

    @BeforeAll
    public static void init() {
        arrayTransform = new ArrayTransform();
    }

    @ParameterizedTest
    @MethodSource("dataForArrayConvert")
    public void ArrayConvertTest(int[] arr, int[] result) {
        assertArrayEquals(result, arrayTransform.arrayConvert(arr));
    }

    @ParameterizedTest
    @MethodSource("dataForCheckingArray")
    public void checkingArrayTest(int[] arr, boolean result) {
        assertEquals(result, arrayTransform.checkingArray(arr));
    }

    @ParameterizedTest
    @MethodSource("invalidDataForArrayConvert")
    public void whenInvalidData_thenThrows(int[] arr) {
        assertThrows(RuntimeException.class, () -> arrayTransform.arrayConvert(arr));
    }

    public static Stream<Arguments> dataForArrayConvert() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}),
                Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 1, 7}, new int[]{2, 3, 1, 7}),
                Arguments.arguments(new int[]{4, 2, 2, 3, 1, 7}, new int[]{2, 2, 3, 1, 7}),
                Arguments.arguments(new int[]{4, 2}, new int[]{2})
        );
    }

    public static Stream<Arguments> invalidDataForArrayConvert() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3}),
                Arguments.arguments(new int[]{1, 2, 3, 4})
        );
    }

    public static Stream<Arguments> dataForCheckingArray() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 4, 6}, true),
                Arguments.arguments(new int[]{1, 4, 5, 5}, true),
                Arguments.arguments(new int[]{1, 4, 4, 1}, true),
                Arguments.arguments(new int[]{1, 2, 3, 4}, true),
                Arguments.arguments(new int[]{1, 2, 3}, false),
                Arguments.arguments(new int[]{2, 3, 4}, false),
                Arguments.arguments(new int[]{1, 2, 3}, false),
                Arguments.arguments(new int[]{2, 3}, false)
        );
    }

}