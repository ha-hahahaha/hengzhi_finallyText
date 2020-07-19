$(document).ready(function() {
	var timer = null;
	var cur = 0;
	var len = $("#ads li").length;
	$.ajax({
		url: "ShowNewsServlet",
		type: "POST",
		dataType: "json",
		data: {
			"info": "学习"
		},
		success: function(data) {},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});

	//鼠标滑过容器停止播放
	$("#ads").hover(function() {
		clearInterval(timer);
	}, function() {
		showImg();
	});
	// 遍历所有圆点导航实现划过切换至对应的图片
	$("#ads li").click(function() {
		clearInterval(timer);
		cur = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$("#ads img").eq(cur).fadeIn(800).siblings("img").fadeOut(800);
	});

	//定义图片切换函数
	function showImg() {
		timer = setInterval(function() {
			cur++;
			if(cur >= len) {
				cur = 0;
			}
			$("#ads img").eq(cur).fadeIn(800).siblings("img").fadeOut(800);
			$("#ads li ").eq(cur).addClass("active").siblings().removeClass("active");

		}, 2000);
	}
	showImg();
	$.ajax({
		url: "EchoStatusServlet",
		type: "POST",
		dataType: "json",

		success: function(data) {
			if(data.echoStatus == "1") {
				$("#user").empty();
				//$("#user").append("已登录："+data.echoName);
				//去往个人界面的id=data.echoId
				$("#user").append("<a href='user.html?id="+data.echoId+"'>已登录:"+data.echoName+"</a>");
			}
			if(data.echoStatus == "2") {
				$("#user").empty();
				$("#user").append("等待审核："+data.echoName+"&nbsp;&nbsp;&nbsp;<br/><a href='login.html'>登录</a>");
				//$("#user").append("<a href='user.html?id='" + data.id + "'>" + data.echoName + "</a>");
				//到登录页面的提示“切换登录
			}
			if(data.echoStatus == "") {
				$("#user").empty();
				$("#user").append("<a href='login.html'>您是游客，请登录</a>");
			}
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	})

	$("#seek").click(function() {
		$("#hunt").css("visibility", "visible");
		$("#hunt").css("opacity", "1");
	});
	$("#close").click(function() {
		$("#hunt").css("visibility", "hidden");
		$("#hunt").css("opacity", "0");
	});
	$('body').on('click', '#seekok', function() {
		var info = $("#keyword").val();
		var url = "search.html";
		$.ajax({
			url: "SaveWordServlet",
			type: "POST",
			dataType: "json",
			data: {
				info: info
			},
			success: function(data) {},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
		window.open(url);
	})
});