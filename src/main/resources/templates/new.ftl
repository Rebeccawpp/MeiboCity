<!DOCTYPE html>
<html>
<head>
    <title>自动补全示例</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <script>
        var myloader = function(param,success,error){
            var q = param.q || '';
            if (q.length <= 0) {
                console.log("q.length <= 0");
                return false;
            }
            else {
                console.log("q.length > 0");
            }
            $.ajax({
                url: '__CONTROLLER__/search/',
                type: 'POST',
                dataType: 'json',
                data: {'searchValue': q},
                success: function(data){
                    var items = $.each(JSON.parse(data), function(value){
                        return value;
                    });
                    success(items);
                }
            });
        }
    </script>
</head>
<body>
补全示例：
<div>
    <input class="easyui-combobox" data-options="
    valueField:'code' , textField:'spec', loader : myloader, mode : 'remote'"/>
</div>
</body>
</html>