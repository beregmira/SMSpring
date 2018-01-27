$('#registration').click(function () {
    var pass = $("#password").val();
    var passwordconfirm = $("#passwordconfirm").val();
    var username = $("#username").val().length;
    if (pass === passwordconfirm && (username & pass.length & passwordconfirm.length)) {
        $('#FormRegistration').submit();
    }
    else {
        $(location).attr('href', '/sign?error')
    }
});
