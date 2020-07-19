function auto() {
	$("#showinfo").trigger("click");
}
$(document).ready(function() {
	var local_url = document.location.href;
	//截取get字符串
	var getstr = local_url.substr(local_url.indexOf('=') + 1);
	var id =getstr
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
			if(data.ifAdmin=="1"){
				$("#manager").show();
			}else{
				$("#manager").hide();
			}
			pastname=data.userName;
			$("#nameA").append("用户名："+data.userName);
			$("#nameS").append("用户名："+data.userName);
			$("#ageS").append("年龄："+data.age);
			$("#info").append("爱好: "+data.information);
			$("#id").append("用户账号: "+data.userId);
			$("#username").val(data.userName);
			$("#userage").val(data.age);
			$("#userinfo").val(data.information);
			$(".boxi").append("<img src='" + data.image + "'>");
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});
	$(".changepassword").hide();
	$(".changein").hide();
	$(".news").show();
	$(".inform").hide();
	
	$("#news").css('background-color', 'rgb(255, 255, 255, 0)');
	$("#inform").css('background-color', 'rgb(255, 255, 255, 0.3)');
	$(".show").hide();
	$("#showinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
	
	$("#changeinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
	$("#changepwd").css('background-color', 'rgb(255, 255, 255, 0.3)');
	$("#changeinfo").click(function() {
		$(".changepassword").hide();
		$(".changein").show();
		$(".news").hide();
		$(".inform").hide();
		$(".show").hide();
		$("#showinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#changeinfo").css('background-color', 'rgb(255, 255, 255, 0)');
		$("#changepwd").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#news").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#inform").css('background-color', 'rgb(255, 255, 255, 0.3)');
	
	})
	$("#changepwd").click(function() {
		//		显示更改
		$(".changepassword").show();
		$(".changein").hide();
		$(".news").hide();
		$(".inform").hide();
		$(".show").hide();
		$("#showinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#changeinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#changepwd").css('background-color', 'rgb(255, 255, 255, 0)');
		$("#news").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#inform").css('background-color', 'rgb(255, 255, 255, 0.3)');
	})
	$("#news").click(function() {
		//		显示新闻
		$(".changepassword").hide();
		$(".changein").hide();
		$(".news").show();
		$(".inform").hide();
		$(".show").hide();
		$("#showinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#changeinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#changepwd").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#news").css('background-color', 'rgb(255, 255, 255, 0)');
		$("#inform").css('background-color', 'rgb(255, 255, 255, 0.3)');
	})
	$("#inform").click(function() {
		//		显示更改
		$(".changepassword").hide();
		$(".changein").hide();
		$(".news").hide();
		$(".inform").show();
		$(".show").hide();
		$("#showinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#changeinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#changepwd").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#news").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#inform").css('background-color', 'rgb(255, 255, 255, 0)');
	})
	$("#showinfo").click(function() {
		//		显示信息
		$(".changepassword").hide();
		$(".changein").hide();
		$(".news").hide();
		$(".inform").hide();
		$(".show").show();
		$("#showinfo").css('background-color', 'rgb(255, 255, 255, 0)');
		$("#changeinfo").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#changepwd").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#news").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#inform").css('background-color', 'rgb(255, 255, 255, 0.3)');
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

	})
	$("#username").blur(function() {
		var name = $("#username").val();
		var gsname = /^[a-zA-Z0-9]{1,15}$/;
		if(gsname.test(name)) {
			$("#hintname").empty();
		} else {
			$("#hintname").html("格式错误 ");
		}
	})
	//判断用户名格式
	$("#userage").blur(function() {
		var age = $("#userage").val();
		var gsage = /^[0-9]{1,2}$/;
		if(gsage.test(age)) {
			$("#hintage").empty();
		} else {
			$("#hintage").html("格式错误 ");
		}
	})

	$('body').on('click', '#changeok', function() {
		var name = $("#username").val();
		var age = $("#userage").val();
		var info = $("#userinfo").val();
		if(name == "") {
			alert("用户名为空，修改失败");
		} else if($("#hintname").html() != "" || $("#hintage").html() != "") {
			return false;
		} else {
			$.ajax({
				url: "UpdateUserServlet",
				anyce:false,
				type: "POST",
				dataType: "json",
				data: {
					"pastname":pastname,
					"userId": id,
					"userName": name,
					"age": age,
					"info": info
				},
				success: function(data) {
					if(data=="1"){
						alert("用户名已存在，请重新输入！");
						return false;
					}
					else{
						$("#nameS").empty();
						$("#ageS").empty();
						$("#info").empty();
						$("#id").empty();
						$("#nameS").append("用户名：" + data.userName);
						$("#ageS").append("年龄：" + data.age);
						$("#info").append("爱好: " + data.information);
						$("#id").append("用户账号: " + data.userId);
						window.location.href = "user.html?id=" + id;
						return false;
					}
				},
				error: function() {
					var error = "查询数据失败！";
					console.log(error);
					alert(error);
				}
			});
			return false;
		}

	});
	$("#pwdnow").blur(function() {
		var pwd0 = $("#pwdnow").val();
		var gspwd = /^[a-zA-Z0-9]{6,14}$/;
		if(gspwd.test(pwd0)) {
			$("#hintpwd").empty();
		} else {
			$("#hintpwd").html("格式错误");
		}
	})

	$('body').on('click', '#changeok2', function() {
		var pwdpast = $("#pwdpast").val();
		var pwdnow = $("#pwdnow").val();
		var userName = $("#username").val();
		if(pwdpast == "") {
			alert("未填写原有密码，修改失败");
			return false;
		} else if(pwdnow == "") {
			alert("未填写现改密码，修改失败");
			return false;
		} else if(pwdnow==pwdpast){
			alert("不可与原密码相同！");
		return false;
		}else if($("#hintpwd").html() != "") {
			return false;
		} else {
			$.ajax({
				url: "UpdatePwdServlet",
				type: "POST",
				dataType: "json",
				data: {
					"userName": userName,
					"pwdpast": pwdpast,
					"pwdnow": pwdnow,
				},
				success: function(data) {
					if(data == "0") {
						//我不确定是不是0
						alert("原密码错误，请重新输入");
					} else {
						alert("修改成功，请重新登录");
						window.location.href = "login.html";
					}
				},
				error: function() {
					var error = "查询数据失败！";
					console.log(error);
					alert(error);
				}
			});
			return false;
		}

	});
	$('body').on('click', '#file', function(){
		$.ajax({
			url: "SaveWordServlet",
			type: "POST",
			dataType: "json",
			data: {
				"info":id
			},
			success: function(data) {
				//window.location.href="user.html?id="+id;
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	})
	$('body').on('click','#manager',function(){
		window.location.href="manager.html?id="+id;
	})
})