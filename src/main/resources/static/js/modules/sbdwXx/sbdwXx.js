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
			url: baseURL + 'sbdwXx/querySbdwXxList', //?page=1&limit=10（该参数可通过 request 自定义）
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
						field: 'id', //字段名
						title: '', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'tyshxydm', //字段名
						title: '统一社会信用代码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sbdwbm', //字段名
						title: '申报单位编码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwmc', //字段名
						title: '单位名称（注册）', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwjymc', //字段名
						title: '单位经营名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwywmc', //字段名
						title: '单位英文名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwywsx', //字段名
						title: '单位英文缩写', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jjlxdm', //字段名
						title: '经济类型', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jjlxmc', //字段名
						title: '经济类型名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'hylbdm', //字段名
						title: '行业类别', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'hylbmc', //字段名
						title: '行业类别名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'kyrq', //字段名
						title: '开业日期', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jyfwzy', //字段名
						title: '经营范围（主营）', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jyfwjy', //字段名
						title: '经营范围（兼营）', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'yyzzyxqQsrq', //字段名
						title: '营业执照有效期_起始日期', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'yyzzyxqJzrq', //字段名
						title: '营业执照有效期_截止日期', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'zczb', //字段名
						title: '注册资金', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'lxdh', //字段名
						title: '联系电话', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwbgdzDzbm', //字段名
						title: '单位办公地址_地址编码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwbgdzSsxqdm', //字段名
						title: '单位办公地址_省市(县)区', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwbgdzDzmc', //字段名
						title: '单位办公地址_地址名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwzcdzDzbm', //字段名
						title: '单位注册地址_地址编码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwzcdzSsxqdm', //字段名
						title: '单位注册地址_省市(县)区', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'dwzcdzQhnxxdz', //字段名
						title: '单位注册地址_地址名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'wz', //字段名
						title: '网址', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fddbrXm', //字段名
						title: '法定代表人(负责人)_姓名', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fddbrGjhdqdm', //字段名
						title: '法定代表人(负责人)_国籍(地区)', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fddbrCyzjdm', //字段名
						title: '法定代表人(负责人)_证件种类', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fddbrCyzjmc', //字段名
						title: '法定代表人(负责人)_证件名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fddbrZjhm', //字段名
						title: '法定代表人(负责人)_证件号码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fddbrWwx', //字段名
						title: '法定代表人(负责人)_外文姓', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fddbrWwm', //字段名
						title: '法定代表人(负责人)_外文名', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fddbrLxdh', //字段名
						title: '法定代表人(负责人)_联系电话', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'lxrGmsfhm', //字段名
						title: '联系人_公民身份号码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'lxrXm', //字段名
						title: '联系人_姓名', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'lxrLxdh', //字段名
						title: '联系人_联系电话', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'djsj', //字段名
						title: '登记时间', //标题
						width: 200,
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
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sbrxm', //字段名
						title: '申报人姓名', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sbrzjh', //字段名
						title: '申报人证件号', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sbruid', //字段名
						title: '申报人uid', //标题
						width: 200,
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
				vm.sbdwXx.startTime = value
			}
		});
		laydate.render({
			elem: '#endTime',
			type: 'datetime',
			done: function(value) {
				vm.sbdwXx.endTime = value
			}
		});
	})
})
var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			keyWords:null
		},
		showList: true,
		title: null,
		sbdwXx: {
			id:null,
			tyshxydm:null,
			sbdwbm:null,
			dwmc:null,
			dwjymc:null,
			dwywmc:null,
			dwywsx:null,
			jjlxdm:null,
			jjlxmc:null,
			hylbdm:null,
			hylbmc:null,
			kyrq:null,
			jyfwzy:null,
			jyfwjy:null,
			yyzzyxqQsrq:null,
			yyzzyxqJzrq:null,
			zczb:null,
			lxdh:null,
			dwbgdzDzbm:null,
			dwbgdzSsxqdm:null,
			dwbgdzDzmc:null,
			dwzcdzDzbm:null,
			dwzcdzSsxqdm:null,
			dwzcdzQhnxxdz:null,
			wz:null,
			fddbrXm:null,
			fddbrGjhdqdm:null,
			fddbrCyzjdm:null,
			fddbrCyzjmc:null,
			fddbrZjhm:null,
			fddbrWwx:null,
			fddbrWwm:null,
			fddbrLxdh:null,
			lxrGmsfhm:null,
			lxrXm:null,
			lxrLxdh:null,
			djsj:null,
			gxsj:null,
			zxlb:null,
			zxsj:null,
			rksj:null,
			versionOptimizedLock:null,
			sbrxm:null,
			sbrzjh:null,
			sbruid:null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sbdwXx = {};
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
			var url = vm.sbdwXx.id? "sbdwXx/editSbdwXx" : "sbdwXx/saveSbdwXx";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sbdwXx),
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
			var ids = getSelectedMoreRow();
			if (ids == undefined) {
				return;
			}
			confirm('确定要删除选中的记录？', function() {
				$.ajax({
					type: "POST",
					url: baseURL + "sbdwXx/deleteSbdwXxList",
					contentType: "application/json",
					data: JSON.stringify(ids),
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
			    url: baseURL + "sbdwXx/querySbdwXxList",
                contentType: "application/x-www-form-urlencoded",
			    data: rowData,
			    success: function(r){
					if(r.code == 200){
						if(!r.resultList||r.resultList.length==0){
							alert("数据不存在");
							return;
						}
		                vm.sbdwXx  = r.resultList[0];
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