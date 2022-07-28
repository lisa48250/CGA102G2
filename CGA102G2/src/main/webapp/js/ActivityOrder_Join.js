function detail(e){
	let id = $(e).parents('tr').find('td:first').text(); //抓到訂單編號 
	//傳到後端

		fetch(`/CGA102G2/activityJoin/activityJoin.do?action=getDetail&id=${id}`)
		.then(response => response.json())
		.then(function(myjson){
			console.log(myjson)
			$('main').children().after(
		`	<div class="card w-100 detail" id="detail">
			<div class="card-body >
				<p class="order" style="text-align:center;">訂單明細</p>
				<div class="card-body card3 " style="height:290px;"> 
					<table class="table table-sm" style="position: absolute; top: -2px; left: -1px;">
						<tbody>
						  <tr>
							<td>訂單編號 :</td>
							<td>${myjson.activityOrderId}</td>
							<td>活動名稱 :</td>
							<td>${myjson.activityName}</td>
						  </tr>
						  <tr>
							<td>活動開始時間 :</td>
							<td>${myjson.activitySessionStart}</td>
							<td>訂單日期 :</td>
							<td>${myjson.orderTime} </td>
						  </tr>
						  <tr>
							<td>活動結束時間:</td>
							<td>${myjson.activitySessionEnd}</td>
							<td>報名人數 :</td>
							<td>${myjson.enrollNumber} 人</td>
						  </tr>
						  <tr>
							<td rowspan="2" colspan="2" class="text-left">備註: <br>${myjson.orderMemo}</td>
							<td>金額 :</td>
							<td>${myjson.orderAmount} 元</td>
						  </tr>
						  <tr>
							<td colspan="2"><input id="close" class="close" type="button" value="關閉訂單明細" style="width: 300px; height: 45px; border: 0px;"></td>
						  </tr>
						</tbody>
					  </table>
				</div>
			</div>
		</div>`)})		
}

