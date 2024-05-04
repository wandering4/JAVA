package Bean;

import java.util.*;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 20:18
 * @Description: Bean
 * @version: 1.0
 */
public class ArrayListMap {
    String[] arr;
    List<String> list;
    Map<Integer,String> map;

    @Override
    public String toString() {
        return "ArrayListMap{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public ArrayListMap() {
    }
}
