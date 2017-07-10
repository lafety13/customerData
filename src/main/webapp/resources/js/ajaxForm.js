jQuery(document).ready(function($) {
    $("#form").submit(function(event) {
        // Disble the search button
        enableButton(false);
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        sendFormAjax();
    });
});

function sendFormAjax() {
    var id = $("#id").val(),
        firstName = $("#firstName").val(),
        lastName = $("#lastName").val(),
        patronymicName = $("#patronymicName").val(),
        phoneNumberId = $("#phoneId").val(),
        phoneNumber = $("#phone").val(),
        phoneNumberType = $("#phoneType").val(),
        phoneNumberComment = $("#phoneComment").val(),
        json =
            {
                "id": id,
                "firstName": firstName,
                "lastName": lastName,
                "patronymicName": patronymicName,
                "phoneNumber":
                    {
                        "id": phoneNumberId,
                        "phoneNumber": phoneNumber,
                        "type": phoneNumberType,
                        "comment": phoneNumberComment
                    }
            };

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/add",
        data : JSON.stringify(json),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            refresh();
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
            enableButton(true);
        }
    });

}

function refresh() {
    var path = window.location.toString();
    $.ajax({
        dataType:'html',
        url: path,
        success: function(d){
            console.log(d);
            $("body").html(d);
        }
    })
}

function enableButton(flag) {
    $("#submit").prop("disabled", flag);
}
