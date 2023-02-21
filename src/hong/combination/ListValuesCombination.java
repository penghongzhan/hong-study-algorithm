package hong.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对多个list的值进行排列组合
 *
 * @author : zhanpenghong
 * @date : 2023/2/7 11:59
 */
public class ListValuesCombination {

    /**
     * 生成维值的所有组合情况
     */
    public List<String> combineDimValues(List<List<String>> list) {
        List<String> result = new ArrayList<>();
        if (list != null && list.size() > 0) {
            combineDimValues(result, new ArrayList<>(), 0, list);
        }
        return result;
    }


    private void combineDimValues(List<String> result, List<String> codes, int index,
            List<List<String>> list) {
        if (index == list.size() - 1) {
            /* 递归结束条件 */
            for (String v : list.get(index)) {
                codes.add(v);
                result.add(codes.stream().map(c -> "[" + c + "]").collect(Collectors.joining()));
                codes.remove(index);
            }
            return;
        }
        for (String v : list.get(index)) {
            codes.add(v);
            combineDimValues(result, codes, index + 1, list);
            codes.remove(index);
        }
    }

}
