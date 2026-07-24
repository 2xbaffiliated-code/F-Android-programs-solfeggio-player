# Solfeggio Frequencies Player

A professional Android application built with Kotlin that plays 9 Solfeggio healing frequencies with individual play, pause, and repeat controls for each frequency.

## 🎵 Features

- **9 Solfeggio Frequencies**:
  - 174 Hz - Relieves pain, stress, and physical tension
  - 285 Hz - Influences energy fields, promotes tissue healing
  - 396 Hz - Liberates guilt, fear, and emotional blockages
  - 417 Hz - Facilitates change, clears negative energy
  - 528 Hz - Known as the "Miracle" tone; links to cell repair
  - 639 Hz - Fosters love, connection, and relationship harmony
  - 741 Hz - Cleanses cells, detoxifies toxins, and boosts expression
  - 852 Hz - Awakens intuition and spiritual awareness
  - 963 Hz - Connects to the crown chakra and higher consciousness

- **Independent Controls**: Each frequency has separate Play, Pause, and Repeat buttons
- **Loop Support**: Play any frequency continuously in loop mode
- **Material Design**: Modern UI with Material 3 components
- **Responsive Layout**: ScrollView for easy navigation across all frequencies
- **Permission Handling**: Automatic permission requests for audio access

## 🛠️ Requirements

- Android 8.0 (API 26) or higher
- Android Studio 2022.1 or later
- Kotlin 1.8+
- Gradle 8.0+

## 📁 File Structure

The application looks for MP3 files in the following locations (in order of preference):
1. External storage Downloads folder: `{DOWNLOADS}/174.mp3`, `{DOWNLOADS}/285.mp3`, etc.
2. App external files directory
3. App internal files directory

## 🎵 Audio Files Required

Place the following MP3 files in your device's root/Downloads folder or app directory:
- `174.mp3`
- `285.mp3`
- `396.mp3`
- `417.mp3`
- `528.mp3`
- `639.mp3`
- `741.mp3`
- `852.mp3`
- `963.mp3`

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/2xbaffiliated-code/F-Android-programs-solfeggio-player.git
cd F-Android-programs-solfeggio-player
```

### 2. Open in Android Studio
- File → Open → Select the project directory
- Wait for Gradle sync to complete

### 3. Add Audio Files
- Connect your Android device or use an emulator
- Place the 9 MP3 files in the Downloads folder on the device

### 4. Build and Run
```bash
# Build APK
./gradlew build

# Run on connected device
./gradlew installDebug
```

### 5. Build Release APK
```bash
./gradlew assembleRelease
```

The release APK will be available at: `app/build/outputs/apk/release/app-release.apk`

## 📱 UI Components

### Material Design Card Views
Each frequency is presented in a Material CardView with:
- Frequency label with Hz value and description
- Three action buttons (Play, Pause, Repeat)
- Elevation and rounded corners for modern appearance

### Buttons
- **Play**: Starts playback of the selected frequency
- **Pause**: Pauses the current playback
- **Repeat**: Plays the frequency in a continuous loop

## 🔧 Architecture

### SoundManager Class
Manages all audio playback operations:
- Maintains MediaPlayer instances for each frequency
- Handles play, pause, resume, and repeat operations
- Manages file location resolution
- Proper resource cleanup

### MainActivity Class
Handles:
- UI initialization with view binding
- Button click listeners for all 9 frequencies
- Permission requests for audio access
- Lifecycle management

## 📋 Permissions

The app requests the following permissions:
- `READ_EXTERNAL_STORAGE` (Android 12 and below)
- `READ_MEDIA_AUDIO` (Android 13 and above)

## 🎨 Customization

### Change Theme Colors
Edit `app/src/main/res/values/themes.xml`:
```xml
<color name="purple_500">#6200EE</color>
<color name="teal_200">#03DAC5</color>
```

### Adjust Button Sizes
Edit `app/src/main/res/layout/activity_main.xml`:
```xml
<Button
    android:layout_height="wrap_content"
    android:layout_weight="1"
    ...
/>
```

## 🐛 Troubleshooting

### Audio Files Not Found
- Ensure MP3 files are named exactly: `{frequency}.mp3` (e.g., `528.mp3`)
- Place files in Downloads folder on the device
- Check file permissions: Settings → Apps → Permissions

### Permission Denied
- Grant permission when prompted
- Manual grant: Settings → Apps → Solfeggio Frequencies Player → Permissions

### No Sound Playing
- Check device volume settings
- Verify audio files are valid MP3 format
- Check Android logs for exceptions

## 📦 Building APK

### Debug APK
```bash
./gradlew assembleDebug
```
Output: `app/build/outputs/apk/debug/app-debug.apk`

### Release APK (Optimized)
```bash
./gradlew assembleRelease
```
Output: `app/build/outputs/apk/release/app-release.apk`

## 📄 License

This project is open source and available under the MIT License.

## 👤 Author

Created for healing and spiritual wellness using Solfeggio frequencies.

## 🙏 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📞 Support

For issues or questions, please create an issue in the GitHub repository.

---

**Note**: The Solfeggio frequencies are ancient healing tones. While scientific evidence for their specific benefits is limited, many individuals report positive experiences with these frequencies for relaxation and meditation purposes.
