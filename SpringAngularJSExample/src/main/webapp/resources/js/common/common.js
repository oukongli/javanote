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
    },

    convertToObj: function(param) {
        var data;
        if(Object.prototype.toString.call(param) == "[object String]")
            data = eval('(' + param + ')');
        if(Object.prototype.toString.call(param) == "[object Object]" || Object.prototype.toString.call(param) == "[object Array]")
            data = param;
        return data;
    }
};

function template(template, data) {
    return template.replace(/\{([\w\.]*)\}/g, function(str, key, offset, source) {
        var keys = key.split("."), v = data[keys.shift()];
        for (var i = 0, l = keys.length; i < l; i++) { v = v[keys[i]]; }
        return (typeof v !== "undefined" && v !== null) ? v : "";
    });
}

$(function () {
    $(document).ajaxError(function (event, jqXHR) {
        if (jqXHR.statusText === "abort") {
            return;
        } else {
            $("#error-info").html(jqXHR.responseText).dialog(UI.dialogOptions()).dialog("open");
        }
    });
});