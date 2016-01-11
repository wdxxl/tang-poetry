package com.wdxxl.jsoup.crawler;

import java.util.HashMap;
import java.util.Map;

public class CategoryMap {
    public static Map<Integer, String> catagoryMap = new HashMap<>();

    static {
        for (int i = 1; i <= 310; i++) {
            if (i <= 33) {
                catagoryMap.put(i, "第一卷：五言古诗");
                continue;
            } else if (i >= 34 && i <= 40) {
                catagoryMap.put(i, "第二卷：五言乐府");
                continue;
            } else if (i >= 41 && i <= 69) {
                catagoryMap.put(i, "第三卷：七言古诗");
                continue;
            } else if (i >= 70 && i <= 82) {
                catagoryMap.put(i, "第四卷：七言乐府");
                continue;
            } else if (i >= 83 && i <= 161) {
                catagoryMap.put(i, "第五卷：五言律诗");
                continue;
            } else if (i >= 162 && i <= 214) {
                catagoryMap.put(i, "第六卷：七言律诗");
                continue;
            } else if (i == 215) {
                catagoryMap.put(i, "第七卷：七言乐府");
                continue;
            } else if (i >= 216 && i <= 244) {
                catagoryMap.put(i, "第八卷：五言绝句");
                continue;
            } else if (i >= 245 && i <= 252) {
                catagoryMap.put(i, "第九卷：五言乐府");
                continue;
            } else if (i >= 253 && i <= 301) {
                catagoryMap.put(i, "第十卷：七言绝句");
                continue;
            } else if (i >= 302 && i <= 310) {
                catagoryMap.put(i, "第十一卷：七言乐府");
                continue;
            }
        }
    }

    public static String getCatagoryMap(int key) {
        return catagoryMap.get(key);
    }

}
