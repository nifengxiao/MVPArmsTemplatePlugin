package mvparms.src.app_package

import com.android.tools.idea.wizard.template.extractLetters

fun armsFragmentJava(
        pageName: String,
        contractPackageName: String,
        fragmentPackageName: String,
        componentPackageName: String,
        presenterPackageName: String,
        packageName: String,
        fragmentLayoutName: String,
) = """
package ${fragmentPackageName};

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import ${componentPackageName}.Dagger${pageName}Component;
import ${contractPackageName}.${pageName}Contract;
import ${presenterPackageName}.${pageName}Presenter;

import ${packageName}.R;

import static com.jess.arms.utils.Preconditions.checkNotNull;

public class ${pageName}Fragment extends BaseFragment<${pageName}Presenter> implements ${pageName}Contract.View{

    public static ${pageName}Fragment newInstance() {
        ${pageName}Fragment fragment = new ${pageName}Fragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        Dagger${pageName}Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.${fragmentLayoutName}, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
    
    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

    }
}

"""


fun armsFragmentKt(
        pageName: String,
        contractPackageName: String,
        fragmentPackageName: String,
        componentPackageName: String,
        presenterPackageName: String,
        packageName: String,
        fragmentLayoutName: String,
        moudlePackageName:String
) = """
package $fragmentPackageName

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import ${componentPackageName}.Dagger${pageName}Component
import ${moudlePackageName}.${pageName}Module
import ${contractPackageName}.${pageName}Contract
import ${presenterPackageName}.${pageName}Presenter

import ${packageName}.R

class ${pageName}Fragment : BaseFragment<${pageName}Presenter>() , ${pageName}Contract.View{
    companion object {
    fun newInstance():${pageName}Fragment {
        val fragment = ${pageName}Fragment()
        return fragment
    }
    }


    override fun setupFragmentComponent(appComponent:AppComponent) {
        Dagger${pageName}Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .${extractLetters(pageName[0].toLowerCase().toString())}${pageName.substring(1, pageName.length)}Module(${pageName}Module(this))
                .build()
                .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View{
        return inflater.inflate(R.layout.${fragmentLayoutName}, container, false);
    }

    override fun initData(savedInstanceState:Bundle?) {

    }

    override fun setData(data:Any?) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message:String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent:Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {

    }
}

"""