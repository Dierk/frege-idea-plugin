package org.fregelang.plugin.idea.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.fregelang.plugin.idea.FregeFileType;
import org.fregelang.plugin.idea.FregeIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class FregeRunConfigurationType implements ConfigurationType {
  private final ConfigurationFactory myConfigurationFactory;

  public FregeRunConfigurationType() {
    myConfigurationFactory = new FregeFactory(this);
  }

  public static FregeRunConfigurationType getInstance() {
    return ConfigurationTypeUtil.findConfigurationType(FregeRunConfigurationType.class);
  }

  @Override
  public String getDisplayName() {
    return "Frege";
  }

  @Override
  public String getConfigurationTypeDescription() {
    return "Frege runnable module or script";
  }

  @Override
  public Icon getIcon() {
    return FregeIcons.FILE;
  }

  @Override
  @NonNls
  @NotNull
  public String getId() {
    return "FregeScriptRunConfiguration";
  }

  @Override
  public ConfigurationFactory[] getConfigurationFactories() {
    return new ConfigurationFactory[]{myConfigurationFactory};
  }

  private static class FregeFactory extends ConfigurationFactory {
    public FregeFactory(ConfigurationType type) {
      super(type);
    }

    @Override
    public boolean isApplicable(@NotNull Project project) {
      return FileTypeIndex.containsFileOfType(FregeFileType.INSTANCE, GlobalSearchScope.allScope(project));
    }

    @Override
    public RunConfiguration createTemplateConfiguration(Project project) {
      return new FregeRunConfiguration(project, this, "Frege Run");
    }

  }
}
