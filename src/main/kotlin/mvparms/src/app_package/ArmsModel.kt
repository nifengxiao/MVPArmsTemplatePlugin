package mvparms.src.app_package

fun armsModelJava(
        pageName: String,
        contractPackageName: String,
        modelPackageName: String,
        needActivity: Boolean,
        needFragment: Boolean
) = """
package ${modelPackageName};

import android.app.Application;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

${scopeStrImportJava(needActivity, needFragment)}
import javax.inject.Inject;

import ${contractPackageName}.${pageName}Contract;


${scopeStr(needActivity, needFragment)}
public class ${pageName}Model extends BaseModel implements ${pageName}Contract.Model{
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public ${pageName}Model(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}
"""


fun armsModelKt(
        pageName: String,
        contractPackageName: String,
        modelPackageName: String,
        needActivity: Boolean,
        needFragment: Boolean
) = """
package $modelPackageName

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

${scopeStrImportKt(needActivity, needFragment)}
import javax.inject.Inject

import ${contractPackageName}.${pageName}Contract


${scopeStr(needActivity, needFragment)}
class ${pageName}Model
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), ${pageName}Contract.Model{
    @Inject
    lateinit var mGson:Gson;
    @Inject
    lateinit var mApplication:Application;

    override fun onDestroy() {
          super.onDestroy();
    }
}

"""