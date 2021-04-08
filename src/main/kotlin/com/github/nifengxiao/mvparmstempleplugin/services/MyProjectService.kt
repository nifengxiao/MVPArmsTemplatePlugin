package com.github.nifengxiao.mvparmstemplateplugin.services

import com.github.nifengxiao.mvparmstemplateplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
