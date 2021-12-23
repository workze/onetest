package com.onetest.script;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangguize
 * @date 2021/11/30
 */
public class ArtifactUsageAnalyze {

    public static void main(String[] args) {

        List<ArtifactUsageDetail> all = new ArrayList<>(10000);

        String url = "https://music-ox.hz.netease.com/api/overmindx/artifactusage/list?offset=%s&limit=%s";
        int pageSize = 1000;
        int offset = 0;
        List<ArtifactUsageDetail> results = null;
        do {
            String s = HttpUtil.get(String.format(url, offset, pageSize));
            JSONObject result = JSON.parseObject(s);
            JSONArray data = result.getJSONArray("data");
            if (data != null) {
                results = data.toJavaList(ArtifactUsageDetail.class);
                all.addAll(results);
            }

            offset = offset + pageSize;
            System.out.println(offset);
        } while (CollUtil.size(results) > 0);

        System.out.println(all.size());

        CsvWriter csvWriter = new CsvWriter(new File("artifact-usage-detail-3.csv"));
        csvWriter.writeBeans(all);

    }

}
