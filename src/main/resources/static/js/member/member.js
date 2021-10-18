var member = {
	init : function (){
		var _this = this;
	},

	save : function () {
		var data = {
			userId: $('#userId').val(),
			pw: $('#pw').val(),
			corpNm: $('#corpNm').val(),
			telNo: $('#telNo').val(),
			name: $('#name').val(),
			email: $('#email').val(),
 		};

		console.log(data)

		$.ajax({
			url: '/sign/signup',
			dataType: 'json',
			type: 'post',
			contentType:'application/json; charset=utf-8',
			data: JSON.stringify(data)
		}).done(function() {
			alert('회원가입이 완료되었습니다.');
			window.location.href = '/';
		}).fail(function (error) {
			alert(JSON.stringify(error));
		});
	},

	login : function () {

		console.log($('form').serialize())

		$.ajax({
			url : "/login",
			type : "post",
			data : $('form').serialize(),
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		}).done(function (data) {

			if(data == "success"){
				window.location.href = "/project/list";
			}else{
				alert(data);
			}
		}).fail(function (error) {
			alert(JSON.stringify(error))
		});

	}


}