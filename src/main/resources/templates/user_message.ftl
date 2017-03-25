<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base id="base" href="${base}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理中心-编辑资料</title>
<link href="css/style.reset.css" rel="stylesheet" type="text/css" />
<link href="css/css3style.css" rel="stylesheet" type="text/css" />
<link href="css/font-color-size.css" rel="stylesheet" type="text/css" />
<link href="css/table.select.style.css" rel="stylesheet" type="text/css" />
<link href="css/top-style.css" rel="stylesheet" type="text/css" />
<link href="css/index-body-style.css" rel="stylesheet" type="text/css" />
<link href="css/user.css" rel="stylesheet" type="text/css" />
<script src="js/top-city-check.js"></script>
 <script type="text/javascript">
    function createIEXmlDom(){
    var arr=["MSXML2.DOMDocument.6.0","MSXML2.DOMDocument.5.0","MSXML2.DOMDocument.4.0","MSXML2.DOMDocument.3.0","MSXML2.DOMDocument","Microsoft.XMLDOM"];

    try{
    for(var i=0;i<arr.length;i++){
    return new ActiveXObject(arr[i]);

    }
    }catch(e){
    throw e;
    }
    }


    function xmlDom(){
    var dom;
    if(window.ActiveXObject){//IE
    dom=createIEXmlDom();
    }else if(document.implementation && document.implementation.createDocument){//在火狐及其他浏览器中的XML解析器
    dom=document.implementation.createDocument("","",null);

    }else{
    throw new Error("您的浏览器不支持");

    }

    return dom;
    }
    window.onload=function(){
    var xmldom;
    if(window.DOMParser){
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.open("GET","/static/city.xml",false);//获取服务器中的books.xml文件
    xmlhttp.send(null); //就是请求的参数
    xmldom=xmlhttp.responseXML;

    }else{
    xmldom=xmlDom();
    xmldom.async=false;
    xmldom.load("/city.xml");

    }

    var pro_obj=document.getElementById("province");
    var city_obj=document.getElementById("city");
    var area_obj=document.getElementById("area");

    var pros=xmldom.getElementsByTagName("province");
    for( var i=0;i<pros.length;i++){
    addOption(pros[i],pro_obj);

    }

    //当省份发生改变时
    pro_obj.onchange=function(){
    //获取当前选中的省份的postcode
    var flag=pro_obj.value;
    //弹出所选择的市
    //alert(pro_obj.options[pro_obj.selectedIndex].text);

    //清空市区中原有的数据
    city_obj.length=1;
    for(var i=0;i<pros.length;i++){
    if(pros[i].nodeType==1 && pros[i].getAttribute("postcode")==flag ){
    var cities=pros[i].childNodes;
    for( var j=0;j<cities.length;j++ ){
    addOption(cities[j],city_obj);

    }
    }
    }
    }

    //当市发生改变时
    var citiess=xmldom.getElementsByTagName("city");
    city_obj.onchange=function(){
    //获取当前选中的市
    var flag_city=city_obj.value;
    //清空地区中原有的数据
    area_obj.length=1;
    for(var i=0;i<citiess.length;i++){
    if( citiess[i].nodeType==1 && citiess[i].getAttribute("postcode")==flag_city ){//citiess[i].nodeType==1 1:表示元素节点，2：表示属性节点，3：表示文本节点
    var areas=citiess[i].childNodes;
    for( var j=0;j<areas.length;j++){
    addOption(areas[j],area_obj);

    }
    }
    }
    }
    }

    //node为要添加的节点对象,obj为要添加到的 select对象
    function addOption(node,obj){
    if(node.nodeType==1){
    var opt=document.createElement("option");
    opt.appendChild( document.createTextNode( node.getAttribute("name") ) );
    opt.setAttribute("value",node.getAttribute("postcode"));
    obj.appendChild(opt);
    }
    }
    </script>
    <script type="text/javascript" src="static/js/jquery-1.11.0.js">

    </script>
    <script type="text/javascript">
        function res() {
            var index1 = $("#province").find("option:selected").text();
            var index2 = $("#city").find("option:selected").text();
            var index3 = $("#area").find("option:selected").text();
            $("#add").val(index1+index2+index3);
        }
    </script>
    <script type="text/javascript">
        $(function () {
            $("#save").click(function () {
                var index1 = $("#province").find("option:selected").text();
                var index2 = $("#city").find("option:selected").text();
                var index3 = $("#area").find("option:selected").text();
                $("#add").val(index1+index2+index3);
            });
        });

    </script>
</head>

<body>
	<!-- 顶部 -->
	<div class="index-top-box">
		<div class="index-top center">
    	<!--收藏夹-->
			<div class="checkCity favorit css3bg fr" onMouseover="jsoverD();" onMouseout="jsoutD();" >&nbsp;&nbsp;<a href="shoucang.html">收藏夹</a>
				<!--收藏夹/显示的内容-->
				<div class="Collection-of-goods none-r" id="d1" onMouseover="jsoverD();" onMouseout="jsoutD();" >
					<p align="center" style="line-height:22px ; padding:10px 0">收藏夹是空的！</p>
				</div>
			</div>
			<!--客户服务-->
			<div class="fr noneAny"><a href="bangzhu.html">客户服务</a></div>
			<!--我的订单-->
			<div class="fr noneAny"><a href="order.ftl">我的订单</a></div>
			<!--我的商铺-->
			<div class="fr noneAny"><a>我的商铺</a></div>
			<!--免费注册-->
			<div class="fr noneAny"><a href="register.ftl">[免费注册]</a></div>
			<!--登录-->
			<div class="fr noneAny"><a href="login.ftl">[登录]</a></div>
			<!--亲，欢迎来！-->
			<div class="fr noneAny">亲，欢迎来美博城！</div>

		</div>
	</div>
	
	<!-- 顶部结束-->
	<div class="clear"></div>
	<!-- logo开始-->
	<div class="logoBox center">
		<!--左侧logo-->
		<div class="logo fl">
			<span class="fl"><img src="img/login/logo.jpg" /></span>
		</div>
		
		<!--右侧search-->
		<div class="searchBox fl">
			
			<!--搜索BOX-->
			<div class="searchinput fr">
				<!--搜索-->
				<div class="S-bg">
					<input type="text" class="S-text fl" value="请输入关键词搜索" style="color:#c4c4c4" />
					<a href="allsearch.html"><input type="submit" class="S-submit size14 fl" value="搜索"></a>
				</div>

			</div>
			
		</div>
	</div>
	<!-- logo结束-->
	<div class="clear"></div>
	<!-- 导航开始-->
	<div class="navBox">
		<div class="nav center">
			<!--商品分类-->
			<div class="classification fl">
				<div class="hd size14-b">商品分类</div>
			</div>
			<!--导航栏目-->
			<div class="bigNav fl">
				<ul>
					<li><a href="#">商城首页</a></li>
					<li><a href="#">品牌专区</a></li>
					<li><a href="#">特价专场</a></li>
					<li><a href="#">关于我们</a></li>
				</ul>
			</div>
			<!--购物车-->
			<div class="shopping-cart fr size14">购物车 ( <a href="order.ftl">0</a> ) 件</div>
		</div>
	</div>
	<!--导航结束-->
	<div class="clear"></div>

	<!--位置-->
	<div class="user_here center">所在的位置：中国美博城 > 编辑资料</div>
	<!--用户管理中心-->
	<div class="user_center center">
		<!--左侧-->
		<div class="user_left fl">
			<div class="user_head"><img src="img/user/user_head.gif" /></div>
			<div class="user_menu">
				<ul>
					<h2><img src="img/user/menu01.jpg" /><span class="" style="display:none">订单查询</span></h2>
					<li><a href="shoping/order1">&gt;&gt;&nbsp;我的订单</a></li>
					<li><a href="yigou.html">&gt;&gt;&nbsp;已购商品</a></li>
					<li><a href="shoucang.html">&gt;&gt;&nbsp;我的收藏</a></li>
					<li><a href="pingjia.html">&gt;&gt;&nbsp;商品评价</a></li>
				</ul>
				<ul>
					<h2><img src="img/user/menu02.jpg" /><span class="" style="display:none">自助服务</span></h2>
					<li><a href="tousu.html">&gt;&gt;&nbsp;在线投诉</a></li>
					<li><a href="tuihuan.html">&gt;&gt;&nbsp;在线退换货物</a></li>
					<li><a href="bupiao.html">&gt;&gt;&nbsp;在线补开发票</a></li>
					<li><a href="chaxun.html">&gt;&gt;&nbsp;常见问题查询</a></li>
					<li><a href="bangzhu.html">&gt;&gt;&nbsp;帮助中心</a></li>
				</ul>
				<ul>
					<h2><img src="img/user/menu03.jpg" /><span class="" style="display:none">账户信息</span></h2>
					<li><a href="zhanghu.html" >&gt;&gt;&nbsp;账户查询</a></li>
				</ul>
				<ul>
					<h2><img src="img/user/menu04.jpg" /><span class="" style="display:none">个人信息</span></h2>
					<li><a id="current">&gt;&gt;&nbsp;编辑资料</a></li>
					<li><a href="anquan.html">&gt;&gt;&nbsp;安全中心</a></li>
					<li><a href="xiaoxi.html">&gt;&gt;&nbsp;消息提醒</a></li>
				</ul>
			</div>
		</div>
		<!--右侧-->
		<div class="user_right fr">
			<div class="user_dingdan">
				<p>编辑资料</p>
			</div>
			<div class="fapiao_table ziliao_table">
				<form action="user/compile_file" method="post" commandName="user" enctype="multipart/form-data">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>

						<td width="147" rowspan="9" align="center" class="color2" valign="top">
						<p><img src="img/user/touxiang.gif" width="105" height="105" /></p>
						<p><ul>
                            <li>修改头像</li>
                            <div class="formRow">
                                <div class="control-group formSep">
                                    <div class="alert alert-info">
                                        <div class="controls">
                                            <div data-fileupload="image" class="fileupload fileupload-new">
                                                <#--<div style="width: 60px; height: 60px;" class="fileupload-new thumbnail">-->
                                                    <#--&lt;#&ndash;<img src="img/user/touxiang.gif" name="portrait" id="portrait" alt="请选择图片" />&ndash;&gt;-->
                                                <#--</div>-->
                                                <div style="width: 80px; height: 80px; line-height: 80px;" class="fileupload-preview fileupload-exists thumbnail">
                                                </div>
                                                <input type="file" id="file0" name="avatar" class="uni_style" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </ul></p></td>
						<td width="80" align="right" class="color2">用户名</td>
						<td width="733"><strong>${user.username}</strong></td>
					  </tr>
					  <tr>
						<td width="80" align="right" class="color2"><span class="color4 size14">*</span> 邮箱</td>
						<td>
							<input type="text" class="oto_text_one fl" name="email" />
						</td>
					  </tr>
					  <tr>
						<td width="80" align="right" class="color2"><span class="color4 size14">*</span> 手机</td>
						<td>

						<input type="text" class="oto_text_one fl" name="phone"/>					</td>
					  </tr>
					  <tr>
						<td width="80" align="right" class="color2"><span class="color4 size14">*</span> 性别</td>
						<td>
							<select name="sex">
								<option value="1">
									男
								</option>
								<option value="0">
									女
								</option>
							</select>
						</td>
					  </tr>
					  <tr>
						<td width="80" align="right" class="color2">真实姓名</td>
						<td><input type="text" class="oto_text_one oto_text_two fl" name="realname" /></td>
					  </tr>
					  <tr>
						<td width="80" align="right" class="color2">身份证号码</td>
						<td>
							<input type="text" class="oto_text_one fl" name="cardId"/>
						</td>
					  </tr>
					  <tr>
						<td width="80" align="right" valign="top" class="color2">所在地</td>
						<td><div class="" style="width:100% ; height:35px">
							<select class="oto_select add_sheng fl" id="province">
                                <option value="100000">--请选择省份--</option>
							</select>
							<select class="oto_select add_shi fl" id="city">
                                <option value="100000">--请选择城市--</option>
							</select>
							<select class="oto_select add_qu fl" id="area">
                                <option value="100000">--请选择地区--</option>
							</select>
                            <input type="hidden" id="add" name="address"/>

                        </div>
							<div class="" style="width:100% ; height:35px">
							<input type="text" class="oto_text_one fl" name="address" placeholder="请输入详细地址" style="width:360px" />
							</div>						</td>
					  </tr>

					  <tr>
						<td>&nbsp;</td>
						<td>
                            <button class="btn_baocun" id="save">保存修改</button>
                            <span style="color:red">
                                <#if up_error??>
                                    ${up_error}
                                </#if>
                            </span>
                        </td>
					  </tr>
					</table>
                </form>
		  </div>
		</div>
	</div>



	<div class="clear" style="height:30px"></div>

	<div class="footerLink">
		<div class="footerLink_ul center">
			<ul>
				<h2>关于美博</h2>
				<li><a href="oto-about.html">关于我们</a></li>
				<li><a href="oto-zxns.html">招贤纳士</a></li>
			</ul>
			<ul>
				<h2>购物指南</h2>
				<li><a href="oto-help.html#gwlc">购物流程</a></li>
				<li><a href="oto-help.html#hyjs">会员介绍</a></li>
				<li><a href="oto-help.html#cjwt">常见问题</a></li>
				<li><a href="oto-help.html#lxkf">联系客服</a></li>
			</ul>
			<ul>
				<h2>配送方式</h2>
				<li><a href="oto-help.html#smzt">上门自提</a></li>
				<li><a href="oto-help.html#xssd">限时送达</a></li>
				<li><a href="oto-help.html#psfwcx">配送服务查询</a></li>
			</ul>
			<ul>
				<h2>支付方式</h2>
				<li><a href="oto-help.html#hdfk">货到付款</a></li>
				<li><a href="oto-help.html#zxzf">在线支付</a></li>
				<li><a href="oto-help.html#xrfk">新人付款</a></li>
			</ul>
			<ul>
				<h2>新手上路</h2>
				<li><a href="oto-help.html#xszq">新手专区</a></li>
				<li><a href="oto-help.html#jyaq">交易安全</a></li>
				<li><a href="oto-help.html#xfjs">消费警示 </a></li>
				<li><a href="oto-help.html#xszc">新手注册</a></li>
				<li><a href="oto-help.html#xsxt">新手学堂</a></li>
				<li><a href="oto-help.html#ywbd">24小时有问必答</a></li>
			</ul>
			<ul>
				<h2>消费者保障</h2>
				<li><a href="oto-help.html#bzfw">保障范围</a></li>
				<li><a href="oto-help.html#thtklc">退货退款流程</a></li>
				<li><a href="oto-help.html#wyfqwq">我要发起维权</a></li>
				<li><a href="oto-help.html#gdtsfw">更多特色服务</a></li>
				<li><a href="oto-help.html#fwzx">服务中心</a></li>
			</ul>
		</div>
	</div>
	
	<div class="footer center">
		<p class="footer-nav">
		 <a href="oto-about.html">关于我们</a> | <a href="oto-mztk.html">免责条款</a> |
		 <a href="oto-yqlj.html">友情链接</a> | <a href="oto-lxwm.html">联系我们</a>
		</p>
		<p>
		 Copyright©2009-2014 中国美博城 All Rights Reserved<br />
		 中国美博城 安徽省合肥市居巢区 联系电话：（86）0551-123456789<br />
		 皖ICP备012344578号
		</p>
	</div>

</body>
</html>