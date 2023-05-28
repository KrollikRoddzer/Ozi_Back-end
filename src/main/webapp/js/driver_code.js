; (function () {
    'use strict';

   // let state = PomodoroTimer.POMODORO;
   let max_pomodoro_count = 4;
   let pt = new PomodoroTimer(max_pomodoro_count);
   let timer;
  function pause_timer(timer) {
    if(!pt.is_running) return;
     pt.is_running = false;
     clearInterval(timer);  
     document.getElementById("button_text").innerHTML = "Start";
 }
 
 // get state() {
 //    return this.state;
 // }
 let pomodoro_radio = document.getElementById("pomodoro");
    let short_break_radio = document.getElementById("short_break");
    let long_break_radio = document.getElementById("long_break");
    let start_button = document.getElementById("start_checkbox");
    pomodoro_radio.checked = true;
    document.getElementById("timer").innerHTML = pt.state + ":00";
 
 function update_timer() {
  //  console.log(this.state);
  pt.current_time++;
    let distance = pt.state * 60 - pt.current_time;
 
    let minutes = Math.floor(distance/60);
    let seconds = distance %60;
    
    if (seconds < 10){
     seconds = "0" + seconds;
    }
    document.getElementById("timer").innerHTML = minutes + ":" + seconds;
   // pt.current_time++;
      
    if (distance < 0) {
    pause_timer(timer);
      if(pt.state == PomodoroTimer.POMODORO) {
          pt.pomodoro_count++;
      }
      let new_state = pt.get_next_state();
      pt.change_mode(new_state);
      document.getElementById("timer").innerHTML = pt.state + ":00";
      pt.ding.play();
    //set next radio as checked
      switch(new_state){
        case PomodoroTimer.POMODORO:
          pomodoro_radio.checked = true;
          break;
        case PomodoroTimer.LONG_BREAK:
          long_break_radio = true;
          break;
        case PomodoroTimer.SHORT_BREAK:
          short_break_radio.checked = true;
          break;
      }
      
    }
 }
 

 
  function start_timer() {
     pt.is_running = true;
     timer = setInterval( update_timer, 1000);
     document.getElementById("button_text").innerHTML = "Pause";
  }
 
    
 

    start_button.addEventListener('change', start_button_listener);
    function start_button_listener() {
        if(pt.is_running) {
            pause_timer(timer);
        } else {
            start_timer(timer);
        }
    }

    pomodoro_radio.addEventListener('change', pomodoro_listener);
    function pomodoro_listener() {
      if(pt.is_running) {
        pause_timer(timer);
        pt.is_running = false;
      }
      pt.state = PomodoroTimer.POMODORO;
      document.getElementById("timer").innerHTML = pt.state + ":00";
    } 

    short_break_radio.addEventListener('change', short_break_listener );
    function short_break_listener() {
      if(pt.is_running) {
        pause_timer(timer);
        pt.is_running = false;
      }
      pt.state = PomodoroTimer.SHORT_BREAK;
      document.getElementById("timer").innerHTML = pt.state + ":00";
    }

    long_break_radio.addEventListener('change', long_break_listener) ;

    function long_break_listener() {
      if(pt.is_running) {
        pause_timer(timer);
        pt.is_running = false;
      }
      pt.state = PomodoroTimer.LONG_BREAK;
      document.getElementById("timer").innerHTML = pt.state + ":00";
    }
    
    

    
})();
