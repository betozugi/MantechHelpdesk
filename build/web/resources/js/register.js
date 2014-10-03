$(document).ready(function () {
    $("#Username").keyup(function () {
        if (this.value.length >= 3) {
            $("#errUsername").text("");
        }
        if (this.value.length == "") {
            $("#errUsername").text("- Username Not Null");
        }
        if (this.value.length < 3) {
            $("#errUsername").text(" - Username greater than 3 characters");
        }
        if (/^[a-zA-Z0-9- ]*$/.test(this.value) == false) {

            $("#errUsername").text(" -Username have special characters");
        }

    });

    $("#Email").keyup(function () {
        if (this.value.length > 3) {
            $("#errEmail").text("");
        }
        if (this.value.length == "") {
            $("#errEmail").text("-Email Not Null");
        }
        if (this.value.length < 3) {
            $("#errEmail").text("Email greater than 3 characters");
        }
        var iChars = "~`!#$%^&*+=-[]\\\';,/{}|\":<>?";
        for (var i = 0; i < this.value.length; i++) {
            if (iChars.indexOf(this.value.charAt(i)) != -1) {
                $("#errEmail").text(" -Email have special characters");
                break;
            }
        }
    });

    $("#Fullname").keyup(function () {
        if (this.value.length >= 3) {
            $("#errFullname").text("");
        }
        if (this.value.length == "") {
            $("#errFullname").text("- Fullname Not Null");
        }
        if (this.value.length < 3) {
            $("#errFullname").text(" - Fullname greater than 3 characters");
        }
        if (/^[a-zA-Z0-9- ]*$/.test(this.value) == false) {

            $("#errFullname").text(" -Fullname have special characters");
        }

    });
    $("#Address").keyup(function () {
        if (this.value.length >= 3) {
            $("#errAddress").text("");
        }
        if (this.value.length == "") {
            $("#errAddress").text("- Address Not Null");
        }
        if (this.value.length < 10) {
            $("#errAddress").text(" - Address greater than 10 characters");
        }
        var iChars = "~`!#$%^&*+=-[]\\\';,/{}|\":<>?";
        for (var i = 0; i < this.value.length; i++) {
            if (iChars.indexOf(this.value.charAt(i)) != -1) {
                $("#errAddress").text(" -Address have special characters");
                break;
            }
        }
    });

    $("#PhoneNumber").keyup(function () {
        if (this.value.length >= 10 && this.value.length <= 11) {
            $("#errPhone").text("");
        }
        else {
            $("#errPhone").text(" - Phone number must be between 10 and 11 number");
        }
        
       
    });
});
