<%--
  Created by IntelliJ IDEA.
  User: KrollikRoddzer
  Date: 10.05.2023
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="true"%>--%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome to Ozi!</title>
  <link rel="icon" type="image/svg+xml" href="./img/svg/Ozi_icon.svg">
  <link rel="icon" type="image/png" href="./img/favicon/Ozi__iconPNG.png">
  <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="css/style-1.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Aleo:ital,wght@0,400;0,700;1,400&family=Inter&family=Lato:ital,wght@0,300;0,400;1,300&family=Red+Hat+Text:wght@500&display=swap" rel="stylesheet">

</head>
<body>
<!-- header start -->
<header class="header">
  <div class="wrapper">

    <div class="header__wrapper">
      <div class="header__logo">
        <a href="#" class="headre__logo-link">
          <img src="./img/Ozi_logo.png" width="80" height="80" alt="Welcome to Ozi!">
        </a>
      </div>
    </div>

  </div>
</header>
<!-- header end -->
<main class="main">
  <section class="intro">
    <!-- info start -->
    <div class="wrapper__info">

      <div class="info__items">

        <div class="info__item">
          <div class="info">
            <h2 class="info__title-top">Amazing features</h2>
            <h1 class="info__title section__title">What You Get</h1>

            <div class="top__cards">

              <div class="top__card">
                <div class="top__card-pic">
                  <div class="top__card-items">
                    <h3 class="top__card-title">Be closer to your friends</h3>
                    <p class="top__card-desc">You can add your friends to chat with them. Share good emotions in the moment</p>
                  </div>
                </div>
              </div>
              <div class="top__card">
                <div class="top__card-pic pic__2">
                  <div class="top__card-items">
                    <h3 class="top__card-title">100% privacy</h3>
                    <p class="top__card-desc">We do not distribute information about our users</p>
                  </div>
                </div>
              </div>
              <div class="top__card">
                <div class="top__card-pic pic__3">
                  <div class="top__card-items">
                    <h3 class="top__card-title">Great Support</h3>
                    <p class="top__card-desc">We are always ready to help solve any problems. It is important for us to use OZi comfortably</p>
                  </div>
                </div>
              </div>
              <div class="top__card">
                <div class="top__card-pic pic__4">
                  <div class="top__card-items">
                    <h3 class="top__card-title">Listen to music</h3>
                    <p class="top__card-desc">Our social network provides an opportunity to listen to music without restrictions and advertising</p>
                  </div>
                </div>
              </div>
              <div class="top__card">
                <div class="top__card-pic pic__5">
                  <div class="top__card-items">
                    <h3 class="top__card-title">Share the news</h3>
                    <p class="top__card-desc">Each user can write posts on their own and other people's walls. Let everyone see you!</p>
                  </div>
                </div>
              </div>
              <div class="top__card">
                <div class="top__card-pic pic__6">
                  <div class="top__card-items">
                    <h3 class="top__card-title">Enjoy it</h3>
                    <p class="top__card-desc">And now you can finally; just enjoy and be creative! if you have any questions, do not hesitate to write to the technical support</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="info__item">
          <div class="form" id="form">
            <div class="form__container">
              <div class="form__logo">
                <img src="./img/svg/Untitled-2.png" width="80" height="80" alt="Welcome to Ozi!">
              </div>
            </div>
            <div class="form__container">
              <div class="form__input-items">
                <input type="text" class="form__input" placeholder="phone or mail">
                <div class="check__date">
                  <label class="custom-checkbox">
                    <input type="checkbox" value="remember">
                    <span>remember me</span>
                  </label>
                </div>
              </div>
            </div>
            <div class="form__buttons">
              <button class="form__button btn__1"><span>sign in</span></button>
              <button class="form__button btn__2"><span>sign up</span></button>
            </div>

          </div>
        </div>
      </div>


    </div>


    <!-- info end -->
  </section>

</main>
<footer class="footer">
  <div class="wrapper">
    <div class="footer__item">
      <div class="footer__logo">
        <p class="footer__name">Ozi</p>
      </div>
      <div class="footer__nav">
        <ul class="footer__menu">
          <li class="footer__menu-item">
            <h3 class="footer__menu-title">Made by:</p>
          </li>
          <li class="footer__menu-item">
            <a href="https://www.instagram.com/kreches/" class="footer__menu-link">Krech Anastasia</a>
          </li>
          <li class="footer__menu-item">
            <a href="https://www.instagram.com/fableddash/" class="footer__menu-link">Vysik Daria</a>
          </li>
          <li class="footer__menu-item">
            <a href="https://www.instagram.com/krollikroddzer/" class="footer__menu-link"> Zaycev Stanislav</a>
          </li>
        </ul>
      </div>
      <div class="footer__rights">
        <div class="footer__right">
          © Ozi. All Rights Reserved 2023
        </div>

      </div>
    </div>
  </div>
</footer>
</body>
</html>

