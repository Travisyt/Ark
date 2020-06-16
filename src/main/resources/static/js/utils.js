function loading(isLoading, loadingId = "loading", backgroundId = "body", callback = function () {
}) {
    if (isLoading) {
        $("#" + loadingId).css('display', 'inline');
        $('#' + backgroundId).addClass("depth-of-focus");
    } else {
        $("#" + loadingId).css('display', 'none');
        $('#' + backgroundId).removeClass("depth-of-focus");
    }
    callback();
}

function logger(functionName = 'main', msg = 'info', callback = function () {
}) {
    let date = new Date();
    console.log(date.toDateString() + "  " + functionName + ":    " + msg);
    callback();
}

function errHandler(msg, handler = function () {
}) {
    alert("错误: " + msg);
    handler();
}