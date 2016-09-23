function correctMenu(id) {
    if (document.body.contains(document.getElementById(id))) {
        setCorrectLinksToMenuOptions();
        activateMenuOption(id);
        setLangSuffix();
    }
    return false;
}

function activateMenuOption(id) {
    document.getElementById(id).setAttribute("class", "active");
    document.querySelectorAll('#'+id+' a')[0].removeAttribute("href");
}

function hideMenuBar() {
    document.getElementById("menuBar").style.visibility = "hidden";
    document.getElementById("collapseButton").style.visibility = "hidden";
}

function setCorrectLinksToMenuOptions() {
    document.getElementById("linkHome").setAttribute("href", "home");
    document.getElementById("linkWeek").setAttribute("href", "week");
    document.getElementById("linkMonth").setAttribute("href", "month");
    document.getElementById("linkCategory").setAttribute("href", "category");
    document.getElementById("linkAdd").setAttribute("href", "add");
}

function getLanguageFromCookie() {
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

function setLangSuffix() {
    var language = getLanguageFromCookie();
    var short = "";
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