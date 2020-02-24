package org.ieselcaminas.cristina.proyectoclase.ui.respiraciones

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RespiracionesViewModel : ViewModel() {
    companion object {
        // These represent different important times
        // This is when the game is over
        const val DONE = 0L
        // This is the number of milliseconds in a second
        const val ONE_SECOND = 1000L
        // This is the total time of the game
        const val COUNTDOWN_TIME_TOTAL = 60000L

        const val FOUR_SECONDS = 4000L

        var breath = true
    }

    private val timerTotal: CountDownTimer
    private val _currentTimeTotal = MutableLiveData<Long>()
    val currentTimeTotal: LiveData<Long>
        get() = _currentTimeTotal


    private val timerBreathe: CountDownTimer
    private val _currentBreathe = MutableLiveData<String>()
    val currentBreathe: LiveData<String>
        get() = _currentBreathe

    init{
        timerTotal = object : CountDownTimer(COUNTDOWN_TIME_TOTAL, ONE_SECOND){
            override fun onTick(millisUntilFinished: Long) {

                _currentTimeTotal.value = (millisUntilFinished / ONE_SECOND)
            }

            override fun onFinish() {
                _currentTimeTotal.value = DONE
            }
        }

        timerBreathe = object  : CountDownTimer(COUNTDOWN_TIME_TOTAL, FOUR_SECONDS){
            override fun onTick(millisUntilFinished: Long) {
                if(breath){
                    _currentBreathe.value = "INHALE"
                    breath = false
                }else{
                    _currentBreathe.value = "EXHALE"
                    breath = true
                }
            }
            override fun onFinish() {
                _currentBreathe.value = "WELL DONE!!"
            }
        }


    }

    fun startTimers(){
        timerTotal.start()
        timerBreathe.start()
    }

}
