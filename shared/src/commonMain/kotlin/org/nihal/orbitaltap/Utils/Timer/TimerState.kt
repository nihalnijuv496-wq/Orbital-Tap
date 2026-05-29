package org.nihal.orbitaltap.Utils.Timer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import kotlin.time.Clock

@Composable
fun StartTimer(timer: Timer) {
    timer.startTimer()
    LaunchedEffect(timer.isRunning) {
            val startTime = Clock.System.now().toEpochMilliseconds() - timer.elapsedTimeMillis
            while (timer.isRunning) {
                timer.elapsedTimeMillis = Clock.System.now().toEpochMilliseconds() - startTime
                delay(100)
        }
    }
}