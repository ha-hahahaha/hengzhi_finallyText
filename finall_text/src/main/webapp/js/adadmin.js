$(document).ready(function() {
	var local_url = document.location.href;
	var getstr = local_url.substr(local_url.indexOf('=') + 1);
	var id = getstr;
	var newsNowId;
	$.ajax({
		url: "SelectUserIdServlet",
		type: "POST",
		dataType: "json",
		data: {
			"userId": id
		},
		success: function(data) {
			$("#name").append(data.userName);
			$("#age").append(data.age);
			$("#info").append(data.information);
			$(".boxi").append('<img src=' + data.image + '>');
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});
	$(".admin").show();
	$(".check").hide();
	$("#deleteadmin").css('background-color', 'rgb(255, 255, 255, 0)');
	$("#checkadmin").css('background-color', 'rgb(255, 255, 255, 0.3)');
	$('body').on('click', '#checkadmin', function() {
		$(".check").show();
		$(".admin").hide();
		$("#deleteadmin").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#checkadmin").css('background-color', 'rgb(255, 255, 255, 0)');
	})
	$('body').on('click', '#deleteadmin', function() {
		$(".check").hide();
		$(".admin").show();
		$("#deleteadmin").css('background-color', 'rgb(255, 255, 255, 0)');
		$("#checkadmin").css('background-color', 'rgb(255, 255, 255, 0.3)');
	})
	//		获得管理员
	$.ajax({
		url: "SelectAdminServlet",
		type: "POST",
		dataType: "json",

		success: function(data) {
			
//			$("#table1 tbody tr").remove();
			for(var i = 0; i < data.length; i++) {
				$("#table1").append("<tr><td id='id'>"  + data[i].userId + "</td><td id='name'>"+data[i].userName + "</td><td id='delete'>删除</td></tr>");
			}
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});
//	获得未审核管理员
	$.ajax({
		url: "SelectWaiterServlet",
		type: "POST",
		dataType: "json",
		success: function(data) {
			for(var i = 0; i < data.length; i++) {
	
				$("#table2").append("<tr><td id='waitid'>" + data[i].waitId + "</td><td id='waitname'>" + data[i].waitUsername + "</td><td id='checkok'>审核通过</td><td id='checkno'>审核否决</td></tr>");
	
			}
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});
	
	//		点击删除
	$('body').on('click', '#delete', function() {
		var name = $(this).parent().children('td').eq(1).html();
		$.ajax({
			url: "DeleteAdminServlet",
			type: "POST",
			dataType: "json",
			data: {
				"name": name
			},
			success: function(data) {
				alert("删除成功")
				window.location.href = "adadmin.html?id=" + id;
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
//	审核通过
	$('body').on('click', '#checkok', function() {
		var name = $(this).parent().children('td').eq(1).html();
		$.ajax({
			url: "AddAdminServlet",
			type: "POST",
			dataType: "json",
			data: {
				"name": name
			},
			success: function(data) {
				window.location.href = "adadmin.html?id=" + id;
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	$('body').on('click', '#checkno', function() {
		var name = $(this).parent().children('td').eq(1).html();
		$.ajax({
			url: "DeleteWaiterServlet",
			type: "POST",
			dataType: "json",
			data: {
				"name": name
			},
			success: function(data) {
				window.location.href = "adadmin.html?id=" + id;
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	$("#return").click(function() {
		window.location.href = "manager.html?id=" + id;
	})
})