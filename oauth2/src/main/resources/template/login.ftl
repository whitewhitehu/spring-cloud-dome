<!DOCTYPE html>
<!--[if IE 7]>
<html class="ie7 lte9 lte8 lte7" lang="zh-cn"><![endif]-->
<!--[if IE 8]>
<html class="ie8 lte9 lte8" lang="zh-cn"><![endif]-->
<!--[if IE 9]>
<html class="ie9 lte9" lang="zh-cn"><![endif]-->
<!--[if gt IE 9]><!-->
<html lang="zh-cn">
<!--<![endif]-->
<head>
    <title>Oauth2登陆界面</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="/auth/assets/stylesheets/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'microsoft yahei'
        }

        .bg-img {
            position: absolute;
            top: 49px;
            z-index: 0;
            left: 0;
            right: 0;
            bottom: 0;
            /*background-image: linear-gradient( 135deg, #ABDCFF 10%, #0396FF 100%);*/
            background: url(/auth/assets/images/7.jpg)
        }

        .head-top {
            height: 49px;
            background: #252525;
            border-bottom: 0;
            position: relative;
            padding: 0;
            box-shadow: 0 0 5px #333;
            color: #fff
        }

    </style>
</head>
<body class="course-dashboard-page" onkeydown="keyLogin();">
<div class="head-top"></div>
<div class="bg-img"></div>
<div id="content-container" class="container" style="margin-top: 100px;">
    <div class="row row-6">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default panel-page" style="background-color: rgba(255,255,255,0.9);">
                <div class="panel-heading">
                    <h2 style="font-size:22px">登录</h2>
                </div>
                <form id="login-form" action="/auth/oauth2/login" onsubmit="return login()" class="form-vertical"
                      method="POST"
                      novalidate="novalidate"
                      data-widget-cid="widget-0" style="padding: 24px;">
                    <div class="form-group">
                        <label class="control-label" for="username">帐号</label>
                        <div class="controls">
                            <input class="form-control" id="username" type="text" name="username" value="" required=""
                                   data-widget-cid="widget-1" data-explain="请输入用户昵称">
                            <div class="help-block">请输入用户昵称</div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="password">密码</label>
                        <div class="controls">
                            <input class="form-control" id="password" type="password" name="password" required=""
                                   data-widget-cid="widget-2" data-explain="">
                            <div class="help-block" style="display:none;"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <#if Session.SPRING_SECURITY_LAST_EXCEPTION??>
                            <div class="alert alert-warning alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                                            aria-hidden="true">&times;</span></button>
                                <strong>${Session.SPRING_SECURITY_LAST_EXCEPTION.message}</strong>
                            </div>
                        </#if>
                        <div class="controls">
                            <button style="width:100%" id="_login" class="btn btn-fat btn-primary btn-large"
                                    type="submit">登录
                            </button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="ptl">
                            <span class="text-muted">还没有注册帐号？</span>
                            <a href="">立即注册</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" id="modal-body">
                <h4>用户名密码不能为空</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!--    javascript   -->
<script src="/auth/assets/javascripts/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    //回车登陆
    function keyLogin() {
        if (event.keyCode == 13)
            document.getElementById("_login").click();
    }

    //登陆
    function login() {

        var username = document.getElementById('username').value
        var password = document.getElementById('password').value
        if (username == '') {
            $('#myModal').modal('show')
            return false
        }
        if (password == '') {
            $('#myModal').modal('show')
            return false
        }
        return true
    }
</script>
</body>
</html>
<#--http://localhost:8762/auth/oauth/authorize?response_type=code&client_id=spdata&redirect_uri=http://baidu.com-->