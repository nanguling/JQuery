
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省市级联查询</title>
    <script type="text/javascript" src="js/jquery-3.5.0.min.js"></script>
    <script type="text/javascript">
      function loadDataAjax() {
        $.get("provselect", function (data) {
          //删除旧的数据，将已经存在的数据清空,防止用户多次点击出现重复数据
          $("#province").empty();
          $.each(data, function (i, n) {
            //data是一个json数组，[{},{},{}]
            //遍历数组得到数组的成员，即每个json
            //***测试一下***
            //alert("下标:"+i+" 省份id:"+n.id+" 省份名称:"+n.name);//通过
            //将得到的每个json拼接到下拉列表框中
            $("#province").append("<option value=" + n.id + ">" + n.name + "</option>");
          })
        })
      }

      $(function () {
        //$(function ()在页面dom对象加载成功后执行的函数，在此发起ajax请求
        loadDataAjax();
        $("#btnload").click(function () {
          loadDataAjax();
        })
        //给省份的select绑定一个change事件，当select内容发生改变的时候，触发事件
        $("#province").on("change",function () {
          //选择器选择出被选中的下拉列表框,得到其value属性值
          var value = $("#province>option:selected").val()
          //通过value属性值再次发起异步请求，得到该省份下的所有城市信息，并添加到城市的下拉列表框中
          $.get("cityselect",{id:value},callback)
        })
      })

      //定义一个处理返回数据的函数
      function callback (res) {
        //res是一个json数组，[{},{},{}]
        //遍历数组
        //先删除原来的city数据，防止多次选择出现重复数据
        $("#city").empty();
        $.each(res,function (i,n) {
          //***测试一下***
          //alert("下标:"+i+" 城市id:"+n.id+" 城市名称:"+n.name)//通过
          //将得到的json数据，添加到ctiy的下拉列表框中
          $("#city").append("<option value="+n.id+">"+n.name+"</option>")
        })
      }
    </script>
  </head>
  <body>
    <center>
      <P>使用Ajax省市级联查询</P>
      <div>
        <table border="2" cellpadding="0" cellspacing="0">
          <tr>
            <td>省份:</td>
            <td>
              <select id="province">
                <option value="0">请选择...</option>
              </select>
              <input type="button" id="btnload" value="load数据">
            </td>
          </tr>
          <tr>
            <td>城市:</td>
            <td><select id="city">
              <option value="0">请选择...</option>
            </select></td>
          </tr>
        </table>
      </div>
    </center>
  </body>
</html>
