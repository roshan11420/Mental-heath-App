package com.example.comniramaya

sealed class Screen  (val screen :String ){
    data object Home : Screen("home")
    data object Profile : Screen("profile")
    data object Result : Screen("result")
    data object Discover : Screen("discover")
    data object Treatment : Screen("treatment")
    object VideoPlayer : Screen("videoPlayer/{videoId}") { // with arg
        fun createRoute(videoId: String) = "videoPlayer/$videoId"
    }


}