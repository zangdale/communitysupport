//获取标题栏展示的用户名
window.onload = function () {
    //DrawTable(null);
    console.log("do get user name");
    $.ajax({
        type: "get",
        url: "/getsession",
        dataType: "json",
        success: function (res) {
            console.log(res);
            //alert(res);
            if (res.code === 200) {
                document.getElementById('show_account').innerText = res.data.uname;
            } else {
                document.getElementById('show_account').innerText = "请登录";
            }
        },
        error: function () {
            document.getElementById('show_account').innerText = "请登录";
        }
    });
    $.ajax({
        type: "get",
        url: "/getcheck",
        dataType: "json",
        success: function (res) {
            console.log(res);
            //alert(res);
            if (res.code === 200) {
                DrawTable(res.data);
            } else {
                document.getElementById('show_account').innerText = "请登录";
            }
        },
        error: function () {
            document.getElementById('show_account').innerText = "请登录";
        }
    });
};
function renderTime(date) {
    var date = new Date(date).toJSON();
    return new Date(+new Date(date) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
};
function upWnumber(oldarr) {
    var arr=new Array();
    for (var i=0,len=oldarr.length; i<len; i++) {
        arr[i]=oldarr[i].wnumber;
    }
    return arr;
};
function upBnumber(oldarr) {
    var arr=new Array();
    for (var i=0,len=oldarr.length; i<len; i++) {
        arr[i]=oldarr[i].bnumber;
    }
    return arr;
};
function upJnumber(oldarr) {
    var arr=new Array();
    for (var i=0,len=oldarr.length; i<len; i++) {
        arr[i]=oldarr[len-i-1].jnumber;
    }
    return arr;
};
function upKnumber(oldarr) {
    var arr=new Array();
    for (var i=0,len=oldarr.length; i<len; i++) {
        arr[i]=oldarr[i].knumber;
    }
    return arr;
};
function upTime(oldarr) {
    var arr=new Array();
    for (var i=0,len=oldarr.length; i<len; i++) {
        arr[i]=String(renderTime(oldarr[i].kdate)).substr(0,10);
    }
    return arr;
};
function DrawTable(valdata) {

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '综合监测数据',
            subtext: '数据可以按照选择进行展示'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['心跳', '血压', '体重', '综合得分']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data:[]
            }
        ],
        yAxis: [
            {
                type: 'value',
                axisLabel: {
                    formatter: '{value} 分'
                }
            }
        ],
        series: [
            {
                name: '心跳',
                type: 'line',
                data: [],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '血压',
                type: 'line',
                data: [],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '体重',
                type: 'line',
                data: [],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            }, {
                name: '综合得分',
                type: 'line',
                data: [],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
        ]
    };
    //数据填充
    var weughts=valdata.weughts;
    var bloods=valdata.bloods;
    var jumps=valdata.jumps;
    var keepages=valdata.keepages;
    //填充的数组
    var weught=upWnumber(weughts,weught);
    var blood=upBnumber(bloods);
    var jump=upJnumber(jumps);
    var keepage=upKnumber(keepages);
    var times=upTime(keepages);


    //心跳
    option.series[0].data=jump;
    //血压
    option.series[1].data=blood;
    //体重
    option.series[2].data=weught;
    //综合得分
    option.series[3].data=keepage;
    console.log(times)
    option.xAxis[0].data=times;
    console.log(option.xAxis.data)
    //console.log(option);

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'), 'customed');
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

}




