<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base id="base" href="${base}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商铺管理</title>
<link href="css/style.reset.css" rel="stylesheet" type="text/css" />
<link href="css/css3style.css" rel="stylesheet" type="text/css" />
<link href="css/font-color-size.css" rel="stylesheet" type="text/css" />
<link href="css/table.select.style.css" rel="stylesheet" type="text/css" />
<link href="css/top-style.css" rel="stylesheet" type="text/css" />
<link href="css/index-body-style.css" rel="stylesheet" type="text/css" />
<link href="css/user.css" rel="stylesheet" type="text/css" />
<link href="css/shanghu_zx.css" rel="stylesheet" type="text/css" />
<script src="js/top-city-check.js"></script>
</head>

<body>
	<!-- 顶部 -->
	<div class="index-top-box">
		<div class="index-top center">
    	<!--收藏夹-->
			<div class="checkCity favorit css3bg fr" onMouseover="jsoverD();" onMouseout="jsoutD();" >&nbsp;&nbsp;<a href="shoucang.ftl">收藏夹</a>
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
			<div class="fr noneAny">
			<#if user??>
                欢迎${user.username}来到美博城！
			<#else>
                亲，欢迎来美博城！
			</#if>
			</div>

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
				<!--热词-->
				<div class="hot-words">
					<a href="allsearch.html">潮流男装</a> <a href="allsearch.html">2013连衣裙</a> <a href="allsearch.html">七夕礼物</a> 
					<a href="allsearch.html">童装上新</a> <a href="allsearch.html">雪纺衫</a> 
					<a href="allsearch.html">T恤</a><a href="allsearch.html">防晒衫</a> <a href="allsearch.html">休闲热裤</a> 
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
	<div class="user_here center">所在的位置：中国美博城 > 我的店铺> 交易管理</div>
	<!--用户管理中心-->
	<div class="user_center center">
		<!--左侧-->
		<div class="shanghu_left fl">
			<div class="shanghu_head"><span>我的商铺</span></div>
            <div class="shangpu_head_user"><img src="img/user/shanghu_touxiang.png"  /><p><span>
			<#if user??>
					${user.username}
				<#else>
					未登录
				</#if>
			</span></p></div>
            
            <div class="shanghu_menu">
				<ul>
					<h2><span class="title"> <strong style="font-size:15px;">+</strong>&nbsp;店铺管理</span></h2>
					<li><a href="#" >&gt;&gt;&nbsp;查看店铺</a></li>
                    <li><a href="dianpushezhi.ftl"  id="current">&gt;&gt;&nbsp;店铺设置</a></li>
                    <li><a href="yuming.ftl" >&gt;&gt;&nbsp;域名设置</a></li>
                     <li><a href="order.ftl">&gt;&gt;&nbsp;产品分类</a></li>
					 
				</ul>
				<ul>
					<h2><span class="title"> <strong style="font-size:15px;">+</strong>&nbsp;交易管理</span></h2>
					<li><a href="order.ftl" >&gt;&gt;&nbsp;已卖出去的商品</a></li>
					<li><a href="tuihuan.html">&gt;&gt;&nbsp;评价管理</a></li>
			 
				</ul>
				<ul>
					<h2><span class="title"> <strong style="font-size:15px;">+</strong>&nbsp;物流管理</span></h2>
					<li><a href="order.ftl">&gt;&gt;&nbsp;发货</a></li>
                   
                    
                    <li><a href="order.ftl">&gt;&gt;&nbsp;我要寄快递</a></li>
                      
				</ul>
				<ul>
					<h2><span class="title"> <strong style="font-size:15px;">+</strong>&nbsp;商品管理</span></h2>
					<li><a href="order.ftl">&gt;&gt;&nbsp;发布商品</a></li>
                    <li><a href="order.ftl">&gt;&gt;&nbsp;出售中的商品</a></li>
                    <li><a href="order.ftl">&gt;&gt;&nbsp;仓库中的商品</a></li>
                    <li><a href="order.ftl">&gt;&gt;&nbsp;体验中心</a></li>
				</ul>
                
                <ul>
					<h2><span class="title"> <strong style="font-size:15px;">+</strong>&nbsp;客户服务</span></h2>
					<li><a href="order.ftl">&gt;&gt;&nbsp;退款管理</a></li>
                    <li><a href="order.ftl">&gt;&gt;&nbsp;售后管理</a></li>
                    <li><a href="order.ftl">&gt;&gt;&nbsp;仓库中的商品</a></li>
                    <li><a href="order.ftl">&gt;&gt;&nbsp;体验中心</a></li>
				</ul>
                
			</div>
			 
		</div>
		<!--右侧-->
        
  <div class="shanghu_right fr">
			<div class="shanghu_dingdan">
				<span class="fr"><a href="#">查看帮助</a></span><p>店铺设置</p>
			</div>

		<form action="" method="post" id="form1" enctype="multipart/form-data">

            <div class="shanghu_list">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="10%" align="right"><span>*</span>店铺名称：</td>
    <td width="90%"><input type="text" class="oto_text_one fl" name="textfield" /></td>
  </tr>
  <tr>
    <td align="right">店铺标志：</td>
    <#--<td class="shangpu_logo"><img src="img/other/shangpu_logo.png" alt="店铺标志"/>-->
    <#--<div class="jiesuan">-->
        <#--<input type="file" id="file0" name="picPath" >-->
							<#--&lt;#&ndash;<button class="btn fl">上传标志</button>&ndash;&gt;-->
		<#--<p style="margin-left:10px;  "><img src="img/user/zhuyi.png" />&nbsp;文件格式GIF、JPG、JPEG、PNG文件大小80K以内，建议尺寸80PX*80PX</p>-->
						<#--</div>-->
    <#--</td>-->
      <div class="formRow">
          <div class="control-group formSep">
              <div class="alert alert-info">
                  <div class="controls">
                      <div data-fileupload="image" class="fileupload fileupload-new">
                          <div style="width: 60px; height: 60px;" class="fileupload-new thumbnail">
                              <img src="upload/cuy.jpg" name="portrait" id="portrait" alt="请选择自己的头像" />
                          </div>
                          <div style="width: 80px; height: 80px; line-height: 80px;" class="fileupload-preview fileupload-exists thumbnail">
                          </div>
                          <span class="btn btn-file"> <span
                                  class="fileupload-new">*选择头像</span> <span
                                  class="fileupload-exists">更换</span> <input type="file" id="file0" name="file0" class="uni_style" />
															<strong>仅支持JPG、PNG、GIF、BMP格式.</strong>
						  </span>
                      </div>
                  </div>
              </div>

          </div>

      </div>
  </tr>
  <tr>
    <td align="right"><span>*</span>店铺类目：</td>
    <td><select class="oto_select fl">
						  <option value="食品">食品</option>
						  <option value="家电">家电</option>
						  <option value="服饰">服饰</option>
                          <option value="美妆">美妆</option>
						</select></td>
  </tr>
  <tr>
    <td align="right">店铺简介：</td>
    <td><textarea name="" cols="" rows="" class="oto_textrea fl" ></textarea></td>
  </tr>
  <tr>
    <td align="right">经营类型：</td>
    <td><label><input name="" type="radio" value="个人全职" class="fl" style=" margin:4px" /> <span class="fl" style="color:#898989;">个人全职</span></label>
		<label><input name="" type="radio" value="个人兼职" class="fl" style=" margin:4px ; margin-left:15px;" /><span class="fl" style="color:#898989;" >个人兼职</span></label>
		<label><input name="" type="radio" value="公司开店" class="fl" style=" margin:4px ; margin-left:15px;" /><span class="fl" style="color:#898989;">公司开店</span></label>	</td>
  </tr>
  <tr>
    <td width="10%" align="right"><span>*</span>联系地址：</td>
    <td width="90%"><input type="text" class="oto_text_one fl" name="textfield" /></td>
  </tr>
  <tr>
    <td width="10%" align="right"><span>*</span>邮政编码：</td>
    <td width="90%"><input type="text" class="oto_text_one fl" name="textfield" /></td>
  </tr>
  <tr>
    <td align="right">是否有实体店：</td>
    <td><label><input name="" type="radio" value="是" class="fl" style=" margin:4px" /> <span class="fl" style="color:#898989;">是</span></label>
							<label><input name="" type="radio" value="否" class="fl" style=" margin:4px ; margin-left:15px;" />
							<span class="fl" style="color:#898989;" >否</span></label>
							 	</td>
  </tr>
  <tr>
    <td width="10%" align="right"><span>*</span>实体店地址：</td>
    <td width="90%"><input type="text" class="oto_text_one fl" name="textfield" /></td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td><button class="btn fl">保存</button></td>
  </tr>
			</table>
            </div>
        </form>
			 
			 
	  </div>
		 
	</div>



	<div class="clear" style="height:30px"></div>

		<div class="footerLink">
		<div class="footerLink_ul center">
			<ul>
				<h2>关于美博</h2>
				<li><a href="oto-about.ftl">关于我们</a></li>
				<li><a href="oto-zxns.html">招贤纳士</a></li>
			</ul>
			<ul>
				<h2>购物指南</h2>
				<li><a href="oto-help.ftl#gwlc">购物流程</a></li>
				<li><a href="oto-help.ftl#hyjs">会员介绍</a></li>
				<li><a href="oto-help.ftl#cjwt">常见问题</a></li>
				<li><a href="oto-help.ftl#lxkf">联系客服</a></li>
			</ul>
			<ul>
				<h2>配送方式</h2>
				<li><a href="oto-help.ftl#smzt">上门自提</a></li>
				<li><a href="oto-help.ftl#xssd">限时送达</a></li>
				<li><a href="oto-help.ftl#psfwcx">配送服务查询</a></li>
			</ul>
			<ul>
				<h2>支付方式</h2>
				<li><a href="oto-help.ftl#hdfk">货到付款</a></li>
				<li><a href="oto-help.ftl#zxzf">在线支付</a></li>
				<li><a href="oto-help.ftl#xrfk">新人付款</a></li>
			</ul>
			<ul>
				<h2>新手上路</h2>
				<li><a href="oto-help.ftl#xszq">新手专区</a></li>
				<li><a href="oto-help.ftl#jyaq">交易安全</a></li>
				<li><a href="oto-help.ftl#xfjs">消费警示 </a></li>
				<li><a href="oto-help.ftl#xszc">新手注册</a></li>
				<li><a href="oto-help.ftl#xsxt">新手学堂</a></li>
				<li><a href="oto-help.ftl#ywbd">24小时有问必答</a></li>
			</ul>
			<ul>
				<h2>消费者保障</h2>
				<li><a href="oto-help.ftl#bzfw">保障范围</a></li>
				<li><a href="oto-help.ftl#thtklc">退货退款流程</a></li>
				<li><a href="oto-help.ftl#wyfqwq">我要发起维权</a></li>
				<li><a href="oto-help.ftl#gdtsfw">更多特色服务</a></li>
				<li><a href="oto-help.ftl#fwzx">服务中心</a></li>
			</ul>
		</div>
	</div>
	
	<div class="footer center">
		<p class="footer-nav">
		 <a href="oto-about.ftl">关于我们</a> | <a href="oto-mztk.html">免责条款</a> |
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