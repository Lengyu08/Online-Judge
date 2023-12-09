document.addEventListener("DOMContentLoaded", function () {
  var projectElements;
  projectElements = document.querySelectorAll(".project");
  for (var i = 0; i < projectElements.length; i++) {
    projectElements[i].addEventListener("click", function () {
      window.location.href = "/ITEM/" + this.id + ".jsp";
    });
  }
});
