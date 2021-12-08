var project = {

	init : function (){

		var _this = this
	},

	regPageMove : function () {




	},

	reg : function () {

		var data = {
			name: $('#name').val(),
			description : $('#description').val(),
			parent : $('#parent').val(),
			state : $('#state').val(),
			price: $('#price').val(),
			manager: $('#manager').val(),
		};

		console.log(data)

		$.ajax({
			url: '/project/reg',
			dataType: 'json',
			type: 'post',
			contentType:'application/json; charset=utf-8',
			data: JSON.stringify(data)
		}).done(function(result) {

			console.log(result)
			alert('프로젝트 등록이 완료되었습니다.');
			window.location.href = '/project/list';

		}).fail(function (error) {
			alert(JSON.stringify(error));
		});
	},

	update : function (){

		alert("작업중");
	}



}