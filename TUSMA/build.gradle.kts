// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
}

buildscript {
    repositories {
        mavenCentral()
}
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
        // Fix Duplicate class
//        implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    }
}