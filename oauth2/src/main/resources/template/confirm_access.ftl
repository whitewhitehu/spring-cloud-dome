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
    <title>Oauth2授权界面</title>
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
                    <h2 style="font-size:22px">授权</h2>
                </div>
                <form id="login-form" action="/auth/oauth/authorize" onsubmit="return authorization()"
                      class="form-vertical"
                      method="post"
                      novalidate="novalidate"
                      data-widget-cid="widget-0" style="padding: 24px;">
                    <div class="alert alert-warning" role="alert">你是否允许${authorizationRequest.clientId}访问您的数据</div>
                    <div class="form-group">
                        <input name="user_oauth_approval" value="true" type="hidden">
                        <input name="authorize" value="Authorize" type="hidden">
                        <#list authorizationRequest.scope as scope>
                            <input value="true" type="hidden" name="scope.${scope}">
                        </#list>
                    </div>
                    <div class="form-group">
                        <div class="controls">
                            <button style="width:100%" id="authorization" class="btn btn-fat btn-primary btn-large"
                                    type="submit">确认授权
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--    javascript   -->
<script src="/auth/assets/javascripts/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    //回车登陆
    function keyLogin() {
        if (event.keyCode == 13)
            document.getElementById("authorization").click();
    }

    //登陆
    function authorization() {
        return true
    }
</script>
</body>
</html>
