package hong.multipointer;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteArrayNoneRepeatDataTest {

    private DeleteArrayNoneRepeatData data = new DeleteArrayNoneRepeatData();

    @Test
    public void deleteNoneRepeatData() {
//        int[] arr = {0, 1, 1, 1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 7, 7, 8, 8, 8, 8, 8, 8};
        int[] arr = {0, 1, 2, 3};
        int i = data.deleteNoneRepeatData(arr);
        System.out.println(i);
        System.out.println("===");
        for (int j = 0; j <= i; j++) {
            System.out.println(arr[j]);
        }
    }
}