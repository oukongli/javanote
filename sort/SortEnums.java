package sort;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kouyang on 3/28/2016.
 */
public class SortEnums {
    public static void main(String[] args) {
        String str = "APPLE-BUNDLE|ANDROID-PACKAGE|WINDOWS-BUNDLE";
        List<String> list = Arrays.asList(str.split("\\|"));
        Collections.sort(list);
        String result = StringUtils.join(list, "|");
        System.out.println(result);
    }
}
