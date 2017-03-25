<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base id="base" href="${base}">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>已发布的信息</title>
    <link href="css/style.reset.css" rel="stylesheet" type="text/css" />
    <link href="css/css3style.css" rel="stylesheet" type="text/css" />
    <link href="css/font-color-size.css" rel="stylesheet" type="text/css" />
    <link href="css/table.select.style.css" rel="stylesheet" type="text/css" />
    <link href="css/top-style.css" rel="stylesheet" type="text/css" />
    <link href="css/index-body-style.css" rel="stylesheet" type="text/css" />
    <link href="css/user.css" rel="stylesheet" type="text/css" />
    <link href="css/shanghu_zx.css" rel="stylesheet" type="text/css" />
    <link href="css/member_store.css" rel="stylesheet" type="text/css" />
    <script src="js/top-city-check.js"></script>
    <script type="text/javascript" src="static/js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        function n_show() {
            $("#empl").hide();
            $("#notice").show();
            $("#n_btn").css("background-color","#E34B64");
            $("#e_btn").css("background-color","white");

        }
        function e_show() {
            $("#notice").hide();
            $("#empl").show();
            $("#e_btn").css("background-color","#E34B64");
            $("#n_btn").css("background-color","white");
        }
        function check(flag,id){
            alert(flag);
            alert(id);
            if(flag==1){
                document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';
            }else{
                window.location.href="info/stick/"+id;
            }
        }
        function closediv(){
            document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';
        }
    </script>
</head>

<body >
<div id="light" class="white_content" style="display: none;
               position: absolute;
               top: 25%;
               left: 25%;
               width: 50%;
               height: 50%;
               padding: 16px;
               border: 3px solid #E34B64;
               background-color: white;
               z-index:1002;
               overflow: auto;">
    <span>
        <h3>您好，您现在是普通会员，不能享受置顶功能</h3><br>
        <h3>您可以选择<a href="">付费置顶</a>或<a href="">开通高级会员</a>(高级会员可免费享受置顶功能)</h3>
    </span>
    <br><br><br><br><br><br><br><br><br>
    <button onclick="closediv()" style="margin-left: 300px;font-size: larger">&nbsp;关 闭&nbsp; </button>
</div>
<div id="fade" class="black_overlay" style="display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index:1001;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=80);"></div>
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
<div class="nav center">
    <div class="bigNav fl">
        <ul>
            <li><a href="#">卖家中心</a></li>
            <li><a href="#">买家中心</a></li>
            <li><a href="#">账户设置</a></li>
        </ul>
    </div>
</div>

<!--导航结束-->
<div class="clear"></div>

<!--位置-->
<div class="user_here center">所在的位置：中国美博城 > 我的店铺> 已发布的信息</div>
<!--用户管理中心-->
<div class="user_center center">
    <!--左侧-->
    <div class="shanghu_left fl" >
        <div class="shanghu_head"><span>我的商铺</span></div>
        <div class="shangpu_head_user"><img src="img/user/shanghu_touxiang.png"  /><p><span> 巢湖三心网络</span></p></div>

        <div class="shanghu_menu">
            <ul>
                <h2><span class="title"> <strong style="font-size:15px;">+</strong>&nbsp;店铺管理</span></h2>
                <li><a href="#" >&gt;&gt;&nbsp;查看店铺</a></li>
                <li><a href="shanghu_goumai.html"  id="current">&gt;&gt;&nbsp;店铺设置</a></li>
                <li><a href="shanghu_yuming.html" >&gt;&gt;&nbsp;域名设置</a></li>
                <li><a href="order.ftl">&gt;&gt;&nbsp;产品分类</a></li>

            </ul>
            <ul>
                <h2><span class="title"> <strong style="font-size:15px;">+</strong>&nbsp;信息管理</span></h2>
                <li><a href="info/post" >&gt;&gt;&nbsp;发布信息</a></li>
                <li><a href="info/manage">&gt;&gt;&nbsp;已发布的信息</a></li>
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
            <span class="fr"><a href="#"></a></span><p>卖家中心</p>
        </div>
        <div id="home">
            <div class="seller-cont">
                <div class="l">
                <div class="stroe-info container" style="width: 700px;height: 900px" >
                    <div style="height: 20px;width: 185px;" class="hd" >
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button id="n_btn" onclick="n_show()" style="background-color: #E34B64;color: #D5D5D5;">&nbsp;公告&nbsp;</button>
                        <button id="e_btn" onclick="e_show()" style="background-color: white;color: #D5D5D5;">&nbsp;招聘信息&nbsp;</button>
                    </div>
                    <div class="content" id="notice" style="width: 620px;margin-left: 12px">
                    <#list n_infos as n_info>
                        <div class="gwlcBox">
                            <span id="#gwlc" name="#gwlc"></span>
                            <p class="color3 size14-b help_r_title">
                                <a href="">${n_info.title}</a>

                                <span style="float: right">

							&nbsp;${n_info.infoDate?date}
						</span>
                            </p>

                        </div>

                        <div>
                            <button style="float: right"><h3><a href="info/del/${n_info.id}">删除</a></h3></button>
                            <button style="float: right" onclick="check(${user.flag},${n_info.id})">
                                <#if n_info.stick=1>已置顶
                                <#else>置顶</#if>
                                </h3></button>
                        </div>
                        <br><br>
                        <hr>
                    </#list>
                        <br>
                        <center>
                            <button><a href="info/manage/1/0">首页</a></button>
                        <#list 1..pagen?number as i>
                            <button ><a href="info/manage/${i}/0">${i}</a></button>
                        </#list>
                            <button><a href="info/manage/${pagen}/0">尾页</a></button>
                        </center>

                    </div>


                    <#assign x=0/>
                    <div class="content" id="empl" style="display: none">
                    <#list e_infos as e_info>
                        <#assign x=x+1>
                        <div class="gwlcBox">
                            <span id="#gwlc" name="#gwlc"></span>
                            <p class="color3 size14-b help_r_title" >
                                <a href="">${e_info.title}</a>

                                <span style="float: right">

							&nbsp;${e_info.infoDate?date}
						</span>
                            </p>
                            <p>
                                ${e_info.content}
                            </p>
                        </div>

                        <div>
                            <button style="float: right"><h3><a href="info/del/${e_info.id}">删除</a></h3></button>
                            <button style="float: right"><h3><a href="info/stick/${e_info.id}"><#if e_info.stick=1>已置顶
                            <#else>置顶</#if></a></h3></button>
                        </div>
                        <br><br>
                        <#if x<5>
                            <hr>
                            <br>
                        </#if>


                    </#list>
                        <center>
                            <button><a href="info/manage/1/1">首页</a></button>
                            <#list 1..pagee?number as i>
                                <button ><a href="info/manage/${i}/1">${i}</a></button>
                            </#list>
                            <button><a href="info/manage/${pagee}/1">尾页</a></button>
                        </center>

                    </div>
                </div>
                </div>
                <div class="r">
                    <div class="news container">
                        <div class="hd">
                            <h2>商城公告</h2>
                        </div>
                        <div class="content">
                            <ul>
                                <li><a target="_blank" href="#" title="2.4??????">三心网络科技</a></li>
                                <li><a target="_blank" href="#" title="三心网络科技">三心网络科技</a></li>
                                <li><a target="_blank" href="#" title="三心网络科技">三心网络科技</a></li>
                                <li><a target="_blank" href="#" title="三心网络科技">三心网络科技</a></li>
                                <li><a target="_blank" href="#" title="三心网络科技">三心网络科技</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="contact container">
                        <div class="hd">
                            <h2>平台联系方式</h2>
                        </div>
                        <div class="content">
                            <ul>
                                <li style="width:100%;">电话1：23456789</li>
                                <li style="width:100%;">电话2：88997788</li>
                                <li style="width:100%;">邮箱：abc@shopnc.net</li>
                            </ul>
                        </div>
                    </div>
                    <a href="#"><img src="img/user/adv200-300.gif" /></a>
                </div>
            </div>
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
