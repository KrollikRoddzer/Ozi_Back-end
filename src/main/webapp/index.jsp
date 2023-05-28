<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.05.2023
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Ozi!</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" type="image/svg+xml" href="${pageContext.request.contextPath}/img/svg/Ozi_icon.svg">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon/Ozi__iconPNG.png">
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Aleo:ital,wght@0,400;0,700;1,400&family=Inter&family=Lato:ital,wght@0,300;0,400;1,300&family=Red+Hat+Text:wght@500&display=swap" rel="stylesheet">

    <!-- подключение общего CSS-файла -->
    <link rel="stylesheet" href="./css/temp.css">
</head>
<body>
<!-- вставка общего хедера из header.jsp -->
<div>
    <!-- подключение файла header.jsp -->
    <jsp:include page="./components/header.jsp" />
</div>

<!-- основное содержимое страницы -->
<main class="main">
    <nav>
        <!-- подключение файла navbar.jsp -->
        <jsp:include page="./components/navbar.jsp" />
    </nav>

    <section class="intro">
        <!-- profile start -->
        <div class="profile__wrap">
            <div class="profile">
                <div class="profile__item">
                    <div class="profile__pic">
                        <img class="profile__photo" alt="profile picture" src="${pageContext.request.contextPath}/img/Dva.jpg" width="350" height="350">
                    </div>
                </div>
                <div class="profile__item">
                    <div class="panel__items">
                        <div class="panel__item">
                            <div class="panel">
                                <div class="user__panel">
                                    <p class="user__name">${name} ${surname}</p>
                                    <p class="user__status">I love Ozi</p>
                                </div>
                                <div class="settings">
                                    <div class="settings__pic">
                                        <a href="http://localhost:8080/ozi_war_exploded/editabout.jsp">
                                            <img src="${pageContext.request.contextPath}/img/svg/settings.svg">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel__item">
                            <div class="panel bottom">
                                <div class="user__atributies-row">
                                    <div class="user__atributies-row-container">
                                        <div class="user__atributies-row-lable">
                                            date of birth:
                                        </div>
                                        <div class="user__atributies-row-in">
                                            <div class="user__atributies-row-datebirth">
                                                    <span class="user__atributies-row-value">
                                                        <a href="#" class="user__link js-serch">${birthday}</a>
                                                    </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="user__atributies-row">
                                    <div class="user__atributies-row-container">
                                        <div class="user__atributies-row-lable">
                                            Languages:
                                        </div>
                                        <div class="user__atributies-row-in">
                                            <div class="user__atributies-row-lang">
                                                    <span class="user__atributies-row-value">
                                                        <a href="#" class="user__link js-serch">Russian, English</a>
                                                    </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="user__atributies-row">
                                    <div class="user__atributies-row-container">
                                        <div class="user__atributies-row-lable">
                                            city:
                                        </div>
                                        <div class="user__atributies-row-in">
                                            <div class="user__atributies-row-city">
                                                    <span class="user__atributies-row-value">
                                                        <a href="#" class="user__link js-serch">${city}</a>
                                                    </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="statistics">
                                    <div class="user__info-row">
                                        <div class="user__item">
                                            <div class="user__info-row-container">
                                                <div class="user__info-row-in">
                                                    <div class="user__info-row-friends">
                                                            <span class="user__info-row-value">
                                                                <a href="#" class="user__link-info js-search">${friends}</a>
                                                            </span>
                                                    </div>
                                                </div>
                                                <div class="user__info-row-lable">
                                                    Friends
                                                </div>
                                            </div>
                                        </div>
                                        <div class="user__item">
                                            <div class="user__info-row-container">
                                                <div class="user__info-row-in">
                                                    <div class="user__info-row-followers">
                                                            <span class="user__info-row-value">
                                                                <a href="#" class="user__link-info js-search">${followers}</a>
                                                            </span>
                                                    </div>
                                                </div>
                                                <div class="user__info-row-lable">
                                                    followers
                                                </div>
                                            </div>
                                        </div>
                                        <div class="user__item">
                                            <div class="user__info-row-container">
                                                <div class="user__info-row-in">
                                                    <div class="user__info-row-Communities">
                                                            <span class="user__info-row-value">
                                                                <a href="#" class="user__link-info js-search">30</a>
                                                            </span>
                                                    </div>
                                                </div>
                                                <div class="user__info-row-lable">
                                                    Communities
                                                </div>
                                            </div>
                                        </div>
                                        <div class="user__item">
                                            <div class="user__info-row-container">
                                                <div class="user__info-row-in">
                                                    <div class="user__info-row-photos">
                                                            <span class="user__info-row-value">
                                                                <a href="#" class="user__link-info js-search">3</a>
                                                            </span>
                                                    </div>
                                                </div>
                                                <div class="user__info-row-lable">
                                                    photos
                                                </div>
                                            </div>
                                        </div>
                                        <div class="user__item">
                                            <div class="user__info-row-container">
                                                <div class="user__info-row-in">
                                                    <div class="user__info-row-music">
                                                            <span class="user__info-row-value">
                                                                <a href="#" class="user__link-info js-search">98</a>
                                                            </span>
                                                    </div>
                                                </div>
                                                <div class="user__info-row-lable">
                                                    music
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- profile end -->


        <!-- posts start -->
        <!-- posts start -->
        <div class="profile__wrap">
            <div class="posts__place">
                <div class="posts__panel">
                    <div class="tools__panel">
                        <div class="lable__part">
                            <div class="post__lable">
                                <p>all notes:</p>
                            </div>
                        </div>
                        <div class="tools">
                            <div class="text-field">
                                <div class="text-field__icon">
                                    <input class="text-field__input" type="text" placeholder="Share the news">
                                    <div class="icons__place">
                                        <span class="text-field__aicon">
                                            <i class='bx bx-bookmark-plus'></i>
                                          </span>
                                        <span class="text-field__aicon-smile">
                                            <i class='bx bx-smile' ></i>
                                          </span>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="post__panel">
                        <div class="post__container">
                            <div class="post">
                                <div class="time__place">
                                    <div class="post__time date">Today</div>
                                </div>

                                <div class="post__card">
                                    <div class="post__info">
                                        <div class="post__pic">
                                            <img class="post__picture" src="img/Dva.jpg" width="65" height="65">
                                        </div>
                                        <div class="post__plot">
                                            <div class="name__time">
                                                <div class="post__name">Anastasia Krech</div>
                                                <div class="post__time">12:05</div>
                                            </div>
                                            <div class="post__text">
                                                Who hasn't had photos for a long time?
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="post">
                                <div class="time__place">
                                    <div class="post__time date">Monday, february 15nd</div>
                                </div>

                                <div class="post__card">
                                    <div class="post__info">
                                        <div class="post__pic">
                                            <img class="post__picture" src="img/Dva.jpg" width="65" height="65">
                                        </div>
                                        <div class="post__plot">
                                            <div class="name__time">
                                                <div class="post__name">Anastasia Krech</div>
                                                <div class="post__time">12:05</div>
                                            </div>
                                            <div class="post__text">
                                                Who hasn't had photos for a long time?
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- posts end -->
    </section>

</main>

    <footer class="footer">
        <!-- подключение файла footer.jsp -->
        <jsp:include page="./components/footer.jsp" />
    </footer>
</body>
</html>


