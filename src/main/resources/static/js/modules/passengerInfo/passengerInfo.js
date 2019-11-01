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
			url: baseURL + 'passengerInfo/queryPassengerInfoList', //?page=1&limit=10（该参数可通过 request 自定义）
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
						title: '信息主键(不参与业务)', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'xxzjw', //字段名
						title: '外系统信息主键', //标题
						width: 200,
						hide: true,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'type', //字段名
						title: '类型', //标题
						width: 200,
						templet: function(d) {
							if (d.type == 1) {
								return '网约房预定';
							} else if (d.type == 2) {
								return '网约房登记';
							} else if (d.type == 3) {
								return '网约房作废';
							} else if (d.type == 4) {
								return '网约房离店';
							} else if (d.type == 5) {
								return '日租房预定';
							} else if (d.type == 6) {
								return '日租房登记';
							} else if (d.type == 7) {
								return '日租房作废';
							} else if (d.type == 8) {
								return '日租房离店';
							} else {
								return '';
							}
						},
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'sbdwbm', //字段名
						title: '申报单位编码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jyzbm', //字段名
						title: '经营者编码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'jyzmc', //字段名
						title: '经营者名称（单位名称）', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'ddbm', //字段名
						title: '订单编码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fwbm', //字段名
						title: '房屋编码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fwdzbm', //字段名
						title: '房屋地址编码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'fwjymc', //字段名
						title: '房屋经营名称', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'xm', //字段名
						title: '姓名', //标题
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
						field: 'gjhdqdm', //字段名
						title: '国籍(地区)', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'cyzjdm', //字段名
						title: '证件种类[采用GA/T517《常用证件代码》]', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'zjhm', //字段名
						title: '证件号码', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'wwx', //字段名
						title: '外文姓', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'wwm', //字段名
						title: '外文名', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'xp', //字段名
						title: '相片', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'rzsj', //字段名
						title: '入住时间', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'lksj', //字段名
						title: '离开时间', //标题
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
						field: 'qxyy', //字段名
						title: '取消原因', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'qxsj', //字段名
						title: '取消时间', //标题
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
						field: 'rksj', //字段名
						title: '入库时间', //标题
						width: 200,
						sort: true //是否允许排序 默认：false
						//fixed: 'left' //固定列
					}, 					{
						field: 'versionOptimizedLock', //字段名
						title: '版本控制', //标题
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
				vm.passengerInfo.startTime = value
			}
		});
		laydate.render({
			elem: '#endTime',
			type: 'datetime',
			done: function(value) {
				vm.passengerInfo.endTime = value
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
		passengerInfo: {
			id:null,
			xxzjw:null,
			type:null,
			sbdwbm:null,
			jyzbm:null,
			jyzmc:null,
			ddbm:null,
			fwbm:null,
			fwdzbm:null,
			fwjymc:null,
			xm:null,
			lxdh:null,
			gjhdqdm:null,
			cyzjdm:null,
			zjhm:null,
			wwx:null,
			wwm:null,
			xp:null,
			rzsj:null,
			lksj:null,
			djsj:null,
			qxyy:null,
			qxsj:null,
			gxsj:null,
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
			vm.passengerInfo = {};
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
			var url = vm.passengerInfo.id? "passengerInfo/editPassengerInfo" : "passengerInfo/savePassengerInfo";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.passengerInfo),
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
					url: baseURL + "passengerInfo/deletePassengerInfoList",
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
			    url: baseURL + "passengerInfo/queryPassengerInfoList",
                contentType: "application/x-www-form-urlencoded",
			    data: rowData,
			    success: function(r){
					if(r.code == 200){
						if(!r.resultList||r.resultList.length==0){
							alert("数据不存在");
							return;
						}
		                vm.passengerInfo  = r.resultList[0];
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