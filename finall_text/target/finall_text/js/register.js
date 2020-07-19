function change(){
	var img=document.getElementById("oImg");
	img.src="VerifycodeServlet?Vname=logincode&'/>"+(new Date()).getTime();
}
$(document).ready(function() {

	$("#username").blur(function() {
		var name = $("#username").val();
		var gsname = /^[a-zA-Z0-9]{1,15}$/;
		if(gsname.test(name)) {
			$("#hintname2").empty();
		} else {
			$("#hintname2").html("格式错误 ");
		}
	})
	//判断用户名格式
	$("#password1").blur(function() {
		var pwd0 = $("#password1").val();
		var gspwd = /[a-zA-Z0-9]{6,14}$/;
		var gspwd1 = /[a-zA-Z]{6,14}$/;
		var gspwd2 = /[0-9]{6,14}$/;
		if(gspwd.test(pwd0)) {
			if(gspwd1.test(pwd0)) {
				$("#hintpwd2").html("仅字母安全度低");
				return false;
			}
			if(gspwd2.test(pwd0)) {
				$("#hintpwd2").html("仅字母安全度低");
				return false;
			}
			$("#hintpwd2").html("安全度较高");

		} else {
			$("#hintpwd2").html("格式错误");
		}

	})
	//判断密码格式
	$("#password2").blur(function(){
		var pwd = $("#password1").val();
		var pwd1 =  $("#password2").val();
		if(pwd != pwd1) {
			$("#hint").html("两次密码不相同");
			
		} else {
			$("#hint").empty();
		}
	})
	$('body').on('click','#registerok',function()
	//$("#registerok").click(function()
	{
		var name = $("#username").val();
		var pwd = $("#password1").val();
		var manager;
		var code=$("#verify").val();
		if($('#manager').is(':checked')) {manager=1;}
		else{manager=0;}
		if(name =="") {
			alert("未填写用户名");
			document.form.username.focus();
			return false;
		}
		if(pwd =="") {
			alert("未填写密码");
			document.form.password.focus();
			return false;
		}
		if($("#hintname2").html()!="" || $("#hintpwd2").html() =="格式错误"||$("#hint").html()!="") {
			return false;
		}
		if(code==""){
			alert("请输入验证码");
			return false;

		}
		$.ajax({
			url: "RegistUserServlet",
			type: "POST",
			dataType: "json",
			data: {
				"username": name,
				"userpwd": pwd,
				"manager":manager,
				"verify":code
			},
			success: function(data) {
				if(data=="1") {
					alert("用户名已被注册");
					return false;
				} else if(data=="0"){
					alert("验证码错误");
					return false;
				}else {
					if(data=="2") {
						alert("注册管理员需要等待审核，审核过后即可登录");
						window.location.href = "index.html";
					}else{
						alert("注册成功！返回登录")
						window.location.href = "login.html";
					}
					return true;
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
		return false;
	})
	//判断是否填全
})