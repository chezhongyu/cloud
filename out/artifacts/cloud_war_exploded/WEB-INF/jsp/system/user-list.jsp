<%--
  Created by IntelliJ IDEA.
  User: 95174
  Date: 2021/2/4
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html lang="en">

<head>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>ERES - Bootstrap Admin Dashboard </title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${basePath}/images/favicon.png">
    <link href="${basePath}/vendor/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="${basePath}/vendor/datatables/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="${basePath}/vendor/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="${basePath}/css/style.css" rel="stylesheet">
    <link href="https://cdn.lineicons.com/2.0/LineIcons.css" rel="stylesheet">
    <script language="javascript">

        function sel(){

            document.mainForm.submit();

        }

    </script>

</head>
<body>

<!--*******************
    Preloader start
********************-->
<div id="preloader">
    <div class="sk-three-bounce">
        <div class="sk-child sk-bounce1"></div>
        <div class="sk-child sk-bounce2"></div>
        <div class="sk-child sk-bounce3"></div>
    </div>
</div>
<!--*******************
    Preloader end
********************-->

<!--**********************************
    Main wrapper start
***********************************-->
<div id="main-wrapper">

    <!--**********************************
        Nav header start
    ***********************************-->
    <div class="nav-header">
        <a href="javascript:void(0);" onclick="location.href = '${basePath}/his/search'" class="brand-logo">
            <img class="logo-abbr" src="${basePath}/images/logo.png" alt="">
            <img class="logo-compact" src="${basePath}/images/logo-text.png" alt="">
            <img class="brand-title" src="${basePath}/images/logo-text.png" alt="">
        </a>

        <div class="nav-control">
            <div class="hamburger">
                <span class="line"></span><span class="line"></span><span class="line"></span>
            </div>
        </div>
    </div>
    <div class="header">
        <div class="header-content">
            <nav class="navbar navbar-expand">
                <div class="collapse navbar-collapse justify-content-between">
                    <div class="header-left">
                        <div class="dashboard_bar">
                            用户管理
                        </div>
                    </div>

                    <ul class="navbar-nav header-right">
                        <li class="nav-item dropdown header-profile">
                            <a class="nav-link" href="javascript:;" role="button" data-toggle="dropdown">
                                <img src="${basePath}/images/profile/12.png" width="20" alt=""/>
                                <div class="header-info">
                                    <span>Hello,<strong> Roberto</strong></span>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <!--**********************************
        Header end ti-comment-alt
    ***********************************-->

    <!--**********************************
        Sidebar start
    ***********************************-->
    <div class="deznav">
        <div class="deznav-scroll">
            <ul class="metismenu mm-show" id="menu">
                <li><a class="has-arrow ai-icon" href="javascript:void()" aria-expanded="false">
                      <i class="flaticon-381-networking"></i>
                      <span class="nav-text">用户管理</span>
                    </a>
                <ul aria-expanded="false">
                    <li><a href="javascript:void(0);" onclick="location.href = '${basePath}/his/search'">用户管理</a></li>
<%--                    <li><a href="">增加</a></li>--%>
<%--                    <li><a href="">Patient Details</a></li>--%>
                </ul>
                <li>

            </ul>
            <div class="plus-box">
                <p class="fs-16 font-w500 mb-1">Check your job schedule</p>
                <a class="text-white fs-26" href="javascript:;"><i class="las la-long-arrow-alt-right"></i></a>
            </div>
            <div class="copyright">
                <p class="fs-14 font-w200"><strong class="font-w400">用户管理</strong> © 2021 All Rights Reserved</p>
                <p>Made with <i class="fa fa-heart"></i> by DexignZone</p>
            </div>
        </div>
    </div>
    <!--**********************************
        Sidebar end
    ***********************************-->

    <!--**********************************
        Content body start
    ***********************************-->
    <form  action="${basePath}/his/search" id="mainForm" name="mainForm" method="post">
        <div class="content-body">
            <!-- row -->
            <div class="container-fluid">
                <div class="form-head d-flex mb-3 mb-md-4 align-items-start">
                    <div class="mr-auto d-none d-lg-block">
                        <a href="javascript:void(0);" onclick="location.href = '${basePath}/his/startinsert'" class="btn btn-primary btn-rounded">+ Add New</a>
                    </div>

                    <div class="input-group search-area ml-auto d-inline-flex mr-3">
                        <input type="text" class="form-control" name="userName" id="userName"  placeholder="查找">
                        <div class="input-group-append">
                            <button type="button" onclick="sel()" class="input-group-text"><i class="flaticon-381-search-2"></i></button>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-12">
                        <div class="table-responsive">

                            <table id="example5"  class="table table-striped patient-list mb-4 dataTablesCard fs-14">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>登录名</th>
                                    <th>密码</th>
                                    <th>真实姓名</th>
                                    <th>用户类别</th>
                                    <th>医生职称</th>
                                    <th>是否参与排班</th>
                                    <th>删除标记</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="list" varStatus="s">
                                <tr>
                                    <td>${list.ID}</td>
                                    <td>${list.userName}</td>
                                    <td>${list.password}</td>
                                    <td>${list.realName}</td>
                                    <td><c:if test="${list.useType == 1}">
                                        甲类
                                       </c:if>
                                        <c:if test="${list.useType != 1}">
                                            乙类
                                        </c:if>
                                    </td>
                                    <td><c:if test="${list.docTitleID == 1}">
                                            李医生
                                        </c:if>
                                        <c:if test="${list.docTitleID != 1}">
                                            王医生
                                        </c:if>
                                    </td>
                                    <td>${list.isScheduling}</td>
                                    <td><c:if test="${list.delMark == 0}">
                                        已删除
                                        </c:if>
                                        <c:if test="${list.delMark != 0}">
                                            未删除
                                        </c:if>
                                    </td>
                                    <td>
                                        <a href="javascript:void(0);" onclick="location.href = '${basePath}/his/startupdate/${list.ID};'">
                                            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                <path d="M17 3C17.2626 2.73735 17.5744 2.52901 17.9176 2.38687C18.2608 2.24473 18.6286 2.17157 19 2.17157C19.3714 2.17157 19.7392 2.24473 20.0824 2.38687C20.4256 2.52901 20.7374 2.73735 21 3C21.2626 3.26264 21.471 3.57444 21.6131 3.9176C21.7553 4.26077 21.8284 4.62856 21.8284 5C21.8284 5.37143 21.7553 5.73923 21.6131 6.08239C21.471 6.42555 21.2626 6.73735 21 7L7.5 20.5L2 22L3.5 16.5L17 3Z" stroke="#3E4954" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                            </svg>
                                        </a>
                                        <a href="javascript:void(0);" onclick="location.href = '${basePath}/his/delete/${list.ID};'">
                                            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                <path d="M3 6H5H21" stroke="#F46B68" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                                <path d="M8 6V4C8 3.46957 8.21071 2.96086 8.58579 2.58579C8.96086 2.21071 9.46957 2 10 2H14C14.5304 2 15.0391 2.21071 15.4142 2.58579C15.7893 2.96086 16 3.46957 16 4V6M19 6V20C19 20.5304 18.7893 21.0391 18.4142 21.4142C18.0391 21.7893 17.5304 22 17 22H7C6.46957 22 5.96086 21.7893 5.58579 21.4142C5.21071 21.0391 5 20.5304 5 20V6H19Z" stroke="#F46B68" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                            </svg>
                                        </a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </table>
                            <t:page page="${searchParam.page}" jsMethodName="search"></t:page>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <!--**********************************
        Content body end
    ***********************************-->

    <!--**********************************
        Footer start
    ***********************************-->
    <div class="footer">
        <div class="copyright">
            <p>Copyright © Designed &amp; Developed by  2021</p>
        </div>
    </div>
</div>
<!--**********************************
    Main wrapper end
***********************************-->

<!--**********************************
    Scripts
***********************************-->
<!-- Required vendors -->
<script src="${basePath}/vendor/global/global.min.js"></script>
<script src="${basePath}/vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
<script src="${basePath}/vendor/chart.js/Chart.bundle.min.js"></script>
<script src="${basePath}/js/custom.min.js"></script>
<script src="${basePath}/js/deznav-init.js"></script>
<script src="${basePath}/vendor/owl-carousel/owl.carousel.js"></script>

<!-- Datatable -->
<script src="${basePath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script>
    (function($) {

        var table = $('#example5').DataTable({
            searching: false,
            paging:true,
            select: false,
            //info: false,
            lengthChange:false

        });
        $('#example tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();

        });

    })(jQuery);
</script>
</body>
</html>
