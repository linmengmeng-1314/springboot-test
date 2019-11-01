$(function () {
		//表格
	layui.use('table', function() {
		var table = layui.table;
		table.render({
			elem: '#layuiTable',
			id: 'tableId',
			height: 'full-55',
			//toolbar: '#toolbar',
			method: 'get', //接口http请求类型，默认：get
			url: baseURL + 'jyzXx/queryJyzXxList', //?page=1&limit=10（该参数可通过 request 自定义）
			//where: {token: 'sasasas', id: 123}, //接口的其它参数
			 request: {
				pageName: 'page', //页码的参数名称，默认：page
				limitName: 'rows', //每页数据量的参数名，默认：limit
			}, 
			response: {
				statusName: 'code', //规定数据状态的字段名称，默认：code
				statusCode: 200, //规定成功的状态码，默认：0
				msgName: 'msg', //规定状态信息的字段名称，默认：msg
				countName: 'count', //规定数据总数的字段名称，默认：count
				dataName: 'resultList', //规定数据列表的字段名称，默认：data
			},
			page: true, //是否分页
			limit: 10, //每页显示的条数
			limits: [10, 20, 30], //每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]。
			cols: [
				[
					{
						field: 'xxzj', //字段名
						title: '信息主键不参与业务', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwDwmc', //字段名
						title: '经营单位_单位名称（注册）', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					},  					{
						field: 'jydwTyshxydm', //字段名
						title: '统一社会信用代码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					},					{
						field: 'jyzbm', //字段名
						title: '经营者（单位）编码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrXm', //字段名
						title: '实际经营人_姓名', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrGjhdqdm', //字段名
						title: '实际经营人_国籍(地区)', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrGjhdqmc', //字段名
						title: '实际经营人_国籍(地区)名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrCyzjdm', //字段名
						title: '实际经营人_证件种类', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrCyzjmc', //字段名
						title: '实际经营人_证件种类名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrZjhm', //字段名
						title: '实际经营人_证件号码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrWwx', //字段名
						title: '实际经营人_外文姓', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrWwm', //字段名
						title: '实际经营人_外文名', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrLxdh', //字段名
						title: '实际经营人_联系电话', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrJzdzmc', //字段名
						title: '实际经营人_居住地址名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sjjyrJzdzbm', //字段名
						title: '实际经营人_居住地址编码', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwJymc', //字段名
						title: '经营单位_经营名称', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwYwmc', //字段名
						title: '经营单位_英文名称', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'ydwYwsx', //字段名
						title: '经营单位_英文缩写', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwJjlxdm', //字段名
						title: '经营单位_经济类型', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwJjlxmc', //字段名
						title: '经营单位_经济类型名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwHylbdm', //字段名
						title: '经营单位_行业类别', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwHylbmc', //字段名
						title: '经营单位_行业类别名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwKyrq', //字段名
						title: '经营单位_开业日期', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwyyzzyxqQsrq', //字段名
						title: '经营单位营业执照有效期_起始日期', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwyyzzyxqJzrq', //字段名
						title: '经营单位营业执照有效期_截止日期', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwZczj', //字段名
						title: '注册资金(万元)', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwLxdh', //字段名
						title: '经营单位_联系电话', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwWz', //字段名
						title: '经营单位_网址', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwbgdzDzbm', //字段名
						title: '经营单位办公地址_地址编码', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwbgdzSsxqdm', //字段名
						title: '经营单位办公地址_省市(县)区', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwbgdzDzmc', //字段名
						title: '经营单位办公地址_地址名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwbgdzSsjwq', //字段名
						title: '经营单位办公地址_所属警务区', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwzcdzDzbm', //字段名
						title: '经营单位注册地址_地址编码', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwzcdzSsxqdm', //字段名
						title: '经营单位注册地址_省市(县)区', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwzcdzQhnxxdz', //字段名
						title: '经营单位注册地址_地址名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwfddbrXm', //字段名
						title: '经营单位法定代表人(负责人)_姓名', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwfddbrGjhdqdm', //字段名
						title: '经营单位法定代表人(负责人)_国籍(地区)', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwfddbrCyzjdm', //字段名
						title: '经营单位法定代表人(负责人)_证件种类', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwfddbrCyzjmc', //字段名
						title: '经营单位法定代表人(负责人)_证件种类名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwfddbrZjhm', //字段名
						title: '经营单位法定代表人(负责人)_证件号码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwfddbrWwx', //字段名
						title: '经营单位法定代表人(负责人)_外文姓', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwfddbrWwm', //字段名
						title: '经营单位法定代表人(负责人)_外文名', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jydwfddbrLxdh', //字段名
						title: '法定代表人(负责人)_联系电话', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'lxrGmsfhm', //字段名
						title: '联系人_公民身份号码', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'lxrXm', //字段名
						title: '联系人_姓名', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'lxrLxdh', //字段名
						title: '联系人_联系电话', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'djsj', //字段名
						title: '登记时间', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'gxsj', //字段名
						title: '更新时间', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'zxlb', //字段名
						title: '注销类别', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'zxsj', //字段名
						title: '注销时间', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'rksj', //字段名
						title: '入库时间', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'versionOptimizedLock', //字段名
						title: '版本号', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}				]
			]
		});
	})
	//日期
	layui.use('laydate', function() {
		var laydate = layui.laydate;
		//日期时间选择器
		laydate.render({
			elem: '#startTime',
			type: 'datetime',
			done: function(value) {
				vm.jyzXx.startTime = value
			}
		});
		laydate.render({
			elem: '#endTime',
			type: 'datetime',
			done: function(value) {
				vm.jyzXx.endTime = value
			}
		});
	})
})
var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			//keyWords:null
		},
		showList: true,
		title: null,
		jyzXx: {
			xxzj:null,
			jyzbm:null,
			sjjyrXm:null,
			sjjyrGjhdqdm:null,
			sjjyrGjhdqmc:null,
			sjjyrCyzjdm:null,
			sjjyrCyzjmc:null,
			sjjyrZjhm:null,
			sjjyrWwx:null,
			sjjyrWwm:null,
			sjjyrLxdh:null,
			sjjyrJzdzmc:null,
			sjjyrJzdzbm:null,
			jydwDwmc:null,
			jydwJymc:null,
			jydwYwmc:null,
			ydwYwsx:null,
			jydwTyshxydm:null,
			jydwJjlxdm:null,
			jydwJjlxmc:null,
			jydwHylbdm:null,
			jydwHylbmc:null,
			jydwKyrq:null,
			jydwyyzzyxqQsrq:null,
			jydwyyzzyxqJzrq:null,
			jydwZczj:null,
			jydwLxdh:null,
			jydwWz:null,
			jydwbgdzDzbm:null,
			jydwbgdzSsxqdm:null,
			jydwbgdzDzmc:null,
			jydwbgdzSsjwq:null,
			jydwzcdzDzbm:null,
			jydwzcdzSsxqdm:null,
			jydwzcdzQhnxxdz:null,
			jydwfddbrXm:null,
			jydwfddbrGjhdqdm:null,
			jydwfddbrCyzjdm:null,
			jydwfddbrCyzjmc:null,
			jydwfddbrZjhm:null,
			jydwfddbrWwx:null,
			jydwfddbrWwm:null,
			jydwfddbrLxdh:null,
			lxrGmsfhm:null,
			lxrXm:null,
			lxrLxdh:null,
			djsj:null,
			gxsj:null,
			zxlb:null,
			zxsj:null,
			rksj:null,
			versionOptimizedLock:null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.jyzXx = {};
		},
		update: function (event) {
            
            var rowData = getSelectedOneRow();
			if (rowData == undefined) {
				return;
			}
			vm.showList = false;
			vm.title = "修改";
			vm.getInfo(rowData)
		},
		saveOrUpdate: function (event) {
			var url = vm.jyzXx.xxzj? "jyzXx/editJyzXx" : "jyzXx/saveJyzXx";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.jyzXx),
			    success: function(r){
			    	if(r.code == 200){
						alert(r.msg, function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		
		del: function (event) {
			var xxzjs = getSelectedMoreRow();
			if (xxzjs == undefined) {
				return;
			}
			confirm('确定要删除选中的记录？', function() {
				$.ajax({
					type: "POST",
					url: baseURL + "jyzXx/deleteJyzXxList",
					contentType: "application/json",
					data: JSON.stringify(xxzjs),
					success: function(r) {
						if (r.code == 200) {
							alert(r.msg, function(index) {
								vm.reload()
							});
						} else {
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(rowData){

			$.ajax({
				type: "POST",
			    url: baseURL + "jyzXx/queryJyzXxList",
                contentType: "application/x-www-form-urlencoded",
			    data: rowData,
			    success: function(r){
					if(r.code == 200){
						if(!r.resultList||r.resultList.length==0){
							alert("数据不存在");
							return;
						}
		                vm.jyzXx  = r.resultList[0];
					}else{
						alert(r.msg);
					}
				}
			});
		},
		reload: function (event) {
		
			vm.showList = true;
//			var keyVal = document.getElementById('keyWords').value;
			layui.use('table', function() {
				var table = layui.table;
				table.reload('tableId', {
					where: vm.q,
					page: {
						curr: 1 //重新从第 1 页开始
					}
				});
			})
		}
	}
});