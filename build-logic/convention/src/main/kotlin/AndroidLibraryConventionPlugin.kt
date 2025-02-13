import com.android.build.gradle.LibraryExtension
import com.lmorda.buildlogic.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
                apply("com.android.library")
            }
            extensions.configure<LibraryExtension> {
                configureAndroid(commonExtension = this)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation", platform(libs.findLibrary("koin.bom").get()))
                add("implementation", libs.findLibrary("koin.android").get())
                add("implementation", libs.findLibrary("timber").get())
                add("testImplementation", libs.findLibrary("junit").get())
                add("testImplementation", libs.findLibrary("kotlinx.coroutines.test").get())
                add("testImplementation", libs.findLibrary("mockk").get())
                add("testImplementation", libs.findLibrary("mockk.android").get())
                add("testImplementation", libs.findLibrary("androidx.core.testing").get())
                add("testImplementation", libs.findLibrary("turbine").get())
            }
        }
    }
}
