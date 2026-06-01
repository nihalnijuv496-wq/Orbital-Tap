package org.nihal.orbitaltap.Utils.Timer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import org.nihal.orbitaltap.GameState
import kotlin.time.Clock

@Composable
fun StartTimer(gameState: GameState, onGameOver: () -> Unit) {

    LaunchedEffect(gameState.timer.isRunning) {
        if(!gameState.timer.isRunning) return@LaunchedEffect
        val startTime = Clock.System.now().toEpochMilliseconds() - gameState.timer.elapsedTimeMillis
        while (gameState.timer.isRunning) {
            gameState.timer.elapsedTimeMillis = Clock.System.now().toEpochMilliseconds() - startTime
            if(gameState.timer.remainingTimeSeconds <= 0)
            {
                onGameOver()
                gameState.timer.pauseTimer()
            }
            delay(100)
        }
    }
}