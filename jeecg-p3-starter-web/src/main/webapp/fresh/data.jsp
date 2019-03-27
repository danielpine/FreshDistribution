<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>生鲜配送决策平台</title>
    <meta name="keywords" content="JEECG-P3 微服务，插件开发框架">
    <meta name="description" content="JEECG-P3 微服务，插件开发框架">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/jeecg-p3-starter-web/plug-in-ui/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/jeecg-p3-starter-web/plug-in-ui/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/jeecg-p3-starter-web/plug-in-ui/hplus/css/animate.css" rel="stylesheet">
    <link href="/jeecg-p3-starter-web/plug-in-ui/hplus/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="wrapper wrapper-content animated fadeInUp">
        <div class="row">
            <div class="col-sm-12">

                <div class="ibox">
                    <div class="ibox-content">

                        <div class="project-list">

                            <table class="table table-hover">
                                <tbody>
                                
                                    <tr>
                                        <td class="project-actions">
                                            <a href="/jeecg-p3-starter-web/fresh/fDGoods.do?toAdd" class="btn btn-white btn-sm"><i class="fa fa-cloud"></i> 新增商品</a>
                                        </td>
                                        <td class="project-actions">
                                            <a href="/jeecg-p3-starter-web/fresh/fDStore.do?toAdd" class="btn btn-white btn-sm"><i class="fa fa-cloud"></i> 新增仓库</a>
                                        </td>
                                        <td class="project-actions">
                                            <a href="/jeecg-p3-starter-web/fresh/fDStoreitems.do?toAdd" class="btn btn-white btn-sm"><i class="fa fa-cloud"></i> 商品存库</a>
                                        </td>
                                        <td class="project-actions">
                                            <a href="/jeecg-p3-starter-web/fresh/fDStore.do?toAdd" class="btn btn-white btn-sm"><i class="fa fa-cloud"></i> 新增仓库</a>
                                        </td>
                                        <td class="project-actions">
                                            <a href="/jeecg-p3-starter-web/fresh/fDStore.do?toAdd" class="btn btn-white btn-sm"><i class="fa fa-cloud"></i> 新增仓库</a>
                                        </td>
                                    </tr>
                                    
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <!-- 全局js -->
    <script src="/jeecg-p3-starter-web/plug-in-ui/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="/jeecg-p3-starter-web/plug-in-ui/hplus/js/bootstrap.min.js?v=3.3.6"></script>

    <script>
        $(document).ready(function(){

            $('#loading-example-btn').click(function () {
                btn = $(this);
                simpleLoad(btn, true)
                simpleLoad(btn, false)
            });
        });

        function simpleLoad(btn, state) {
            if (state) {
                btn.children().addClass('fa-spin');
                btn.contents().last().replaceWith(" Loading");
            } else {
                setTimeout(function () {
                    btn.children().removeClass('fa-spin');
                    btn.contents().last().replaceWith(" Refresh");
                }, 2000);
            }
        }
    </script>

    </body>
</html>
