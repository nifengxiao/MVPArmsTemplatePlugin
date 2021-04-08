package mvparms.src.app_package

/**
 * @CreateDate:     2021/4/6
 * @Author:         Creator
 * @Description:
 */

fun scopeStrImportKt(needActivity: Boolean,
                       needFragment: Boolean): String {
    return if (needActivity && needFragment) {
        "import com.jess.arms.di.scope.ActivityScope"
    } else if (needActivity) {
        "import com.jess.arms.di.scope.ActivityScope"
    } else {
        "import com.jess.arms.di.scope.FragmentScope"
    }
}

fun scopeStrImportJava(needActivity: Boolean,
                       needFragment: Boolean): String {
    return if (needActivity && needFragment) {
        "import com.jess.arms.di.scope.ActivityScope;"
    } else if (needActivity) {
        "import com.jess.arms.di.scope.ActivityScope;"
    } else {
        "import com.jess.arms.di.scope.FragmentScope;"
    }
}


fun scopeStr(needActivity: Boolean,
             needFragment: Boolean): String {
    return if (needActivity && needFragment) {
        "@ActivityScope"
    } else if (needActivity) {
        "@ActivityScope"
    } else {
        "@FragmentScope"
    }
}


fun injectImportKt(activityPackageName: String,
                   fragmentPackageName: String,
                   pageName: String,
                   needActivity: Boolean,
                   needFragment: Boolean): String {
    return if (needActivity && needFragment) {
        "import com.jess.arms.di.scope.ActivityScope\n" +
                "import ${activityPackageName}.${pageName}Activity\n" +
                "import ${fragmentPackageName}.${pageName}Fragment"
    } else if (needActivity) {
        "import com.jess.arms.di.scope.ActivityScope\n" +
                "import ${activityPackageName}.${pageName}Activity"
    } else {
        "import com.jess.arms.di.scope.FragmentScope\n" +
                "import ${fragmentPackageName}.${pageName}Fragment"
    }
}

fun injectImportJava(activityPackageName: String,
                   fragmentPackageName: String,
                   pageName: String,
                   needActivity: Boolean,
                   needFragment: Boolean): String {
    return if (needActivity && needFragment) {
        "import com.jess.arms.di.scope.ActivityScope;\n" +
                "import ${activityPackageName}.${pageName}Activity;\n" +
                "import ${fragmentPackageName}.${pageName}Fragment;"
    } else if (needActivity) {
        "import com.jess.arms.di.scope.ActivityScope;\n" +
                "import ${activityPackageName}.${pageName}Activity;"
    } else {
        "import com.jess.arms.di.scope.FragmentScope;\n" +
                "import ${fragmentPackageName}.${pageName}Fragment;"
    }
}


fun injectKt(pageName: String,
             needActivity: Boolean,
             needFragment: Boolean): String {
    return if (needActivity && needFragment) {
        "fun inject(activity:${pageName}Activity)\n" +
                "\tfun inject(fragment:${pageName}Fragment)"
    } else {
        "fun inject(${if (needFragment) {
            "fragment:${pageName}Fragment"
        } else {
            "activity:${pageName}Activity"
        }})"
    }
}

fun injectJava(pageName: String,
             needActivity: Boolean,
             needFragment: Boolean): String {
    return if (needActivity && needFragment) {
        "void inject(${pageName}Activity activity);\n" +
                "void inject(${pageName}Fragment fragment);"
    } else {
        "void inject(${if (needFragment) {
            "${pageName}Fragment fragment"
        } else {
            "${pageName}Activity activity"
        }});"
    }
}