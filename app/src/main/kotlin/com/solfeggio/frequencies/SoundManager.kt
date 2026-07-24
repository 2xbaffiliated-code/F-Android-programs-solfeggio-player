package com.solfeggio.frequencies

import android.content.Context
import android.media.MediaPlayer
import android.os.Environment
import java.io.File

class SoundManager(private val context: Context) {

    private val mediaPlayers = mutableMapOf<Int, MediaPlayer?>()
    private val frequencies = listOf(174, 285, 396, 417, 528, 639, 741, 852, 963)

    init {
        // Initialize all media players
        frequencies.forEach { freq ->
            mediaPlayers[freq] = null
        }
    }

    fun play(frequency: Int) {
        try {
            val soundFile = getSoundFile(frequency)
            if (soundFile.exists()) {
                // Stop any existing playback for this frequency
                stop(frequency)
                
                // Create new media player
                val mediaPlayer = MediaPlayer()
                mediaPlayer.setDataSource(soundFile.absolutePath)
                mediaPlayer.prepare()
                mediaPlayer.start()
                mediaPlayers[frequency] = mediaPlayer
            } else {
                throw Exception("Sound file not found: ${soundFile.absolutePath}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun pause(frequency: Int) {
        try {
            val mediaPlayer = mediaPlayers[frequency]
            if (mediaPlayer != null && mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun resume(frequency: Int) {
        try {
            val mediaPlayer = mediaPlayers[frequency]
            if (mediaPlayer != null && !mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun stop(frequency: Int) {
        try {
            val mediaPlayer = mediaPlayers[frequency]
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.stop()
                }
                mediaPlayer.reset()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun repeat(frequency: Int) {
        try {
            val soundFile = getSoundFile(frequency)
            if (soundFile.exists()) {
                stop(frequency)
                
                val mediaPlayer = MediaPlayer()
                mediaPlayer.setDataSource(soundFile.absolutePath)
                mediaPlayer.isLooping = true
                mediaPlayer.prepare()
                mediaPlayer.start()
                mediaPlayers[frequency] = mediaPlayer
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getSoundFile(frequency: Int): File {
        // Try to get from external storage first (root directory)
        val externalFile = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "${frequency}.mp3")
        if (externalFile.exists()) {
            return externalFile
        }

        // Try app directory
        val appFile = File(context.getExternalFilesDir(null), "${frequency}.mp3")
        if (appFile.exists()) {
            return appFile
        }

        // Try assets
        return File(context.filesDir, "${frequency}.mp3")
    }

    fun release() {
        frequencies.forEach { freq ->
            mediaPlayers[freq]?.let {
                if (it.isPlaying) {
                    it.stop()
                }
                it.release()
            }
            mediaPlayers[freq] = null
        }
    }

    fun isPlaying(frequency: Int): Boolean {
        return mediaPlayers[frequency]?.isPlaying ?: false
    }
}
