var UI = {
    dialogOptions: function (options) {
        var settings = $.extend({}, $.ui.dialog.prototype.options, {
            height: "auto",
            width: "auto",
            modal: true,
            resizable: false,
            open: function (ui) {
                var $thisDialog = $(this).parents(".ui-dialog").eq(0);
                if (options && options.removeTitlebarClose == true) {
                    $(".ui-dialog-titlebar-close", $thisDialog).remove();
                } else {
                    $(".ui-dialog-titlebar-close", $thisDialog).html("<button class='close'>&times;</button>").blur();
                }
            },
            close: function () {
                $(this).dialog("destroy");
                $(this).empty();
            }
        });
        if (options) {
            $.extend(settings, options);
        }
        return settings;
    }
};

$(function () {
    $(document).ajaxError(function (event, jqXHR) {
        if (jqXHR.statusText === "abort") {
            return;
        } else {
            $("#error-info").html(jqXHR.responseText).dialog(UI.dialogOptions()).dialog("open");
        }
    });
});