# SpotifyKt
A Spotify client written in Kotlin with a Clean Architecture.
It uses Compose, Mavericks, Hilt, Coroutines and Retrofit.

## Getting Started
It's necessary add your Spotify's client and secret in your `gradle.properties`:
```
spotifyClient=YOUR_CLIENT
spotifySecret=YOUR_SECRET
```


### Gradle tasks
```
./gradlew detektAll //Code analysis.
./gradlew checkDependencyUpdates //Check dependency updates.
```
