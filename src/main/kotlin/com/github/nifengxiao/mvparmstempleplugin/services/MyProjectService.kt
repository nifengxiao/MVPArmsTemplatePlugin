package com.github.nifengxiao.mvparmstempleplugin.services

import com.github.nifengxiao.mvparmstempleplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
