function correctMenu(id) {
        setLangSuffix();
        setCorrectLinksToMenuOptions();
    if (document.body.contains(document.getElementById(id))) {
        activateMenuOption(id);
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
    document.getElementById("linkHome").setAttribute("href", "/vocky/home");
    document.getElementById("linkWeek").setAttribute("href", "/vocky/week");
    document.getElementById("linkMonth").setAttribute("href", "/vocky/month");
    document.getElementById("linkCategory").setAttribute("href", "/vocky/category");
    document.getElementById("linkVocabulary").setAttribute("href", "/vocky/vocabulary");
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
function openAndFill(event) {
    var formFields = [];
    var $target = $(event.target);
    var $row = $target.closest('tr');
    $row.find('td').each(function (index, el) {
        var fieldValue = $(el).html();
        switch (index) {
            case 0:
                formFields['id'] = $(el).find('div:first').text();
                break;
            case 1:
                formFields['word'] = fieldValue;
                break;
            case 2:
                formFields['translation'] = fieldValue;
                break;
            case 3:
                formFields['category'] = fieldValue;
                break;
            case 4:
            if ($(el.getElementsByTagName('span')).length>=1) {
                formFields['weekWord'] = true;
            } else {
                formFields['weekWord'] = false;
            }
                break;
            default:
                break;
        }
    });
    fillForm(formFields);
};

function fillForm(data) {
    var $form = $('#modalForm');
    $form.attr('action', '/vocky/word/edit');
    $('#submitModal').attr('value', 'Edit word');
    $form.find('input').each(function () {
        var $input = $(this);
        switch ($input.attr("name")) {
            case 'id':
               $input.val(data['id']);
               break;
            case 'word':
               $input.val(data['word']);
               break;
            case 'translation':
               $input.val(data['translation']);
               break;
            case 'category':
               $input.val(data['category']);
               break;
            case 'addAsWeekWord':
               $input.prop("checked", data['weekWord']);
               break;
            default:
                break;

        }
        $("#addWordModal").modal('show');
    });
}

$('#openModalButton').click(function () {
    $('#modalForm').attr('action', '/vocky/word/add');

    $('#submitModal').attr('value', 'Add word');
});

function deleteWord(id, option) {
    if(confirm("Are you sure you want to delete this word?")) {
        switch (option) {
            case 'regular':
                document.location='/vocky/word/remove/' + id;
                break;
            case 'week' :
                document.location='/vocky/weekWord/remove/' + id;
                break;
            case 'month':
                document.location='/vocky/monthWord/remove/' + id;
                break;
        }
        return false
    }
}

function deleteWeekWord(id) {
    deleteWord(id, 'week' );
}

function deleteMonthWord(id) {
    deleteWord(id, 'month');
}

function deleteRegularWord(id) {
    deleteWord(id, 'regular');
}

