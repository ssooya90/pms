var manager = {

	init : function (){
		var _this = this
	},

	reg : function (){

		var data = {
			managerNm : $('#managerNm').val(),
			managerTelNo : $('#managerTelNo').val(),
		}

		$.ajax({
			url : "/manager/reg",
			dataType : 'json',
			type : 'post',
			contentType:'application/json; charset=utf8',
			data : JSON.stringify(data)
		}).done(function (result){
			console.log(result)
			alert('담당자 등록이 완료되었습니다.');
			window.location.href = '/manager/list';
		}).fail(function (error){
			alert(JSON.stringify(error));
		});
	},

	update : function (){

		var _params = {
			id : $('input[name=id]').val(),
			managerNm: $('input[name=managerNm]').val(),
			managerTelNo: $('input[name=managerTelNo]').val(),
		}


		$.ajax({
			url: "/manager/update",
			dataType: 'json',
			type: 'post',
			contentType: 'application/json; charset=utf=8',
			data: JSON.stringify(_params)
		}).done(function (result){

			alert("수정되었습니다");
			window.location.href="/manager/list"




		}).fail(function (error){
			alert(JSON.stringify(error));
		});

	}
}