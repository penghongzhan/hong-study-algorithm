package hong.multipointer;

/**
 * 删除数组中不重复的元素
 *
 * @author : zhanpenghong
 * @date : 2023/2/21 20:37
 */
public class DeleteArrayNoneRepeatData {

    /**
     * 删除数组中不重复的元素
     */
    public int deleteNoneRepeatData(int[] arr) {
        if (arr == null || arr.length == 1) {
            return -1;
        }
        int effect = -1;
        int index = 1;
        while (index < arr.length) {
            int count = 0;
            while (index < arr.length && arr[index] == arr[index - 1]) {
                index++;
                count++;
            }
            if (count > 0) {
                count++;
                for (int i = 0; i < count; i++) {
                    arr[++effect] = arr[index - count + i];
                }
            } else {
                index++;
            }
        }
        return effect;
    }

}
