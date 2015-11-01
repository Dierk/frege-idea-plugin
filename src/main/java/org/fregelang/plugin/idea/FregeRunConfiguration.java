package org.fregelang.plugin.idea;

import com.intellij.execution.application.ApplicationConfiguration;
import com.intellij.execution.application.ApplicationConfigurationType;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfileWithCompileBeforeLaunchOption;
import com.intellij.openapi.project.Project;

public class FregeRunConfiguration extends ApplicationConfiguration implements RunProfileWithCompileBeforeLaunchOption {
    public FregeRunConfiguration(String title, Project project, ConfigurationFactory configurationFactory) {
        super(title,project,configurationFactory);
    }

    public FregeRunConfiguration(String name, Project project, ApplicationConfigurationType applicationConfigurationType) {
        super(name, project, applicationConfigurationType);
    }
}
