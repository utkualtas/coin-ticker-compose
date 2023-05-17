# Coin Ticker

Coin Ticker is a work-in-progress cyrptocurrency app with Jetpack Compose which uses [Coingecko API](https://www.coingecko.com/en/api/)

## Tech stack & libraries
- Jetpack;
    - [Compose](https://developer.android.com/jetpack/compose): A recommended modern toolkit for building native UI.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): A business logic or screen level state holder.
    - [Room](https://developer.android.com/training/data-storage/room): An abstraction layer over SQLite to allow fluent database access
    - [Navigation](https://developer.android.com/jetpack/compose/navigation): For navigating screens and [Hilt Navigation Compose](https://developer.android.com/jetpack/compose/libraries#hilt) for injecting dependencies.
- [Coroutines](https://developer.android.com/kotlin/coroutines) with [Flow](https://developer.android.com/kotlin/flow) for asynchronous.
- [Hilt](https://dagger.dev/hilt/): A standard way to incorporate [Dagger](https://github.com/google/dagger) dependency injection into an Android application.
- [Retrofit2](https://square.github.io/retrofit/ "Retrofit2"): A type-safe HTTP client for Android
- [OkHttp3](https://github.com/square/okhttp): An efficient HTTP & HTTP/2 client for Android
- [Coil](https://github.com/coil-kt/coil): An image loading library for Android backed by Kotlin Coroutines. 

## Architecture
The app follows the [official architecture guidance](https://developer.android.com/topic/architecture) and based on [Now in Android App](https://github.com/android/nowinandroid) 
