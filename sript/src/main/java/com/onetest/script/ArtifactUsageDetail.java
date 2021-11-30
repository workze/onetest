package com.onetest.script;


import lombok.Data;

import java.io.Serializable;

@Data
public class ArtifactUsageDetail implements Serializable {

    private static final long serialVersionUID = 1638106817505L;

    private Integer providerAppId;
    private String providerAppName;
    private String providerDepartment1;
    private String providerDepartment2;
    private String providerDepartment3;
    private String providerDepartment4;

    /**
     * 主键
     */
    private Integer usageId;

    /**
     * 制品
     */
    private String artifactId;
    private String groupId;
    private String version;
    private String rpcClient;
    private String snapshot;

    private Integer consumerAppId;
    private String consumerAppName;
    private String consumerDepartment1;
    private String consumerDepartment2;
    private String consumerDepartment3;
    private String consumerDepartment4;
}
