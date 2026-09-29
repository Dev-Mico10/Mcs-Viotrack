plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mcs_viotrack"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.mcs_viotrack"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.vintage.engine)
    testImplementation(libs.junit.platform.launcher)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val sourceSets = project.extensions.getByType<SourceSetContainer>()
val unitTest = sourceSets.maybeCreate("unitTest")
afterEvaluate {
    val testSourceSet = sourceSets.findByName("test")
    val debugUnitTestRuntime = configurations.findByName("debugUnitTestRuntimeClasspath")
    val compileDebugUnitTest = tasks.findByName("compileDebugUnitTestJavaWithJavac") as? JavaCompile
    val compileDebugJava = tasks.findByName("compileDebugJavaWithJavac") as? JavaCompile

    if (compileDebugUnitTest != null) {
        unitTest.output.dir(compileDebugUnitTest.destinationDirectory)
    }
    if (compileDebugJava != null) {
        unitTest.output.dir(compileDebugJava.destinationDirectory)
    }

    val runtimeConfig = debugUnitTestRuntime ?: testSourceSet?.runtimeClasspath ?: files()
    unitTest.compileClasspath = testSourceSet?.compileClasspath ?: files()
    unitTest.runtimeClasspath = unitTest.output + runtimeConfig
}




