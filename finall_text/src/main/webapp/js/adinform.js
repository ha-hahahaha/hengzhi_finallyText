$(document).ready(function() {
	var local_url = document.location.href;
	var getstr = local_url.substr(local_url.indexOf('=') + 1);
	var id = getstr;
	var datalen = 0; // data数据总条数
	var dataNum = 5; // 每页展示的数据条数
	var newsNowId;
	var info;
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
	$(".news").show();
	$(".add").hide();
	$(".change").hide();
	$("#news").css('background-color', 'rgb(255, 255, 255, 0)');
	$("#add").css('background-color', 'rgb(255, 255, 255, 0.3)');
	$('body').on('click', '#add', function() {
		$(".news").hide();
		$(".add").show();
		$(".text div").remove();
		$(".change").hide();
		$("#news").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$("#add").css('background-color', 'rgb(255, 255, 255, 0)');
	})
	$('body').on('click', '#news', function() {
		$(".news").show();
		$(".add").hide();
		$(".change").hide();
		$("#news").css('background-color', 'rgb(255, 255, 255, 0)');
		$("#add").css('background-color', 'rgb(255, 255, 255, 0.3)');
		$(".text div").remove();
	})
	//		获得通告数据
	$.ajax({
		url: "ShowInformServlet",
		type: "POST",
		dataType: "json",
		data: {"info": ""},
		success: function(data) {
			//$('#table1 tbody').load("url+'#table1 tbody'");
			$("#table1 tbody tr").remove();
			datalen = data;
			var temp = " ";
			// 总条数
			$("#total").html(data.length);
			// 总页数
			var pageSize = Math.ceil(data.length / dataNum);
			$("#pageSize").html(pageSize);
			// 当前第N页
			$("#page").html(1);
			for(var i = 0; i < data.length; i++) {

				$("#table1 tbody").append("<tr style='display:none;'><td id='td1'>" + "<div id='month'>" + data[i].writeTime.slice(0, 7) + "</div>" + "<div id='day'>" + data[i].writeTime.slice(8, 10) + "</div>" + "</td> <td id='td2'>" + data[i].title + "</td><td id='td3'>更改</td><td id='td4'>删除</td></tr>");

			}
			// 默认第一页展示的数据
			for(var i = 0; i < dataNum; i++) {

				$("#table1 tbody tr").eq(i).show();
			}
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});
	//		修改tonggao
	$('body').on('click', '#changeok', function() {
		var title = $("#changetitle").val();
		var anthor = $("#changeanthor").val();
		var textnew = $("#changetext").val();
		$.ajax({
			url: "UpdateInformServlet",
			type: "POST",
			dataType: "json",
			data: {
				"title": title,
				"author": anthor,
				"text": textnew,
				"newId":newsNowId
			},
			success: function(data) {
				alert("修改成功！");
				window.location.href = "adinform.html?id=" + id;
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	//		增加新闻
	$('body').on('click', '#addok', function() {

		var title = $("#addtitle").val();
		var anthor = $("#addanthor").val();
		var textnew = $("#addtext").val();
		$.ajax({
			url: "AddInformServlet",
			type: "POST",
			dataType: "json",
			data: {
				"title": title,
				"author": anthor,
				"text": textnew
			},
			success: function(data) {
				alert("添加成功")
				window.location.href = "adinform.html?id=" + id;
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	//		点击修改√
	$('body').on('click', '#td3', function() {
		$(".news").hide();
		$(".change").show();
		var title = $(this).parent().children('td').eq(1).html();
		$.ajax({
			url:"ShowInformServlet",
			type: "POST",
			dataType: "json",
			data: {
				"info": title
			},
			success: function(data) {
				newsNowId=data[0].newsId;
				$("#changetitle").val(data[0].title);
				$("#changetext").val(data[0].content);
				$("#changeanthor").val(data[0].author);
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	})
	var num;
	//		点入正文√
	$('body').on('click', '#td2', function() {
		var title = $(this).html();
		$(".news").hide();
		$(".text div").remove();
		$.ajax({
			url: "ShowInformServlet",
			type: "POST",
			dataType: "json",
			data: {
				"info": ""
			},
			success: function(data) {
				datalen = data;
				var temp = " ";
				// 总条数
				for(var i = 0; i < data.length; i++) {
					if(title == data[i].title) {
						$(".text").append("<div class='title'>" + title + "</div><div class='remark'>" + data[i].writeTime + " " + data[i].author + "</div><div class='text'>" + data[i].content + "</div><div class='pre'><img src='img/shangyitiao.png'></div><div class='next'><img src='img/xiayitiao.png'></div><div class='close'>返回</div>");
						num = i;
					}
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	//		点击删除√
	$('body').on('click', '#td4', function() {
		var title = $(this).parent().children('td').eq(1).html();
		$(".news").hide();
		$.ajax({
			url: "DeleteInformServlet",
			type: "POST",
			dataType: "json",
			data: {
				"title": title
			},
			success: function(data) {
				alert("删除成功")
				window.location.href = "adinform.html?id=" + id;
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	$('body').on('click', '.close', function() {
		$(".text").empty();
		$(".news").show();
	})
	$('body').on('click', '.pre img', function() {
		//		上一条
		$.ajax({
			url: "ShowInformServlet",
			type: "POST",
			dataType: "json",
			data: {"info": ""},
			success: function(data) {
				datalen = data;
				var temp = " ";
				// 总条数
				num = parseInt(num);
				if(num > 0) {
					$(".text div").remove();
					$(".text").append("<div class='title'>" + data[num-1].title + "</div><div class='remark'>" + data[num-1].writeTime + " " + data[num-1].author + "</div><div class='text'>" + data[num-1].content + "</div><div class='pre'><img src='img/shangyitiao.png'></div><div class='next'><img src='img/xiayitiao.png'></div><div class='close'>返回</div>");
					num = num - 1;
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});
	$('body').on('click', '.next img', function() {
		//		下一条
		$.ajax({
			url: "ShowInformServlet",
			type: "POST",
			dataType: "json",
			data: {"info": ""},
			success: function(data) {
				datalen = data;
				var temp = " ";
				// 总条数
				num = parseInt(num);
				if(num < data.length-1 ) {
					$(".text div").remove();
					$(".text").append("<div class='title'>" + data[num+1].title + "</div><div class='remark'>" + data[num+1].writeTime + " " + data[num+1].author + "</div><div class='text'>" + data[num+1].content + "</div><div class='pre'><img src='img/shangyitiao.png'></div><div class='next'><img src='img/xiayitiao.png'></div><div class='close'>返回</div>");
					num = num + 1;
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
	});

	/* 上一页 */
	$("#bt1").click(function() {
		var page = $("#page").html();
		if(parseInt(page) > 1) {
			// 先隐藏所有的行（数据）
			$("#table1 tbody tr").hide();
			// 点击上一页时当前页数发生变化
			$("#page").html(parseInt(page) - 1);
			var count = 0;
			// 定位到上一页
			var beforePage = parseInt(page) - 1; // 假设是2
			// 显示的数据则是上上一页的后一页，即：
			var nextData = parseInt(beforePage - 1) * dataNum;
			for(var i02 = parseInt(nextData); i02 <= datalen.length; i02++) {
				count += 1;
				if(count <= dataNum) {
					$("#table1 tbody tr").eq(i02).show();
				}
			}
		}

	});
	/* 下一页 */
	$("#bt2").click(function() {
		var page = $("#page").html();
		var pageSize = $("#pageSize").html();
		// 当前页码小于总页码时
		if(parseInt(page) < parseInt(pageSize)) {
			// 先隐藏所有的行（数据）
			$("#table1 tbody tr").hide();
			// 点击下一页时当前页数发生变化
			$("#page").html(parseInt(page) + 1);
			// 展示的数据也定位到下一页（nextData~datalen.length）
			var nextData = parseInt(page) * dataNum;
			var count = 0;
			for(var i02 = parseInt(nextData); i02 <= datalen.length; i02++) {
				count += 1;
				if(count <= dataNum) {
					$("#table1 tbody tr").eq(i02).show();
				}
			}
		}

	});
	/* 首页 */
	$("#bt0").click(function() {
		var page = $("#page").html();
		var pageSize = $("#pageSize").html();
		// 当前页码大1时
		if(parseInt(page) > 1) {
			// 先隐藏所有的行（数据）
			$("#table1 tbody tr").hide();
			// 点击首页时当前页码定位到第一页
			$("#page").html(1);
			// 展示的数据也定位到第一页（1~dataNum条）
			for(var i0 = 0; i0 < dataNum; i0++) {
				$("#table1 tbody tr").eq(i0).show();
			}
		}
	});
	/* 尾页 */
	$("#bt3").click(function() {
		var page = $("#page").html();
		var pageSize = $("#pageSize").html();
		if(parseInt(page) < parseInt(pageSize)) {
			// 先隐藏所有的行（数据）
			$("#table1 tbody tr").hide();
			// 点击尾页时页码变为最大码
			$("#page").html(pageSize);
			// 展示的数据也定位到最后一页
			var nextData = parseInt(pageSize - 1) * dataNum;
			// 从倒数第二页的最后一条往后的数据展示出来
			for(var i03 = parseInt(nextData); i03 <= datalen.length; i03++) {
				$("#table1 tbody tr").eq(i03).show();
			}
		}
	});
	$("#pageNumber").click(function() {
		var pagenumber = $("#number").val();
		var pageSize = $("#pageSize").html();
		if(pagenumber == "") {
			alert("未输入内容");
		} else if(pagenumber > pageSize || pagenumber < 1) {
			alert("不包含此页");
		} else {
			$("#table1 tbody tr").hide();
			var n = (pagenumber - 1) * dataNum + 1;
			for(var i01 = n; i01 < n + dataNum; i01++) {
				$("#table1 tbody tr").eq(i01).show();
			}
		}

	})
	$("#return").click(function(){
		window.location.href="manager.html?id="+id;
	})
})