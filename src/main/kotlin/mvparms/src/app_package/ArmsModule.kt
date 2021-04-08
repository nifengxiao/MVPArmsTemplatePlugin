package mvparms.src.app_package


fun armsModuleJava(
        pageName: String,
        contractPackageName: String,
        modelPackageName: String,
        moudlePackageName: String
) = """
package ${moudlePackageName};

import dagger.Binds;
import dagger.Module;

import ${contractPackageName}.${pageName}Contract;
import ${modelPackageName}.${pageName}Model;


@Module
public abstract class ${pageName}Module {

    @Binds
    abstract ${pageName}Contract.Model bind${pageName}Model(${pageName}Model model);
}
"""

fun armsModulelKt(
        pageName: String,
        contractPackageName: String,
        modelPackageName: String,
        moudlePackageName: String,
        needActivity: Boolean,
        needFragment: Boolean
) = """
package $moudlePackageName

${scopeStrImportKt(needActivity, needFragment)}

import dagger.Module
import dagger.Provides

import ${contractPackageName}.${pageName}Contract
import ${modelPackageName}.${pageName}Model


@Module
 //构建${pageName}Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ${pageName}Module(private val view:${pageName}Contract.View) {
    ${scopeStr(needActivity, needFragment)}
    @Provides
    fun provide${pageName}View():${pageName}Contract.View{
        return this.view
    }

    ${scopeStr(needActivity, needFragment)}
    @Provides
    fun provide${pageName}Model(model:${pageName}Model):${pageName}Contract.Model{
        return model
    }
}

"""
