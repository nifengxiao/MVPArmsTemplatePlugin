package mvparms
import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider

/**
 * @CreateDate:     2021/4/1
 * @Author:         Creator
 * @Description:
 */
class SamplePluginTemplateProviderImpl : WizardTemplateProvider(){
    override fun getTemplates(): List<Template> = listOf(
            // activity的模板
            MVPArmsTemplate
    )
}
