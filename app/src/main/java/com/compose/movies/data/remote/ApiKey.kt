package com.compose.movies.data.remote

import android.content.Context
import com.compose.movies.R

object ApiKey {
    /** At this point, the API key is accessed to use the themoviedb API.
    This API is free, but it requires each user to use their own key, which is why the api_key file, a string file where I placed my key, is not available in the code.

    But don't worry, the solution is simple! You can generate your own key by visiting https://developer.themoviedb.org/docs.

    After creating your key, go to res -> values and create a file called "api_key.xml" and insert:
    <resources>
    <string name="api_key" translatable="false">YOUR_API_KEY_HERE</string>
    </resources>

    Once you've done that, the app will be able to access the API using your own key.

    Don't forget to add "api_key.xml" to the .gitignore file to prevent your API key from being exposed.

    Note: This is a simple solution to avoid exposing the API key in the code.
    However, there are better solutions, such as using Firebase remote config, for example.*/
    fun getApiKey(context:Context): String {
        return context.getString(R.string.api_key)
    }
}