function change(){
	var img=document.getElementById("oImg");
	img.src="VerifycodeServlet?Vname=logincode&'/>"+(new Date()).getTime();
}
$(document).ready(function() {
	var isShow = true;
	$('#look').click(function() {
		$(this).toggleClass("glyphicon-eye-open glyphicon-eye-close");
		if(isShow) {
			$("#password").attr("type","text");
			isShow = false;

		} else {
			$("#password").attr("type","password");
			isShow = true;
		}
	});
	//眼睛图片的切换
	$("#username").blur(function() {
		var name =$("#username").val();
		var gsname = /^[a-zA-Z0-9]{1,15}$/;
		if(gsname.test(name)) {
			$("#hintname").empty();
		} else {
			$("#hintname").html("格式错误 ");
		}
	})
	//判断用户名格式
	$("#password").blur(function(){
		var pwd0 = $("#password").val();
		var gspwd = /[a-zA-Z0-9]{6,14}$/;
		if(gspwd.test(pwd0)) {
			$("#hintpwd").empty();
		} else {
			$("#hintpwd").html("格式错误");
		}
	})
	//判断密码格式
	$('body').on('click','#loginok',function()
	//$("#loginok").on('click', function()
	//$("#loginok").click(function()
	{
		var userName = $("#username").val();
		var passWord = $("#password").val();
		var code=$("#verify").val();
		if(userName == "") {
			alert("请输入用户名");
			document.form.username.focus();
			return false;
		}
		if(passWord == "") {
			alert("请输入密码");
			document.form.password.focus();
			return false;
		}
		if($("#hintname").val()!=""||$("#hintpwd").val()!=""){
			return false;
		}
		if(code==""){
			alert("请输入验证码");
			return false;
			
		}
			userName=String(userName);
			passWord=String(passWord);
			var isCheckStart;
			var b
			$.ajax({
				url: "SelectUserServlet",
				type: "POST",
				async:false,
				dataType: "json",
				data: {
					"userName1":userName,
					"passWord1":passWord,
					"verify":code
				},
				success: function(data) {
					var id=data.userId;
					if(data=="0"){
						alert("验证码不正确");
						return false;
					}else{
						if(data=="1"){
							alert("用户名或密码错误！")
						}
						else{
							if(data.ifAdmin==1){
								window.location.href = "manager.html?id="+id;
							}
							else{
								window.location.href = "user.html?id=" + id;
							}
						}
					}
				},
				error: function() {
					var error = "查询数据失败！";
					console.log(error);
					alert("错误");
				}
			});
		return false;
	})
	//判断是否填全
})