function auto() {
	$("#showinfo").trigger("click");
}
$(document).ready(function() {
	var local_url = document.location.href;
	//截取get字符串
	var getstr = local_url.substr(local_url.indexOf('=') + 1);
	var id = getstr;
	var pastname;
	window.onload = auto;
	$.ajax({
		url: "SelectUserIdServlet",
		type: "POST",
		dataType: "json",
		data: {
			"userId": id
		},
		success: function(data) {
			pastname=data.userName;
			$("#name").append("管理员："+data.userName);
			$("#age").append("年龄："+data.age);
			$("#info").append("爱好: "+data.information);
			$("#id").append("用户账号: "+data.userId);
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
	$(".changepassword").hide();
	$(".changein").hide();
	$(".show").show();
	$("#showinfo").css('background-color', 'rgb(255, 255, 255, 0)');
	$("#changeinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
	$("#changepwd").css('background-color', 'rgb(255, 255, 255, 0.3)');
	$("#changeinfo").click(function() {
		$(".changepassword").hide();
		$(".changein").show();
		$(".show").hide();
		$("#showinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#changeinfo").css('background-color', 'rgb(255, 255, 255, 0)');
	})
	$("#showinfo").click(function() {
		$(".changepassword").hide();
		$(".changein").hide();
		$(".show").show();
		$("#showinfo").css('background-color', 'rgb(255, 255, 255, 0)');
		$("#changeinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
	})
	//判断用户名格式
	$("#userage").blur(function() {
		var age = $("#userage").val();
		var gsage = /^[0-9]{1,3}$/;
		if(gsage.test(age)) {
			$("#hintage").empty();
		} else {
			$("#hintage").html("格式错误 ");
		}
	})
	$("#pwdnow").blur(function() {
		var pwd0 = $("#pwdnow").val();
		var gspwd = /[a-zA-Z0-9]{6,14}$/;
		if(gspwd.test(pwd0)) {
			$("#hintpwd").empty();
		} else {
			$("#hintpwd").html("格式错误");
		}
	})
	$("#return").click(function() {
		$.ajax({
			url: "UserExitServlet",
			type: "POST",
			dataType: "json",
			success: function(data) {
				if(data=="1"){
					window.location.href="index.html";
					return false
				}
				else {
					alert("退出失败");
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
		window.location.href = "index.html";
	})


	$('body').on('click', '#adnews', function() {
		window.location.href = "adnews.html?id=" + id;
	});
	$('body').on('click', '#adinform', function() {
		window.location.href = "adinform.html?id=" + id;
	});
	$('body').on('click', '#adnav', function() {
		window.location.href = "adnav.html?id=" + id;
	});
	$('body').on('click', '#adadmin', function() {
		window.location.href = "adadmin.html?id=" + id;
	})
	$('body').on('click', '#user', function() {
		window.location.href = "user.html?id=" + id;
	});

})