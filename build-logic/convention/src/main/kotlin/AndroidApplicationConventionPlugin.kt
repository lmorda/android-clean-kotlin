import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.lmorda.buildlogic.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
                apply("com.android.application")
            }
            extensions.configure<BaseAppModuleExtension> {
                configureAndroid(commonExtension = this)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation", platform(libs.findLibrary("koin.bom").get()))
                add("implementation", libs.findLibrary("koin.android").get())
                add("implementation", libs.findLibrary("timber").get())
            }
        }
    }
}
