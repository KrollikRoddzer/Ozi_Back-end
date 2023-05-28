<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.05.2023
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header class="header__home">
    <div class="wrapper">

        <div class="header__wrapper">

            <div class="header__item">
                <div class="header__logo">
                    <a href="http://localhost:8080/ozi_war_exploded/ozi" class="headre__logo-link">
                        <img src="${pageContext.request.contextPath}/img/Ozi_logo.png" width="80" height="80" alt="Welcome to Ozi!">
                    </a>
                </div>
            </div>
            <div class="header__item">
                <div class="search-box">
                    <input type="text" name="" class="search-txt" placeholder="Type to search"/>
                    <a class="search-btn" href="#">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
            <div class="header__item">
                <form method="post">
                    <button class="exit__button" name="exit" id="exit" value="1" >Exit</button>
                </form>
            </div>

        </div>

    </div>
</header>
</html>