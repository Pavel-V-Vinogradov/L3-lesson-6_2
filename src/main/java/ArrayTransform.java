import java.util.Arrays;

public class ArrayTransform {

    public int[] arrayConvert(int[] arr) {

        Integer LastOccurrenceIndex = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                if (i == arr.length - 1) {
                    break;
                } else {
                    LastOccurrenceIndex = i;
                    break;
                }
            }
        }
        if (LastOccurrenceIndex == null) {
            throw new RuntimeException("the array must contain at least one four");
        }
        return Arrays.copyOfRange(arr, LastOccurrenceIndex + 1, arr.length);
    }

    public boolean checkingArray(int[] arr) {
        boolean existOne = false;
        boolean existFour = false;
        for (int i : arr) {
            if (!existOne) {
                existOne = (i == 1);
            }
            if (!existFour) {
                existFour = (i == 4);
            }
            if (existOne && existFour) {
                return true;
            }
        }
        return false;
    }
}
