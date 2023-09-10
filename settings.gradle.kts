pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    versionCatalogs {
        create("libs"){
            library("dagger-hilt","com.google.dagger:hilt-android:2.44")
            library("dagger-kapt","com.google.dagger:hilt-android-compiler:2.44")
            library("hilt-compiler","androidx.hilt:hilt-compiler:1.0.0")
            library("lifecycle-extensions","android.arch.lifecycle:extensions:1.1.1")

            library("compose-navigation","androidx.navigation:navigation-compose:2.7.2")

            val lifecycleDependency = "2.6.2"
            library("lifecycle-runtime-compose","androidx.lifecycle:lifecycle-runtime-compose:$lifecycleDependency")
            library("lifecycle-compiler","androidx.lifecycle:lifecycle-compiler:$lifecycleDependency")

            library("hilt-navigation-compose","androidx.hilt:hilt-navigation-compose:1.0.0")
            library("network-retrofit","com.squareup.retrofit2:retrofit:2.9.0")
            library("converter-gson","com.squareup.retrofit2:converter-gson:2.6.0")

            val roomVersion = "2.5.2"

            library("room-runtime","androidx.room:room-runtime:$roomVersion")
            library("annotation-room-compiler","androidx.room:room-compiler:$roomVersion")

            // To use Kotlin annotation processing tool (kapt)
            library("room-compiler","androidx.room:room-compiler:$roomVersion")

            // optional - Kotlin Extensions and Coroutines support for Room
            library("room-ktx","androidx.room:room-ktx:$roomVersion")
        }
    }
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Expression Calculator"
include(":app")
 