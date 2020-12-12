
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax根据省份id获取名称</title>
    <script src="js/jquery-3.5.0.min.js"></script>
    <script type="text/javascript">
      //使用jquery实现ajax请求
        $(function () {
            $("#btn").click(function () {
              //获取dom的value值
              var id = $("#id").val();
              //发起ajax请求
              $.ajax({
                url:"one",
                type:"get",
                data:{
                  "id":id
                },
                dataType:"json",
                success:function (data) {
                  alert("省份名称:"+data.name+" 省份简称:"+data.jiancheng+" 省会:"+data.shenghui);
                  //给文本框赋值
                  $("#name").val(data.name);
                  $("#jiancheng").val(data.jiancheng);
                  $("#shenghui").val(data.shenghui)
                }
              })
            })
        })

    </script>
  </head>
  <body>
        <center>
          <P>ajax根据省份id获取名称</P>
          <table border="2">
            <tr>
              <td>省份编号</td>
              <td><input type="text" id="id"></td>
              <td><input type="button" value="搜索" id="btn"></td>
            </tr>
            <tr>
              <td>省份名称</td>
              <td><input type="text" id="name"></td>
            </tr>
            <tr>
              <td>省份简称</td>
              <td><input type="text" id="jiancheng"></td>
            </tr>
            <tr>
              <td>省会</td>
              <td><input type="text" id="shenghui"></td>
            </tr>
          </table>
        </center>
  </body>
</html>
