package mvparms.src.app_package

fun armsComponentJava(
        pageName: String,
        activityPackageName: String,
        componentPackageName: String,
        contractPackageName: String,
        moudlePackageName: String,
        fragmentPackageName: String,
        needActivity: Boolean,
        needFragment: Boolean
) = """
package ${componentPackageName};

import dagger.BindsInstance;
import dagger.Component;
import com.jess.arms.di.component.AppComponent;

import ${moudlePackageName}.${pageName}Module;
import ${contractPackageName}.${pageName}Contract;

${injectImportJava(activityPackageName,fragmentPackageName,pageName,needActivity,needFragment)};


${scopeStr(needActivity, needFragment)}
@Component(modules = ${pageName}Module.class, dependencies = AppComponent.class)
public interface ${pageName}Component {
    ${injectJava(pageName,needActivity,needFragment)}
    @Component.Builder
    interface Builder {
        @BindsInstance
        ${pageName}Component.Builder view(${pageName}Contract.View view);
        ${pageName}Component.Builder appComponent(AppComponent appComponent);
        ${pageName}Component build();
    }
}
"""


fun armsComponentKt(
        pageName: String,
        activityPackageName: String,
        componentPackageName: String,
        fragmentPackageName: String,
        moudlePackageName: String,
        needActivity: Boolean,
        needFragment: Boolean
) = """
package $componentPackageName

import dagger.Component
import com.jess.arms.di.component.AppComponent

import ${moudlePackageName}.${pageName}Module

${injectImportKt(activityPackageName,fragmentPackageName,pageName,needActivity,needFragment)}


${scopeStr(needActivity, needFragment)}
@Component(modules = arrayOf(${pageName}Module::class),dependencies = arrayOf(AppComponent::class))
interface ${pageName}Component {
  ${injectKt(pageName,needActivity,needFragment)}
}
"""

