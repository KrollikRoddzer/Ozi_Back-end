<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Messages</title>
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="icon" type="image/svg+xml" href="./img/svg/Ozi_icon.svg">
  <link rel="icon" type="image/png" href="./img/favicon/Ozi__iconPNG.png">
  <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="css/temp.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Aleo:ital,wght@0,400;0,700;1,400&family=Inter&family=Lato:ital,wght@0,300;0,400;1,300&family=Red+Hat+Text:wght@500&display=swap" rel="stylesheet">
    
    </head>
    <body>
       <div>
           <jsp:include page="./components/header.jsp" />
       </div>
        <!-- header end -->
        <main class="main">
            <section class="intro">
                <!-- info start -->
                <jsp:include page="./components/navbar.jsp" />
                <!-- info end -->

                <!-- message__list start -->
               
                <div class="profile__wrap">
                    <div class="chat__windows">
                        <div class="message__list">
                            <div class="search__chat">
                                <div class="search__items">
                                        <div class="search__item">
                                            <form class="search__form">
                                                <input type="text" class="search__input" placeholder="Type to search...">
                                                <button class="search__button"></button>
                                              </form>
                                        </div>
                                        <div class="search__item">
                                            <i class='bx bx-plus' style='color:#c6c6c6'  ></i>
                                        </div>
                                </div>
                            </div>
                            <div class="dialogs element">
                                    <div class="radio__chat">
                                        <div class="form_radio_btn">
                                            <input id="radio-1" type="radio" name="radio" value="1">
                                            <label for="radio-1">
                                                <div class="chats">
                                                    <div class="start_chat">
                                                        <div class="chat">
                                                            <div class="chat__img">
                                                                <img class="chat__pic" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                            </div>
                                                        </div>
                                                        <div class="chat">
                                                            <div class="chat__center">
                                                                <div class="chat__name">
                                                                    Stanislav Zaycev
                                                                </div>
                                                                <div class="chat__last">
                                                                    <span class="your__message">you:</span>
                                                                    Am I the only one keeping track...
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="chat">
                                                        <div class="chat__time">
                                                            <div class="chat__last">23:07</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </label>
                                        
                                        </div>
                                    </div>
                                    <div class="radio__chat">
                                        <div class="form_radio_btn">
                                            <input id="radio-2" type="radio" name="radio" value="2">
                                            <label for="radio-2">
                                                <div class="chats">
                                                    <div class="start_chat">
                                                        <div class="chat">
                                                            <div class="chat__img">
                                                                <img class="chat__pic" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                            </div>
                                                        </div>
                                                        <div class="chat">
                                                            <div class="chat__center">
                                                                <div class="chat__name">
                                                                    Anton Sheynikov
                                                                </div>
                                                                <div class="chat__last">
                                                                    <span class="">you:</span>
                                                                     Yes, yes and yes again
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="chat">
                                                        <div class="chat__time">
                                                            <div class="chat__last">16:31</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </label>
                                        
                                        </div>
                                    </div>
                                    <div class="radio__chat">
                                        <div class="form_radio_btn">
                                            <input id="radio-3" type="radio" name="radio" value="3">
                                            <label for="radio-3">
                                                <div class="chats">
                                                    <div class="start_chat">
                                                        <div class="chat">
                                                            <div class="chat__img">
                                                                <img class="chat__pic" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                            </div>
                                                        </div>
                                                        <div class="chat">
                                                            <div class="chat__center">
                                                                <div class="chat__name">
                                                                    Artemiy Kuteyko
                                                                </div>
                                                                <div class="chat__last">
                                                                    <span class="your__message">you:</span>
                                                                    Great, these are the memes I app...
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="chat">
                                                        <div class="chat__time">
                                                            <div class="chat__last">16:03</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </label>
                                        
                                        </div>
                                    </div>
                                    <div class="radio__chat">
                                        <div class="form_radio_btn">
                                            <input id="radio-4" type="radio" name="radio" value="4">
                                            <label for="radio-4">
                                                <div class="chats">
                                                    <div class="start_chat">
                                                        <div class="chat">
                                                            <div class="chat__img">
                                                                <img class="chat__pic" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                            </div>
                                                        </div>
                                                        <div class="chat">
                                                            <div class="chat__center">
                                                                <div class="chat__name">
                                                                    Daria Vusik
                                                                </div>
                                                                <div class="chat__last">
                                                                    <span class="your__message">you:</span>
                                                                    Pomodora timer is done!
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="chat">
                                                        <div class="chat__time">
                                                            <div class="chat__last">Fr</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </label>
                                        
                                        </div>
                                    </div>
                            </div>
                        </div>
                        <div class="message__bg">
                            <div class="info__part">
                               <div class="name__part">
                                Anton Sheynikov
                               </div>
                               <div class="time__part">
                                last seen today at 16:44
                               </div>
                            </div>
                            <div class="main__part">
                                <div class="messages element">
                                    <div class="message">
                                        <div class="message_item-start">
                                            <div class="message_item">
                                                <div class="message__img">
                                                    <img class="chat__pic" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                </div>
                                            </div>
                                            <div class="message_item">
                                                <div class="chat__center">
                                                    <div class="chat__name companion">
                                                        Anton
                                                    </div>
                                                    <div class="chat__last comp_message">
                                                        I found a very cool song today. Enjoy
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="message_item">
                                            <div class="chat__time">
                                                <div class="chat__last">16:11</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="message">
                                        <div class="message_item-start ">
                                            <div class="message_item">
                                                <div class="message__img again__message-space">
                                                    <img class="chat__pic again__message" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                </div>
                                            </div>
                                            <div class="message_item">
                                                <div class="chat__center">
                                                    <div class="chat__name again__message companion">
                                                        Anton
                                                    </div>
                                                    <div class="messag chat__last comp_message">
                                                        I found a very cool song today. Enjoyaaaaaaaaaaaaaaaaaaa
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="message_item">
                                            <div class="chat__time">
                                                <div class="chat__last">16:11</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="message">
                                        <div class="message_item-start">
                                            <div class="message_item">
                                                <div class="message__img">
                                                    <img class="chat__pic" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                </div>
                                            </div>
                                            <div class="message_item">
                                                <div class="chat__center">
                                                    <div class="chat__name companion">
                                                        Anton
                                                    </div>
                                                    <div class="chat__last comp_message">
                                                        I found a very cool song today. Enjoy
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="message_item">
                                            <div class="chat__time">
                                                <div class="chat__last">16:11</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="message">
                                        <div class="message_item-start">
                                            <div class="message_item">
                                                <div class="message__img">
                                                    <img class="chat__pic" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                </div>
                                            </div>
                                            <div class="message_item">
                                                <div class="chat__center">
                                                    <div class="chat__name companion">
                                                        Anastasia
                                                    </div>
                                                    <div class="chat__last comp_message">
                                                        Now it's my favorite song
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="message_item">
                                            <div class="chat__time">
                                                <div class="chat__last">16:15</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="message">
                                        <div class="message_item-start">
                                            <div class="message_item">
                                                <div class="message__img">
                                                    <img class="chat__pic" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                </div>
                                            </div>
                                            <div class="message_item">
                                                <div class="chat__center">
                                                    <div class="chat__name companion">
                                                        Anton
                                                    </div>
                                                    <div class="chat__last comp_message">
                                                        Now it's about you
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="message_item">
                                            <div class="chat__time">
                                                <div class="chat__last">16:16</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="message">
                                        <div class="message_item-start">
                                            <div class="message_item">
                                                <div class="message__img">
                                                    <img class="chat__pic" src="./img/Dva.jpg" width="60" height="60" alt="user photo">
                                                </div>
                                            </div>
                                            <div class="message_item">
                                                <div class="chat__center">
                                                    <div class="chat__name companion">
                                                        Anastasia
                                                    </div>
                                                    <div class="chat__last comp_message">
                                                        Yes, yes and yes again
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="message_item">
                                            <div class="chat__time">
                                                <div class="chat__last">16:31</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="type__part">
                                <div class="components">
                                    <textarea class="message_in" placeholder="Write your message..."></textarea>
                                    <a href="#!" class="benefits__card-more">`</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                 <!-- message__list end -->
            </section>

        </main>
            

    </body>
    <footer class="footer">
        <jsp:include page="components/footer.jsp"/>
    </footer>
</html>