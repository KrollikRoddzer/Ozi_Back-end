<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>edit your about!</title>
  
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="icon" type="image/svg+xml" href="${pageContext.request.contextPath}/img/svg/Ozi_icon.svg">
  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon/Ozi__iconPNG.png">
  <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/temp.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Aleo:ital,wght@0,400;0,700;1,400&family=Inter&family=Lato:ital,wght@0,300;0,400;1,300&family=Red+Hat+Text:wght@500&display=swap" rel="stylesheet">
    
    </head>
    <body>
        <!-- header start -->
        <div>
            <jsp:include page="components/header.jsp"/>
        </div>
        <!-- header end -->
        <main class="main__body">
            <section class="intro">
                <!-- info start -->
                <nav>
                    <!-- подключение файла navbar.jsp -->
                    <jsp:include page="./components/navbar.jsp" />
                </nav>
                <!-- info end -->

                <!-- profile start -->
                <div class="profile-about__wrap">
                    <div class="profile__about">
                        
                            <div class="panel__items">
                               
                                <div class="panel__item">
                                    
                                    <div class="panel__about">
                                        <div class="edit__info">
                                            <h1 class="edit__title">Edit your status!</h1>
                                            <p class="edit__p">
                                                You can change information about your feelings
                                            </p>
                                           </div>
                                        <div class="edit">
                                            <textarea class="about_in" id="element" placeholder="*Your former about*"></textarea>
                                            <div class="buttoms">
                                                <button class="edit__but save">Save</button>
                                                <button class="edit__but">Cancel</button>
                                            </div>
                                        </div>
                                        <div class="statistics__about">
                                            <div class="user__info-row">
                                                <div class="user__item">
                                                    <div class="user__info-row-container">
                                                        <div class="user__info-row-in">
                                                            <div class="user__info-row-friends">
                                                                <span class="user__info-row-value">
                                                                    <a href="#" class="user__link-info js-search">110</a>  
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
                                                                    <a href="#" class="user__link-info js-search">89</a>  
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
                <!-- profile end -->

            </section>
            
        </main>
        <footer class="footer">
            <jsp:include page="components/footer.jsp"/>
        </footer>
        
    </body>
</html>
