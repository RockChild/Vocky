function correctMenu2(id) {
        setLangSuffix2();
        setCorrectLinksToMenuOptions2();
    if (document.body.contains(document.getElementById(id))) {
        activateMenuOption2(id);
    }
    return false;
}

function activateMenuOption2(id) {
    document.getElementById(id).setAttribute("class", "active");
    document.querySelectorAll('#'+id+' a')[0].removeAttribute("href");
}

function hideMenuBar2() {
    document.getElementById("menuBar").style.visibility = "hidden";
    document.getElementById("collapseButton").style.visibility = "hidden";
}

function setCorrectLinksToMenuOptions2() {
    document.getElementById("linkHome").setAttribute("href", "home");
    document.getElementById("linkWeek").setAttribute("href", "week");
    document.getElementById("linkMonth").setAttribute("href", "month");
    document.getElementById("linkCategory").setAttribute("href", "category");
    document.getElementById("linkAdd").setAttribute("href", "add");
}

function getLanguageFromCookie2() {
    var name = "language=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == ' ') {
          c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
          return c.substring(name.length, c.length);
      }
    }
    return "";
}

function setLangSuffix2() {
    var language = getLanguageFromCookie2();
    var short = '';
    if (language == "English") {
        short = " EN";
    } else if (language == "Polish") {
        short = " PL";
    } else {
        document.cookie.language = "English";
        short= " EN";
    }
    document.getElementById('linkVocky').textContent += short;
}