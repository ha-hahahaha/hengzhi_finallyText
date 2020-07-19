$(document).ready(function() {
	var local_url = document.location.href;
	var getstr = local_url.substr(local_url.indexOf('=') + 1);
	var userid = getstr;
	//显示用户
	$.ajax({
		url: "SelectUserIdServlet",
		type: "POST",
		dataType: "json",
		data: {
			"userId": userid
		},
		success: function(data) {
			$("[id=name]").append(data.userName);
			$("#age").append(data.age);
			$("#info").append(data.information);
			$("#username").val(data.userName);
			$("#userage").val(data.age);
			$("#userinfo").val(data.information);
			$(".boxi").append('<img src=' + data.image + '>');
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});
	$(".navs").show();
	$(".addfather").hide();
	$(".addson").hide();
	$(".changefa").hide();
	$(".changeson").hide();
	$(".table").hide();

	$("#navs").css('background-color', 'rgb(255, 255, 255, 0)');
	$("#addfa").css('background-color', 'rgb(255, 255, 255, 0.3)');
	$("#addson").css('background-color', 'rgb(255, 255, 255, 0.3)');
	$('body').on('click', '#addfa', function() {

		$(".navs").hide();
		$(".addfather").show();
		$(".addson").hide();
		$(".changeson").hide();
		$(".changefa").hide();
		$(".table").show();
		$("#navs").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#addfa").css('background-color', 'rgb(255, 255, 255, 0)');
		$("#addson").css('background-color', 'rgb(255, 255, 255, 0.3)');
	})
	$('body').on('click', '#navs', function() {
		$(".navs").show();
		$(".addfather").hide();
		$(".addson").hide();
		$(".changeson").hide();
		$(".changefa").hide();
		$(".table").hide();
		$("#navs").css('background-color', 'rgb(255, 255, 255, 0)');
		$("#addfa").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#addson").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$(".text div").remove();
	})
	$('body').on('click', '#addson', function() {
		$(".navs").hide();
		$(".addfather").hide();
		$(".addson").show();
		$(".changeson").hide();
		$(".changefa").hide();
		$(".table").show();
		$("#navs").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#addfa").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#addson").css('background-color', 'rgb(255, 255, 255, 0)');
		$(".text div").remove();
	})
	var num;
	//显示父类
	$.ajax({
		url: "ShowNavFatherServlet",
		async: false,
		type: "POST",
		dataType: "json",
		success: function(data) {
			num = data.length;
			for(var i = 0; i < data.length; i++) {
				$(".container").append("<div class='col-md-7'><ul><li class='stair'><a id='letmeget' href='" + data[i].toLink + "'>" + data[i].navName + "</a><div id='changefa'>更改</div><div id='deletefa'>删除</div></li><li id='id'>" + data[i].nameId + "</li></ul></div>");
				//$("#table2").append("<tr><td>"+data[i].nameId+"</td><td>"+data[i].navName+"</td></tr>");
				//$("select").append("<option value='"+data[i].navName+"'>"+data[i].navName+"</option>");
			}
			$("[id=id]").hide();
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});
	$.ajax({
		url: "ShowNavFatherServlet",
		type: "POST",
		//async: false,
		dataType: "json",
		success: function(data) {
			for(var i = 0; i < data.length; i++) {
				$("select").append("<option value='" + data[i].navName + "'>" + data[i].navName + "</option>");
			}
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});
	//显示所有子类
	for(var i = 0; i < num; i++) {
		var ide = $("ul").eq(i).children('li').eq(1).html();
		$.ajax({
			url: "ShowNavSonServlet",
			async: false,
			type: "POST",
			dataType: "json",
			data: {
				//你给我父类id我给你子类
				"id": ide
			},
			success: function(data) {
				//alert(data[0].navName);
				for(var j = 0; j < data.length; j++) {
					$("ul").eq(i).append("<li class='item'><img src='img/tubiao.png'><a href='" + data[j].toLink + "'>" + data[j].navName + "</a><div id='changeson'>更改</div><div id='deleteson'>删除</div></li>")
				}
			},
			error: function() {
				alert(ide);
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	}
	var newsNowId1;
	//		点击修改父
	$('body').on('click', '#changefa', function() {
		$(".navs").hide();
		$(".changefa").show();
		$(".table").show();
		var name = $(this).parent().children("a:eq(0)").html();
		name = name.split("<")[0];
		$.ajax({
			url: "SelectNavNameServlet",
			type: "POST",
			dataType: "json",
			data: {
				"info": name
			},
			success: function(data) {
				newsNowId1 = data[0].nameId;
				$("#changefaname").val(data[0].navName);
				$("#changefalink").val(data[0].toLink);
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	})
	var newsNowId2;
	//		点击修改子
	$('body').on('click', '#changeson', function() {
		$(".navs").hide();
		$(".changeson").show();
		$(".table").show();
		var name = $(this).parent().children("a:eq(0)").html();
		name = name.split("<")[0];
		$.ajax({
			url: "SelectNavNameServlet",
			type: "POST",
			dataType: "json",
			data: {
				"info": name
			},
			success: function(data) {
				newsNowId2 = data[0].nameId;
				$("#changesonname").val(data[0].navName);
				$("#changesonlink").val(data[0].toLink);
				$("#changefather").val(data[0].fatherId);
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	})
	//		修改父
	$('body').on('click', '#changefaok', function() {
		var name = $("#changefaname").val();
		var link = $("#changefalink").val();
		$.ajax({
			url: "UpdataNFatherServlet",
			type: "POST",
			dataType: "json",
			data: {
				"navName": name,
				"toLink": link,
				"navId": newsNowId1
			},
			success: function(data) {
				if(data=="1"){
					alert("修改成功！");
					window.location.href = "adnav.html?id=" + userid;
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	//		修改子
	$('body').on('click', '#changesonok', function() {
		var name = $("#changesonname").val();
		var link = $("#changesonlink").val();
		var father = $("#changefather").val();
		$.ajax({
			url: "UpdateNSonServlet",
			type: "POST",
			dataType: "json",
			data: {
				"navName": name,
				"toLink": link,
				"fatherId": father,
				"navId": newsNowId2
			},
			success: function(data) {
				if(data=="1"){
					alert("修改成功！");
					window.location.href = "adnav.html?id=" + userid;
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});

	//		增加父
	$('body').on('click', '#addfaok', function() {
		var name = $("#addname1").val();
		var link = $("#addlink1").val();
		$.ajax({
			url: "AddNavFatherServlet",
			type: "POST",
			dataType: "json",
			data: {
				"navName": name,
				"toLink":link
			},
			success: function(data) {
				if(data=="1"){
					alert("添加成功")
					window.location.href = "adnav.html?id=" + userid;
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
				alert(title);
			}
		});
	});
	//	增加子
	$('body').on('click', '#addsonok', function() {

		var name = $("#addname2").val();
		var link = $("#addlink2").val();
		var father = $("#father").val();
		$.ajax({
			url: "AddNavSonServlet",
			type: "POST",
			dataType: "json",
			data: {
				"navName": name,
				"toLink": link,
				"fatherName": father
			},
			success: function(data) {
				if(data=="1"){
					alert("添加成功")
					window.location.href = "adnav.html?id=" + userid;
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
				alert(title);
			}
		});
	});

	//		点击删除父
	$('body').on('click', '#deletefa', function() {
		var name = $(this).parent().children("a:eq(0)").html();
		name = name.split("<")[0];
		$.ajax({
			url: "DeleteNavServlet",
			type: "POST",
			dataType: "json",
			data: {
				"navName": name
			},
			success: function(data) {
				if(data=="1")
				{
					alert("删除成功");
					window.location.href = "adnav.html?id=" + userid;
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	//		点击删除子
	$('body').on('click', '#deleteson', function() {

		var name = $(this).parent().children("a:eq(0)").html();
		name = name.split("<")[0];
		$.ajax({
			url:  "DeleteNavServlet",
			type: "POST",
			dataType: "json",
			data: {
				"navName": name
			},
			success: function(data) {
				if(data=="1")
				{
					alert("删除成功");
					window.location.href = "adnav.html?id=" + userid;
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	//返回
	$("#return").click(function() {
		window.location.href = "manager.html?id=" + userid;
	})
})