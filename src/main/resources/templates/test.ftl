<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        function show(){
            var val=$("#in").val();
//            alert(val);
            $.ajax({
                type:"post",
                dataType:"json",
                data:val,
                url:"test/"+val,
                success:function(text){
                    $("#choose option").remove();

                    $(text).each(function(i){


                        $("#choose").append("<option value='"+text[i].value+"'>"+text[i].name+"</option>");

                    });


                }
            });
        }
    </script>
</head>
<body>
    <input type="text" id="in" oninput="show()" list="choose">
    <datalist id="choose">

    </datalist>
</body>
</html>