package org.fregelang.plugin.idea.run;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Binds to the UI that will render when you edit Run Configurations for Frege
 *
 * @author rahulsom
 */
public class FregeSettingsEditor extends SettingsEditor<FregeRunConfiguration> {
  private JPanel myPanel;
  private JTextField className;

  @Override
  protected void resetEditorFrom(FregeRunConfiguration fregeRunConfiguration) {
    className.setText(fregeRunConfiguration.getClassName());
  }

  @Override
  protected void applyEditorTo(FregeRunConfiguration fregeRunConfiguration) throws ConfigurationException {
    fregeRunConfiguration.setClassName(className.getText());
  }

  @NotNull
  @Override
  protected JComponent createEditor() {
    return myPanel;
  }
}
