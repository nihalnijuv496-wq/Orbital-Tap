package org.nihal.orbitaltap.Utils

import com.russhwolf.settings.Settings


object ScoreStorage
{
    private val settings: Settings = Settings()

    fun setHighScore(highScore: Int)
    {
        if (highScore > getHighScore())
            settings.putInt("HighScore", highScore)
    }

    fun getHighScore(): Int {
        return settings.getInt("HighScore", 0)
    }
}