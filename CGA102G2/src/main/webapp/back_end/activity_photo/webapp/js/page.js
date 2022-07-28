const body = { document };
let date = new Date();
$(document).ready(function() {
  document.getElementById("card-number-input").oninput = () => {
    document.getElementById(
      "card-number-box"
    ).innerText = document.getElementById("card-number-input").value;
  };

  document.querySelector("#card-holder-input").oninput = () => {
    document.querySelector(
      "#card-holder-name"
    ).innerText = document.querySelector("#card-holder-input").value;
  };

  document.querySelector(".month-input").oninput = () => {
    document.querySelector(".exp-month").innerText = document.querySelector(
      ".month-input"
    ).value;
  };

  document.querySelector(".year-input").oninput = () => {
    document.querySelector(".exp-year").innerText = document.querySelector(
      ".year-input"
    ).value;
  };

  document.querySelector("#cvv-input").onmouseenter = () => {
    document.querySelector("#front").style.transform =
      "perspective(1000px) rotateY(-180deg)";
    document.querySelector("#back").style.transform =
      "perspective(1000px) rotateY(0deg)";
  };

  document.querySelector("#cvv-input").onmouseleave = () => {
    document.querySelector("#front").style.transform =
      "perspective(1000px) rotateY(0deg)";
    document.querySelector("#back").style.transform =
      "perspective(1000px) rotateY(180deg)";
  };

  document.querySelector("#cvv-input").oninput = () => {
    document.querySelector("#cvv-box").innerText = document.querySelector(
      "#cvv-input"
    ).value;
  };

  document.querySelector("#cr").onclick = () => {
    document.querySelector("#front").style.visibility = "visible";
    document.querySelector("#back").style.visibility = "visible";
    document.querySelector(".form").style.visibility = "visible";
    document.querySelector(".info").style.height = "961px";
    document.querySelector(".submit-top").style.visibility = "hidden";
    document.querySelector("footer").style.bottom = "-1200px";
  };
  document.querySelector("#cash").onclick = () => {
    document.querySelector("#front").style.visibility = "hidden";
    document.querySelector("#back").style.visibility = "hidden";
    document.querySelector(".form").style.visibility = "hidden";
    document.querySelector(".info").style.height = "400px";
    document.querySelector(".submit-top").style.visibility = "visible";
  };
  $("#end_date").prop("disabled", true);
  document.querySelector("#start_date").onchange = () => {
    $("input").prop("disabled", false);
  };

  
});
