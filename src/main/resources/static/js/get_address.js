'use strict';

$(function(){
	// [住所検索]ボタンクリックで非同期処理開始
	$(document).on('click','#get_address_btn',function() {
		$.ajax({
			url: 'http://zipcoda.net/api',	// 送信先 WebAPIのURL
			dataType: 'jsonp',	// レスポンスデータ形式 今回は最後にpをつける
			data: {	//リクエストパラメータ情報
				zipcode:$('#zipcode').val()
			},
			async: true	// 非同期で処理を行う
		}).done(function(data) {	// レスポンスデータがdataに入る
		// 検索成功時にはページに結果を反映
		// コンソールに取得したJSONデータを表示
		console.dir(JSON.stringify(data));
		$('#address').val(data.items[0].pref + data.items[0].address);	// 住所欄に住所をセット
	}).fail(function(XMLHttpRequest, textStatus, errorThrown) {
		// 検索失敗時には、その旨をダイアログ表示しエラー情報をコンソールに記載
		alert('正しい結果がえられませんでした。');
		console.log('XMLHttpRequest:' + XMLHttpRequest.status);
		console.log('textStatus:' + textStatus);
		console.log('errorThrown:' + errorThrown);
		});
	});
});

