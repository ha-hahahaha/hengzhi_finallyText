$(document).ready(function() {
	var num;
	$.ajax({
		url: "ShowNavFatherServlet",
		async: false,
		type: "POST",
		dataType: "json",
		success: function(data) {

			num=data.length;
			for(var i=0;i<data.length;i++){
				$(".container").append("<div class='col-md-5'><ul><div class='head'><img src='img/2020-07-14 183215.png'></div><li class='stair'><a href='"+data[i].toLink+"'>"+data[i].navName+"</a></li><li id='id'>"+data[i].nameId+"</li></ul></div>");
			}
			$("[id=id]").hide();
		},
		error: function() {
			var error = "查询数据失败！";
			console.log(error);
			alert(error);
		}
	});
	for(var i=0;i<num;i++){
		id=$("ul").eq(22+i).children('li').eq(1).html();
		$.ajax({
			url: "ShowNavSonServlet",
			async: false,
			type: "POST",
			dataType: "json",
			data:{
				//你给我父类id我给你子类
				"id":id
			},
			success: function(data) {
				//alert(data[0].navName);
				for(var j = 0; j < data.length; j++) {
					$("ul").eq(22 + i).append("<li class='item'><a href='"+data[j].toLink+"'><img src='img/tuya_huabanfuben.png'>"+data[j].navName+"</a></li>")
				}
			},
			error: function() {
				var error = "查询数据失败！";
				console.log(error);
				alert(error);
			}
		});
		$("ul").eq(22 + i).append("<div class='line'></div>");
	}
})