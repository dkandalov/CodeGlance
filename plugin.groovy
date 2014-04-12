import net.vektah.codeglance.CodeGlancePlugin

import static liveplugin.PluginUtil.changeGlobalVar
import static liveplugin.PluginUtil.show

// add-to-classpath $HOME/Library/Application Support/IntelliJIdea13/live-plugins/CodeGlance/classes/artifacts/CodeGlance_jar/*.jar

if (isIdeStartup) return

changeGlobalVar("codeGlance"){ previousPlugin ->
	if (previousPlugin != null) {
		previousPlugin.disposeComponent()
		show("Disposed previous CodeGlancePlugin")
	}

	def plugin = new CodeGlancePlugin(project)
	plugin.initComponent()
	plugin
}

show("Reloaded CodeGlancePlugin")