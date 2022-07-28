// 信用卡動畫
const body = { document };
$(document).ready(function() {
  $("#end_date").prop("disabled", true);
  document.querySelector("#start_date").onchange = () => {
    $("input").prop("disabled", false);
  }
});
