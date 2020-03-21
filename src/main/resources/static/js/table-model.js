function loading(isLoading) {
    if (isLoading) {
        $("#loading").css('display', 'inline');
        $('#main-table').addClass("depth-of-focus");
    } else {
        $("#loading").css('display', 'none');
        $('#main-table').removeClass("depth-of-focus");
    }
}

function errHandler(msg, callback = function () {
}) {
    alert(msg);
    callback(msg);
}

