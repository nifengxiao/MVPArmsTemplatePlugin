package mvparms.src.app_package

fun armsPresenterJava(
        pageName: String,
        contractPackageName: String,
        presenterPackageName: String,
        needActivity: Boolean,
        needFragment: Boolean
) = """
package ${presenterPackageName};

import android.app.Application;

import com.jess.arms.integration.AppManager;
${scopeStrImportJava(needActivity, needFragment)}
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import javax.inject.Inject;

import ${contractPackageName}.${pageName}Contract;


${scopeStr(needActivity, needFragment)}
public class ${pageName}Presenter extends BasePresenter<${pageName}Contract.Model, ${pageName}Contract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public ${pageName}Presenter (${pageName}Contract.Model model, ${pageName}Contract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}

"""


fun armsPresenterKt(
        pageName: String,
        contractPackageName: String,
        presenterPackageName: String,
        needActivity: Boolean,
        needFragment: Boolean
) = """
package $presenterPackageName

import android.app.Application

import com.jess.arms.integration.AppManager
${scopeStrImportKt(needActivity, needFragment)}
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import ${contractPackageName}.${pageName}Contract

${scopeStr(needActivity, needFragment)}
class ${pageName}Presenter
@Inject
constructor(model: ${pageName}Contract.Model, rootView: ${pageName}Contract.View) :
BasePresenter<${pageName}Contract.Model, ${pageName}Contract.View>(model,rootView) {
    @Inject
    lateinit var mErrorHandler:RxErrorHandler
    @Inject
    lateinit var mApplication:Application
    @Inject
    lateinit var mImageLoader:ImageLoader
    @Inject
    lateinit var mAppManager:AppManager


    override fun onDestroy() {
          super.onDestroy();
    }
}
"""