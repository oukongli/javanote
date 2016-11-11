<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>

</head>
<body>

<style type="text/css">
    table {
        border-collapse: collapse;
    }

    table, td, th {
        border: 1px solid black;
    }

    .hidden_div {
        display: none !important;
        max-height: 0;
        overflow: hidden;
        mso-hide: all;
        height: 0;
        width: 0;
        line-height: 0;
        float: left;
    }

    .hidden_div tr {
        display: none !important;
    }
</style>

<h1>Welcome ${user}!</h1>
<p>Our latest product: <a href="${latestProduct.url}">${latestProduct.name}</a>!</p>


<div class="hidden_div">
    <h4>垂直的表头：</h4>
    <table border="1">
        <tr>
            <th>姓名</th>
            <td>Bill Gates</td>
        </tr>
        <tr>
            <th>电话</th>
            <td>555 77 854</td>
        </tr>
        <tr>
            <th>电话</th>
            <td>555 77 855</td>
        </tr>
    </table>
</div>


</body>
</html>