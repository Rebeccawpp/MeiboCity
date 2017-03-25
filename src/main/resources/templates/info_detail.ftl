<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base id="base" href="${base}">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>招聘详情</title>
    <link href="css/style.reset.css" rel="stylesheet" type="text/css" />
    <link href="css/css3style.css" rel="stylesheet" type="text/css" />
    <link href="css/font-color-size.css" rel="stylesheet" type="text/css" />
    <link href="css/table.select.style.css" rel="stylesheet" type="text/css" />
    <link href="css/top-style.css" rel="stylesheet" type="text/css" />
    <script src="js/top-city-check.js"></script>
    <script src="js/miaov.js" type="text/javascript"></script>
    <script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var loaded = true;
            var top = $("#demo").offset().top;
            function Add_Data()
            {
                var scrolla=$(window).scrollTop();
                var cha=parseInt(top)-parseInt( scrolla);
                if(loaded && cha<=0)
                {
                    $("#demo").removeClass("demo2").addClass("demo1");
                    loaded=false;
                }
                if(!loaded && cha>0)
                {
                    $("#demo").removeClass("demo1").addClass("demo2");
                    loaded=true;
                }
            }
            $(window).scroll(Add_Data);
        });
    </script>
    <style>
        .helpBox{ width:1200px; overflow:auto ;  margin-top:10px ;  }
        /* 左侧 */
        .help_left{ width:218px ; height:auto ; border:1px solid #dedede ; border-bottom:none }
        .help_left:hover{ border:1px solid #38a149 ; }

        .tc_nav { overflow: hidden ;  }
        .tc_nav li { width: 100%; line-height:35px; }

        .tc_nav h2 { width:100%; cursor: pointer ; background:#f8f8f8 ; color:#999 ; border-bottom:1px solid #dedede}
        .tc_nav h2 span { font-size:12px ; font-weight:bold ; padding-left:20px  }
        .tc_nav h2:hover { background:#ebeaea  }
        .tc_nav h2.active { background:#38a149 ; color:#fff  }

        .tc_nav ul { width: 100% ; height:auto ; display: none ; overflow:hidden ; }
        .tc_nav ul li { width:100% ; border-bottom:1px solid #dedede; font-family:"宋体" ; }
        .tc_nav ul li a { display:block; width:100% ; color:#999 ; text-indent:20px;}
        .tc_nav ul li a:hover { color:#38a149 ; background:#f8f8f8 }
        .tc_nav ul li:hover { }

        /* 右侧 */
        .help_right{ width:968px ; background:#fff ; min-height:496px; border:1px solid #dedede ; }
        .help_right .padding20{ padding:0 20px 10px 20px}
        .help_right .gwlcBox{ margin-top:10px ; margin-bottom:10px}
        .help_right .gwlcBox .help_r_title{ border-bottom:1px dotted #dedede ; line-height:35px ; margin-bottom:5px}

        .demo{}
        .demo1{	position: fixed;	_position: absolute;	top: 0px; border:1px solid #38a149  }
        .demo2{}

    </style>
</head>

<body>
<!-- 顶部 -->
<div class="index-top-box">
    <div class="index-top center">
        <!--收藏夹-->
        <div class="checkCity favorit css3bg fr" onMouseover="overD();" onMouseout="outD();" >&nbsp;&nbsp;<a href="shoucang.html">收藏夹</a>
            <!--收藏夹/显示的内容-->
            <div class="Collection-of-goods none-r" id="d1" onMouseover="overD();" onMouseout="outD();" >
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
<div class="user_here center">所在的位置：首页 > 招聘中心>招聘详情</div>

<br>
<div class="help_right " style="margin-left: 200px">
    <div class="padding20">

        <div class="gwlcBox">
            <span id="#gwlc" name="#gwlc"></span>
            <p class="color3 size14-b help_r_title">
                ${info.title}

                <span style="float: right">
							<a href="shoping/store/shopid/${info.shop.id}">${info.shop.name}</a>
							&nbsp;${info.infoDate?date}
						</span>
            </p>
            <p>
                ${info.content}
            </p>
        </div>

    </div>
</div>
</div>


<div class="clear" style="height:30px"></div>


<!--底部导航-->

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
