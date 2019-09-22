
function validateForm() {
  var x = document.forms["formName"]["contact"].value;
  if (x.length>9) {
    alert("Password must be filled out");
    return false;
  }
}
