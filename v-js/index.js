

var template = `
<table bgcolor="#FFFFFF">
    <tr>
        <th>Name</th>
        <th>Email</th>
    </tr>

    {{#each response}}
        <tr>
            <td>{{appName}}</td>
            <td>{{email}}</td>
        </tr>
    {{/each}}
</table>
`;

var s = `{
    "code": 200,
    "data": [
        {
            "department": {
                "departmentId": "D083002005001",
                "department1": "音乐事业部",
                "department2": "技术中心",
                "department3": "公共技术部",
                "department4": "业务中间件组",
                "department5": null
            },
            "owner": "hzguoyuanhua",
            "recentCommiter": "jiangxingtao",
            "recentCommiterList": [
                "hzlindzh",
                "jiangxingtao"
            ],
            "lastParseTimestamp": 1639973724628,
            "lastParseTime": "2021-12-20 12:15:24",
            "lastCommitId": "c436da196042d1320bc3f565b28e217a07656033",
            "projectBuildType": null,
            "traceId": "0000017dd60c8e4f10da0ac7072601c8",
            "appId": 485,
            "appName": "nydus-kernel"
        }
    ],
    "message": ""
}`
var res = s
if (res && res.data) {
    if (res.data) {
        console.log(typeof res.data)
    }
}

// Set visualizer
// pm.visualizer.set(template, {
//     // Pass the response body parsed as JSON as `data`
//     response: pm.response.json().data
// });